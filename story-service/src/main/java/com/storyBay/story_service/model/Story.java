package com.storyBay.story_service.model;

import com.mongodb.lang.NonNull;
import com.storyBay.story_service.enums.StoryStatus;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;
import java.util.Date;

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

    public String getStoryId() {
        return storyId;
    }

    public void setStoryId(String storyId) {
        this.storyId = storyId;
    }

    @NonNull
    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(@NonNull String titleName) {
        this.titleName = titleName;
    }

    public StoryStatus getStatus() {
        return status;
    }

    public void setStatus(StoryStatus status) {
        this.status = status;
    }

    public String getStoryContent() {
        return storyContent;
    }

    public void setStoryContent(String storyContent) {
        this.storyContent = storyContent;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getGenreId() {
        return genreId;
    }

    public void setGenreId(String genreId) {
        this.genreId = genreId;
    }

    public int getDislikedCount() {
        return dislikedCount;
    }

    public void setDislikedCount(int dislikedCount) {
        this.dislikedCount = dislikedCount;
    }

    public int getLikedCount() {
        return likedCount;
    }

    public void setLikedCount(int likedCount) {
        this.likedCount = likedCount;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }

    public String getStoryImgPath() {
        return storyImgPath;
    }

    public void setStoryImgPath(String storyImgPath) {
        this.storyImgPath = storyImgPath;
    }

    public int getReadTime() {
        return readTime;
    }

    public void setReadTime(int readTime) {
        this.readTime = readTime;
    }
}
