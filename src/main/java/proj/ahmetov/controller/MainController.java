package proj.ahmetov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import proj.ahmetov.entities.Airport;
import proj.ahmetov.entities.Plane;
import proj.ahmetov.service.AirportService;
import proj.ahmetov.service.PlaneService;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private AirportService airportService;

    @Autowired
    private PlaneService planeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAllAirports(Model model){

        model.addAttribute("airport",new Airport());

        List<Airport> list = airportService.getAll();


        model.addAttribute("airports",list);
        return "index";
    }

    @PostMapping("addAirport")
    public String addAirport(@ModelAttribute Airport airport){
        System.out.println(
                airport.getId() + "\n" +
                        airport.getCity() + "\n" +
                        airport.getCodeIata() + "\n" +
                        airport.getCodeIkao() + "\n"
        );

        airportService.addAirport(airport);

        return "redirect:/";
    }




}
