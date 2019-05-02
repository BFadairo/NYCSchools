package com.mindthemethod.android.nycschools.data.Retrofit;

import com.mindthemethod.android.nycschools.model.TestScores;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetTestData {

    @GET("f9bf-2cp4.json")
    Call<List<TestScores>> getSchoolScores(@Query("dbn") String dbn);
}
