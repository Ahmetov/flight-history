package proj.ahmetov.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proj.ahmetov.entities.Flight;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("flightDao")
@Transactional
public class FlightDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Flight> getFlightsById(Long id){
        return entityManager.createQuery("from Flight f where f.plane.id = :id")
                .setParameter("id",id)
                .getResultList();
    }

    public void addFlight(Flight flight){
        entityManager.persist(flight);
        entityManager.flush();

    }
}
