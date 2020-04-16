package ru.asu.pdn.service;

import ru.asu.pdn.model.Violation;

import java.util.List;

public interface ViolationService {
    List<Violation> findAll();

    void save(Violation violation);

    Violation get(Long id);

    void delete(Long id);
}
