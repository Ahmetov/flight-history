package proj.ahmetov.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proj.ahmetov.entities.Airport;
import proj.ahmetov.entities.Plane;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("planeDao")
@Transactional
public class PlaneDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Plane> getPlanesByAirportId(Long id){
        return entityManager.createQuery("from Plane p where p.location.id = :id")
                .setParameter("id",id)
                .getResultList();
    }

    public void addPlane(Plane plane){
//        System.out.println("persist: " + plane.getLocation().getId() + "\n");
        entityManager.persist(plane);
        entityManager.flush();
    }
}
