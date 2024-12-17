package com.storyBay.search_service.model;

import lombok.Data;

@Data
public class SearchCriteria {
    private String title;
    private String authorId;
    private String genreId;
    private String status;
    private Integer minLikedCount;
    private Integer maxLikedCount;
    private Integer minReadTime;
    private Integer maxReadTime;
}
