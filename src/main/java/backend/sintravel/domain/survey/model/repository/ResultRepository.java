package backend.sintravel.domain.survey.model.repository;

import backend.sintravel.domain.survey.model.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, Long> {
}
