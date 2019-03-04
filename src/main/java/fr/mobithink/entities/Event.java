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
public class Event implements Serializable {

    @Id
    @Column(name = "event_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    @Column(name = "name")
    private String eventName;

    @Column(name = "type")
    private String eventType;

    @Column(name = "start_time")
    private Long startTime;

    @Column(name = "end_time")
    private Long endTime;

    @Column(name = "gps_lat_start")
    private Long gpsLatStart;

    @Column(name = "gps_long_start")
    private Long gpsLongStart;

    @Column(name = "gps_lat_end")
    private Long gpsLatEnd;

    @Column(name = "gps_long_end")
    private Long gpsLongEnd;

    @Column(name = "voice_memo")
    private String voiceMemo;

    @Column(name = "picture")
    private String picture;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trip_id")
    private Trip trip;
}
