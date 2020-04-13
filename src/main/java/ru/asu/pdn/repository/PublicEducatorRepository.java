package ru.asu.pdn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.asu.pdn.model.PublicEducator;

public interface PublicEducatorRepository extends JpaRepository<PublicEducator, Integer> {
    @Query("select p from PublicEducator p where p.fio = :fio")
    PublicEducator findByFio(@Param("fio") String fio);
}
