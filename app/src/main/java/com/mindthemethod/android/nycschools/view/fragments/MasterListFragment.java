package com.mindthemethod.android.nycschools.view.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mindthemethod.android.nycschools.R;
import com.mindthemethod.android.nycschools.model.School;
import com.mindthemethod.android.nycschools.view.adapters.SchoolAdapter;
import com.mindthemethod.android.nycschools.viewmodel.SchoolViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MasterListFragment extends Fragment implements SchoolAdapter.SchoolOnClick {

    private final String LOG_TAG = MasterListFragment.class.getSimpleName();

    @BindView(R.id.school_list_recycler)
    RecyclerView schoolRecycler;
    private SchoolAdapter mAdapter;
    private SchoolViewModel schoolViewModel;

    public MasterListFragment() {
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        schoolViewModel = ViewModelProviders.of(this).get(SchoolViewModel.class);
        schoolViewModel.getSchoolList().observe(this, new Observer<List<School>>() {
            @Override
            public void onChanged(List<School> schools) {
                mAdapter.setSchools(schools);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.school_list_fragment, container, false);
        ButterKnife.bind(this, rootView);
        populateUi();

        return rootView;
    }

    private void populateUi() {
        mAdapter = new SchoolAdapter(getContext(), this);
        //Set the layout manager
        schoolRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        schoolRecycler.setAdapter(mAdapter);
    }

    @Override
    public void onClick(int adapterPosition, School school) {
        Log.v(LOG_TAG, school.getName());
        Toast.makeText(getContext(), "" + school.getName(), Toast.LENGTH_SHORT).show();
    }
}
