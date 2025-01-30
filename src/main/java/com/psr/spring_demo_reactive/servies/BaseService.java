package com.psr.spring_demo_reactive.servies;

import com.psr.spring_demo_reactive.repositories.BaseRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public abstract class BaseService<T, ID> implements CrudService<T, ID> {
    private final BaseRepository<T, ID> repository;

    @Override
    public Mono<T> create(T entity) {
        return repository.save(entity);
    }

    @Override
    public Mono<T> update(ID id, T entity) {
        return repository.findById(id)
                .flatMap(existingEntity -> {
                    // Update the existing entity with the new values
                    // This assumes that the entity has a method to update its fields
                    // You may need to implement this method in your entity classes
                    updateEntity(existingEntity, entity);
                    return repository.save(existingEntity);
                });
    }

    @Override
    public Mono<Void> delete(ID id) {
        return repository.deleteById(id);
    }

    @Override
    public Mono<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public Flux<T> findAll() {
        return repository.findAll();
    }

    protected abstract void updateEntity(T existingEntity, T newEntity);
}
