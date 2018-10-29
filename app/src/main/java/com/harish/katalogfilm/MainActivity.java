package com.harish.katalogfilm;

import android.content.Intent;
import android.provider.Settings;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<Movie>> {
    private RecyclerView recyclerView;
    private ArrayList<Movie> list;


    private String URL = "https://api.themoviedb.org/3/movie/now_playing?api_key=67b6380268ec08352e29f665e862f113&region=ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.mainRecycler);
        recyclerView.setHasFixedSize(true);
        getSupportLoaderManager().initLoader(0, null, (LoaderManager.LoaderCallbacks<ArrayList<Movie>>)this).forceLoad();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_cardview:
                Intent intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showRecyclerCardView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MovieAdapter MovieAdapter = new MovieAdapter(this);
        MovieAdapter.setMovies(list);
        recyclerView.setAdapter(MovieAdapter);
    }

    @Override
    public Loader<ArrayList<Movie>> onCreateLoader(int i, Bundle bundle) {
        return new DataMovie(this, URL);
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<Movie>> loader, ArrayList<Movie> movies) {
        this.list = movies;
        Log.d("LIST : ", String.valueOf(this.list.size()));
        if(this.list != null){
            showRecyclerCardView();
        }else{
            setContentView(R.layout.single_page_movie);
        }
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<Movie>> loader) {
        this.list = null;
    }



}