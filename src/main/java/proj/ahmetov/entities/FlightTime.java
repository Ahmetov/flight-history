package proj.ahmetov.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Класс время полёта
 */
@Entity
@Table(name = "flight_time")
public class FlightTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hours")
    private long hours;

    @Column(name = "minutes")
    private long minutes;

    @Column(name = "seconds")
    private long seconds;

    public FlightTime(){}

    /**
     * Конструтор
     * @param startTime - время начала
     * @param endTime - время конца полета
     */
    public FlightTime(LocalDateTime startTime, LocalDateTime endTime){

        LocalDateTime tempDateTime = LocalDateTime.from( startTime );

        long years = tempDateTime.until( endTime, ChronoUnit.YEARS);
        tempDateTime = tempDateTime.plusYears( years );

        long months = tempDateTime.until( endTime, ChronoUnit.MONTHS);
        tempDateTime = tempDateTime.plusMonths( months );

        long days = tempDateTime.until( endTime, ChronoUnit.DAYS);
        tempDateTime = tempDateTime.plusDays( days );

        this.hours = tempDateTime.until( endTime, ChronoUnit.HOURS);
        tempDateTime = tempDateTime.plusHours( hours );

        this.minutes = tempDateTime.until( endTime, ChronoUnit.MINUTES);
        tempDateTime = tempDateTime.plusMinutes( minutes );

        this.seconds = tempDateTime.until( endTime, ChronoUnit.SECONDS);
    }


    public long getHours() {
        return hours;
    }

    public void setHours(long hours) {
        this.hours = hours;
    }

    public long getMinutes() {
        return minutes;
    }

    public void setMinutes(long minutes) {
        this.minutes = minutes;
    }

    public long getSeconds() {
        return seconds;
    }

    public void setSeconds(long seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString(){
        return hours + ":"
                + minutes + ":"
                + seconds;
    }
}
