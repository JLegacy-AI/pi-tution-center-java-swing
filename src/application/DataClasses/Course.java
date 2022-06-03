package application.DataClasses;

import java.time.LocalDateTime;

public class Course {
    private String id;
    private int price;
    private LocalDateTime time;

    private String name;
    private int capacity=4;

    public Course() {
    }

    public Course(String id, int price, String name, LocalDateTime parse) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.time = parse;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
