package com.storyBay.search_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "story") // For MongoDB
public class Story {
    @Id
    private String storyId;          // Unique ID for the story
    private String titleName;        // Title of the story
    private String storyContent;     // Full text of the story
    private String authorName;       // Name of the author
    private String genre;            // Genre (e.g., Thriller, Adventure)
    private int likedCount;          // Number of likes
    private int dislikedCount;       // Number of dislikes
    private Date publishingDate;     // Story publishing date
    private String storyImgPath;     // Path to the story image
    private int readTime;            // Estimated reading time (in minutes)

    public Story(String storyId,
                 String titleName,
                 String storyContent,
                 String authorId,
                 String authorName,
                 String genreId,
                 Integer likedCount,
                 Integer dislikedCount,
                 Date publishingDate,
                 String storyImgPath,
                 Integer readTime) {
    }
}
