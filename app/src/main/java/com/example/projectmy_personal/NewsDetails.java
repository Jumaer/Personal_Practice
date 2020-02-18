package com.example.projectmy_personal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.projectmy_personal.news_response.Article;
import com.squareup.picasso.Picasso;

public class NewsDetails extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        imageView = findViewById(R.id.news_image);
        Article article = (Article) getIntent().getSerializableExtra("article");
        if(article!=null){
            String imageUrl = article.getUrlToImage();
            Picasso.get().load(imageUrl).into(imageView);
        }
    }
}
