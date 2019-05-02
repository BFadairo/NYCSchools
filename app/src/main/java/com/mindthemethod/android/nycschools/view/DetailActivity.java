package com.mindthemethod.android.nycschools.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.mindthemethod.android.nycschools.R;
import com.mindthemethod.android.nycschools.model.School;
import com.mindthemethod.android.nycschools.view.fragments.DetailFragment;

public class DetailActivity extends AppCompatActivity {

    private DetailFragment detailFragment;
    private School retrievedSchool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (getIntent() != null) {
            Intent intent = getIntent();
            retrievedSchool = intent.getParcelableExtra("School");
            setupDetailFragment(retrievedSchool.getDbn());
        }
    }

    private void setupDetailFragment(String dbn) {
        Bundle schoolBundle = new Bundle();
        schoolBundle.putParcelable("school", retrievedSchool);
        detailFragment = new DetailFragment();
        detailFragment.setArguments(schoolBundle);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, detailFragment)
                .commit();
    }
}
