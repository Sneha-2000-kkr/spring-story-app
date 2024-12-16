package com.storyBay.story_service.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.storyBay.story_service.model.Story;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.bson.Document;

import java.util.List;


public class StoryRepo {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void deleteById(String id) {
    }

    public Story save(Story  story) {
        MongoDatabase database = mongoTemplate.getDb();
        MongoCollection<Document> collection = database.getCollection("story");

        // Convert each Story object to a Document (MongoDB's internal format)
        Document document =  new Document("title", story.getTitleName())
                        .append("author", story.getAuthorId())
                        .append("content", story.getStoryContent());

        // Perform bulk insert using MongoDB's insertMany
        collection.insertOne(document);
        story.setStoryId(document.getObjectId("_id").toString());
        return story;

    }

    public Story findById(String id) {
    }

    public List<Story> findAll() {
    }
}
