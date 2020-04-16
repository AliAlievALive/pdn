package ru.asu.pdn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.asu.pdn.model.Violation;
import ru.asu.pdn.repository.ViolationRepository;
import ru.asu.pdn.service.ViolationService;

import java.util.List;

@Service
public class ViolationServiceImpl implements ViolationService {
    @Autowired
    private ViolationRepository repo;

    @Override
    public List<Violation> findAll() {
        return repo.findAll();
    }

    public void save(Violation violation) {
        repo.save(violation);
    }

    public Violation get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
