
package ru.belogurowdev.lab7.model.placesList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Southwest {

    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lng")
    @Expose
    private Double lng;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Southwest{");
        sb.append("lat=").append(lat);
        sb.append(", lng=").append(lng);
        sb.append('}');
        return sb.toString();
    }
}
