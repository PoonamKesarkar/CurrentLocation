package in.co.poonam.hnwebtest.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static in.co.poonam.hnwebtest.util.Constant.baseUrl;

public class RetrofitSingleton {
    private static Retrofit retrofit = null;
    private static RetrofitSingleton retrofitSingletonInstance;

    private RetrofitSingleton() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    public static synchronized RetrofitSingleton getInstance() {
        if (retrofitSingletonInstance == null)
            retrofitSingletonInstance = new RetrofitSingleton();
        return retrofitSingletonInstance;
    }

    public RetrofitApiClient getApi() {
        return retrofit.create(RetrofitApiClient.class);
    }

}
