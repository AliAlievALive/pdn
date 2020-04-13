package ru.asu.pdn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.asu.pdn.model.Child;

public interface ChildRepository extends JpaRepository<Child, Integer> {
    @Query("select c from Child c where c.fio = :fio")
    Child findByFio(@Param("fio") String fio);
}
