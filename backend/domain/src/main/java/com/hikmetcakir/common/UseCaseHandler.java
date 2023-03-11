package com.hikmetcakir.common;

import com.hikmetcakir.common.model.UseCase;

public interface UseCaseHandler<E, T extends UseCase> {

    E handle(T useCase);
}
