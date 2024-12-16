package com.storyBay.story_service.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.storyBay.story_service.model.Story;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StoryRepository {

    private final MongoCollection<Document> collection;

    @Autowired
    public StoryRepository(MongoDatabase database) {
        this.collection = database.getCollection("story"); // Replace "story" with your collection name
    }

    public Story saveStory(Story story) {
        Document document = new Document()
                .append("title", story.getTitleName())
                .append("content", story.getStoryContent())
                .append("author", story.getAuthorName());
        collection.insertOne(document);
        return story;
    }

    public Story findStoryById(String id) {
        Document query = new Document("_id", id);
        Document document = collection.find(query).first();
        if (document != null) {
            Story story = new Story();
            story.setStoryId(document.getObjectId("_id").toString());
            story.setTitleName(document.getString("title"));
            story.setStoryContent(document.getString("content"));
            story.setAuthorName(document.getString("author"));
            return story;
        }
        return null;
    }

    public List<Story> findAllStories() {
        List<Story> stories = new ArrayList<>();
        for (Document document : collection.find()) {
            Story story = new Story();
            story.setStoryId(document.getObjectId("_id").toString());
            story.setTitleName(document.getString("title"));
            story.setStoryContent(document.getString("content"));
            story.setAuthorName(document.getString("author"));
            stories.add(story);
        }
        return stories;
    }

    public void deleteStoryById(String id) {
        Document query = new Document("_id", id);
        collection.deleteOne(query);
    }
}
