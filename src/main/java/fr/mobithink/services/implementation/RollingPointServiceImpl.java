package fr.mobithink.services.implementation;

import fr.mobithink.dao.RollingPointRepository;
import fr.mobithink.entities.RollingPoint;
import fr.mobithink.exceptions.RollingPointNotFoundException;
import fr.mobithink.services.RollingPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RollingPointServiceImpl implements RollingPointService {

    private RollingPointRepository rollingPointRepository;

    @Autowired
    public RollingPointServiceImpl(RollingPointRepository rollingPointRepository) {
        this.rollingPointRepository = rollingPointRepository;
    }

    @Override
    public List<RollingPoint> getAllRollingPoints() {
        return rollingPointRepository.findAll();
    }

    @Override
    public RollingPoint getRollingPointById(Long rollingPointId) {
        return rollingPointRepository.findById(rollingPointId).orElseThrow(() -> new RollingPointNotFoundException(rollingPointId));
    }

    @Override
    public List<RollingPoint> findRollingPointsByTripId(Long tripId) {
        return rollingPointRepository.findRollingPointsByTripId(tripId);
    }

    @Override
    public RollingPoint modifyRollingPoint(RollingPoint rollingPoint, Long rollingPointId) {
        // l'appelle à cette méthode va garantir une exception en cas ou le Event n'est pas retrouvable
        this.getRollingPointById(rollingPointId);

        rollingPoint.setRollingPointId(rollingPointId);
        return rollingPointRepository.saveAndFlush(rollingPoint);
    }

    @Override
    public RollingPoint createRollingPoint(RollingPoint rollingPoint) {
        return rollingPointRepository.save(rollingPoint);
    }

    @Override
    public void deleteRollingPoint(Long rollingPointId) {
        // l'appelle à cette méthode va garantir une exception en cas ou le Event n'est pas retrouvable
        this.getRollingPointById(rollingPointId);

        rollingPointRepository.deleteById(rollingPointId);
    }
}
