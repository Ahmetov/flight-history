package proj.ahmetov.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Класс Аэропорт
 */
@Entity
@Table(name = "airport")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Название */
    @Column(name = "airportname")
    private String name;

    /** Город */
    @Column(name = "city")
    private String city;

    /** ИАТА код */
    @Column(name = "codeiata")
    private String codeIata;

    /** ИКАО код */
    @Column(name = "codeikao")
    private String codeIkao;

    @OneToMany(mappedBy = "location", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Plane> planes;

    public Airport(){

    }

    /**
     * Конструтор
     * @param name - название
     * @param city - город
     * @param codeIata - ИАТА код
     * @param codeIkao - ИКАО код
     */
    public Airport(String name, String city, String codeIata, String codeIkao) {
        this.name = name;
        this.city = city;
        this.codeIata = codeIata;
        this.codeIkao = codeIkao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCodeIata() {
        return codeIata;
    }

    public void setCodeIata(String codeIata) {
        this.codeIata = codeIata;
    }

    public String getCodeIkao() {
        return codeIkao;
    }

    public void setCodeIkao(String codeIkao) {
        this.codeIkao = codeIkao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(Set<Plane> planes) {
        this.planes = planes;
    }
}
