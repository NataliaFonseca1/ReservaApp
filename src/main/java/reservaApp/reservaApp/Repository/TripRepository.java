package reservaApp.reservaApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reservaApp.reservaApp.Model.Trip;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByDestinationId(Long destinationId);
}
