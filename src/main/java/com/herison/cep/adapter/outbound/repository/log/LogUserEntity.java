package com.herison.cep.adapter.outbound.repository.log;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;

@Data
@Document(collection = "log_user_entity")
public class LogUserEntity {

    @Id
    private String id;
    private UserDetails userDetails;

    @CreatedDate
    private LocalDateTime createdAt;

    @Version
    private Integer version;


}
