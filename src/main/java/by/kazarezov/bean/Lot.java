package by.kazarezov.bean;

import org.apache.commons.fileupload.FileItem;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Lot implements Serializable {
    private int id;
    private String name;
    private boolean active;
    private double price;
    private User organizer;
    private User winner;
    private String description;
    private LocalDateTime creationTime;
    private Image picture;

    public Lot() {
    }

    public Lot(int id, String name, boolean active, double price, User organizer, User winner, String description, LocalDateTime creationTime, Image picture) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.price = price;
        this.organizer = organizer;
        this.winner = winner;
        this.description = description;
        this.creationTime = creationTime;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getOrganizer() {
        return organizer;
    }

    public void setOrganizer(User organizer) {
        this.organizer = organizer;
    }

    public User getWinner() {
        return winner;
    }

    public void setWinner(User winner) {
        this.winner = winner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public Image getPicture() {
        return picture;
    }

    public void setPicture(Image picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lot lot = (Lot) o;
        return id == lot.id && active == lot.active && Double.compare(lot.price, price) == 0 && Objects.equals(name, lot.name) && Objects.equals(organizer, lot.organizer) && Objects.equals(winner, lot.winner) && Objects.equals(description, lot.description) && Objects.equals(creationTime, lot.creationTime) && Objects.equals(picture, lot.picture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, active, price, organizer, winner, description, creationTime, picture);
    }

    @Override
    public String toString() {
        return "Lot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", price=" + price +
                ", organizer=" + organizer +
                ", winner=" + winner +
                ", description='" + description + '\'' +
                ", creationTime=" + creationTime +
                ", picture=" + picture +
                '}';
    }
}
