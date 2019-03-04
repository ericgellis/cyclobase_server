package fr.mobithink.dao;

import fr.mobithink.entities.RollingPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RollingPointRepository extends JpaRepository<RollingPoint, Long> {

    @Query("select r FROM RollingPoint r where r.trip.tripId = :tripId")
    List<RollingPoint> findRollingPointsByTripId(@Param("tripId") Long tripId);
}
