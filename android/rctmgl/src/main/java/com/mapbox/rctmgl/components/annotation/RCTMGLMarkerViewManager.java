package com.mapbox.rctmgl.components.annotation;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.bridge.Dynamic;
import com.mapbox.rctmgl.components.AbstractEventEmitter;
import com.mapbox.rctmgl.utils.GeoJSONUtils;
import com.mapbox.mapboxsdk.geometry.LatLng;

import java.util.Map;

public class RCTMGLMarkerViewManager extends AbstractEventEmitter<RCTMGLMarkerView> {
    public static final String REACT_CLASS = "RCTMGLMarkerView";

    public RCTMGLMarkerViewManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactProp(name="coordinate")
    public void setCoordinate(RCTMGLMarkerView markerView, ReadableArray coordinates) {
        markerView.setCoordinate(GeoJSONUtils.toGNPointGeometry(new LatLng(coordinates.getDouble(1), coordinates.getDouble(0))));
    }

    @ReactProp(name="anchor")
    public void setAnchor(RCTMGLMarkerView markerView, ReadableMap map) {
        markerView.setAnchor((float) map.getDouble("x"), (float) map.getDouble("y"));
    }

    @Override
    protected RCTMGLMarkerView createViewInstance(ThemedReactContext reactContext) {
        return new RCTMGLMarkerView(reactContext, this);
    }

    @Override
    public Map<String, String> customEvents() {
        return MapBuilder.<String, String>builder()
                .build();
    }
}
