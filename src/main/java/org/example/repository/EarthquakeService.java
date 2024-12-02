package org.example.repository;


import org.example.entity.Earthquake;

import java.util.List;

public class EarthquakeService {
    private EarthquakeRepository repository;

    public EarthquakeService(EarthquakeRepository repository) {
        this.repository = repository;
    }

    // Yeni deprem ekle
    public void addEarthquake(Earthquake earthquake) {
        if (validateEarthquake(earthquake)) {
            repository.addEarthquake(earthquake);
        } else {
            System.out.println("Invalid earthquake data: " + earthquake);
        }
    }

    // Magnitüd'e göre filtreleme
    public List<Earthquake> getEarthquakesByMagnitude(double minMagnitude) {
        return repository.getEarthquakesByMagnitude(minMagnitude);
    }

    // Yere göre filtreleme
    public List<Earthquake> getEarthquakesByPlace(String place) {
        return repository.getEarthquakesByPlace(place);
    }

    // Deprem doğrulama
    private boolean validateEarthquake(Earthquake earthquake) {
        return earthquake.getMagnitude() > 0 && earthquake.getPlace() != null && !earthquake.getPlace().isEmpty();
    }
}