package reservaApp.reservaApp.dto;

import java.time.OffsetDateTime;

public class BookingDTO {

    private Long id;
    private String clientName;
    private String clientEmail;
    private Integer people;
    private String status;
    private Double totalPrice;
    private OffsetDateTime createdAt;

    private TripDTO trip; // Trip resumida

    public BookingDTO() {}

    public BookingDTO(Long id, String clientName, String clientEmail, Integer people,
                      String status, Double totalPrice, OffsetDateTime createdAt, TripDTO trip) {
        this.id = id;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.people = people;
        this.status = status;
        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
        this.trip = trip;
    }

    // GETTERS & SETTERS

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }

    public String getClientEmail() { return clientEmail; }
    public void setClientEmail(String clientEmail) { this.clientEmail = clientEmail; }

    public Integer getPeople() { return people; }
    public void setPeople(Integer people) { this.people = people; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(Double totalPrice) { this.totalPrice = totalPrice; }

    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }

    public TripDTO getTrip() { return trip; }
    public void setTrip(TripDTO trip) { this.trip = trip; }
}
