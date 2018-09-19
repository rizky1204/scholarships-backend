package system.repository;

import org.springframework.data.repository.CrudRepository;
import system.domain.Scholarships;

import java.util.List;

public interface ScholarshipRepository extends CrudRepository<Scholarships, Long> {

    Scholarships findByCountryNameEqualsIgnoreCase(String countryName);
    Scholarships findBySecureId(String secureId);
    List<Scholarships> findAll();
}
