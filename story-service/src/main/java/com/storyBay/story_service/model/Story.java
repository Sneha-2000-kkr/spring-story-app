package com.storyBay.story_service.model;

import com.mongodb.lang.NonNull;
import com.storyBay.story_service.enums.StoryStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.util.Date;

@Getter
@Setter
@Component
public class Story {
    @Id
    String storyId;

    @NonNull
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
