package reservaApp.reservaApp.Controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import reservaApp.reservaApp.Model.Booking;
import reservaApp.reservaApp.Model.Trip;
import reservaApp.reservaApp.Service.BookingService;
import reservaApp.reservaApp.dto.BookingDTO;
import reservaApp.reservaApp.dto.TripDTO;
import reservaApp.reservaApp.dto.DestinationDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = {"http://localhost:5173","https://seu-frontend.vercel.app"})
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    private DestinationDTO toDestinationDTO(Trip t) {
        return new DestinationDTO(
                t.getDestination().getId(),
                t.getDestination().getName(),
                t.getDestination().getCountry(),
                t.getDestination().getCity(),
                t.getDestination().getDescription(),
                t.getDestination().getImageUrl(),
                t.getDestination().getBasePrice()
        );
    }

    private TripDTO toTripDTO(Trip t) {
        return new TripDTO(
                t.getId(),
                t.getStartDate(),
                t.getEndDate(),
                t.getSeats(),
                t.getPrice(),
                toDestinationDTO(t)
        );
    }

    private BookingDTO toBookingDTO(Booking b) {
        return new BookingDTO(
                b.getId(),
                b.getClientName(),
                b.getClientEmail(),
                b.getPeople(),
                b.getStatus(),
                b.getTotalPrice(),
                b.getCreatedAt(),
                toTripDTO(b.getTrip())
        );
    }

    @PostMapping("/trip/{tripId}")
    public ResponseEntity<BookingDTO> create(@PathVariable Long tripId, @Valid @RequestBody Booking booking) {

        Booking saved = bookingService.create(tripId, booking);

        return ResponseEntity.status(HttpStatus.CREATED).body(toBookingDTO(saved));
    }

    @GetMapping
    public List<BookingDTO> getAll() {
        return bookingService.findAll()
                .stream()
                .map(this::toBookingDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BookingDTO getById(@PathVariable Long id) {
        return toBookingDTO(bookingService.findById(id));
    }

    @PutMapping("/{id}")
    public BookingDTO update(@PathVariable Long id, @Valid @RequestBody Booking updated) {
        Booking b = bookingService.update(id, updated);
        return toBookingDTO(b);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookingService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
