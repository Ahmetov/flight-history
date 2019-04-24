package proj.ahmetov.entities;

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
    private int flightNumber;

    /** Поле самолёт */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "plane_id")
    private Plane plane;

    /** Поле Начало маршрута */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "start_point_id")
    private Airport startPoint;

    /** Поле Конец маршрута */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "end_point_id")
    private Airport endPoint;

    /** Время взлёта */
    @Column(name = "start_time")
    private LocalDateTime startTime;

    /** Время посадки */
    @Column(name = "end_time")
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

    public int getFlightNumber() {
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

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }


}

