package com.example.lr6;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;

//import com.yandex.mapkit.
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;

public class ActivityMap extends AppCompatActivity {


    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /*Bundles are generally used for passing data between various Android activities.
        It depends on you what type of values you want to pass, but bundles can hold all
        types of values and pass them to the new activity.*/

        MapKitFactory.initialize(this);
        setContentView(R.layout.activity_map);
        super.onCreate(savedInstanceState);

        mapView = findViewById(R.id.Map);

        Point point = new Point();
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            point = extras.getParcelable("data");  // присваиваем данные, полученные из ключа data
        }

        // Перемещение камеры
        mapView.getMap().move(
                new CameraPosition(point.getPoint(), 14.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 3),
                null);

        // заполняем экран с картой всей информацией
        ((TextView) findViewById(R.id.mainName)).setText(point.getName());
        ((TextView) findViewById(R.id.mainInfo)).setText(point.getInfo());
        mapView.getMap().getMapObjects().addPlacemark(point.getPoint());
    }

    @Override
    protected void onStop() {
        // Вызов onStop нужно передавать инстансам MapView и MapKit.
        mapView.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }

    @Override
    protected void onStart() {
        // Вызов onStart нужно передавать инстансам MapView и MapKit.
        super.onStart();
        MapKitFactory.getInstance().onStart();
        mapView.onStart();
    }
}

