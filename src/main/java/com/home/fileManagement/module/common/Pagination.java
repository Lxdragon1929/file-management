package com.home.fileManagement.module.common;

import java.io.Serializable;
import java.util.List;

/**
 * @author LX
 * @since 2021/3/26 9:49
 */

public class Pagination<T> implements Serializable {

    /**
     * 当前页
     */
    private int page;

    /**
     * 每页大小
     */
    private int pageSize;

    /**
     * 数据列表
     */
    private List<T> data;

    /**
     * 数据总数
     */
    private long total;

    /**
     * 总页数
     */
    private int totalPages;

    public Pagination(int page, int pageSize, List<T> data, long count) {
        this.page = page;
        this.pageSize = pageSize;
        this.data = data;
        this.total = count;
    }

    public Pagination(int page, int pageSize, List<T> data, long total, int totalPages) {
        this.page = page;
        this.pageSize = pageSize;
        this.data = data;
        this.total = total;
        this.totalPages = totalPages;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
