package com.iti.mobile.triporganizer.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Embedded;


public class TripAndLocation implements Parcelable {
    @Embedded
    private Trip trip;

    @Embedded
    private LocationData locationDataList;

    public TripAndLocation() {
    }

    protected TripAndLocation(Parcel in) {
        trip = in.readParcelable(Trip.class.getClassLoader());
        locationDataList = in.readParcelable(LocationData.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(trip, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TripAndLocation> CREATOR = new Creator<TripAndLocation>() {
        @Override
        public TripAndLocation createFromParcel(Parcel in) {
            return new TripAndLocation(in);
        }

        @Override
        public TripAndLocation[] newArray(int size) {
            return new TripAndLocation[size];
        }
    };

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public LocationData getLocationDataList() {
        return locationDataList;
    }

    public void setLocationDataList(LocationData locationDataList) {
        this.locationDataList = locationDataList;
    }

}
