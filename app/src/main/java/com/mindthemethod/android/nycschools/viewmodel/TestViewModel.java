package com.mindthemethod.android.nycschools.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.mindthemethod.android.nycschools.data.Retrofit.repositories.TestRepository;
import com.mindthemethod.android.nycschools.model.TestScores;

public class TestViewModel extends ViewModel {

    private final String LOG_TAG = TestViewModel.class.getSimpleName();

    private MediatorLiveData<TestScores> testScoresList;
    private MutableLiveData<String> dbn = new MutableLiveData<>();

    private TestRepository testRepository;


    public LiveData<TestScores> getTestScores() {
        testScoresList = new MediatorLiveData<>();
        testRepository = new TestRepository();
        testScoresList.addSource(testRepository.getTestScores(dbn.getValue()),
                new Observer<TestScores>() {
                    @Override
                    public void onChanged(TestScores testScores) {
                        testScoresList.setValue(testScores);
                    }
                });
        return testScoresList;
    }

    public void setDbn(String dbn) {
        this.dbn.setValue(dbn);
    }

    public String getDbn() {
        return this.dbn.getValue();
    }
}
