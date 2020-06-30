package in.co.poonam.hnwebtest.retrofit;

import in.co.poonam.hnwebtest.Model.EventModel;
import retrofit2.Call;
import retrofit2.http.GET;

import static in.co.poonam.hnwebtest.util.Constant.partyqusetUrl;

public interface RetrofitApiClient {
    @GET(partyqusetUrl)
    Call<EventModel> getEventList();
}
