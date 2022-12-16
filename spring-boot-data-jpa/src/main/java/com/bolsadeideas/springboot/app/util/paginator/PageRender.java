package com.bolsadeideas.springboot.app.util.paginator;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Data
public class PageRender<T> {

    private String url;

    private Page<T> page;

    private int totalPages;

    private int elementForPage;

    private int actualPage;


    private List<PageItem> pages;

    public PageRender(String url, Page<T> page) {
        this.url = url;
        this.page = page;
        this.pages = new ArrayList<PageItem>();


        totalPages = page.getTotalPages();
        elementForPage = page.getSize();
        actualPage = page.getNumber() + 1;

        int init, finish;
        if (totalPages <= elementForPage) {
            init = 1;
            finish = totalPages;
        } else {
            if (actualPage <= elementForPage / 2) {
                init = 1;
                finish = elementForPage;
            } else if (actualPage >= totalPages - elementForPage / 2) {
                init = totalPages - elementForPage + 1;
                finish = elementForPage;
            } else {
                init = actualPage - elementForPage/2;
                finish = elementForPage;

            }
        }

        for (int i = 0; i < finish; i++) {
            pages.add(new PageItem(init + i, actualPage == init + i));
        }
    }

    public boolean isFirst() {
        return page.isFirst();
    }

    public boolean isLast() {
        return page.isLast();
    }

    public boolean isHasNext() {
        return page.hasNext();
    }

    public boolean isHasPrevious() {
        return page.hasPrevious();
    }
}
