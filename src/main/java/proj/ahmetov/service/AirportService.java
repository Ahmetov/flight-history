package proj.ahmetov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.ahmetov.dao.AirportDaoInterface;
import proj.ahmetov.entities.Airport;
import java.util.List;

/** Сервис Airport */
@Service
public class AirportService implements AirportServiceInterface{
    /** Репозиторий для хранения аэропортов */
    @Autowired
    private AirportDaoInterface airportDao;

    /**
     * Получить Airport по id
     * @param id - id аэропорта
     */
    @Override
    public Airport getAirportById(String id){
        Long parsedId;
        try{
            parsedId = Long.parseLong(id);
        } catch (NumberFormatException ex){
            return null;
        }
        return airportDao.getAirportById(parsedId);
    }

    /**
     * Удалить Airport по id
     * @param id - id аэропорта
     */
    @Override
    public void deleteAirportById(String id){
        Long parsedId;
        try{
            parsedId = Long.parseLong(id);
        } catch (NumberFormatException ex){
            return;
        }
        airportDao.deleteAirportById(parsedId);
    }

    /**
     * Получить список всех Airport
     */
    @Override
    public List<Airport> getAll(){
        return airportDao.getAll();
    }

    /**
     * Добавить Airport в базу данных
     * @param airport - Airport для добавления
     */
    @Override
    public void addAirport(Airport airport){
        airportDao.addAirport(airport);
    }

}
