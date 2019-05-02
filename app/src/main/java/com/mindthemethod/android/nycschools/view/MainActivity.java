package com.mindthemethod.android.nycschools.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.mindthemethod.android.nycschools.R;
import com.mindthemethod.android.nycschools.view.fragments.MasterListFragment;

public class MainActivity extends AppCompatActivity {

    private MasterListFragment masterListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupMasterlistFragment();
    }

    private void setupMasterlistFragment() {
        masterListFragment = new MasterListFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, masterListFragment)
                .commit();
    }
}
