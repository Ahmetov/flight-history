package proj.ahmetov.dao;

import proj.ahmetov.entities.Airport;

import java.util.List;

/** Интерфейс AirportDAO */
public interface AirportDaoInterface {
    /**
     * Получить Airport по id
     * @param id - id аэропорта
     */
    Airport getAirportById(Long id);

    /**
     * Удалить Airport по id
     * @param id - id аэропорта
     */
    void deleteAirportById(Long id);

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
