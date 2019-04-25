package proj.ahmetov.dao;

import proj.ahmetov.entities.Flight;

import java.util.List;

/** Интерфейс FlightDAO */
public interface FlightDaoInterface {
    /**
     * Получить Flight по id
     * @param id - id полёта
     */
    List<Flight> getFlightsById(Long id);

    /**
     * Удалить Flight по id
     * @param id - id аэропорта
     */
    void deleteFlightById(Long id);

    /**
     * Добавить Flight в базу данных
     * @param flight - Flight для добавления
     */
    void addFlight(Flight flight);


}
