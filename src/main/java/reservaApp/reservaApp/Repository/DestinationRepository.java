package reservaApp.reservaApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reservaApp.reservaApp.Model.Destination;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
}
