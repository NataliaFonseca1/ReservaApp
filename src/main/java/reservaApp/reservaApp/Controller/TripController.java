package reservaApp.reservaApp.Controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reservaApp.reservaApp.Model.Trip;
import reservaApp.reservaApp.Model.Destination;
import reservaApp.reservaApp.Repository.TripRepository;
import reservaApp.reservaApp.Repository.DestinationRepository;
import reservaApp.reservaApp.Exception.ResourceNotFoundException;
import reservaApp.reservaApp.dto.TripDTO;
import reservaApp.reservaApp.dto.DestinationDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/trips")
@CrossOrigin(origins = {"http://localhost:5173","https://seu-frontend.vercel.app"})
public class TripController {

    private final TripRepository tripRepository;
    private final DestinationRepository destinationRepository;

    public TripController(TripRepository tripRepository, DestinationRepository destinationRepository) {
        this.tripRepository = tripRepository;
        this.destinationRepository = destinationRepository;
    }

    private DestinationDTO toDestinationDTO(Destination d) {
        if (d == null) return null;
        return new DestinationDTO(
                d.getId(),
                d.getName(),
                d.getCountry(),
                d.getCity(),
                d.getDescription(),
                d.getImageUrl(),
                d.getBasePrice()
        );
    }

    // 👉 conversão Trip -> TripDTO usando o construtor novo (com location)
    private TripDTO toTripDTO(Trip t) {
        if (t == null) return null;
        return new TripDTO(
                t.getId(),
                t.getStartDate(),
                t.getEndDate(),
                t.getSeats(),
                t.getPrice(),
                t.getLocation(),
                toDestinationDTO(t.getDestination())
        );
    }

    @PostMapping("/destination/{destinationId}")
    public ResponseEntity<TripDTO> create(@PathVariable Long destinationId, @Valid @RequestBody Trip trip) {
        Destination dest = destinationRepository.findById(destinationId)
                .orElseThrow(() -> new ResourceNotFoundException("Destination not found"));
        trip.setDestination(dest);
        Trip saved = tripRepository.save(trip);
        return ResponseEntity.status(HttpStatus.CREATED).body(toTripDTO(saved));
    }

    /**
     * GET /api/trips
     * optional query param: ?destination=ID
     * if destination present, returns trips only for that destination
     */
    @GetMapping
    public List<TripDTO> getAll(@RequestParam(value = "destination", required = false) Long destinationId) {
        List<Trip> trips;
        if (destinationId != null) {
            trips = tripRepository.findByDestinationId(destinationId);
        } else {
            trips = tripRepository.findAll();
        }
        return trips.stream().map(this::toTripDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TripDTO getById(@PathVariable Long id) {
        Trip t = tripRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trip not found"));
        return toTripDTO(t);
    }

    @PutMapping("/{id}")
    public TripDTO update(@PathVariable Long id, @Valid @RequestBody Trip updated) {
        Trip existing = tripRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trip not found"));
        existing.setStartDate(updated.getStartDate());
        existing.setEndDate(updated.getEndDate());
        existing.setSeats(updated.getSeats());
        existing.setPrice(updated.getPrice());
        // destination permanece o mesmo
        Trip saved = tripRepository.save(existing);
        return toTripDTO(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!tripRepository.existsById(id)) throw new ResourceNotFoundException("Trip not found");
        tripRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
