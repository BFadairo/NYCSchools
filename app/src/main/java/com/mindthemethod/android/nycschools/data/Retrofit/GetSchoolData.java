package com.mindthemethod.android.nycschools.data.Retrofit;

import com.mindthemethod.android.nycschools.model.School;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetSchoolData {

    @GET("s3k6-pzi2.json")
    Call<List<School>> getSchools();
}
