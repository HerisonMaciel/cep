package com.herison.cep.adapter.outbound.repository;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "log")
public class LogEntity {

    @Id
    private String id;
    private EstablishmentByZipcodeEntity establishmentByZipcodeEntity;

    @CreatedDate
    private LocalDateTime createdAt;

    @Version
    private Integer version;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EstablishmentByZipcodeEntity getEstablishmentByZipcodeEntity() {
        return establishmentByZipcodeEntity;
    }

    public void setEstablishmentByZipcodeEntity(EstablishmentByZipcodeEntity establishmentByZipcodeEntity) {
        this.establishmentByZipcodeEntity = establishmentByZipcodeEntity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "LogEntity{" +
                "id='" + id + '\'' +
                ", establishmentByZipcodeEntity=" + establishmentByZipcodeEntity +
                ", createdAt=" + createdAt +
                ", version=" + version +
                '}';
    }
}
