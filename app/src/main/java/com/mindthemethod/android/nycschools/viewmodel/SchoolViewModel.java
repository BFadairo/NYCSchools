package com.mindthemethod.android.nycschools.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.mindthemethod.android.nycschools.data.Retrofit.repositories.SchoolRepository;
import com.mindthemethod.android.nycschools.model.School;

import java.util.List;

public class SchoolViewModel extends ViewModel {

    private final String LOG_TAG = SchoolViewModel.class.getSimpleName();

    private MediatorLiveData<List<School>> schoolsList;
    private SchoolRepository schoolRepository;

    public SchoolViewModel() {

    }

    public LiveData<List<School>> getSchoolList() {
        schoolRepository = new SchoolRepository();
        schoolsList = new MediatorLiveData<>();
        schoolsList.addSource(schoolRepository.getNYCSchools(),
                new Observer<List<School>>() {
                    @Override
                    public void onChanged(List<School> schools) {
                        schoolsList.setValue(schools);
                    }
                });
        return schoolsList;
    }
}
