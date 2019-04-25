package proj.ahmetov.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proj.ahmetov.entities.Plane;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/** Репозиторий для хранения самолётов */
@Repository("planeDao")
@Transactional
public class PlaneDao {
    /** Управление сущностями */
    @PersistenceContext
    private EntityManager entityManager;

    /** Логгер */
    private final static Logger loger = Logger.getLogger(PlaneDao.class);

    /**
     * Получить Plane по id
     * @param id - id самолёта
     */
    public Plane getPlaneById(Long id){
        loger.info("Получение Plane по id = " + id.toString());
        return (Plane) entityManager.createQuery("from Plane p where p.id = :id")
                .setParameter("id",id)
                .getSingleResult();
    }

    /**
     * Удалить Plane по id
     * @param id - id аэропорта
     */
    public void deletePlaneById(Long id){
        loger.info("Удаление Plane по id = " + id.toString());
        entityManager.createQuery("delete from Plane p where p.id = :id")
                .setParameter("id",id)
                .executeUpdate();
    }

    /**
     * Получить список всех Plane
     */
    public List<Plane> getPlanesByAirportId(Long id){
        return entityManager.createQuery("from Plane p where p.location.id = :id")
                .setParameter("id",id)
                .getResultList();
    }

    /**
     * Добавить Plane в базу данных
     * @param plane - Plane для добавления
     */
    public void addPlane(Plane plane){
        loger.info("Добавляется Plane");
        entityManager.persist(plane);
        entityManager.flush();
    }
}
