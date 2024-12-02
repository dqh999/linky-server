package com.example.linky_server.app.dataTransferObject;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;

@Getter @Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PageResponse<T> implements Serializable {
    Integer totalElements;
    Integer totalViews;
    Integer totalPages;
    Integer currentPage;
    Integer pageSize;
    List<T> data;
    Boolean hasNext;
    Boolean hasPrevious;
}