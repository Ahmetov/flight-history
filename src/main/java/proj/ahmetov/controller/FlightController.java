package proj.ahmetov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import proj.ahmetov.entities.Airport;
import proj.ahmetov.entities.Flight;
import proj.ahmetov.entities.FlightTime;
import proj.ahmetov.entities.Plane;
import proj.ahmetov.service.AirportService;
import proj.ahmetov.service.FlightService;
import proj.ahmetov.service.PlaneService;
import java.util.List;

/**
 * Контроллер для класса Flight
 */
@Controller
public class FlightController {
    /** Сервис для Flight */
    @Autowired
    FlightService flightService;

    /** Сервис для Airport */
    @Autowired
    AirportService airportService;

    /** Сервис для Plane */
    @Autowired
    PlaneService planeService;

    /** id текущего самолёта */
    private String id;

    /** Контроллер для страницы flights
     * @param id - id текущего самолёта
     * @param model - модель страницы
     *  */
    @RequestMapping(value = "/flights", method = RequestMethod.GET)
    public String getPlanesByAirportId(@RequestParam(name = "id") String id, Model model){
        this.id = id;
        Flight flight = new Flight();
        flight.setStartPoint(new Airport());
        flight.setEndPoint(new Airport());
        model.addAttribute("flight",flight);

        List<Airport> airList = airportService.getAll();
        model.addAttribute("airports",airList);

        List<Flight> list = flightService.getFlightsByPlaneId(id);
        for(Flight f : list)
        {
            System.out.println(f.getStartPoint().getName());
        }

        model.addAttribute("plane_id",id);
        model.addAttribute("flights",list);
        return "flights";
    }

    /**
     * Контроллер удаления Flight из базы данных
     * @param id - id Flight для удаления
     *  */
    @RequestMapping(value = "deleteFlight/{id}", method = RequestMethod.GET)
    public String deleteFlight(@PathVariable String id){
        flightService.deleteFlightById(id);
        return "redirect:/flights?id=" + this.id;
    }

    /** Контроллер добавления flight в базу данных
     * @param flight - flight для добавления в базу данных
     *  */
    @PostMapping("addFlight")
    public String addFlight(@ModelAttribute Flight flight){
        Plane plane = planeService.getPlaneById(id);
        flight.setPlane(plane);
        flight.setFlightTime(new FlightTime(flight.getStartTime(),flight.getEndTime()));
        flightService.addFlight(flight);
        return "redirect:flights?id=" + id;
    }
}
