package proj.ahmetov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.ahmetov.entities.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long> {

}
