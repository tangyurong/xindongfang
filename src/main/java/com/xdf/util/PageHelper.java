package com.xdf.util;

/**
 * Created by Justin on 2017-6-8.
 */
public class PageHelper {

    private int page = 0;//当前页，默认为0
    private int rows = 20;//每页条数
    private int pageTotal;//总页数


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int totalRows) {

        this.pageTotal = totalRows % rows == 0 ? (totalRows / rows) : ((totalRows / rows) + 1);
        //  this.pageTotal = totalRows % rows == 0 ? totalRows / rows : totalRows / rows + 1;
    }

    //处理page大于pageTotal的问题
    public void processPageTotalPage() {
        if (this.page > this.pageTotal) {
            this.page = this.pageTotal;
        }
    }
}
