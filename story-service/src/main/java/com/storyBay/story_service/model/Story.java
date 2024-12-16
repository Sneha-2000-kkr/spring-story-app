package com.storyBay.story_service.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Getter
@Setter
@Component
public class Story {
    String storyId;
    String titleName;
    String storyContent;
    StoryStatus status;
    String authorId;
    String authorName;
    String genreId;
    int likedCount;
    int dislikedCount;
    Date publishingDate;
    String storyImgPath;
    int readTime;

}
