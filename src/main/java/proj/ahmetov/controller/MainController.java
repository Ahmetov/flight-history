package proj.ahmetov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import proj.ahmetov.entities.Airport;
import proj.ahmetov.service.AirportService;
import proj.ahmetov.service.PlaneService;
import java.util.List;

/**
 * Контроллер для класса Airport
 */
@Controller
public class MainController {

    /** Сервис для Airport */
    @Autowired
    private AirportService airportService;

    /** Сервис для Plane */
    @Autowired
    private PlaneService planeService;

    /** Контроллер главной страницы
     *  */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAllAirports(Model model){
        model.addAttribute("airport",new Airport());
        List<Airport> list = airportService.getAll();
        model.addAttribute("airports",list);
        return "index";
    }

    /**
     * Контроллер удаления Airport из базы данных
     * @param id - id Airport для удаления
     *  */
    @RequestMapping(value = "deleteAirport/{id}", method = RequestMethod.GET)
    public String deleteAirport(@PathVariable String id){
        System.out.println("delete id = " + id );
        airportService.deleteAirportById(id);
        return "redirect:/";
    }

    /**
     * Контроллер добавления Airport в базу данных
     * @param airport - Airport для добавления
     *  */
    @PostMapping("addAirport")
    public String addAirport(@ModelAttribute Airport airport){
        airportService.addAirport(airport);
        return "redirect:/";
    }
}
