package com.hikmetcakir.domain.article.jpa.repository;

import com.hikmetcakir.domain.article.jpa.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleJpaRepository extends JpaRepository<ArticleEntity, String> {
}
