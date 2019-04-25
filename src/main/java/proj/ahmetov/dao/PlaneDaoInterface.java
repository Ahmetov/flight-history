package proj.ahmetov.dao;

import proj.ahmetov.entities.Plane;

import java.util.List;

/** Интерфейс PlaneDAO */
public interface PlaneDaoInterface {
    /**
     * Получить Plane по id
     * @param id - id самолёта
     */
    Plane getPlaneById(Long id);

    /**
     * Удалить Plane по id
     * @param id - id аэропорта
     */
    void deletePlaneById(Long id);

    /**
     * Получить список всех Plane
     */
    List<Plane> getPlanesByAirportId(Long id);

    /**
     * Добавить Plane в базу данных
     * @param plane - Plane для добавления
     */
    void addPlane(Plane plane);
}
