package proj.ahmetov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proj.ahmetov.entities.Plane;

public interface PlaneRepository extends JpaRepository<Plane, Long> {

}
