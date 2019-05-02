package com.mindthemethod.android.nycschools.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mindthemethod.android.nycschools.R;
import com.mindthemethod.android.nycschools.model.School;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.ViewHolder> {
    private final String LOG_TAG = SchoolAdapter.class.getSimpleName();
    private List<School> mSchools = new ArrayList<>();
    private Context mContext;
    private SchoolOnClick schoolOnClick;

    public SchoolAdapter(Context context, SchoolOnClick schoolOnClick) {
        mContext = context;
        this.schoolOnClick = schoolOnClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.school_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        School currentSchool = mSchools.get(position);

        TextView schoolName = holder.schoolName;

        schoolName.setText(currentSchool.getName());
    }

    @Override
    public int getItemCount() {
        return mSchools.size();
    }

    public void setSchools(List<School> schools) {
        this.mSchools = schools;
        notifyDataSetChanged();
    }

    public interface SchoolOnClick {
        void onClick(int adapterPosition, School school);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final View mView;
        @BindView(R.id.school_name)
        TextView schoolName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            mView.setOnClickListener(this);
            ButterKnife.bind(this, mView);
        }

        @Override
        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            School school = mSchools.get(adapterPosition);
            schoolOnClick.onClick(adapterPosition, school);
        }
    }
}
