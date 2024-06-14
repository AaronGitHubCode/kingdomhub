package app.kh.characters;

import java.util.Date;
import java.util.ArrayList;

import lombok.Getter;

@Getter
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
}
