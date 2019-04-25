package proj.ahmetov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import proj.ahmetov.entities.Airport;
import proj.ahmetov.entities.Flight;
import proj.ahmetov.entities.Plane;
import proj.ahmetov.service.AirportService;
import proj.ahmetov.service.FlightService;
import proj.ahmetov.service.PlaneService;

import java.util.List;

@Controller
public class FlightController {
    @Autowired
    FlightService flightService;

    @Autowired
    AirportService airportService;

    @Autowired
    PlaneService planeService;

    private String id;

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



//        Plane plane = new Plane();
//
//        model.addAttribute("plane",plane);
//
//        List<Plane> list = planeService.getPlanesByAirportId(id);
//
//        model.addAttribute("airport_id",id);
//        model.addAttribute("planes",list);

        return "flights";
    }


    @PostMapping("addFlight")
    public String addFlight(@ModelAttribute Flight flight){

        System.out.println("start id: " + flight.getStartPoint().getId() + " end id: " +
                flight.getEndPoint().getId());
        Plane plane = planeService.getPlaneById(id);
        flight.setPlane(plane);

        System.out.println("plane id: " + plane.getId());

        //System.out.println();

        flightService.addFlight(flight);


        return "redirect:flights?id=" + id;
    }
}
