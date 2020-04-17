package coronavirus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import coronavirus.domain.Country;

public interface CountryRepository extends JpaRepository<Country, Long>{

}
