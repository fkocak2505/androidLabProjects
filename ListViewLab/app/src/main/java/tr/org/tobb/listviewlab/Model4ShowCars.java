package tr.org.tobb.listviewlab;

/**
 * Created by fatihkocak on 7.05.2018.
 */

import java.io.Serializable;

public class Model4ShowCars implements Serializable
{
    private String model;
    private String color;
    private String plates;
    private String seats;


    public Model4ShowCars() {}

    public Model4ShowCars(String model, String color, String plates, String seats) {
        this.model = model;
        this.color = color;
        this.plates = plates;
        this.seats = seats;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlates() {
        return plates;
    }

    public void setPlates(String plates) {
        this.plates = plates;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }
}
