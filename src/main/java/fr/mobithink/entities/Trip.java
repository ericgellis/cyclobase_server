package fr.mobithink.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trip implements Serializable {
  @Id @Column(name="trip_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long tripId;

  @Column(name = "name")
  private String tripName;

  @Column(name = "start_time")
  private Long startTime;

  @Column(name = "end_time")
  private Long endTime;

  @Column(name = "city")
  private String city;

  @Column(name = "atmo")
  private int atmo;

  @Column(name = "temperature")
  private String temperature;

  @Column(name = "weather")
  private String weather;

  @Column(name = "start_gps_lat")
  private Long startGpsLat;

  @Column(name = "start_gps_long")
  private Long startGpsLong;

  @Column(name = "end_gps_lat")
  private Long endGpsLat;

  @Column(name = "end_gps_long")
  private Long endGpsLong;

  @OneToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "trip")
  @JsonIgnore
  @JsonSetter
  private Collection<Event> events;

  @OneToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "trip"/*, fetch = FetchType.LAZY*/)
  @JsonIgnore
  @JsonSetter
  private Collection<RollingPoint> rollingPoints;

  @PrePersist
  private void prePersist() {
    events.forEach(c -> c.setTrip(this));
    rollingPoints.forEach(c -> c.setTrip(this));
  }
}
