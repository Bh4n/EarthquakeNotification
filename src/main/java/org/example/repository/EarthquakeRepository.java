package org.example.repository;

import org.example.entity.Earthquake;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EarthquakeRepository {
    private List<Earthquake> earthquakes;

    public EarthquakeRepository() {
        this.earthquakes = new ArrayList<>();
    }

    // Deprem ekleme
    public void addEarthquake(Earthquake earthquake) {
        earthquakes.add(earthquake);
    }

    // Tüm depremleri listeleme
    public List<Earthquake> getAllEarthquakes() {
        return earthquakes;
    }

    // Magnitüd'e göre filtreleme
    public List<Earthquake> getEarthquakesByMagnitude(double minMagnitude) {
        return earthquakes.stream()
                .filter(eq -> eq.getMagnitude() >= minMagnitude)
                .collect(Collectors.toList());
    }

    // Yere göre filtreleme
    public List<Earthquake> getEarthquakesByPlace(String place) {
        return earthquakes.stream()
                .filter(eq -> eq.getPlace().equalsIgnoreCase(place))
                .collect(Collectors.toList());
    }
}