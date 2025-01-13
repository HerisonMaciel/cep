package com.herison.cep.adapter.outbound.repository.log;

import com.herison.cep.adapter.outbound.repository.zipcode.EstablishmentByZipcodeEntity;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "log_establishmente_by_zipcode")
public class LogEstablishmentByZipcodeEntity {

    @Id
    private String id;
    private EstablishmentByZipcodeEntity establishmentByZipcodeEntity;

    @CreatedDate
    private LocalDateTime createdAt;

    @Version
    private Integer version;

}
