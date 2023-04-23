package com.hikmetcakir.domain.user.adapter;

import com.hikmetcakir.article.port.CachePort;
import com.hikmetcakir.domain.user.jpa.entity.UserEntity;
import com.hikmetcakir.domain.user.jpa.repository.UserJpaRepository;
import com.hikmetcakir.user.model.User;
import com.hikmetcakir.user.port.UserPort;
import com.hikmetcakir.user.usecase.QueryUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
