package com.myproject.booksapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BookDetails extends AppCompatActivity {

    private ArrayList<String> authors;
    TextView titleTV, subtitleTV, publisherTV, publisheddate,description ,thumbnail;
    private ImageView bookIV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        bookIV=findViewById(R.id.idIVbook);
       titleTV=findViewById(R.id.idTVTitle);
       subtitleTV=findViewById(R.id.idTVSubTitle);
       publisherTV=findViewById(R.id.idTVpublisher);
       publisheddate=findViewById(R.id.idTVPublishDate);
       description=findViewById(R.id.idTVDescription);
       String il=getIntent().getStringExtra("bookimage");



       titleTV.setText(getIntent().getStringExtra("booktitle"));
       subtitleTV.setText(getIntent().getStringExtra("booksubtitle"));
       publisherTV.setText(getIntent().getStringExtra("bookpublisher"));
       publisheddate.setText(getIntent().getStringExtra("bookpublisheddate"));
       description.setText(getIntent().getStringExtra("bookdes"));

Picasso.get().load(il).into(bookIV);



       
    }
}