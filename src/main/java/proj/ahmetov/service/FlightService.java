package proj.ahmetov.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.ahmetov.dao.FlightDao;
import proj.ahmetov.entities.Flight;

import java.util.List;

@Service
public class FlightService {
    @Autowired
    FlightDao flightDao;

    public List<Flight> getFlightsByPlaneId(String id){
        Long parsedId = Long.parseLong(id);
        return flightDao.getFlightsById(parsedId);
    }

    public void addFlight(Flight flight){
        flightDao.addFlight(flight);
    }
}
