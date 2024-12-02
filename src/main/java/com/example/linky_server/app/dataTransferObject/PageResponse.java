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
    int totalElements;
    int totalViews;
    int totalPages;
    int currentPage;
    int pageSize;
    List<T> data;
    boolean hasNext;
    boolean hasPrevious;
}