package fr.mobithink.restController;

import fr.mobithink.entities.RollingPoint;
import fr.mobithink.services.RollingPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rollingPoints")
public class RollingPointRestController {

    private RollingPointService rollingPointService;

    @Autowired
    public RollingPointRestController(RollingPointService rollingPointService) {
        this.rollingPointService = rollingPointService;
    }

    @GetMapping
    public ResponseEntity<List<RollingPoint>> getAllRollingPoints() {
        return ResponseEntity.ok(rollingPointService.getAllRollingPoints());
    }

    @GetMapping(value = "/{rollingPointId}")
    public ResponseEntity<RollingPoint> getRollingPointById(@PathVariable Long rollingPointId) {
        return ResponseEntity.ok(rollingPointService.getRollingPointById(rollingPointId));
    }

    @GetMapping(value = "/trip/{tripId}")
    public List<RollingPoint> findRollingPointsByTripId(@PathVariable Long tripId) {
        return rollingPointService.findRollingPointsByTripId(tripId);
    }

    @PutMapping(value = "/{rollingPointId}")
    public ResponseEntity<RollingPoint> modifyRollingPoint(@RequestBody RollingPoint rollingPoint, @PathVariable Long rollingPointId) {
        rollingPointService.modifyRollingPoint(rollingPoint, rollingPointId);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<RollingPoint> createRollingPoint(@RequestBody RollingPoint rollingPoint) {
        rollingPointService.createRollingPoint(rollingPoint);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{rollingPointId}")
    public void deleteRollingPoint(@PathVariable Long rollingPointId) {
        rollingPointService.deleteRollingPoint(rollingPointId);
    }
}
