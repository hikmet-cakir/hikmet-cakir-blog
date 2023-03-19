package com.hikmetcakir.common;

import com.hikmetcakir.common.model.UseCase;

public interface VoidUseCaseHandler<T extends UseCase> {

    void handle(T t);
}
