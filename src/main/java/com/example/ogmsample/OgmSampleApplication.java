package com.example.ogmsample;

import com.example.ogmsample.entity.Entity;
import org.neo4j.ogm.session.SessionFactory;
import org.neo4j.ogm.session.event.Event;
import org.neo4j.ogm.session.event.EventListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class OgmSampleApplication {

    @Autowired
    private SessionFactory sessionFactory;

    public static void main(String[] args) {
        SpringApplication.run(OgmSampleApplication.class, args);
    }

    @PostConstruct
    public void registerEventListener() {
        sessionFactory.register(
                new EventListenerAdapter() {
                    @Override
                    public void onPreSave(Event event) {
                        Entity entity = (Entity) event.getObject();
                        entity.generateId();
                    }
                }
        );
    }
}
