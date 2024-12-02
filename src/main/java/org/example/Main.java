package org.example;

import org.example.entity.Earthquake;
import org.example.repository.EarthquakeRepository;
import org.example.repository.EarthquakeService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EarthquakeRepository repository = new EarthquakeRepository();
        EarthquakeService service = new EarthquakeService(repository);

        // Doğru bir deprem ekleme
        service.addEarthquake(new Earthquake("eq1", 1633036800, "San Francisco", 37.7749, -122.4194, 10.0, 4.5));

        // Hatalı bir deprem ekleme
        service.addEarthquake(new Earthquake("eq2", 1633036900, "", 0, 0, 0, -1));

        // Depremleri listele
        System.out.println("\nAll Earthquakes:");
        repository.getAllEarthquakes().forEach(System.out::println);

        // Magnitüd'e göre filtrele
        System.out.println("\nEarthquakes with magnitude >= 4.0:");
        List<Earthquake> filteredByMagnitude = service.getEarthquakesByMagnitude(4.0);
        filteredByMagnitude.forEach(System.out::println);

        // Yere göre filtrele
        System.out.println("\nEarthquakes in San Francisco:");
        List<Earthquake> filteredByPlace = service.getEarthquakesByPlace("San Francisco");
        filteredByPlace.forEach(System.out::println);
    }
}