package ru.asu.pdn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.asu.pdn.model.Parent;

public interface ParentRepository extends JpaRepository<Parent, Integer> {
    @Query("select p from Parent p where p.fio = :fio")
    Parent findByFio(@Param("fio") String fio);
}
