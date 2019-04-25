package proj.ahmetov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.ahmetov.dao.PlaneDaoInterface;
import proj.ahmetov.entities.Plane;
import java.util.List;

/** Сервис Plane */
@Service
public class PlaneService implements PlaneServiceInterface{
    /** Репозиторий для хранения самолётов */
    @Autowired
    private PlaneDaoInterface planetDao;

    /**
     * Получить Plane по id
     * @param id - id самолёта
     */
    @Override
    public Plane getPlaneById(String id){
        Long parsedId;
        try{
            parsedId = Long.parseLong(id);
        } catch (NumberFormatException ex){
            return null;
        }
        return planetDao.getPlaneById(parsedId);
    }

    /**
     * Удалить Plane по id
     * @param id - id аэропорта
     */
    @Override
    public void deletePlaneById(String id){
        Long parsedId;
        try{
            parsedId = Long.parseLong(id);
        } catch (NumberFormatException ex){
            return;
        }
        planetDao.deletePlaneById(parsedId);
    }

    /**
     * Получить список всех Plane
     */
    @Override
    public List<Plane> getPlanesByAirportId(String id){
        Long parsedId;
        try{
            parsedId = Long.parseLong(id);
        } catch (NumberFormatException ex){
            return null;
        }
        return planetDao.getPlanesByAirportId(parsedId);
    }

    /**
     * Добавить Plane в базу данных
     * @param plane - Plane для добавления
     */
    @Override
    public void addPlane(Plane plane){
        planetDao.addPlane(plane);
    }
}
