package com.mindthemethod.android.nycschools;

import com.mindthemethod.android.nycschools.data.Retrofit.GetSchoolData;
import com.mindthemethod.android.nycschools.data.Retrofit.RetrofitInstance;
import com.mindthemethod.android.nycschools.model.School;
import com.mindthemethod.android.nycschools.viewmodel.SchoolViewModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.util.List;

import retrofit2.Response;

import static org.junit.Assert.assertEquals;


@RunWith(JUnit4.class)
public class SchoolRetrofitTest {
    private GetSchoolData schoolData;

    private SchoolViewModel schoolViewModel;

    @Before
    public void setUp() {
        schoolData = RetrofitInstance.getRetrofitInstance().create(GetSchoolData.class);
    }

    @Test
    public void getSchools() {
        try {
            Response<List<School>> response = schoolData.getSchools().execute();
            assertEquals(response.code(), 200);
            assertEquals(response.body().get(0).getName(), "Clinton School Writers & Artists, M.S. 260");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
