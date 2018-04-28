package novel.web.entitys;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {
    //当前页
    private int currentPage;
    //每页显示多少条
    private int pageSize;
    //总页数
    private int totalPage;
    //总记录数
    private int totalCount;


    private List<T> pages = new ArrayList<>();

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    //总页数
    public int getTotalPage() {
        return totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
    }



    public List<T> getPages() {
        return pages;
    }

    public void setPages(List<T> pages) {
        this.pages = pages;
    }
}
