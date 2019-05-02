package com.mindthemethod.android.nycschools.data.Retrofit.repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import com.mindthemethod.android.nycschools.data.Retrofit.GetTestData;
import com.mindthemethod.android.nycschools.data.Retrofit.RetrofitInstance;
import com.mindthemethod.android.nycschools.model.TestScores;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestRepository {
    private final String LOG_TAG = TestRepository.class.getSimpleName();
    private MediatorLiveData<TestScores> testScores;


    public LiveData<TestScores> getTestScores(String dbn) {
        testScores = new MediatorLiveData<>();
        retrieveTestScores(dbn);
        return testScores;
    }


    private void retrieveTestScores(String dbn) {
        GetTestData getTestData = RetrofitInstance.getRetrofitInstance().create(GetTestData.class);
        Call<List<TestScores>> testScoresCall = getTestData.getSchoolScores(dbn);
        Log.v(LOG_TAG, testScoresCall.request()
                .url().toString());

        testScoresCall.enqueue(new Callback<List<TestScores>>() {
            @Override
            public void onResponse(Call<List<TestScores>> call, Response<List<TestScores>> response) {
                if (response.body().size() > 0) {
                    testScores.postValue(response.body().get(0));
                }
            }

            @Override
            public void onFailure(Call<List<TestScores>> call, Throwable t) {
                Log.v(LOG_TAG, t.getMessage());
            }
        });
    }
}
