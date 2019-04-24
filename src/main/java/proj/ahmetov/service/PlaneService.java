package proj.ahmetov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.ahmetov.dao.PlaneDao;
import proj.ahmetov.entities.Plane;

import java.util.List;

@Service
public class PlaneService {
    @Autowired
    private PlaneDao planetDao;

    public List<Plane> getPlanesByAirportId(String id){
        Long parsedId = Long.parseLong(id);
        return planetDao.getPlanesByAirportId(parsedId);
    }

    public void addPlane(Plane plane){
        planetDao.addPlane(plane);
    }
}
