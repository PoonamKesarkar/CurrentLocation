package in.co.poonam.hnwebtest.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class EventData implements Serializable {

    @SerializedName("event_name")
    String event_name;

    @SerializedName("start_date")
    String start_date;

    @SerializedName("start_time")
    String start_time;

    @SerializedName("end_date")
    String end_date;

    @SerializedName("end_time")
    String end_time;

    @SerializedName("event_venue")
    String event_venue;

    @SerializedName("address")
    String address;

    @SerializedName("event_flyer")
    String event_flyer;

    @SerializedName("description")
    String description;

    @SerializedName("lat")
    String latitude;

    @SerializedName("long1")
    String longitude;

    @SerializedName("color")
    String color;

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getEvent_venue() {
        return event_venue;
    }

    public void setEvent_venue(String event_venue) {
        this.event_venue = event_venue;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEvent_flyer() {
        return event_flyer;
    }

    public void setEvent_flyer(String event_flyer) {
        this.event_flyer = event_flyer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
