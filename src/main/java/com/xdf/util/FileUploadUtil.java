package com.xdf.util;


import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

	public Map<String, String> uploadResult() throws Exception {
		//虚拟路径
		//判断路径是否存在，若不存在，则创建
		File newPath = new File(this.realPath);
		if (!newPath.exists() && !newPath.isDirectory()) {
			newPath.mkdirs();
		}
		//文件原始名称
		String originalFilename = file.getOriginalFilename();
		//新文件名称 = uuid + 扩展名
		String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
		//生成新文件
		File newFile = new File(this.realPath + newFileName);
		//将内存的数据写入磁盘||将生成的新文件写入磁盘
		file.transferTo(newFile);
		Map<String, String> map = new HashMap<String, String>();
		map.put("originalFilename", originalFilename);
		map.put("newFileName", newFileName);
		map.put("path", path + newFileName);
		return map;
	}

	public Map<String, String> uploadProductResult() throws Exception {
		//虚拟路径
		//判断路径是否存在，若不存在，则创建
		File newPath = new File(this.realPath);
		if (!newPath.exists() && !newPath.isDirectory()) {
			newPath.mkdirs();
		}
		//文件原始名称
		String originalFilename = file.getOriginalFilename();
		//新文件名称 = uuid + 扩展名
		String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
		//生成新文件
		File newFile = new File(this.realPath + newFileName);
		//将内存的数据写入磁盘||将生成的新文件写入磁盘
		file.transferTo(newFile);
		String strFileDistName = newFile.getName();
		String strFileNameWithoutSuffix = CommonUtils.GetFileNameWithoutSuffix(strFileDistName);
		String strFileNameSuffix =  CommonUtils.GetFileNameSuffix(strFileDistName);
		String strFolder = this.realPath;
		ThumbnailsHelper.scaleDIY(newFile,new File(strFolder+strFileNameWithoutSuffix+"_"+50+"X"+50+strFileNameSuffix),50,50,(float) 1.0);
		ThumbnailsHelper.scaleDIY(newFile,new File(strFolder+strFileNameWithoutSuffix+"_"+500+"X"+500+strFileNameSuffix),500,500,(float) 1.0);
		ThumbnailsHelper.scaleDIY(newFile,new File(strFolder+strFileNameWithoutSuffix+"_"+300+"X"+400+strFileNameSuffix),300,400,(float) 1.0);
		Map<String, String> map = new HashMap<String, String>();
		map.put("originalFilename", originalFilename);
		map.put("newFileName", newFileName);
		map.put("path", path + newFileName);
		return map;
	}

	public Map<String, String> uploadResult(int length,int width) throws Exception {
		return uploadResult(length,width,true);
	}


	public Map<String, String> uploadResult(int length,int width,boolean liukongorcaijian) throws Exception {
		//虚拟路径
		//判断路径是否存在，若不存在，则创建
		File newPath = new File(this.realPath);
		if (!newPath.exists() && !newPath.isDirectory()) {
			newPath.mkdirs();
		}
		//文件原始名称
		String originalFilename = file.getOriginalFilename();
		//新文件名称 = uuid + 扩展名
		String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
		//生成新文件
		File newFile = new File(this.realPath + newFileName);
		//将内存的数据写入磁盘||将生成的新文件写入磁盘
		file.transferTo(newFile);
		String strFileDistName = newFile.getName();
		String strFileNameWithoutSuffix = CommonUtils.GetFileNameWithoutSuffix(strFileDistName);
		String strFileNameSuffix =  CommonUtils.GetFileNameSuffix(strFileDistName);
		String strFolder = this.realPath;
		ThumbnailsHelper.scaleDIY(newFile,new File(strFolder+strFileNameWithoutSuffix+"_"+length+"X"+width+strFileNameSuffix),length,width,(float) 1.0,liukongorcaijian);

		Map<String, String> map = new HashMap<String, String>();
		map.put("originalFilename", originalFilename);
		map.put("newFileName", newFileName);
		map.put("path", path + newFileName);
		return map;
	}
	
	
	public FileUploadUtil(MultipartFile file, String realPath, String basePath, String path) {
		super();
		this.file = file;
		this.realPath = realPath;
		this.basePath = basePath;
		this.path = path;
	}


	private MultipartFile file;
	
	private String realPath;
	
	private String basePath;
	
	private String path;
	

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getRealPath() {
		return realPath;
	}

	public void setRealPath(String realPath) {
		this.realPath = realPath;
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}


	
}
