package coronavirus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import coronavirus.domain.Global;

public interface GlobalRepository extends JpaRepository<Global, Long>{

}
