package com.cubico.donationtracker.locationparser;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class Location {
    private int key;
    private String name;
    private float lat;
    private float longitude;
    private String address;
    private String city;
    private String state;
    private int zip;
    private LocationType type;
    private String phone;
    private String website;
    private static boolean alreadyUploaded = false;

    Location(int key, String name, float lat, float longitude, String address, String city, String state, int zip, LocationType type, String phone, String website) {
        this.key = key;
        this.name = name;
        this.lat = lat;
        this.longitude = longitude;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.type = type;
        this.phone = phone;
        this.website = website;
    }

    public static void upload(List<Location> locations) {
        if (alreadyUploaded) {
            return;
        }
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference locationRef = database.getReference().child("Locations");
        DatabaseReference myRef;
        for(Location loc: locations) {
            myRef = database.getReference().child("Locations").child(loc.key + "");
            myRef.setValue(loc);
        }
        alreadyUploaded = true;
    }

    public String toString() {
        return String.format("Welcome to %s, located in %s, %s", name, city, state);
    }

    public int getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public float getLat() {
        return lat;
    }

    public float getLongitude() {
        return longitude;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZip() {
        return zip;
    }

    public LocationType getType() {
        return type;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }
}

