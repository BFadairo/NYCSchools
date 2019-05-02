package com.mindthemethod.android.nycschools.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.mindthemethod.android.nycschools.R;
import com.mindthemethod.android.nycschools.model.School;
import com.mindthemethod.android.nycschools.model.TestScores;
import com.mindthemethod.android.nycschools.viewmodel.TestViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailFragment extends Fragment {

    private final String LOG_TAG = MasterListFragment.class.getSimpleName();

    @BindView(R.id.number_of_test_takers)
    TextView numOfTestTakers;
    @BindView(R.id.critical_reading_score)
    TextView readingScore;
    @BindView(R.id.math_score)
    TextView mathScore;
    @BindView(R.id.writing_score)
    TextView writingScore;
    @BindView(R.id.school_name)
    TextView schoolName;
    private TestViewModel testViewModel;
    private School retrievedSchool;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        testViewModel.getTestScores().observe(this, new Observer<TestScores>() {
            @Override
            public void onChanged(TestScores testScores) {
                /*if (testScores.getSchoolName() != null) {
                    Log.v(LOG_TAG, "School is not null");
                    schoolName.setText(testScores.getSchoolName());
                } else {
                    Log.v(LOG_TAG, "School is null");
                    schoolName.setText(retrievedSchool.getName());
                }*/
                if (testScores != null) {
                    numOfTestTakers.setText(String.valueOf(testScores.getNumOfTestTakers()));
                    readingScore.setText(String.valueOf(testScores.getReadingAvgScore()));
                    mathScore.setText(String.valueOf(testScores.getMathAvgScore()));
                    writingScore.setText(String.valueOf(testScores.getWritingAvgScore()));
                }
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.detail_fragment, container, false);
        ButterKnife.bind(this, rootView);

        //Get the associated ViewModel
        testViewModel = ViewModelProviders.of(this).get(TestViewModel.class);

        //Retrieve the arguments from the bundle
        if (getArguments() != null) {
            Bundle retrievedArguments = getArguments();
            retrievedSchool = retrievedArguments.getParcelable("school");

            schoolName.setText(retrievedSchool.getName());
            numOfTestTakers.setText("N/A");
            readingScore.setText("N/A");
            mathScore.setText("N/A");
            writingScore.setText("N/A");

            testViewModel.setDbn(retrievedSchool.getDbn());
        }

        return rootView;
    }
}