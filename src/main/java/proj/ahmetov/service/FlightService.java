package proj.ahmetov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.ahmetov.dao.FlightDao;
import proj.ahmetov.entities.Flight;
import java.util.List;

/** Сервис Flight */
@Service
public class FlightService {
    /** Репозиторий для хранения полётов */
    @Autowired
    FlightDao flightDao;

    /**
     * Получить Flight по id
     * @param id - id полёта
     */
    public List<Flight> getFlightsByPlaneId(String id){
        Long parsedId = Long.parseLong(id);
        return flightDao.getFlightsById(parsedId);
    }

    /**
     * Удалить Flight по id
     * @param id - id аэропорта
     */
    public void deleteFlightById(String id){
        Long parsedId = Long.parseLong(id);
        flightDao.deleteFlightById(parsedId);
    }

    /**
     * Добавить Flight в базу данных
     * @param flight - Flight для добавления
     */
    public void addFlight(Flight flight){
        flightDao.addFlight(flight);
    }
}
