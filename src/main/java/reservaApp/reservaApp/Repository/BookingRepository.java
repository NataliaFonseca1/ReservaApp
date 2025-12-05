package reservaApp.reservaApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reservaApp.reservaApp.Model.Booking;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByTripId(Long tripId);
}
