package ru.asu.pdn.service;

import ru.asu.pdn.model.Child;

import java.util.List;

public interface ChildService {
    Child addChild(Child child);

    void delete(int id);

    Child getByFio(String fio);

    Child getById(int id);

    Child edit(Child child);

    List<Child> getAll();
}
