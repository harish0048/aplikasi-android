package com.harish.katalogfilm;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by User on 28/10/2018.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.CardViewHolder> {

    private ArrayList<Movie> movies;
    private Context context;

    public MovieAdapter(Context context){
        this.context = context;
    }
    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    };
    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_movie, viewGroup, false);
        CardViewHolder viewHolder = new CardViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CardViewHolder cardViewHolder, int i) {
        final Movie m = getMovies().get(i);

        Glide.with(context)
                .load(m.getImgPoster())
                .override(350, 350)
                .into(cardViewHolder.imgPoster);

        cardViewHolder.txtTitle.setText(m.getTxtTitle());
        String overview = m.getTxtOverview();
        if(overview.length() >= 100){
            overview = m.getTxtOverview().substring(0, 100) + "... ";
        }
        cardViewHolder.txtOverview.setText(overview);

        cardViewHolder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MovieSinglePage.class);
                intent.putExtra("M", m);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return getMovies().size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPoster;
        TextView txtTitle, txtOverview;
        Button btnDetail;

        public CardViewHolder(View view) {
            super(view);
            imgPoster = (ImageView)itemView.findViewById(R.id.imgPoster);
            txtTitle = (TextView)itemView.findViewById(R.id.txtTitle);
            txtOverview = (TextView)itemView.findViewById(R.id.txtOverview);
            btnDetail = (Button)itemView.findViewById(R.id.btnDetail);
        }
    }
}
