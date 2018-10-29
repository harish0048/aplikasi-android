package com.harish.katalogfilm;

import java.io.Serializable;

/**
 * Created by User on 28/10/2018.
 */

public class Movie implements Serializable{
    private String txtTitle;
    private String txtOverview;
    private String releaseDate;
    private String imgPoster;

    public Movie(String title,String overview, String releaseDate, String imgPoster){
        this.txtTitle = title;
        this.txtOverview = overview;
        this.releaseDate = releaseDate;
        this.imgPoster = imgPoster;
    }

    public String getImgPoster() {
        return imgPoster;
    }

    public void setImgPoster(String imgPoster) {
        this.imgPoster = imgPoster;
    }

    public String getTxtTitle() {
        return txtTitle;
    }

    public void setTxtTitle(String txtTitle) {
        this.txtTitle = txtTitle;
    }

    public String getTxtOverview() {
        return txtOverview;
    }

    public void setTxtOverview(String txtOverview) {
        this.txtOverview = txtOverview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }



}
