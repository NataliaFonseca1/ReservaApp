package reservaApp.reservaApp.Controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reservaApp.reservaApp.Model.Destination;
import reservaApp.reservaApp.Repository.DestinationRepository;
import reservaApp.reservaApp.Exception.ResourceNotFoundException;
import reservaApp.reservaApp.dto.DestinationDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/destinations")
@CrossOrigin(origins = {"http://localhost:5173","https://seu-frontend.vercel.app"})
public class DestinationController {

    private final DestinationRepository destinationRepository;

    public DestinationController(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    private DestinationDTO toDTO(Destination d) {
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

    private void applyUpdateFromDto(Destination existing, Destination updated) {
        if (updated.getName() != null) existing.setName(updated.getName());
        if (updated.getCountry() != null) existing.setCountry(updated.getCountry());
        if (updated.getCity() != null) existing.setCity(updated.getCity());
        if (updated.getDescription() != null) existing.setDescription(updated.getDescription());
        if (updated.getImageUrl() != null) existing.setImageUrl(updated.getImageUrl());
        if (updated.getBasePrice() != null) existing.setBasePrice(updated.getBasePrice());
    }

    @PostMapping
    public ResponseEntity<DestinationDTO> create(@Valid @RequestBody Destination destination) {
        Destination saved = destinationRepository.save(destination);
        return ResponseEntity.status(HttpStatus.CREATED).body(toDTO(saved));
    }

    @GetMapping
    public List<DestinationDTO> getAll() {
        return destinationRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public DestinationDTO getById(@PathVariable Long id) {
        Destination d = destinationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Destination not found"));
        return toDTO(d);
    }

    @PutMapping("/{id}")
    public DestinationDTO update(@PathVariable Long id, @Valid @RequestBody Destination updated) {
        Destination existing = destinationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Destination not found"));
        applyUpdateFromDto(existing, updated);
        Destination saved = destinationRepository.save(existing);
        return toDTO(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!destinationRepository.existsById(id)) throw new ResourceNotFoundException("Destination not found");
        destinationRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
