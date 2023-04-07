package com.hikmetcakir.article.port;

import com.hikmetcakir.article.model.Article;
import com.hikmetcakir.article.usecase.DeleteArticle;
import com.hikmetcakir.article.usecase.QueryArticle;
import com.hikmetcakir.article.usecase.UpdateArticle;
import com.hikmetcakir.article.usecase.UploadArticle;

import java.util.List;

public interface ArticlePort {

    Article upload(UploadArticle uploadArticle);

    void delete(DeleteArticle deleteArticle);

    void update(UpdateArticle updateArticle);

    List<Article> query(QueryArticle queryArticle);
}
