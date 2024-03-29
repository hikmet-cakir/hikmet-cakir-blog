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

    @Column(name = "user_id")
    private String userId;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    public User toModel() {
        return User.builder()
                .id(this.getId())
                .userId(userId)
                .password(password)
                .name(name)
                .lastName(lastName)
                .updatedAt(this.getUpdatedAt())
                .createdAt(this.getCreatedAt())
                .build();
    }
}
