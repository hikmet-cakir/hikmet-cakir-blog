package com.hikmetcakir.article.port;

import com.hikmetcakir.article.model.Article;
import com.hikmetcakir.article.usecase.DeleteArticle;
import com.hikmetcakir.article.usecase.UploadArticle;

public interface ArticlePort {

    Article upload(UploadArticle uploadArticle);

    void delete(DeleteArticle deleteArticle);
}
