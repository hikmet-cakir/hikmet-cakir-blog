package com.hikmetcakir.domain.user.jpa.entity;

import com.hikmetcakir.common.entity.AbstractEntity;
import com.hikmetcakir.user.model.User;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@FieldNameConstants
@Table(name = "user")
public class UserEntity extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

    public User toModel() {
        return User.builder()
                .id(this.getId())
                .name(name)
                .lastName(lastName)
                .password(password)
                .updatedAt(this.getUpdatedAt())
                .createdAt(this.getCreatedAt())
                .build();
    }
}
