package com.example.projectmy_personal.news_response;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsApiService {
    @GET("v2/everything?q=bitcoin&from=2020-02-07&sortBy=publishedAt&apiKey=0c124027b61a44518f35c4ca23f5d4e4")
    Call<NewsApiALLCoreClass> getNewsResponse();
}
