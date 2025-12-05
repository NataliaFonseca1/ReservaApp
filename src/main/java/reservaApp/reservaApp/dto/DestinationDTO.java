package reservaApp.reservaApp.dto;


public class DestinationDTO {
    private Long id;
    private String name;
    private String country;
    private String city;
    private String description;
    private String imageUrl;
    private Double basePrice;

    public DestinationDTO() {}

    public DestinationDTO(Long id, String name, String country, String city, String description, String imageUrl, Double basePrice) {
        this.id = id; this.name = name; this.country = country; this.city = city;
        this.description = description; this.imageUrl = imageUrl; this.basePrice = basePrice;
    }

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public Double getBasePrice() { return basePrice; }
    public void setBasePrice(Double basePrice) { this.basePrice = basePrice; }
}
