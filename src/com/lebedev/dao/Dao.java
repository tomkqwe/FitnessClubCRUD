package com.lebedev.dao;

import com.lebedev.dto.TrainingDTO;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    Optional<T> get(int id);

    List<T> getAll();

    void save(T t);
    void update(TrainingDTO t);

    boolean delete(int id);
}
