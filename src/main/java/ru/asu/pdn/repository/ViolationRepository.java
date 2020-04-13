package ru.asu.pdn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.asu.pdn.model.Violation;

public interface ViolationRepository extends JpaRepository<Violation, Long> {
}
