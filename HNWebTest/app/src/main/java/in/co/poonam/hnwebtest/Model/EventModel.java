package in.co.poonam.hnwebtest.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class EventModel {

    @SerializedName("message_code")
    public int messageCode;

    @SerializedName("message")
    public String message;

    @SerializedName("response")
    public ArrayList<EventData> data = new ArrayList<>();


}
