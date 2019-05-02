package com.mindthemethod.android.nycschools.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class School implements Parcelable {

    public static final Creator<School> CREATOR = new Creator<School>() {
        @Override
        public School createFromParcel(Parcel source) {
            return new School(source);
        }

        @Override
        public School[] newArray(int size) {
            return new School[size];
        }
    };
    @SerializedName("school_name")
    @Expose
    private String name;
    @SerializedName("primary_address_line_1")
    @Expose
    private String address;
    @SerializedName("zip")
    @Expose
    private int zip;
    @SerializedName("dbn")
    @Expose
    private String dbn;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("overview_paragraph")
    @Expose
    private String overview;
    @SerializedName("school_sports")
    @Expose
    private String schoolSports;
    @SerializedName("extracurricular_activities")
    @Expose
    private String extracurriculars;
    @SerializedName("website")
    @Expose
    private String schoolWebsite;


    public School(String name, String address, int zip, String dbn, String phoneNumber, String overview, String schoolSports, String extracurriculars, String schoolWebsite) {
        this.name = name;
        this.address = address;
        this.zip = zip;
        this.dbn = dbn;
        this.phoneNumber = phoneNumber;
        this.overview = overview;
        this.schoolSports = schoolSports;
        this.extracurriculars = extracurriculars;
        this.schoolWebsite = schoolWebsite;
    }

    protected School(Parcel in) {
        this.name = in.readString();
        this.address = in.readString();
        this.zip = in.readInt();
        this.dbn = in.readString();
        this.phoneNumber = in.readString();
        this.overview = in.readString();
        this.schoolSports = in.readString();
        this.extracurriculars = in.readString();
        this.schoolWebsite = in.readString();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getZip() {
        return zip;
    }

    public String getDbn() {
        return dbn;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getOverview() {
        return overview;
    }

    public String getSchoolSports() {
        return schoolSports;
    }

    public String getExtracurriculars() {
        return extracurriculars;
    }

    public String getSchoolWebsite() {
        return schoolWebsite;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.address);
        dest.writeInt(this.zip);
        dest.writeString(this.dbn);
        dest.writeString(this.phoneNumber);
        dest.writeString(this.overview);
        dest.writeString(this.schoolSports);
        dest.writeString(this.extracurriculars);
        dest.writeString(this.schoolWebsite);
    }
}
