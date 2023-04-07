package com.hikmetcakir.domain.article.jpa.repository;

import com.hikmetcakir.article.usecase.QueryArticle;
import com.hikmetcakir.common.entity.AbstractEntity;
import com.hikmetcakir.domain.article.jpa.entity.ArticleEntity;
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
public interface ArticleJpaRepository extends JpaRepository<ArticleEntity, String>, JpaSpecificationExecutor<ArticleEntity> {

    default Page<ArticleEntity> queryArticle(QueryArticle queryArticle) {
        Specification<ArticleEntity> specification = (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if(queryArticle.getId() != null) {
                predicates.add(builder.equal(root.get(AbstractEntity.Fields.id), queryArticle.getId()));
            }

            if(queryArticle.getContent() != null) {
                predicates.add(builder.like(root.get(ArticleEntity.Fields.content), "%" + queryArticle.getContent() + "%"));
            }

            if(queryArticle.getGenre() != null) {
                predicates.add(builder.equal(root.get(ArticleEntity.Fields.genre), queryArticle.getGenre()));
            }

            if(queryArticle.getCreatedAt() != null) {
                predicates.add(builder.greaterThan(root.get(AbstractEntity.Fields.createdAt), queryArticle.getCreatedAt()));
            }
            query.orderBy(builder.desc(root.get(AbstractEntity.Fields.createdAt)));
            return builder.and(predicates.toArray(new Predicate[0]));
        };
        Pageable page = PageRequest.of(queryArticle.getPage(), queryArticle.getSize());
        return findAll(specification, page);
    }
}
