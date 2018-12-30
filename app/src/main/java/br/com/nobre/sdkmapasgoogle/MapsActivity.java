package br.com.nobre.sdkmapasgoogle;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // mudar a exibição do mapa
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        // Add a marker in Sydney and move the camera
        LatLng ibirapuera = new LatLng(-23.589662, -46.6612375);
        //-23.589662,-46.6612375

        // eventos de click
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

                Double latitude = latLng.latitude;
                Double longitude = latLng.longitude;

                Toast.makeText(MapsActivity.this, "OnClick Lat: " + latitude + " Long: " + longitude, Toast.LENGTH_LONG).show();

                mMap.addMarker(
                        new MarkerOptions()
                                .position(latLng)
                                .title("Local")
                                .snippet("Descrição")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.moto_pequeno)) // mudar marcador padrao
                );
            }
        });

        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                Double latitude = latLng.latitude;
                Double longitude = latLng.longitude;

                Toast.makeText(MapsActivity.this, "OnLongClick Lat: " + latitude + " Long: " + longitude, Toast.LENGTH_LONG).show();

                mMap.addMarker(
                        new MarkerOptions()
                                .position(latLng)
                                .title("Local")
                                .snippet("Descrição")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.moto_pequeno)) // mudar marcador padrao
                );
            }
        });

        mMap.addMarker(
                new MarkerOptions()
                        .position(ibirapuera)
                        .title("Parque do Ibirapuera")
                        /*.icon(
                                BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN) // cor do marcador
                        )*/
                        .icon(
                                BitmapDescriptorFactory.fromResource(R.drawable.moto_pequeno) // mudar marcador padrao
                        )
        );

        mMap.moveCamera( // o float varia de 2.0 a 21.0
                CameraUpdateFactory.newLatLngZoom(ibirapuera, 18)
        );
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(ibirapuera));
    }
}
