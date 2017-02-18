package com.example.cz264.heroradio.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cz264.heroradio.Adapters.StationsAdapter;
import com.example.cz264.heroradio.R;
import com.example.cz264.heroradio.Services.DataService;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.
 * Use the {@link StationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StationFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_STATION_TYPE = "station_type";

    // TODO: Rename and change types of parameters
    private int stationType;

    public static final int STATION_TYPE_FEATURED = 0;
    public static final int STATION_TYPE_RECENT = 1;
    public static final int STATION_TYPE_PARTY = 2;

//    private OnFragmentInteractionListener mListener;

    public StationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param stationType .
     *
     * @return A new instance of fragment StationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StationFragment newInstance(int stationType) {
        StationFragment fragment = new StationFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_STATION_TYPE, stationType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            stationType = getArguments().getInt(ARG_STATION_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        StationsAdapter adapter;

        View v = inflater.inflate(R.layout.fragment_station, container, false);
        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.recyclerStations);
        recyclerView.setHasFixedSize(true);


        if (stationType == STATION_TYPE_FEATURED) {

            adapter = new StationsAdapter(DataService.getInstance().getFeaturedStation());

        } else if (stationType == STATION_TYPE_RECENT){

            adapter = new StationsAdapter(DataService.getInstance().getRecentStation());

        } else {

            adapter = new StationsAdapter(DataService.getInstance().getPartyStation());

        }

        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        // Inflate the layout for this fragment
        return v;
    }

}
