package application.DataClasses;

import java.util.ArrayList;

public class Notes {
    private String bid;
    private String notes;

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "bid='" + bid + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
