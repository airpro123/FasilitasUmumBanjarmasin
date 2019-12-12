package com.example.projekfasilitasumumandri;

import android.Manifest;
import android.app.AlertDialog;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Looper;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projekfasilitasumumandri.database.AppDatabase;
import com.example.projekfasilitasumumandri.database.dbJarak.Jarak;
import com.example.projekfasilitasumumandri.database.dbJarak.JarakDAO;
import com.example.projekfasilitasumumandri.database.dbLokasi.Lokasi;
import com.example.projekfasilitasumumandri.database.dbLokasi.LokasiDAO;
import com.mapbox.android.core.permissions.PermissionsListener;
import com.mapbox.android.core.permissions.PermissionsManager;
import com.mapbox.api.directions.v5.DirectionsCriteria;
import com.mapbox.api.directions.v5.models.DirectionsResponse;
import com.mapbox.api.directions.v5.models.DirectionsRoute;
import com.mapbox.api.geocoding.v5.GeocodingCriteria;
import com.mapbox.api.geocoding.v5.MapboxGeocoding;
import com.mapbox.api.geocoding.v5.models.GeocodingResponse;
import com.mapbox.geojson.Point;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.geometry.LatLngBounds;
import com.mapbox.mapboxsdk.location.LocationComponent;
import com.mapbox.mapboxsdk.location.modes.CameraMode;
import com.mapbox.mapboxsdk.location.modes.RenderMode;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.style.sources.GeoJsonSource;
import com.mapbox.services.android.navigation.ui.v5.NavigationLauncher;
import com.mapbox.services.android.navigation.ui.v5.NavigationLauncherOptions;
import com.mapbox.services.android.navigation.ui.v5.route.NavigationMapRoute;
import com.mapbox.services.android.navigation.v5.navigation.MapboxNavigation;
import com.mapbox.services.android.navigation.v5.navigation.NavigationRoute;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback, PermissionsListener
        , View.OnClickListener {

    private MapView mapView;
    private MapboxMap map;
    private PermissionsManager permissionsManager;
    private Location location;
    private NavigationMapRoute navigationMapRoute;
    private MapboxNavigation navigation;

    DirectionsRoute drNavigasi;
    DirectionsRoute ruteTerdekat;
    DirectionsRoute ruteTerdekat1;

    AppDatabase database;
    LokasiDAO lokasiDAO;
    JarakDAO jarakDao;
    LiveData<List<Lokasi>> dataAtm;
    LiveData<List<Jarak>> dataJarak;
    LiveData<List<Jarak>> dataJarakTerdekat;
    List<Lokasi> listAtm;
    List<Jarak> listJarakTerdekat;
    LiveData<List<Lokasi>> dataSPBU;
    List<Lokasi> listSPBU;

    ArrayList<Double> list1;

    private String alamat;
    private String lat;
    private String lng;
    private String kategori;
    private String dokumen;
    private String bank;

    public static Double jarakPalingDekat = null;
    public static Double jarakPalingDekat1 = null;
    public static Point pointPalingDekat = null;
    public static Point pointPalingDekat1 = null;
    public static Point pointOrigin = null;
    public static Point pointOrigin1= null;
    public static Point pointDest1= null;


    private TextView tv_alamat;
    Button btnNavUI;
    ImageButton btnInfo;
    CardView cvSearch;
    LinearLayout mapV;

    int tinggiAsli, tinggiUbah;
    public int jumlahRute;

    private Point dest;
    boolean isUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this, getString(R.string.accesToken));
        navigation = new MapboxNavigation(this, getString(R.string.accesToken));
        setContentView(R.layout.activity_map);

        try {

            mapView = findViewById(R.id.mapView);
            mapView.onCreate(savedInstanceState);
            mapView.getMapAsync(this);

            tv_alamat = findViewById(R.id.tv_tujuan);
            btnInfo = findViewById(R.id.btn_info);
            btnNavUI = findViewById(R.id.btn_navigasi);
            mapV = findViewById(R.id.viewCV);
            cvSearch = findViewById(R.id.cv_info);

            cvSearch.setVisibility(View.GONE);
            tinggiAsli = mapV.getHeight();
            tinggiUbah = 0;

            Intent i = getIntent();
            kategori = i.getStringExtra("kategori");
            bank = i.getStringExtra("bank");

            if (ruteTerdekat1!=null){
                ruteTerdekat1 = null;
                jarakPalingDekat1 = null;
                pointPalingDekat1 = null;
                pointOrigin1 = null;
            }

            if (kategori != null) {
                if (kategori.equals("atm")) {

                } else if (kategori.equals("spbu")) {

                } else {

                    alamat = i.getStringExtra("alamat");
                    lat = i.getStringExtra("lat");
                    lng = i.getStringExtra("lng");
                    dest = Point.fromLngLat(Float.valueOf(lng), Float.valueOf(lat));
                }
            } else {
            }


            btnNavUI.setOnClickListener(this);
            btnInfo.setOnClickListener(this);

        } catch (Exception e) {
            Toast.makeText(this, "erorr", Toast.LENGTH_SHORT).show();
        }

    }

    private void cekGPS(Context context){
        LocationManager lm = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean network_enabled = false;

        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch(Exception ex) {}

        try {
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch(Exception ex) {}

        if(!gps_enabled) {
            // notify user
            new AlertDialog.Builder(context)
                    .setMessage(R.string.open_location_settings)
                    .setPositiveButton("Setting", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            context.startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                        }
                    }).setNegativeButton("Kembali", null)
                    .show();
        }
        if (!network_enabled){
            new AlertDialog.Builder(context)
                    .setMessage(R.string.open_network_settings)
                    .setPositiveButton("Setting", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            context.startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                        }
                    }).setNegativeButton("Kembali", null)
                    .show();
        }
    }

    @Override
    public void onClick(View v) {
        if (v == btnInfo) {
            if (isUp) {
                slideDown(cvSearch);
            } else {
                slideUp(cvSearch);
            }
            isUp = !isUp;
        }
        if (v == btnNavUI) {
            navigasiUI(drNavigasi);
        }
    }

    private void buatMarkerATM(Point oriMarker, Style style) {
        try {
            database = AppDatabase.getInstance(this);
            lokasiDAO = database.lokasiDAO();

            dataAtm = lokasiDAO.getCariLokasi("atm", "%" + bank + "%");

            Toast.makeText(this, bank, Toast.LENGTH_SHORT).show();

            dataAtm.observe(this, new Observer<List<Lokasi>>() {
                @Override
                public void onChanged(@Nullable List<Lokasi> lokasis) {
                    listAtm = lokasis;

                    for (int i = 0; i < lokasis.size(); i++) {

                        Point atm = Point.fromLngLat(
                                Float.valueOf(lokasis.get(i).lng),
                                Float.valueOf(lokasis.get(i).lat));

                        Marker m1 = map.addMarker(new MarkerOptions()
                                .position(new LatLng(atm.latitude(), atm.longitude()))
                                .title("ATM"));

                        map.setOnMarkerClickListener(new MapboxMap.OnMarkerClickListener() {
                            @Override
                            public boolean onMarkerClick(@NonNull Marker marker) {

                                Point destMarker = Point.fromLngLat(marker.getPosition().getLongitude(), marker.getPosition().getLatitude());

                                getRoute("biasa", oriMarker, destMarker, 1);

                                Utest(style, destMarker);

                                LatLngBounds latLngBounds = new LatLngBounds.Builder()
                                        .include((new LatLng(oriMarker.latitude(), oriMarker.longitude())))
                                        .include((new LatLng(destMarker.latitude(), destMarker.longitude())))
                                        .build();

                                map.animateCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds,
                                        100, 100,
                                        100, 400));

                                map.selectMarker(marker);

                                return false;

                            }
                        });
                    }

                }
            });
        } catch (Exception e) {

        }
    }

    private void buatMarkerATM1(Point oriMarker, Style style) {
        try {

            database = AppDatabase.getInstance(this);
            lokasiDAO = database.lokasiDAO();

            dataAtm = lokasiDAO.getCariLokasi("atm", "%" + bank + "%");

            dataAtm.observe(MapActivity.this, new Observer<List<Lokasi>>() {
                @Override
                public void onChanged(@Nullable List<Lokasi> lokasis) {
                    listAtm = lokasis;
                    jumlahRute = lokasis.size();

                    for (int i = 0; i < lokasis.size(); i++) {

                        Point atm = Point.fromLngLat(
                                Float.valueOf(lokasis.get(i).lng),
                                Float.valueOf(lokasis.get(i).lat));

                        Marker m1 = map.addMarker(new MarkerOptions()
                                .position(new LatLng(atm.latitude(), atm.longitude()))
                                .title(lokasis.get(i).namaLokasi));

                        new ambilRute(i, oriMarker, atm).execute();
                        //getRoute("atm", oriMarker, atm, i);

                        map.setOnMarkerClickListener(new MapboxMap.OnMarkerClickListener() {
                            @Override
                            public boolean onMarkerClick(@NonNull Marker marker) {

                                Point destMarker = Point.fromLngLat(marker.getPosition().getLongitude(), marker.getPosition().getLatitude());

                                getRoute("biasa", oriMarker, destMarker, 1);

                                Utest(style, destMarker);

                                LatLngBounds latLngBounds = new LatLngBounds.Builder()
                                        .include((new LatLng(oriMarker.latitude(), oriMarker.longitude())))
                                        .include((new LatLng(destMarker.latitude(), destMarker.longitude())))
                                        .build();

                                map.animateCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds,
                                        100, 100,
                                        100, 400));

                                map.selectMarker(marker);

                                return false;

                            }
                        });
                    }

                }
            });

        } catch (Exception e) {

        }
    }

    private void buatMarkerSPBU(Point oriMarker, Style style) {
        try {

            database = AppDatabase.getInstance(this);
            lokasiDAO = database.lokasiDAO();

            dataSPBU = lokasiDAO.getLokasiSPBU();

            dataSPBU.observe(this, new Observer<List<Lokasi>>() {
                @Override
                public void onChanged(@Nullable List<Lokasi> lokasis) {
                    listSPBU = lokasis;
                    jumlahRute = lokasis.size();

                    for (int i = 0; i < lokasis.size(); i++) {
                        Point spbu = Point.fromLngLat(
                                Float.valueOf(lokasis.get(i).lng),
                                Float.valueOf(lokasis.get(i).lat));

                        Marker m1 = map.addMarker(new MarkerOptions()
                                .position(new LatLng(spbu.latitude(), spbu.longitude()))
                                .title(lokasis.get(i).namaLokasi));

                        new ambilRute(i, oriMarker, spbu).execute();
                        Utest(style, spbu);

                        //getRoute("spbu", oriMarker, atm, i);

                        map.setOnMarkerClickListener(new MapboxMap.OnMarkerClickListener() {
                            @Override
                            public boolean onMarkerClick(@NonNull Marker marker) {

                                Point destMarker = Point.fromLngLat(marker.getPosition().getLongitude(), marker.getPosition().getLatitude());

                                getRoute("biasa", oriMarker, destMarker, 1);

                                Utest(style, destMarker);

                                LatLngBounds latLngBounds = new LatLngBounds.Builder()
                                        .include((new LatLng(oriMarker.latitude(), oriMarker.longitude())))
                                        .include((new LatLng(destMarker.latitude(), destMarker.longitude())))
                                        .build();

                                map.animateCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds,
                                        100, 100,
                                        100, 400));

                                map.selectMarker(marker);

                                return false;

                            }
                        });

                    }

                }
            });
        } catch (Exception e) {

        }
    }

    @Override
    public void onMapReady(@NonNull MapboxMap mapboxMap) {
        try {
            cekGPS(this);

            MapActivity.this.map = mapboxMap;

            map.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {
                @Override
                public void onStyleLoaded(@NonNull final Style style) {
                    Log.e("MapActivity", "onStyleLoaded: ");

                    if (enableLocationComponent(map.getStyle()) != null) {
                        location = enableLocationComponent(map.getStyle());

                        Point origin = Point.fromLngLat(location.getLongitude(), location.getLatitude());

                        pointOrigin = origin;
                        pointOrigin1 = origin;

                        if (kategori.equals("pemerintahan") || kategori.equals("polisi") || kategori.equals("rumahsakit")
                                || kategori.equals("wisata")) {

                            Marker marker = map.addMarker(new MarkerOptions()
                                    .position(new LatLng(dest.latitude(), dest.longitude()))
                                    .snippet(alamat));

                            getRoute("biasa", origin, dest, 1);

                            Utest(style, dest);

                            LatLngBounds latLngBounds = new LatLngBounds.Builder()
                                    .include((new LatLng(origin.latitude(), origin.longitude())))
                                    .include((new LatLng(dest.latitude(), dest.longitude())))
                                    .build();

                            map.animateCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds,
                                    100, 100,
                                    100, 400));

                            map.selectMarker(marker);

                        }
                    }
                }
            });
            mapView.addOnDidFinishLoadingStyleListener(new MapView.OnDidFinishLoadingStyleListener() {
                @Override
                public void onDidFinishLoadingStyle() {
                    if (enableLocationComponent(map.getStyle()) != null) {
                        location = enableLocationComponent(map.getStyle());

                        Point origin = Point.fromLngLat(location.getLongitude(), location.getLatitude());

                        pointOrigin = origin;
                        pointOrigin1 = origin;

                        if (kategori.equals("spbu")) {
                            buatMarkerSPBU(origin, map.getStyle());
                        } else {
                            buatMarkerATM1(origin, map.getStyle());
                        }
                    }
                }
            });
        } catch (Exception e) {

        } finally {
            AsyncTask.execute(new Runnable() {
                @Override
                public void run() {
                    AppDatabase.getInstance(MapActivity.this).jarakDAO().deletAll();
                }
            });
        }
    }

    public String isi;

    //Ambil data geoCoding Online//
    public void Utest(final Style style, final Point point) {
        try {

            GeoJsonSource source = style.getSourceAs("test");
            if (source != null) {
                source.setGeoJson(point);
            }

            MapboxGeocoding client = MapboxGeocoding.builder()
                    .accessToken(getString(R.string.accesToken))
                    .query(Point.fromLngLat(point.longitude(), point.latitude()))
                    .geocodingTypes(GeocodingCriteria.TYPE_NEIGHBORHOOD)
                    .build();

            MapboxGeocoding client2 = MapboxGeocoding.builder()
                    .accessToken(getString(R.string.accesToken))
                    .query(Point.fromLngLat(point.longitude(), point.latitude()))
                    .geocodingTypes(GeocodingCriteria.TYPE_NEIGHBORHOOD)
                    .build();

            client.enqueueCall(new Callback<GeocodingResponse>() {
                @Override
                public void onResponse(Call<GeocodingResponse> call, Response<GeocodingResponse> response) {

                    isi = String.valueOf(response.body().features().get(0).placeName());

                    tv_alamat.setText(isi);

                }

                @Override
                public void onFailure(Call<GeocodingResponse> call, Throwable t) {
                    Toast.makeText(MapActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                }
            });

            client2.enqueueCall(new Callback<GeocodingResponse>() {
                @Override
                public void onResponse(Call<GeocodingResponse> call, Response<GeocodingResponse> response) {
                    String dataAlamat = String.valueOf(call.request().url());
                    //bukaGson(dataAlamat);
                }

                @Override
                public void onFailure(Call<GeocodingResponse> call, Throwable t) {

                }
            });
        } catch (Exception e) {

        }

    }

    //TEST DATA GEOJSON DIBROWSER//
    public void bukaGson(String url) {
        Uri uri = Uri.parse(url); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private Location enableLocationComponent(Style style) {
        Location locationlast = null;
        if (PermissionsManager.areLocationPermissionsGranted(this)) {

            // Get an instance of the component
            LocationComponent locationComponent = map.getLocationComponent();

            // Activate with options
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                //return;
            }
            locationComponent.activateLocationComponent(this, style);

            // Enable to make component visible
            locationComponent.setLocationComponentEnabled(true);

            locationlast = locationComponent.getLastKnownLocation();

            // Set the component's camera mode
            locationComponent.setCameraMode(CameraMode.NONE);
            locationComponent.setRenderMode(RenderMode.COMPASS);
        } else {
            permissionsManager = new PermissionsManager(this);
            permissionsManager.requestLocationPermissions(this);
        }
        return locationlast;
    }

    public void getRoute(String rute, Point origin, Point destination, int index) {
        try {
            if (rute.equals("spbu")) {

                NavigationRoute.builder(MapActivity.this)
                        .accessToken(Mapbox.getAccessToken())
                        .origin(origin)
                        .destination(destination)
                        .build()
                        .getRoute(new Callback<DirectionsResponse>() {
                    @Override
                    public void onResponse(Call<DirectionsResponse> call, Response<DirectionsResponse> response) {
                        if (response.body() == null) {
                            Log.e("MapActivity", "onResponse: No SPBu Route Found");
                            return;
                        } else if (response.body().routes().size() == 0) {
                            Log.e("MapActivity", "onResponse: no SPBU Routes Found");
                            return;
                        }

                        DirectionsRoute currentRoute = response.body().routes().get(0);
                        drNavigasi = currentRoute;

                        jarakDao = database.jarakDAO();

                        AsyncTask.execute(new Runnable() {
                            @Override
                            public void run() {
                                AppDatabase.getInstance(MapActivity.this).jarakDAO().insert(
                                        new Jarak(currentRoute.duration()
                                                , String.valueOf(listSPBU.get(index).lat)
                                                , String.valueOf(listSPBU.get(index).lng)));

                            }
                        });

                        if (jarakPalingDekat == null) {
                            jarakPalingDekat = currentRoute.duration();
                            ruteTerdekat = currentRoute;
                            infoNavigasi();
                            pointPalingDekat = Point.fromLngLat(Float.valueOf(listSPBU.get(index).lng),
                                    Float.valueOf(listSPBU.get(index).lat));
                        } else {
                            if (jarakPalingDekat > currentRoute.duration()) {
                                jarakPalingDekat = currentRoute.duration();
                                ruteTerdekat = currentRoute;
                                infoNavigasi();
                                pointPalingDekat = Point.fromLngLat(Float.valueOf(listSPBU.get(index).lng),
                                        Float.valueOf(listSPBU.get(index).lat));
                            }
                        }

                        if (navigationMapRoute != null) {
                            navigationMapRoute.removeRoute();
                        } else {
                            navigationMapRoute = new NavigationMapRoute(null, mapView, map);
                        }

                        list1 = new ArrayList<>(Arrays.asList(currentRoute.distance()));

                        if (index == (jumlahRute - 1)) {
                            if (pointPalingDekat != null || pointOrigin != null) {

                                AsyncTask.execute(new Runnable() {
                                    @Override
                                    public void run() {
                                        dataJarak = jarakDao.getAllJarak();
                                        dataJarakTerdekat = jarakDao.getJarakTerdekat();

                                        dataJarakTerdekat.observe(MapActivity.this, new Observer<List<Jarak>>() {
                                            @Override
                                            public void onChanged(@Nullable List<Jarak> jaraks) {
                                                listJarakTerdekat = jaraks;
                                                Double t = Double.valueOf(jaraks.get(0).lng);
                                                Double g = Double.valueOf(jaraks.get(0).lat);

                                                Point p = Point.fromLngLat(t, g);

                                                getRoute("biasa", pointOrigin, p, 1);

                                                LatLngBounds latLngBounds = new LatLngBounds.Builder()
                                                        .include((new LatLng(pointOrigin.latitude(), pointOrigin.longitude())))
                                                        .include((new LatLng(p.latitude(), p.longitude())))
                                                        .build();

                                                map.animateCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds,
                                                        100, 100,
                                                        100, 400));
                                            }
                                        });
                                    }
                                });
                            }

                        }

                    }

                    @Override
                    public void onFailure(Call<DirectionsResponse> call, Throwable t) {

                    }
                });

            } else if (rute.equals("atm")){
                NavigationRoute.builder(MapActivity.this)
                        .accessToken(Mapbox.getAccessToken())
                        .origin(origin)
                        .destination(destination)
                        .build().getRoute(new Callback<DirectionsResponse>() {
                    @Override
                    public void onResponse(Call<DirectionsResponse> call, Response<DirectionsResponse> response) {
                        if (response.body() == null) {
                            Log.e("MapActivity", "onResponse: No SPBu Route Found");
                            return;
                        } else if (response.body().routes().size() == 0) {
                            Log.e("MapActivity", "onResponse: no SPBU Routes Found");
                            return;
                        }

                        DirectionsRoute currentRoute = response.body().routes().get(0);
                        drNavigasi = currentRoute;

                        jarakDao = database.jarakDAO();

                        AsyncTask.execute(new Runnable() {
                            @Override
                            public void run() {
                                AppDatabase.getInstance(MapActivity.this).jarakDAO().insert(
                                        new Jarak(currentRoute.duration()
                                                , String.valueOf(listAtm.get(index).lat)
                                                , String.valueOf(listAtm.get(index).lng)));
                            }
                        });

                        if (jarakPalingDekat1 == null) {
                            jarakPalingDekat1 = currentRoute.duration();
                            ruteTerdekat1 = currentRoute;
                            infoNavigasi();
                            pointPalingDekat1 = Point.fromLngLat(Float.valueOf(listAtm.get(index).lng),
                                    Float.valueOf(listAtm.get(index).lat));
                        } else {
                            if (jarakPalingDekat1 > currentRoute.duration()) {
                                jarakPalingDekat1 = currentRoute.duration();
                                ruteTerdekat1 = currentRoute;
                                infoNavigasi();
                                pointPalingDekat1 = Point.fromLngLat(Float.valueOf(listAtm.get(index).lng),
                                        Float.valueOf(listAtm.get(index).lat));
                            }
                        }

                        if (navigationMapRoute != null) {
                            navigationMapRoute.removeRoute();
                        } else {
                            navigationMapRoute = new NavigationMapRoute(null, mapView, map);
                        }

                        list1 = new ArrayList<>(Arrays.asList(currentRoute.distance()));

                        if (index == (jumlahRute - 1)) {
                            if (pointPalingDekat1 != null && pointOrigin1 != null) {
                                AsyncTask.execute(new Runnable() {
                                    @Override
                                    public void run() {
                                        //dataJarak = jarakDao.getAllJarak();
                                        dataJarakTerdekat = jarakDao.getJarakTerdekat();

                                        dataJarakTerdekat.observe(MapActivity.this, new Observer<List<Jarak>>() {
                                            @Override
                                            public void onChanged(@Nullable List<Jarak> jaraks) {
                                                listJarakTerdekat = jaraks;
                                                Double t = Double.valueOf(jaraks.get(0).lng);
                                                Double g = Double.valueOf(jaraks.get(0).lat);

                                                Point p = Point.fromLngLat(t, g);

                                                getRoute("biasa", pointOrigin1, p, 1);

                                                LatLngBounds latLngBounds = new LatLngBounds.Builder()
                                                        .include((new LatLng(pointOrigin1.latitude(), pointOrigin1.longitude())))
                                                        .include((new LatLng(p.latitude(), p.longitude())))
                                                        .build();

                                                map.animateCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds,
                                                        100, 100,
                                                        100, 400));

                                                //Toast.makeText(MapActivity.this, String.valueOf(jaraks.get(0).jarak), Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    }
                                });
                            }
                            Toast.makeText(MapActivity.this, "Perhitungan Selesai", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<DirectionsResponse> call, Throwable t) {

                    }
                });
            }
            else {

                NavigationRoute.builder(MapActivity.this)
                        .accessToken(Mapbox.getAccessToken())
                        .origin(origin)
                        .destination(destination)
                        .alternatives(true)
                        .build()
                        .getRoute(new Callback<DirectionsResponse>() {
                            @Override
                            public void onResponse(Call<DirectionsResponse> call, Response<DirectionsResponse> response) {
                                if (response.body() == null) {
                                    Log.e("MapActivity", "onResponse: No Route Found");
                                    return;
                                } else if (response.body().routes().size() == 0) {
                                    Log.e("MapActivity", "onResponse: no Routes Found");
                                    return;
                                }

                                DirectionsRoute currentRoute = response.body().routes().get(0);
                                drNavigasi = currentRoute;

                                infoNavigasi();

                                if (navigationMapRoute != null) {
                                    navigationMapRoute.removeRoute();
                                } else {
                                    navigationMapRoute = new NavigationMapRoute(null, mapView, map);
                                }

                                navigationMapRoute.addRoute(currentRoute);

                            }

                            @Override
                            public void onFailure(Call<DirectionsResponse> call, Throwable t) {
                                Toast.makeText(MapActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        } catch (Exception e) {

        }
    }

    public void navigasiUI(DirectionsRoute route) {
        try {
            NavigationLauncherOptions options = NavigationLauncherOptions.builder()
                    .directionsRoute(route)
                    .shouldSimulateRoute(true)
                    .waynameChipEnabled(true)
                    .build();

            NavigationLauncher.startNavigation(this, options);
        } catch (Exception e) {

        }
    }

    public void infoNavigasi() {
        try {
            TextView tv_jarak = findViewById(R.id.tv_jarak);
            TextView tv_waktu = findViewById(R.id.tv_waktu);

            Double jarakM = drNavigasi.distance();
            Double jarakKM = drNavigasi.distance() / 1000;

            Double waktuD = drNavigasi.duration();
            Double waktuM = drNavigasi.duration() / 60;
            Double waktuJ = waktuM / 60;

            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            decimalFormat.setRoundingMode(RoundingMode.UP);

            if (jarakM >= 1000) {
                String jarak = String.valueOf(": " + decimalFormat.format(jarakKM) + "km");
                tv_jarak.setText(jarak);
            } else {
                String jarak = String.valueOf(": " + decimalFormat.format(jarakM) + "m");
                tv_jarak.setText(jarak);
            }

            if (waktuD >= 3600) {
                String waktu = String.valueOf(": " + decimalFormat.format(waktuJ) + "jam");
                tv_waktu.setText(waktu);
            } else if (waktuD < 3600) {
                String waktu = String.valueOf(": " + decimalFormat.format(waktuM) + "mnt");
                tv_waktu.setText(waktu);
            } else if (waktuD < 60) {
                String waktu = String.valueOf(": " + decimalFormat.format(waktuD) + "dtk");
                tv_waktu.setText(waktu);
            }
        } catch (Exception e) {

        }

    }

    public void slideUp(View view) {
        try {
            view.setVisibility(View.VISIBLE);
            TranslateAnimation animate = new TranslateAnimation(
                    0,                 // fromXDelta
                    0,                 // toXDelta
                    mapV.getHeight(),  // fromYDelta
                    0);                // toYDelta
            animate.setDuration(500);
            animate.setFillAfter(true);
            view.startAnimation(animate);
        } catch (Exception e) {

        }
    }

    // slide the view from its current position to below itself
    public void slideDown(View view) {
        try {
            TranslateAnimation animate = new TranslateAnimation(
                    0,                 // fromXDelta
                    0,                 // toXDelta
                    0,                 // fromYDelta
                    mapV.getHeight()); // toYDelta
            animate.setDuration(500);
            animate.setFillAfter(true);
            view.startAnimation(animate);
        } catch (Exception e) {

        }
    }

    @Override
    public void onExplanationNeeded(List<String> permissionsToExplain) {
        Toast.makeText(this, "Berjalan", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPermissionResult(boolean granted) {
        if (granted) {
            map.getStyle(new Style.OnStyleLoaded() {
                @Override
                public void onStyleLoaded(@NonNull Style style) {
                    enableLocationComponent(style);
                }
            });
        } else {
            Toast.makeText(this, "ditolak", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        permissionsManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
        if (navigationMapRoute != null) {
            navigationMapRoute.onStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        navigation.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (outState!=null){
            mapView.onSaveInstanceState(outState);
        }
    }

    public class ambilRute extends AsyncTask<Void, Void, Void>{

        Point origin, destination, p;
        int index;

        public ambilRute (int index, Point origin, Point destination){
            super();
            this.origin = origin;
            this.destination = destination;
            this.index = index;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                NavigationRoute.builder(MapActivity.this)
                        .accessToken(Mapbox.getAccessToken())
                        .origin(origin)
                        .destination(destination)
                        .build().getRoute(new Callback<DirectionsResponse>() {
                    @Override
                    public void onResponse(Call<DirectionsResponse> call, Response<DirectionsResponse> response) {
                        if (response.body() == null) {
                            Log.e("MapActivity", "onResponse: No SPBu Route Found");
                            return;
                        } else if (response.body().routes().size() == 0) {
                            Log.e("MapActivity", "onResponse: no SPBU Routes Found");
                            return;
                        }

                        DirectionsRoute currentRoute = response.body().routes().get(0);
                        drNavigasi = currentRoute;

                        jarakDao = database.jarakDAO();

                        AsyncTask.execute(new Runnable() {
                            @Override
                            public void run() {
                                AppDatabase.getInstance(MapActivity.this).jarakDAO().insert(
                                        new Jarak(currentRoute.duration()
                                                , String.valueOf(destination.latitude())
                                                , String.valueOf(destination.longitude())));
                            }
                        });

                        if (jarakPalingDekat1 == null) {
                            jarakPalingDekat1 = currentRoute.duration();
                            ruteTerdekat1 = currentRoute;
                            infoNavigasi();
                            pointPalingDekat1 = Point.fromLngLat(destination.longitude(),destination.latitude());
                        } else {
                            if (jarakPalingDekat1 > currentRoute.duration()) {
                                jarakPalingDekat1 = currentRoute.duration();
                                ruteTerdekat1 = currentRoute;
                                infoNavigasi();
                                pointPalingDekat1 = Point.fromLngLat(destination.longitude(),destination.latitude());
                            }
                        }

                        if (navigationMapRoute != null) {
                            navigationMapRoute.removeRoute();
                        } else {
                            navigationMapRoute = new NavigationMapRoute(null, mapView, map);
                        }

                        list1 = new ArrayList<>(Arrays.asList(currentRoute.distance()));

                        if (index == (jumlahRute - 1)) {
                            if (pointPalingDekat1 != null && pointOrigin1 != null) {
                                AsyncTask.execute(new Runnable() {
                                    @Override
                                    public void run() {
                                        dataJarakTerdekat = jarakDao.getJarakTerdekat();
                                        dataJarakTerdekat.observe(MapActivity.this, new Observer<List<Jarak>>() {
                                            @Override
                                            public void onChanged(@Nullable List<Jarak> jaraks) {
                                                listJarakTerdekat = jaraks;

                                                for (int i = 0; i<jaraks.size(); i++){
                                                    Double t = Double.valueOf(jaraks.get(0).lng);
                                                    Double g = Double.valueOf(jaraks.get(0).lat);

                                                    Point p = Point.fromLngLat(t, g);
                                                    pointDest1 = p;

                                                    getRoute("biasa", pointOrigin1, p, 1);

                                                    LatLngBounds latLngBounds = new LatLngBounds.Builder()
                                                            .include((new LatLng(pointOrigin1.latitude(), pointOrigin1.longitude())))
                                                            .include((new LatLng(p.latitude(), p.longitude())))
                                                            .build();

                                                    map.animateCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds,
                                                            100, 100,
                                                            100, 400));
                                                }

                                            }
                                        });
                                    }
                                });
                            }
                            Toast.makeText(MapActivity.this, "Perhitungan Selesai", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<DirectionsResponse> call, Throwable t) {

                    }
                });
            }catch (Exception e){
            }
            return null;
        }
    }

}


