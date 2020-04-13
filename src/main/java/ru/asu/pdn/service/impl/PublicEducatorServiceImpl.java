package ru.asu.pdn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.asu.pdn.model.PublicEducator;
import ru.asu.pdn.repository.PublicEducatorRepository;
import ru.asu.pdn.service.PublicEducatorService;

import java.util.List;

@Service
public class PublicEducatorServiceImpl implements PublicEducatorService {
    @Autowired
    private PublicEducatorRepository publicEducatorRepository;

    @Override
    public PublicEducator addPublicEducator(PublicEducator publicEducator) {
        PublicEducator savePublicEducator = publicEducatorRepository.saveAndFlush(publicEducator);

        return savePublicEducator;
    }

    @Override
    public void delete(int id) {
        publicEducatorRepository.deleteById(id);
    }

    @Override
    public PublicEducator getByFio(String fio) {
        return publicEducatorRepository.findByFio(fio);
    }

    @Override
    public PublicEducator getById(int id) {
        return publicEducatorRepository.findById(id).get();
    }

    @Override
    public PublicEducator edit(PublicEducator publicEducator) {
        return publicEducatorRepository.saveAndFlush(publicEducator);
    }

    @Override
    public List<PublicEducator> getAll() {
        return publicEducatorRepository.findAll();
    }
}
