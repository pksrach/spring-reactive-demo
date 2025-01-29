package com.psr.spring_demo_reactive.infrastructures.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CrudService<T, ID> {
    Mono<T> create(T entity);

    Mono<T> update(ID id, T entity);

    Mono<Void> delete(ID id);

    Mono<T> findById(ID id);

    Flux<T> findAll();
}
