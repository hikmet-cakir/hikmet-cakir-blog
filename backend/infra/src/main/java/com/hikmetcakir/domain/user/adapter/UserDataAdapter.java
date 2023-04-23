package com.hikmetcakir.domain.user.adapter;

import com.hikmetcakir.common.port.CachePort;
import com.hikmetcakir.common.exception.UserException;
import com.hikmetcakir.common.exception.enums.ApiExceptionUser;
import com.hikmetcakir.domain.user.jpa.entity.UserEntity;
import com.hikmetcakir.domain.user.jpa.repository.UserJpaRepository;
import com.hikmetcakir.user.model.User;
import com.hikmetcakir.user.port.UserPort;
import com.hikmetcakir.user.usecase.DeleteUser;
import com.hikmetcakir.user.usecase.QueryUser;
import com.hikmetcakir.user.usecase.UpdateUser;
import com.hikmetcakir.user.usecase.UploadUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDataAdapter implements UserPort {

    private final UserJpaRepository userJpaRepository;

    private final CachePort cachePort;

    @Override
    public List<User> query(QueryUser queryUser) {
        return userJpaRepository.queryUser(queryUser).stream()
                .map(UserEntity::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(DeleteUser deleteUser) {
        var userEntity = userJpaRepository.findById(deleteUser.getId())
                .orElseThrow(() -> new UserException(ApiExceptionUser.USER_NOT_FOUND));
        userJpaRepository.delete(userEntity);
        cachePort.deleteValue(userEntity.getId());
    }

    @Override
    public User upload(UploadUser uploadUser) {
        var userEntity = new UserEntity();
        userEntity.setId(UUID.randomUUID().toString());
        userEntity.setUserId(uploadUser.getUserId());
        userEntity.setPassword(uploadUser.getPassword());
        userEntity.setName(uploadUser.getName());
        userEntity.setLastName(uploadUser.getLastName());
        userEntity.setUpdatedAt(LocalDateTime.now());
        userEntity.setCreatedAt(LocalDateTime.now());
        var user = userJpaRepository.save(userEntity).toModel();
        cachePort.putValue(user.getId(), user);
        return user;
    }

    @Override
    public void update(UpdateUser updateUser) {
        var userEntity = userJpaRepository.findById(updateUser.getId())
                .orElseThrow(() -> new UserException(ApiExceptionUser.USER_NOT_FOUND));
        userEntity.setUserId(updateUser.getUserId());
        userEntity.setPassword(updateUser.getPassword());
        userEntity.setName(updateUser.getName());
        userEntity.setLastName(updateUser.getLastName());
        userEntity.setUpdatedAt(updateUser.getUpdatedAt());
        userJpaRepository.save(userEntity);
        cachePort.putValue(updateUser.getId(), userEntity.toModel());
    }
}
