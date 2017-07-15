package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rd on 15-12-2016.
 */
public class QuakeDataAdapter extends ArrayAdapter<QuakeData> {
    private static final String LOCATION_SEPARATOR = " of ";

    public QuakeDataAdapter(Context context, List<QuakeData> earthquakes)
    {
        super(context,0,earthquakes);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if(convertView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.quake_item,parent,false);
        }

        final QuakeData currentData = getItem(position);

        TextView magnitudeText = (TextView) listItemView.findViewById(R.id.magnitude);

        // Set the proper background color on the magnitude circle.
                // Fetch the background from the TextView, which is a GradientDrawable.
                        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeText.getBackground();
                // Get the appropriate background color based on the current earthquake magnitude
                int magnitudeColor = getMagnitudeColor(currentData.getMagnitude());
                // Set the color on the magnitude circle
                        magnitudeCircle.setColor(magnitudeColor);


        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");

        magnitudeText.setText(magnitudeFormat.format(currentData.getMagnitude()));

        String originalPlace = currentData.getPlace();
        String locationOffset;
        String primaryLocation;
        if(originalPlace.contains(LOCATION_SEPARATOR))
        {
            String[] parts = originalPlace.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        }
        else
        {
            locationOffset = "Near the";
            primaryLocation = originalPlace;
        }

        TextView locationText = (TextView) listItemView.findViewById(R.id.place_coordinate);
        locationText.setText(locationOffset);




        TextView placeText = (TextView) listItemView.findViewById(R.id.place);
        placeText.setText(primaryLocation);



        TextView dateText = (TextView) listItemView.findViewById(R.id.date);
        dateText.setText(currentData.getDate());

        TextView timeText = (TextView) listItemView.findViewById(R.id.time);
        timeText.setText(currentData.getTime());





        return listItemView;
    }

    public QuakeDataAdapter(Activity context, ArrayList<QuakeData> quakeDatas) {
        super(context,0,quakeDatas);

    }

    private int getMagnitudeColor(double magnitude) {
                int magnitudeColorResourceId;
                int magnitudeFloor = (int) Math.floor(magnitude);
                switch (magnitudeFloor) {
                        case 0:
                        case 1:
                                magnitudeColorResourceId = R.color.magnitude1;
                                break;
                        case 2:
                                magnitudeColorResourceId = R.color.magnitude2;
                                break;
                        case 3:
                                magnitudeColorResourceId = R.color.magnitude3;
                                break;
                        case 4:
                                magnitudeColorResourceId = R.color.magnitude4;
                                break;
                     case 5:
                               magnitudeColorResourceId = R.color.magnitude5;
                                break;
                        case 6:
                                magnitudeColorResourceId = R.color.magnitude6;
                                break;
                        case 7:
                                magnitudeColorResourceId = R.color.magnitude7;
                                break;
                        case 8:
                                magnitudeColorResourceId = R.color.magnitude8;
                                break;
                        case 9:
                                magnitudeColorResourceId = R.color.magnitude9;
                                break;
                        default:
                                magnitudeColorResourceId = R.color.magnitude10plus;
                                break;
                    }

                        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
            }

}
