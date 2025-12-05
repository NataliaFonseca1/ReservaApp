package reservaApp.reservaApp.dto;

import java.time.LocalDate;

public class TripDTO {

    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer seats;
    private Double price;
    private String description;
    private DestinationDTO destination;
    private String location;

    public TripDTO() {}

    // 👉 construtor usado pelo BookingController (sem location)
    public TripDTO(Long id,
                   LocalDate startDate,
                   LocalDate endDate,
                   Integer seats,
                   Double price,
                   DestinationDTO destination) {
        this(id, startDate, endDate, seats, price, null, destination);
    }

    // 👉 construtor usado pelo TripController (com location)
    public TripDTO(Long id,
                   LocalDate startDate,
                   LocalDate endDate,
                   Integer seats,
                   Double price,
                   String location,
                   DestinationDTO destination) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.seats = seats;
        this.price = price;
        this.location = location;
        this.destination = destination;
    }

    // GETTERS & SETTERS

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public Integer getSeats() { return seats; }
    public void setSeats(Integer seats) { this.seats = seats; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public DestinationDTO getDestination() { return destination; }
    public void setDestination(DestinationDTO destination) { this.destination = destination; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
