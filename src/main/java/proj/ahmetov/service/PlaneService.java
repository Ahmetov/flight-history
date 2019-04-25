package proj.ahmetov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.ahmetov.dao.PlaneDao;
import proj.ahmetov.entities.Plane;
import java.util.List;

/** Сервис Plane */
@Service
public class PlaneService {
    /** Репозиторий для хранения самолётов */
    @Autowired
    private PlaneDao planetDao;

    /**
     * Получить Plane по id
     * @param id - id самолёта
     */
    public Plane getPlaneById(String id){
        Long parsedId = Long.parseLong(id);
        return planetDao.getPlaneById(parsedId);
    }

    /**
     * Удалить Plane по id
     * @param id - id аэропорта
     */
    public void deletePlaneById(String id){
        Long parsedId = Long.parseLong(id);
        planetDao.deletePlaneById(parsedId);
    }

    /**
     * Получить список всех Plane
     */
    public List<Plane> getPlanesByAirportId(String id){
        Long parsedId = Long.parseLong(id);
        return planetDao.getPlanesByAirportId(parsedId);
    }

    /**
     * Добавить Plane в базу данных
     * @param plane - Plane для добавления
     */
    public void addPlane(Plane plane){
        planetDao.addPlane(plane);
    }
}
