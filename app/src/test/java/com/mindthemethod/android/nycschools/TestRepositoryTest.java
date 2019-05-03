package com.mindthemethod.android.nycschools;

import com.mindthemethod.android.nycschools.data.Retrofit.GetTestData;
import com.mindthemethod.android.nycschools.data.Retrofit.RetrofitInstance;
import com.mindthemethod.android.nycschools.model.TestScores;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.util.List;

import retrofit2.Response;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class TestRepositoryTest {

    private GetTestData testData;

    @Before
    public void setupService() {
        testData = RetrofitInstance.getRetrofitInstance().create(GetTestData.class);
    }

    @Test
    public void getTestScores() {
        try {
            Response<List<TestScores>> response = testData.getSchoolScores("01M448").execute();
            assertEquals(response.code(), 200);
            assertEquals(response.body().get(0).getNumOfTestTakers(), 91);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
