package com.wr.util;

import java.util.List;

/**
 * @author: fanping
 * @create: 2021-04
 */
public class PageInfo<T> {
    private List<T> data;
    private Integer totalNum;
    private Integer totalPage;
    private Integer cpage;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getCpage() {
        return cpage;
    }

    public void setCpage(Integer cpage) {
        this.cpage = cpage;
    }

}
