package proj.ahmetov.service;

import proj.ahmetov.entities.Plane;

import java.util.List;

/** Интерфейс PlaneService*/
public interface PlaneServiceInterface {
    /**
     * Получить Plane по id
     * @param id - id самолёта
     */
    Plane getPlaneById(String id);

    /**
     * Удалить Plane по id
     * @param id - id аэропорта
     */
    void deletePlaneById(String id);

    /**
     * Получить список всех Plane
     */
    List<Plane> getPlanesByAirportId(String id);

    /**
     * Добавить Plane в базу данных
     * @param plane - Plane для добавления
     */
    void addPlane(Plane plane);
}
