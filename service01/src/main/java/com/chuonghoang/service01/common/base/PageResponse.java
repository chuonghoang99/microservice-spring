package com.chuonghoang.service01.common.base;

import com.chuonghoang.service01.common.paging.TPage;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;


import java.util.List;

@Setter
public class PageResponse<T> implements TPage<T> {
    private List<T> content;
    private int page;
    private int size;
    private String sort;
    private long totalElements;
    private int totalPages;
    private int numberOfElements;

    public PageResponse() {
    }

    @JsonProperty(
            index = 0
    )
    public List<T> getContent() {
        return this.content;
    }

    @JsonProperty(
            index = 1
    )
    public int getPage() {
        return this.page;
    }

    @JsonProperty(
            index = 2
    )
    public int getSize() {
        return this.size;
    }

    @JsonProperty(
            value = "sort",
            index = 3
    )
    public String getTSort() {
        return this.sort;
    }

    @JsonProperty(
            index = 4
    )
    public long getTotalElements() {
        return this.totalElements;
    }

    @JsonProperty(
            index = 5
    )
    public int getTotalPages() {
        return this.totalPages;
    }

    @JsonProperty(
            index = 6
    )
    public int getNumberOfElements() {
        return this.numberOfElements;
    }

}
