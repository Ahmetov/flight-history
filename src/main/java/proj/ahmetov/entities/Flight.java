package proj.ahmetov.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Класс Полёт самолёта
 */

@Entity
@Table(name = "flight")
public class Flight {

    /** Номер рейса */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_number")
    private Long flightNumber;

    /** Поле самолёт */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "plane_id", referencedColumnName = "id")
    private Plane plane;

    /** Поле Начало маршрута */
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "start_point_id", referencedColumnName = "id")
    private Airport startPoint;

    /** Поле Конец маршрута */
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "end_point_id", referencedColumnName = "id")
    private Airport endPoint;

    /** Время взлёта */
    @Column(name = "start_time")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime startTime;

    /** Время посадки */
    @Column(name = "end_time")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime endTime;

    /** Время полёта */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_time_id")
    private FlightTime flightTime;

    public Flight(){}

    /**
     * Конструтор
     * @param plane - самолёт
     * @param startPoint - начало маршрута
     * @param endPoint - конец маршрута
     * @param startTime - время начала
     * @param endTime - время конца полета
     */
    public Flight(Plane plane, Airport startPoint, Airport endPoint, LocalDateTime startTime, LocalDateTime endTime) {
        this.plane = plane;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.startTime = startTime;
        this.endTime = endTime;
        this.flightTime = new FlightTime(startTime,endTime);
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Long getFlightNumber() {
        return flightNumber;
    }

    public Airport getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Airport startPoint) {
        this.startPoint = startPoint;
    }

    public Airport getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Airport endPoint) {
        this.endPoint = endPoint;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public FlightTime getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(FlightTime flightTime) {
        this.flightTime = flightTime;
    }

    public void setFlightNumber(Long flightNumber) {
        this.flightNumber = flightNumber;
    }


}

