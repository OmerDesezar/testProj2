package testPackage;

import java.time.LocalDate;
import java.util.Objects;

public class Order implements Comparable<Order> {
    private LocalDate readyOn;
    private String text;
    private boolean Important;
    private boolean poped;

    public Order(LocalDate readyOn, String text, boolean important) {
        this.readyOn = readyOn;
        this.text = text;
        this.Important = important;
        this.poped = false;
    }

    public LocalDate getReadyOn() {
        return readyOn;
    }

    public void setReadyOn(LocalDate readyOn) {
        this.readyOn = readyOn;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isImportant() {
        return Important;
    }

    public void setImportant(boolean important) {
        Important = important;
    }

    public boolean isPoped() {
        return poped;
    }

    public void setPoped(boolean poped) {
        this.poped = poped;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(readyOn, order.readyOn) &&
                Objects.equals(text, order.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(readyOn, text);
    }

    @Override
    public String toString() {
        return "Order - " +
                "ready On: " + readyOn +
                ", text: '" + text + '\'' +
                ", Important? " + Important +
                ", poped? " + poped +
                "}\n";
    }

    @Override
    public int compareTo(Order o) {
        return this.readyOn.compareTo(o.readyOn);
    }
}
