package com.example.android.quakereport;

/**
 * Created by rd on 15-12-2016.
 */
public class QuakeData {
    private String mPlace;
    private double mMagnitude;
    private String mDate;
    private String mTime;
    private String mUrl;

    public QuakeData(double magnitude, String place, String date, String time, String url) {
        mDate = date;
        mMagnitude = magnitude;
        mPlace = place;
        mTime = time;
        mUrl = url;

    }

    public String getPlace() {
        return mPlace;
    }

    public String getDate() {
        return mDate;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getTime() { return mTime; }

    public  String getUrl() { return mUrl; }
}
