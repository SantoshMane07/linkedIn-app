package com.codingshuttle.linkedin.user_service.event;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserCreatedEvent {
    private String name;
    private  Long user_id;
}
