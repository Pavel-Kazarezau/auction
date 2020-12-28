package by.kazarezov.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Deposit implements Serializable {
    private int id;
    private Lot lot;
    private User user;
    private double value;
    private LocalDateTime time;

    public Deposit() {
    }

    public Deposit(int id, Lot lot, User user, double value, LocalDateTime time) {
        this.id = id;
        this.lot = lot;
        this.user = user;
        this.value = value;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deposit deposit = (Deposit) o;
        return id == deposit.id && Double.compare(deposit.value, value) == 0 && Objects.equals(lot, deposit.lot) && Objects.equals(user, deposit.user) && Objects.equals(time, deposit.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lot, user, value, time);
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + id +
                ", lot=" + lot +
                ", user=" + user +
                ", value=" + value +
                ", time=" + time +
                '}';
    }
}
