package com.xdf.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.filters.Canvas;
import net.coobird.thumbnailator.geometry.Positions;


/**
 * @author justin
 * @since 2018年5月17日
 */
public class ThumbnailsHelper {
    //缩放类型
    public final static int SCALETYPE_WIDTH = 1;
    public final static int SCALETYPE_HEIGHT = 2;
    public final static int SCALETYPE_MAX = 3;
    public final static int SCALETYPE_MIN = 4;

    /**
     * 获取图片的宽度和高度尺寸
     * @param img
     * @return
     */
    public static int[] getSize(File img){
        BufferedImage image = null;
        int width = 0;
        int height = 0;
        try {
            image = ImageIO.read(img);
            width =  image.getWidth();
            height = image.getHeight();

        } catch (IOException e) {
            try {
                File cmykJPEGFile = img;
                image = ImageIO.read(cmykJPEGFile);
                width =  image.getWidth();
                height = image.getHeight();
            }catch (Exception ex){

            }
        }
        int[] size = {width,height};
        return size;
    }

    /**
     * 功能：图片缩放
     * @param source 原图像
     * @param target 目标图像
     * @param width 缩放后的图片宽度
     * @param height 缩放后的图片高度
     * @param scaleType 缩放类型，是按高度，还是按宽度，是以缩放最小为准还是以缩放最大为准
     * @param forceAble 当图片大小小于规定的尺寸，是否强制将图片放大失真
     * @param quality
     */
    public static void scale(File source,File target,int width,int height,int scaleType,boolean forceAble,float quality){
        //按比例缩放
        int size[] = getSize(source);
        int w = size[0];
        int h = size[1];
        double wScale = getScale(width, w);
        double hScale = getScale(height,h);
        double scale = 1.0;
        //System.out.println(width+"--"+height+"--"+w+"--"+h);
		/*
		 *  width      height
		 * -----   =  --------
		 *   w     		 h
		 */
        switch (scaleType) {
            case SCALETYPE_WIDTH:
                scale = wScale;
                break;
            case SCALETYPE_HEIGHT:
                scale = hScale;
                break;
            case SCALETYPE_MIN:
                scale = Math.min(wScale,hScale);
                break;
            case SCALETYPE_MAX:
                scale = Math.max(wScale, hScale);
                break;
            default:
                scale = Math.min(wScale, hScale);
                break;
        }
        try{
            if(!target.getParentFile().exists()){
                target.getParentFile().mkdirs();
            }
            //如果按照大于1的比例进行缩放（其实是放大），这里会根据参数决定forceAble决定
            if(scale<=1 || scale > 1 && forceAble){
                //缩放原图
                Thumbnails.of(source).scale(scale).outputQuality(quality).toFile(target);
            }
            else{
                //复制原图
                Thumbnails.of(source).scale(1).outputQuality(quality).toFile(target);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }


    /**
     * 功能：图片缩放
     * @param source 原图像
     * @param target 目标图像
     * @param width 缩放后的图片宽度
     * @param height 缩放后的图片高度
     * @param quality
     */
    public static void scaleDIY(File source,File target,int width,int height,float quality){
        scaleDIY(source,target,width,height,quality,true);
    }


    /**
     * 功能：图片缩放
     * @param source 原图像
     * @param target 目标图像
     * @param width 缩放后的图片宽度
     * @param height 缩放后的图片高度
     * @param quality
     * @param liukongorcaijian liukong为true,caijian为false
     */
    public static void scaleDIY(File source,File target,int width,int height,float quality,boolean liukongorcaijian){
        //按比例缩放
        try {
            int size[] = getSize(source);
            int sw = size[0];
            int sh = size[1];
            double sa = (double)sw/(double)sh;

            double da = (double)width/(double)height;

            BufferedImage thumb = null;

            double wScale = getScale(width, sw);
            double hScale = getScale(height,sh);
            double scale = 1.0;
            scale = Math.max(wScale,hScale);     //按照最小的进行处理

            if(!target.getParentFile().exists()){
                target.getParentFile().mkdirs();
            }

            if(liukongorcaijian||sa==da) {
                //下面的代码是留空白

                if (sa < da) {
                    double tw = sh * da;
                    int x = (int) (sw - tw) / 2;
                    int y = 0;
                    thumb = Thumbnails.of(source).sourceRegion(x, y, (int) tw, sh).size(width, height).asBufferedImage();
                    Canvas canvas = new Canvas(width, height, Positions.CENTER, java.awt.Color.WHITE);
                    thumb = canvas.apply(thumb);
                } else if (sa > da) {
                    double th = sw / da;
                    int x = 0;
                    int y = (int) (sh - th) / 2;
                    thumb = Thumbnails.of(source).sourceRegion(x, y, sw, (int) th).size(width, height).asBufferedImage();
                    Canvas canvas = new Canvas(width, height, Positions.CENTER, java.awt.Color.WHITE);
                    thumb = canvas.apply(thumb);
                } else {
                    thumb = Thumbnails.of(source).size(width, height).asBufferedImage();
                    Canvas canvas = new Canvas(width, height, Positions.CENTER, java.awt.Color.WHITE);
                    thumb = canvas.apply(thumb);
                }
                if (thumb != null) {
                    Thumbnails.of(thumb).size(width, height).outputQuality(quality).toFile(target);
                }
            }else {
                int posX = 0;
                int posY = 0;
                if (scale > 1) {
                    //如果按照大于1的比例进行缩放（其实是放大)
                    //先按比例缩放存到内存
                    BufferedImage image = Thumbnails.of(source).scale(scale).asBufferedImage();

                    if (sa > da) {
                        posX = (int) (height * sw / sh - width) / 2;
                        posY = 0;
                        //后从中心剪裁
                        Thumbnails.of(image).size(width, height).sourceRegion(posX, posY, width, height).outputQuality(quality).toFile(target);
                    } else {
                        posX = 0;
                        posY = (int) (width * sh / sw - height) / 2;
                        //后从中心剪裁
                        Thumbnails.of(image).size(width, height).sourceRegion(posX, posY, width, height).outputQuality(quality).toFile(target);
                    }
                } else {
                    //先按比例缩放存到内存
                    BufferedImage image = Thumbnails.of(source).scale(scale).asBufferedImage();

                    if (sa > da) {
                        posX = (int) (sw * height / sh - width) / 2;
                        posY = 0;
                        //后从中心剪裁
                        Thumbnails.of(image).size(width, height).sourceRegion(posX, posY, width, height).outputQuality(quality).toFile(target);
                    } else {
                        posX = 0;
                        posY = (int) (sh * width / sw - height) / 2;
                        //后从中心剪裁
                        Thumbnails.of(image).size(width, height).sourceRegion(posX, posY, width, height).outputQuality(quality).toFile(target);
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 功能：自定义位置图片剪裁,案例：头像剪裁
     * @param source 原图像
     * @param target 目标图像
     * @param width 剪裁后的宽度
     * @param height 剪裁后的高度
     * @param posX 位置x
     * @param posY 位置y
     * @param scaleWidth 缩放后的图像宽度
     * @param quality 剪裁后的图片质量
     */
    public static void clip(File source,File target,int width,int height,int posX,int posY,int scaleWidth,float quality){
        int size[] = getSize(source);
        int w = size[0];
        //scale为1.0表示原图剪裁，否则就缩放(扩大)
        double scale = (scaleWidth > 0) ? getScale(scaleWidth , w) : 1.0;
        try {
            if(!target.getParentFile().exists()){
                target.getParentFile().mkdirs();
            }
            //先按比例缩放存到内存
            BufferedImage image = Thumbnails.of(source).scale(scale).asBufferedImage();
            //后从中心剪裁
            Thumbnails.of(image).size(width,height).sourceRegion(posX,posY, width, height).outputQuality(quality).toFile(target);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 从中心剪裁图片
     * @param source
     * @param target
     * @param width
     * @param height
     * @param scaleAble  是否先缩放后剪裁
     */
    public static void clipBySize(File source,File target,int width,int height,boolean scaleAble){
        int size[] = getSize(source);
        int w = size[0];
        int h = size[1];
        double wScale = getScale(width, w);
        double hScale = getScale(height, h);
        double maxScale = Math.min(wScale, hScale);
        double scale = scaleAble ? maxScale : 1.0;
        if(!target.getParentFile().exists()){
            target.getParentFile().mkdirs();
        }
        try {
            //先按比例缩放存到内存
            BufferedImage image = Thumbnails.of(source).scale(scale).asBufferedImage();
            //后从中心剪裁
            Thumbnails.of(image).size(width, height).sourceRegion(Positions.CENTER, width, height).outputQuality(1.0f).toFile(target);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据宽度缩放
     * @param source
     * @param target
     * @param width
     */
    public static void scaleByWidth(File source,File target,int width){
        scale(source, target, width, 0, ThumbnailsHelper.SCALETYPE_WIDTH, false, 1.0f);
    }
    /**
     * 根据高度缩放
     * @param source
     * @param target
     * @param height
     */
    public static void scaleByHeight(File source,File target,int height){
        scale(source, target, 0, height, ThumbnailsHelper.SCALETYPE_HEIGHT, false, 1.0f);
    }

    /**
     * 剪裁成正方形
     * @param source
     * @param target
     * @param width
     */
    public static void clip(File source,File target,int width){
        clipBySize(source, target, width,width,true);
    }

    private static double getScale(double num1,double num2){
        BigDecimal b1 = new BigDecimal(Double.toString(num1));
        BigDecimal b2 = new BigDecimal(Double.toString(num2));
        double result = b1.divide(b2, 3,BigDecimal.ROUND_HALF_UP).doubleValue();
        return result;
    }
}
