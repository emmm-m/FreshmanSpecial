package com.mredrock.freshmanspecial.view.dataFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mredrock.freshmanspecial.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class JobRateFragment extends Fragment {


    public JobRateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.special_2017_fragment_job_rate, container, false);
    }

}
