package ru.asu.pdn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.asu.pdn.model.Parent;
import ru.asu.pdn.repository.ParentRepository;
import ru.asu.pdn.service.ParentService;

import java.util.List;

@Service
public class ParentServiceImpl implements ParentService {
    @Autowired
    private ParentRepository parentRepository;

    @Override
    public Parent addParent(Parent parent) {
        Parent saveParent = parentRepository.saveAndFlush(parent);

        return saveParent;
    }

    @Override
    public void delete(int id) {
        parentRepository.deleteById(id);
    }

    @Override
    public Parent getByFio(String fio) {
        return parentRepository.findByFio(fio);
    }

    @Override
    public Parent getById(int id) {
        return parentRepository.findById(id).get();
    }

    @Override
    public Parent edit(Parent parent) {
        return parentRepository.saveAndFlush(parent);
    }

    @Override
    public List<Parent> getAll() {
        return parentRepository.findAll();
    }
}
