package proj.ahmetov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.ahmetov.dao.FlightDaoInterface;
import proj.ahmetov.entities.Flight;
import java.util.List;

/** Сервис Flight */
@Service
public class FlightService implements FlightServiceInterface{
    /** Репозиторий для хранения полётов */
    @Autowired
    FlightDaoInterface flightDao;

    /**
     * Получить Flight по id
     * @param id - id полёта
     */
    public List<Flight> getFlightsByPlaneId(String id){
        Long parsedId;
        try{
           parsedId = Long.parseLong(id);
        } catch (NumberFormatException ex){
            return null;
        }
        return flightDao.getFlightsById(parsedId);
    }

    /**
     * Удалить Flight по id
     * @param id - id аэропорта
     */
    @Override
    public void deleteFlightById(String id){
        Long parsedId;
        try{
            parsedId = Long.parseLong(id);
        } catch (NumberFormatException ex){
            return;
        }
        flightDao.deleteFlightById(parsedId);
    }

    /**
     * Добавить Flight в базу данных
     * @param flight - Flight для добавления
     */
    @Override
    public void addFlight(Flight flight){
        flightDao.addFlight(flight);
    }
}
