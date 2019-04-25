package proj.ahmetov.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proj.ahmetov.entities.Flight;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/** Репозиторий для хранения полётов */
@Repository("flightDao")
@Transactional
public class FlightDao {
    /** Управление сущностями */
    @PersistenceContext
    private EntityManager entityManager;

    /** Логгер */
    private final static Logger loger = Logger.getLogger(PlaneDao.class);

    /**
     * Получить Flight по id
     * @param id - id полёта
     */
    public List<Flight> getFlightsById(Long id){
        loger.info("Удаление Flight по id = " + id.toString());
        return entityManager.createQuery("from Flight f where f.plane.id = :id")
                .setParameter("id",id)
                .getResultList();
    }

    /**
     * Удалить Flight по id
     * @param id - id аэропорта
     */
    public void deleteFlightById(Long id){
        loger.info("Удаление Flight по id = " + id.toString());
        entityManager.createQuery("delete from Flight a where a.id = :id")
                .setParameter("id",id)
                .executeUpdate();
    }

    /**
     * Добавить Flight в базу данных
     * @param flight - Flight для добавления
     */
    public void addFlight(Flight flight){
        loger.info("Добавляется Flight");
        entityManager.persist(flight);
        entityManager.flush();
    }
}
