package com.herison.cep.adapter.outbound.repository.zipcode;

import com.herison.cep.core.domain.AddressZipCode;
import com.herison.cep.core.domain.Establishment;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Document(collection = "establishments_by_zipcode")
public class EstablishmentByZipcodeEntity {

    @Id
    private String zipcode;
    private AddressZipCode addressZipCode;
    private List<Establishment> establishmentList;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Version
    private Integer version;

}

