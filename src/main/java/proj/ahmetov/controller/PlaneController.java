package proj.ahmetov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import proj.ahmetov.entities.Airport;
import proj.ahmetov.entities.Plane;
import proj.ahmetov.service.AirportServiceInterface;
import proj.ahmetov.service.PlaneServiceInterface;

import java.util.List;
/**
 * Контроллер для класса Plane
 */
@Controller
public class PlaneController {

    /** Сервис для Plane */
    @Autowired
    private PlaneServiceInterface planeService;
    /** Сервис для Airport */
    @Autowired
    private AirportServiceInterface airportService;

    /** id текущего аэропорта */
    private String id;

    /** Контроллер для страницы planes
     * @param id - id текущего аэропорта
     * @param model - модель страницы
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

    /**
     * Контроллер удаления Plane из базы данных
     * @param id - id Plane для удаления
     *  */
    @RequestMapping(value = "deletePlane/{id}", method = RequestMethod.GET)
    public String deletePlane(@PathVariable String id){
        planeService.deletePlaneById(id);
        return "redirect:/planes?id=" + this.id;
    }

    /** Контроллер для добавления plane
     * @param plane - plane для добавления в базу данных
     *  */
    @PostMapping("addPlane")
    public String addPlane(@ModelAttribute Plane plane){
        Airport locationAirport = airportService.getAirportById(id);
        plane.setLocation(locationAirport);
        planeService.addPlane(plane);
        return "redirect:planes?id=" + id;
    }
}
