package com.github.sep_android_app.ui.alerts;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.sep_android_app.R;
import com.github.sep_android_app.adapters.AlertAdapter;
import com.github.sep_android_app.data.model.Alert;

import java.util.ArrayList;
import java.util.List;

public class fragment_alerts extends Fragment {

    private FragmentAlertsViewModel mViewModel;
    private RecyclerView recyclerView;

    public static fragment_alerts newInstance() {
        return new fragment_alerts();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alerts, container, false);
        //Providing link to recyclerview and doing optimisations as the size shouldn't change
        recyclerView = view.findViewById(R.id.recyclerViewAlert);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //Adding dummy data
        List<Alert> alerts = new ArrayList<>();
        alerts.add(new Alert("Tornado warning", "all of them"));


        //Assigning adapter for the recyclerview
        AlertAdapter adapter = new AlertAdapter(alerts);

        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FragmentAlertsViewModel.class);
        // TODO: Use the ViewModel
    }

}
