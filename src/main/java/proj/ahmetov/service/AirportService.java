package proj.ahmetov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.ahmetov.dao.AirportDao;
import proj.ahmetov.entities.Airport;
import java.util.List;

/** Сервис Airport */
@Service
public class AirportService {
    /** Репозиторий для хранения аэропортов */
    @Autowired
    private AirportDao airportDao;

    /**
     * Получить Airport по id
     * @param id - id аэропорта
     */
    public Airport getAirportById(String id){
        Long parsedId = Long.parseLong(id);
        return airportDao.getAirportById(parsedId);
    }

    /**
     * Удалить Airport по id
     * @param id - id аэропорта
     */
    public void deleteAirportById(String id){
        Long parsedId = Long.parseLong(id);
        airportDao.deleteAirportById(parsedId);
    }

    /**
     * Получить список всех Airport
     */
    public List<Airport> getAll(){
        return airportDao.getAll();
    }

    /**
     * Добавить Airport в базу данных
     * @param airport - Airport для добавления
     */
    public void addAirport(Airport airport){
        airportDao.addAirport(airport);
    }

}
