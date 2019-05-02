package com.mindthemethod.android.nycschools.data.Retrofit.repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import com.mindthemethod.android.nycschools.data.Retrofit.GetSchoolData;
import com.mindthemethod.android.nycschools.data.Retrofit.RetrofitInstance;
import com.mindthemethod.android.nycschools.model.School;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SchoolRepository {
    private final String LOG_TAG = SchoolRepository.class.getSimpleName();
    private MediatorLiveData<List<School>> schoolList;
    private List<School> retrievedSchools = new ArrayList<>();

    public SchoolRepository() {
    }

    public LiveData<List<School>> getNYCSchools() {
        schoolList = new MediatorLiveData<>();
        getSchoolList();
        return schoolList;
    }

    public void getSchoolList() {
        GetSchoolData schoolData = new RetrofitInstance().getRetrofitInstance().create(GetSchoolData.class);
        Call<List<School>> schoolCall = schoolData.getSchools();
        Log.v(LOG_TAG,
                schoolCall.request().url().toString());
        schoolCall.enqueue(new Callback<List<School>>() {
            @Override
            public void onResponse(Call<List<School>> call, Response<List<School>> response) {
                if (response.isSuccessful()) {
                    retrievedSchools = response.body();
                    schoolList.postValue(retrievedSchools);
                    Log.v(LOG_TAG, "Retrofit Call Successful");
                }
            }

            @Override
            public void onFailure(Call<List<School>> call, Throwable t) {
                Log.v(LOG_TAG, t.getMessage());
            }
        });
    }
}
