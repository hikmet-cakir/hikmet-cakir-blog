package com.hikmetcakir.article.model;

import java.util.stream.Stream;

public enum Genre {

    JAVA("java"),
    SPRING("spring"),
    SQL("sql"),
    ALGORITHM("algorithm");

    private final String value;

    Genre(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Genre of(String value) {
        return Stream.of(Genre.values())
                .filter(genre -> genre.value.equals(value)).findFirst().orElseThrow();
    }
}
