package com.example.projectmy_personal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.projectmy_personal.news_response.Article;
import com.example.projectmy_personal.news_response.NewsApiALLCoreClass;
import com.example.projectmy_personal.news_response.NewsApiService;
import com.example.projectmy_personal.recycle_package.NewsAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String BASE_URL = "https://newsapi.org/";
    private static final String TAG = "Retrofit Call";
    private RecyclerView recyclerView;
    private NewsAdapter newsAdapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.news_recycle);
        linearLayoutManager = new LinearLayoutManager(this);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NewsApiService apiService = retrofit.create(NewsApiService.class);
        apiService.getNewsResponse().enqueue(new Callback<NewsApiALLCoreClass>() {
            @Override
            public void onResponse(Call<NewsApiALLCoreClass> call, Response<NewsApiALLCoreClass> response) {
            if(response.code()==200){
                NewsApiALLCoreClass newsApiALLCoreClass = response.body();
                List<Article> articles = newsApiALLCoreClass.getArticles();


                // news adapter ...

                newsAdapter = new NewsAdapter(MainActivity.this,articles);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(newsAdapter);
                Toast.makeText(MainActivity.this, ""+articles.size(), Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(MainActivity.this, "Something wrong", Toast.LENGTH_SHORT).show();
            }

            }

            @Override
            public void onFailure(Call<NewsApiALLCoreClass> call, Throwable t) {
                Log.e(TAG,t.getLocalizedMessage());
            }
        });
    }
}
