package app.kh.characters;

import java.util.Date;
import java.util.ArrayList;

public final class Character {
    private int _id;
    private ArrayList<Object> films;
    private ArrayList<Object> shortFilms;
    private ArrayList<Object> tvShows;
    private ArrayList<String> videoGames;
    private ArrayList<Object> parkAttractions;
    private ArrayList<Object> allies;
    private ArrayList<Object> enemies;
    private String sourceUrl;
    private String name;
    private String imageUrl;
    private Date createdAt;
    private Date updatedAt;
    private String url;
    private int __v;

    public int getId() {
        return _id;
    }

    public int getV() {
        return __v;
    }

    public ArrayList<Object> getFilms() {
        return films;
    }

    public ArrayList<Object> getShortFilms() {
        return shortFilms;
    }

    public ArrayList<Object> getTvShows() {
        return tvShows;
    }

    public ArrayList<String> getVideogames() {
        return videoGames;
    }

    public ArrayList<Object> getParkAttractions() {
        return parkAttractions;
    }

    public ArrayList<Object> getAllies() {
        return allies;
    }

    public ArrayList<Object> getEnemies() {
        return enemies;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public String getUrl() {
        return url;
    }
}
