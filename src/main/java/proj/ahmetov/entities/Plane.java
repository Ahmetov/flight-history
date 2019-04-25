package proj.ahmetov.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Класс Самолёт
 */
@Entity
@Table(name = "plane")
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Название */
    @Column(name = "plainname")
    private String name;

    /** Местоположение */

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "airport_location_id", referencedColumnName = "id")
    private Airport location;

    /** Полёты */

    @OneToMany(mappedBy = "plane", fetch = FetchType.EAGER, cascade = CascadeType.ALL) //cascade all
    private Set<Flight> flights = new HashSet<>();

    public Plane(){

    }

    /**
     * Конструтор
     * @param name - название самолета
     * @param location - местоположение
     */
    public Plane(String name, Airport location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Airport getLocation() {
        return location;
    }

    public void setLocation(Airport location) {
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    }
}
