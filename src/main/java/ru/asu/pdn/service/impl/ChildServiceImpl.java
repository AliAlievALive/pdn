package ru.asu.pdn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.asu.pdn.model.Child;
import ru.asu.pdn.repository.ChildRepository;
import ru.asu.pdn.service.ChildService;

import java.util.List;

@Service
public class ChildServiceImpl implements ChildService {
    @Autowired
    private ChildRepository childRepository;

    @Override
    public Child addChild(Child child) {
        Child saveChild = childRepository.saveAndFlush(child);

        return saveChild;
    }

    @Override
    public void delete(int id) {
        childRepository.deleteById(id);
    }

    @Override
    public Child getByFio(String fio) {
        return childRepository.findByFio(fio);
    }

    @Override
    public Child getById(int id) {
        return childRepository.findById(id).get();
    }

    @Override
    public Child edit(Child child) {
        return childRepository.saveAndFlush(child);
    }

    @Override
    public List<Child> getAll() {
        return childRepository.findAll();
    }
}
