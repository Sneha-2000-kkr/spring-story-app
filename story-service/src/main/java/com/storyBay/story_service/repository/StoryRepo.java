package com.storyBay.story_service.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.storyBay.story_service.model.Story;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.bson.Document;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StoryRepo {

    @Autowired
    private MongoTemplate mongoTemplate;
    MongoDatabase database = mongoTemplate.getDb();
    MongoCollection<Document> collection = database.getCollection("story");

    public void deleteStoryById(String id) {
        collection.deleteOne(new Document("storyId", id));

    }

    public Story saveStory(Story  story) {

        // Convert each Story object to a Document (MongoDB's internal format)
        Document document =  new Document("title", story.getTitleName())
                        .append("author", story.getAuthorId())
                        .append("content", story.getStoryContent());

        // Perform bulk insert using MongoDB's insertMany
        collection.insertOne(document);
        story.setStoryId(document.getObjectId("_id").toString());
        return story;

    }

    public Story findStoryById(String id) {
        // Query MongoDB collection for the story by storyId
        Document document = collection.find(new Document("storyId", id)).first();

        // If the story is found, convert the document back to a Story object
        if (document != null) {
            Story story = new Story();
            story.setStoryId(document.getObjectId("_id").toString());
            story.setTitleName(document.getString("title"));
            story.setAuthorId(document.getString("author"));
            story.setStoryContent(document.getString("content"));
            return story;
        }
        return null;

    }

    public List<Story> findAllStories() {
        // Retrieve all documents from the "story" collection
        List<Document> documents = collection.find().into(new ArrayList<>());

        // Convert each document into a Story object
        List<Story> stories = new ArrayList<>();
        for (Document document : documents) {
            Story story = new Story();
            story.setStoryId(document.getObjectId("_id").toString());
            story.setTitleName(document.getString("title"));
            story.setAuthorId(document.getString("author"));
            story.setStoryContent(document.getString("content"));
            stories.add(story);
        }

        return stories;

    }
}
