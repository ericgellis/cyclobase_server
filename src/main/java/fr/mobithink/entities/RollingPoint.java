package fr.mobithink.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RollingPoint implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="rollingPointId")
  private Long rollingPointId;

  @Column(name = "gps_lat")
  private Long gpsLat;

  @Column(name = "gps_long")
  private Long gpsLong;

  @Column(name = "point_time")
  private Long timeOfRollingPoint;

  @ManyToOne
  @JoinColumn(name = "trip_id")
  private Trip trip;
}
