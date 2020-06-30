package in.co.poonam.hnwebtest.Model;

import java.util.ArrayList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import in.co.poonam.hnwebtest.retrofit.RetrofitSingleton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventViewModel extends ViewModel {
    private MutableLiveData<ArrayList<EventModel>> eventList;
    private MutableLiveData<Boolean> isShow;

    public LiveData<ArrayList<EventModel>> getEventList(){
        eventList = new MutableLiveData<>();
        getEventListApi();
        return eventList;
    }

    private void getEventListApi() {
        isShow = new MutableLiveData<>();
        Call<EventModel> responseCall = RetrofitSingleton.getInstance().getApi().getEventList();
        final ArrayList<EventModel> list = new ArrayList<>();
        isShow.setValue(true);
        responseCall.enqueue(new Callback<EventModel>() {
            @Override
            public void onResponse(Call<EventModel> call, Response<EventModel> response) {
                EventModel eventModel=response.body();
                list.add(eventModel);
                isShow.setValue(false);
                eventList.setValue(list);
            }

            @Override
            public void onFailure(Call<EventModel> call, Throwable t) {
                isShow.setValue(false);
                call.cancel();
            }
        });
    }

    public LiveData<Boolean> showDialog() {
        return isShow;
    }
}
