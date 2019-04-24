package proj.ahmetov.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.ahmetov.dao.AirportDao;
import proj.ahmetov.entities.Airport;

import java.util.List;

@Service
public class AirportService {

    @Autowired
    private AirportDao airportDao;

    public Airport getAirportById(String id){
        Long parsedId = Long.parseLong(id);
        return airportDao.getAirportById(parsedId);
    }

    public List<Airport> getAll(){
        return airportDao.getAll();
    }

    public void addAirport(Airport airport){
        airportDao.addAirport(airport);
    }

}
