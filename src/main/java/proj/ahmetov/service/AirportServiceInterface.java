package proj.ahmetov.service;

import proj.ahmetov.entities.Airport;

import java.util.List;

/** Интерфейс AirportService*/
public interface AirportServiceInterface {
    /**
     * Получить Airport по id
     * @param id - id аэропорта
     */
    Airport getAirportById(String id);

    /**
     * Удалить Airport по id
     * @param id - id аэропорта
     */
    void deleteAirportById(String id);

    /**
     * Получить список всех Airport
     */
    List<Airport> getAll();

    /**
     * Добавить Airport в базу данных
     * @param airport - Airport для добавления
     */
    void addAirport(Airport airport);
}
