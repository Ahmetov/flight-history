package proj.ahmetov.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proj.ahmetov.entities.Airport;
import proj.ahmetov.util.SessionUtil;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("airportDao")
@Transactional
public class AirportDao {

    @PersistenceContext
    private EntityManager entityManager;


//
//    public List<Airport> getAllAirports (){
//        Session session = sessionUtil.openTransactionSession();
//        session.get()
//    }
    public Airport getAirportById(Long id){
        return (Airport) entityManager.createQuery("from Airport a where a.id = :id")
                .setParameter("id",id)
                .getSingleResult();
    }

    public List<Airport> getAll(){
        return entityManager.createQuery("from Airport", Airport.class).getResultList();
    }

    public void addAirport(Airport airport){
        entityManager.persist(airport);
        entityManager.flush();
    }
}
