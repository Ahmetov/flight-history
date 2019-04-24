package proj.ahmetov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.ahmetov.entities.FlightTime;

public interface FlightTimeRepository extends JpaRepository<FlightTime, Long> {

}