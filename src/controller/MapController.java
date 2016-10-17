package controller;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.*;
import fxapp.MainFXApplication;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.report.Location;
import model.report.ReportList;
import model.report.WaterSourceReport;
import netscape.javascript.JSObject;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Map view that is inside of view reports screen.
 */
public class MapController implements Initializable, MapComponentInitializedListener {
        private MainFXApplication mainApplication;

        @FXML
        private GoogleMapView mapView;
        private GoogleMap map;


        @Override
        public void initialize(URL url, ResourceBundle rb) {
            mapView.addMapInializedListener(this);
        }

        @Override
        public void mapInitialized() {
            MapOptions options = new MapOptions();

            //Center of map
            LatLong center = new LatLong(33.7756, -84.3963);

            options.center(center)
                    .zoom(9)
                    .overviewMapControl(false)
                    .panControl(false)
                    .rotateControl(false)
                    .scaleControl(false)
                    .streetViewControl(false)
                    .zoomControl(true)
                    .mapType(MapTypeIdEnum.TERRAIN);

            map = mapView.createMap(options);


            ReportList reportList = ReportList.soleInstance;
            List reports = reportList.get();

            for (Object report : reports) {
                MarkerOptions markerOptions = new MarkerOptions();
                Location location = ((WaterSourceReport) report).getLocation();
                LatLong loc = new LatLong(location.getLatitude(), location.getLongitude());

                markerOptions.position(loc)
                        .visible(Boolean.TRUE)
                        .title(((WaterSourceReport) report).getWaterType().toString());

                Marker marker = new Marker(markerOptions);

                map.addUIEventHandler(marker,
                        UIEventType.click,
                        (JSObject obj) -> {
                            InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
                            infoWindowOptions.content(((WaterSourceReport) report).getWaterCondition().toString());

                            InfoWindow window = new InfoWindow(infoWindowOptions);
                            window.open(map, marker);
                        });

                map.addMarker(marker);
            }


        }



}
