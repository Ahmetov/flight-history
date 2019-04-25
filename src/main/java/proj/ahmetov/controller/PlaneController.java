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
/**
 * Контроллер для класса Plane
 */
@Controller
public class PlaneController {

    /** Сервис для Plane */
    @Autowired
    private PlaneService planeService;
    /** Сервис для Airport */
    @Autowired
    private AirportService airportService;

    /** id текущего самолёта */
    private String id;

    /** Контроллер главной страницы
     *  */
    @RequestMapping(value = "/planes", method = RequestMethod.GET)
    public String getPlanesByAirportId(@RequestParam(name = "id") String id, Model model){
        this.id = id;

        Plane plane = new Plane();

        model.addAttribute("plane",plane);

        List<Plane> list = planeService.getPlanesByAirportId(id);

        model.addAttribute("airport_id",id);
        model.addAttribute("planes",list);
        return "planes";
    }




    @PostMapping("addPlane")
    public String addPlane(@ModelAttribute Plane plane){

        Airport locationAirport = airportService.getAirportById(id);
        plane.setLocation(locationAirport);

        planeService.addPlane(plane);

        return "redirect:planes?id=" + id;
    }
}
