package com.ahmadrosid.lib.drawroutemap;

import android.content.Context;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by ocittwo on 11/14/16.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */

public class DrawRouteMaps {

    public interface TimeCallbackInterface {
        void onTimeResult(String time);
    }

    private static DrawRouteMaps instance;
    private Context context;

    public static DrawRouteMaps getInstance(Context context) {
        instance = new DrawRouteMaps();
        instance.context = context;
        return instance;
    }

    public DrawRouteMaps draw(LatLng origin, LatLng destination, GoogleMap googleMap, TimeCallbackInterface timeCallback){
        String url_route = FetchUrl.getUrl(origin, destination, instance.context.getResources().getString(R.string.google_maps_key));
        DrawRoute drawRoute = new DrawRoute(googleMap, timeCallback);
        drawRoute.execute(url_route);
        return instance;
    }

    public static Context getContext() {
        return instance.context;
    }
}
