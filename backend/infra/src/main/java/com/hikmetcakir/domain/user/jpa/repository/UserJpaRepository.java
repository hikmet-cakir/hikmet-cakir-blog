package com.hikmetcakir.domain.user.jpa.repository;


import com.hikmetcakir.common.entity.AbstractEntity;
import com.hikmetcakir.domain.user.jpa.entity.UserEntity;
import com.hikmetcakir.user.usecase.QueryUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, String>, JpaSpecificationExecutor<UserEntity> {

    default Page<UserEntity> queryUser(QueryUser queryUser) {
        Specification<UserEntity> specification = (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(queryUser.getId() != null) {
                predicates.add(builder.equal(root.get(AbstractEntity.Fields.id), queryUser.getId()));
            }

            if(queryUser.getUserId() != null) {
                predicates.add(builder.equal(root.get(UserEntity.Fields.userId), queryUser.getUserId()));
            }

            if(queryUser.getName() != null) {
                predicates.add(builder.like(root.get(UserEntity.Fields.name), "%" + queryUser.getName() + "%"));
            }

            if(queryUser.getLastName() != null) {
                predicates.add(builder.equal(root.get(UserEntity.Fields.lastName), queryUser.getLastName()));
            }

            if(queryUser.getCreatedAt() != null) {
                predicates.add(builder.greaterThan(root.get(AbstractEntity.Fields.createdAt), queryUser.getCreatedAt()));
            }
            query.orderBy(builder.desc(root.get(AbstractEntity.Fields.createdAt)));
            return builder.and(predicates.toArray(new Predicate[0]));
        };
        Pageable page = PageRequest.of(queryUser.getPage(), queryUser.getSize());
        return findAll(specification, page);
    }
}
