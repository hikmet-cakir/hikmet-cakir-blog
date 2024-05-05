package com.hikmetcakir.repository;

import com.hikmetcakir.dto.ArticleQueryRequest;
import com.hikmetcakir.entity.ArticleEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<ArticleEntity, String> {

    @Query("SELECT articleEntity " +
           "FROM ArticleEntity articleEntity " +
           "WHERE " +
           "(:#{#filter.id} IS NULL OR articleEntity.id = :#{#filter.id}) AND " +
           "(:#{#filter.topic} IS NULL OR articleEntity.topic = :#{#filter.topic}) " +
           "ORDER BY articleEntity.createdDate DESC ")
    List<ArticleEntity> findByFilter(@Param("filter") ArticleQueryRequest filter, Pageable pageable);
}
