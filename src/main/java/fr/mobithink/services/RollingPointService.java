package fr.mobithink.services;

import fr.mobithink.entities.RollingPoint;

import java.util.List;

public interface RollingPointService {

    List<RollingPoint> getAllRollingPoints();
    RollingPoint getRollingPointById(Long rollingPointId);
    List<RollingPoint> findRollingPointsByTripId(Long tripId);
    RollingPoint modifyRollingPoint(RollingPoint rollingPoint, Long rollingPointId);
    RollingPoint createRollingPoint(RollingPoint rollingPoint);
    void deleteRollingPoint(Long rollingPointId);
}
