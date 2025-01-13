package com.codingshuttle.linkedin.connections_service.consumer;


import com.codingshuttle.linkedin.connections_service.entity.Person;
import com.codingshuttle.linkedin.connections_service.event.SendConnectionRequestEvent;
import com.codingshuttle.linkedin.connections_service.repository.PersonRepository;
import com.codingshuttle.linkedin.user_service.event.UserCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserCreatedConsumer {

    private final PersonRepository personRepository;

    @KafkaListener(topics = "user-created-topic")
    public void handleUserCreatedEvent(UserCreatedEvent userCreatedEvent) {
        log.info("handle handleUserCreatedEvent: handleUserCreatedEvent: {}", userCreatedEvent);
        //Create a new node Person in neo4j
        Person person = new Person();
        person.setUserId(userCreatedEvent.getUser_id());
        person.setName(userCreatedEvent.getName());
        personRepository.save(person);
    }
}
