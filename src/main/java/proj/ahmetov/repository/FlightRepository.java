package proj.ahmetov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.ahmetov.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
