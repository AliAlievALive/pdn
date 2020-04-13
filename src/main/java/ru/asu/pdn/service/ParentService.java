package ru.asu.pdn.service;

import ru.asu.pdn.model.Parent;

import java.util.List;

public interface ParentService {
    Parent addParent(Parent parent);

    void delete(int id);

    Parent getByFio(String fio);

    Parent getById(int id);

    Parent edit(Parent parent);

    List<Parent> getAll();
}
