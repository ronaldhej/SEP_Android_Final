package com.github.sep_android_app.ui.home;

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
import com.github.sep_android_app.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FloatingActionButton mainFab;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mainFab = Objects.requireNonNull(getActivity()).findViewById(R.id.main_fab);
        mainFab.hide();

        return view;
    }
}
