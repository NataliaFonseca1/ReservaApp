package reservaApp.reservaApp.Service;

import org.springframework.stereotype.Service;
import reservaApp.reservaApp.Model.Booking;
import reservaApp.reservaApp.Model.Trip;
import reservaApp.reservaApp.Repository.BookingRepository;
import reservaApp.reservaApp.Repository.TripRepository;
import reservaApp.reservaApp.Exception.ResourceNotFoundException;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final TripRepository tripRepository;

    public BookingService(BookingRepository bookingRepository, TripRepository tripRepository) {
        this.bookingRepository = bookingRepository;
        this.tripRepository = tripRepository;
    }

    public Booking create(Long tripId, Booking booking) {
        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new ResourceNotFoundException("Trip not found"));
        booking.setTrip(trip);
        // calculate total price
        if (booking.getPeople() == null || booking.getPeople() < 1) {
            booking.setPeople(1);
        }
        booking.setTotalPrice(trip.getPrice() * booking.getPeople());
        booking.setStatus("PENDING");
        booking.setCreatedAt(OffsetDateTime.now());
        return bookingRepository.save(booking);
    }

    public Booking update(Long id, Booking updated) {
        Booking existing = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));
        // Only allow updating client info, people and status. Trip should remain the same.
        existing.setClientName(updated.getClientName());
        existing.setClientEmail(updated.getClientEmail());
        if (updated.getPeople() != null && updated.getPeople() > 0) {
            existing.setPeople(updated.getPeople());
            // recalculate price based on trip price
            if (existing.getTrip() != null && existing.getTrip().getPrice() != null) {
                existing.setTotalPrice(existing.getTrip().getPrice() * existing.getPeople());
            }
        }
        if (updated.getStatus() != null) existing.setStatus(updated.getStatus());
        return bookingRepository.save(existing);
    }

    public void delete(Long id) {
        if (!bookingRepository.existsById(id)) {
            throw new ResourceNotFoundException("Booking not found");
        }
        bookingRepository.deleteById(id);
    }

    public Booking findById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));
    }

    public List<Booking> findAll() { return bookingRepository.findAll(); }
}
