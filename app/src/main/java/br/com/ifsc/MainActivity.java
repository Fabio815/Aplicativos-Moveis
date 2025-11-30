package br.com.ifsc;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class MainActivity extends AppCompatActivity {

    LocationManager locationManager;
    TextView textView;
    Button btn;
    MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        textView = findViewById(R.id.textView);
        btn = findViewById(R.id.button);
        mapView = findViewById(R.id.mapinha);

        btn.setOnClickListener(v -> getLocation());
    }

    @SuppressLint("MissingPermission")
    public void getLocation() {

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            requestPermission();
            return;
        }

        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        if (location != null) {
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();

            textView.setText("Latitude: " + latitude + " Longitude: " + longitude);

            showLocationOnMap(latitude, longitude);
        }
    }

    public void showLocationOnMap(double latitude, double longitude ) {
        GeoPoint point = new GeoPoint(latitude, longitude);

        mapView.getController().setCenter(point);
        mapView.getController().setZoom(18);
        mapView.invalidate();
    }

    public void requestPermission(){
        ActivityCompat.requestPermissions(
                this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1
        );
    }
}
