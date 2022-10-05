package br.unicamp.apiretrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig
{
    private static final String BASE_URL = "http://177.220.18.39:3000";
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance()
    {
        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
