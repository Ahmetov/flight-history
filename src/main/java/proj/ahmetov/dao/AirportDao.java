package proj.ahmetov.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import proj.ahmetov.entities.Airport;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/** Репозиторий для хранения аэропортов */
@Repository("airportDao")
@Transactional
public class AirportDao implements AirportDaoInterface{
    /** Управление сущностями */
    @PersistenceContext
    private EntityManager entityManager;

    /** Логгер */
    private final static Logger loger = Logger.getLogger(PlaneDao.class);

    /**
     * Получить Airport по id
     * @param id - id аэропорта
     */
    @Override
    public Airport getAirportById(Long id){
        loger.info("Получение Airport по id = " + id.toString());
        return (Airport) entityManager.createQuery("from Airport a where a.id = :id")
                .setParameter("id",id)
                .getSingleResult();
    }

    /**
     * Удалить Airport по id
     * @param id - id аэропорта
     */
    @Override
    public void deleteAirportById(Long id){
        loger.info("Удаление Airport по id = " + id.toString());
            entityManager.createQuery("delete from Airport a where a.id = :id")
                    .setParameter("id",id)
                    .executeUpdate();
    }

    /**
     * Получить список всех Airport
     */
    @Override
    public List<Airport> getAll(){
        return entityManager.createQuery("from Airport", Airport.class).getResultList();
    }

    /**
     * Добавить Airport в базу данных
     * @param airport - Airport для добавления
     */
    @Override
    public void addAirport(Airport airport){
        loger.info("Добавляется Airport");
        entityManager.persist(airport);
        entityManager.flush();
    }
}
