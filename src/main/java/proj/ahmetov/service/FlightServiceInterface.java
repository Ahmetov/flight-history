package proj.ahmetov.service;

import proj.ahmetov.entities.Flight;

import java.util.List;

/** Интерфейс FlightService*/
public interface FlightServiceInterface {
    /**
     * Получить Flight по id
     * @param id - id полёта
     */
    List<Flight> getFlightsByPlaneId(String id);

    /**
     * Удалить Flight по id
     * @param id - id аэропорта
     */
    void deleteFlightById(String id);

    /**
     * Добавить Flight в базу данных
     * @param flight - Flight для добавления
     */
    void addFlight(Flight flight);
}
