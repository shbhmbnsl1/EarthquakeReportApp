package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rd on 21-01-2017.
 */
public class EarthquakeLoader extends AsyncTaskLoader<ArrayList<QuakeData>> {

    private static final String LOG_TAG = EarthquakeLoader.class.getName();
    private String mUrl;


    public EarthquakeLoader(Context context, String url)
    {
        super(context);
        mUrl = url;
    }

    @Override
    public ArrayList<QuakeData> loadInBackground() {
        Log.e(LOG_TAG,"loadInBackground is called");
        if(mUrl == null)
        {
            return null;
        }

        ArrayList<QuakeData> earthquak = QueryUtils.extractEarthquakes(mUrl);
        return earthquak;
    }

    @Override
    protected void onStartLoading() {
        Log.e(LOG_TAG,"onStartLoading is called");
       forceLoad();
    }
}
