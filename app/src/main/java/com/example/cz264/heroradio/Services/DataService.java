package com.example.cz264.heroradio.Services;

import com.example.cz264.heroradio.model.Station;

import java.util.ArrayList;

/**
 * Created by cz264 on 2017/2/17.
 */
public class DataService {
    private static DataService ourInstance = new DataService();

    public static DataService getInstance() {
        return ourInstance;
    }

    private DataService() {
    }


    // Assume we have all the music
    public ArrayList<Station> getFeaturedStation() {
        ArrayList<Station> list = new ArrayList<>();

        list.add(new Station("Fight Plan(Tunes for travle)", "flightplanmusic"));
        list.add(new Station("Two-Wheelin (Biking Playlist)", "bicyclemusic"));
        list.add(new Station("Kids Jams (Music for children)", "kidsmusic"));

        return list;
    }

    public ArrayList<Station> getRecentStation() {
        ArrayList<Station> list = new ArrayList<>();
        return list;
    }

    public ArrayList<Station> getPartyStation() {
        ArrayList<Station> list = new ArrayList<>();
        return list;
    }
}
