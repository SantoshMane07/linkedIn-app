package com.codingshuttle.linkedin.user_service.event;


import lombok.Data;

@Data
public class UserCreatedEvent {
    private String name;
    private  Long user_id;
}

