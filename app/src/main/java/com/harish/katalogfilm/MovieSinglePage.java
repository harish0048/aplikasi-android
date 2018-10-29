package com.harish.katalogfilm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by User on 28/10/2018.
 */

public class MovieSinglePage extends AppCompatActivity {
    private TextView txtTitle;
    private TextView txtDescription;
    private TextView txtDateShow;
    private ImageView imgPoster;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_page_movie);
        Movie m = (Movie) getIntent().getSerializableExtra("M");
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setText(m.getTxtTitle());

        txtDescription = (TextView) findViewById(R.id.txtDescription);
        txtDescription.setText(m.getTxtOverview());

        txtDateShow = (TextView) findViewById(R.id.txtDateShow);
        txtDateShow.setText(m.getReleaseDate());

        imgPoster = (ImageView) findViewById(R.id.posterMovie);
        Glide.with(getApplicationContext())
                .load(m.getImgPoster())
                .override(350, 350)
                .into(imgPoster);


        Log.d("",m.getTxtTitle());
    }
}
