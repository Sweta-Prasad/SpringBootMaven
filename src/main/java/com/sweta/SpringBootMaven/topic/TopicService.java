package com.sweta.SpringBootMaven.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    //Arrays.asList creates an immutable list, so v use ArrayList
    private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("spring","spring framework","spring description"),
                                                new Topic("python","python framework","python description"),
                                                new Topic("jpa","jpa framework","jpa description")));

    public List<Topic> getAllTopics(){
        return topics;
    }

    public Topic getTopic(String id){
        return topics.stream().filter(e-> e.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic){
        topics.add(topic);
    }

    public void updateTopic(String id, Topic topic) {
        for (int i = 0; i < topics.size(); i++) {
            Topic t = topics.get(i);
            if (t.getId().equals(id)) {

                if (topic.getDescription() != null)
                    t.setDescription(topic.getDescription());
                if (topic.getName() != null)
                    t.setName(topic.getName());
                topics.set(i, t);
                //topics.set(i,topic);
                return;
            }
        }
    }

    public void deleteTopic(String id){
        topics.removeIf(t -> t.getId().equals(id));
    }

}