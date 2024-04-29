package com.hikmetcakir.repository;

import com.hikmetcakir.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleEntity, String> {
}
