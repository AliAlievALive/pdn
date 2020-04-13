package ru.asu.pdn.service;

import ru.asu.pdn.model.PublicEducator;

import java.util.List;

public interface PublicEducatorService {
    PublicEducator addPublicEducator(PublicEducator publicEducator);

    void delete(int id);

    PublicEducator getByFio(String fio);

    PublicEducator getById(int id);

    PublicEducator edit(PublicEducator publicEducator);

    List<PublicEducator> getAll();
}
