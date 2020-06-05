package com.github.sep_android_app.ui.users;

import androidx.lifecycle.ViewModelProviders;

import android.app.AlertDialog;
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
import com.github.sep_android_app.adapters.UserAdapter;
import com.github.sep_android_app.data.model.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static android.content.ContentValues.TAG;

public class fragment_users extends Fragment implements UserAdapter.onClickListener {


    private FragmentUsersViewModel mViewModel;

    private FloatingActionButton mainFab;

    private RecyclerView recyclerView;

    private List<User> users = new ArrayList<>();


    public static fragment_users newInstance() {
        return new fragment_users();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_users, container, false);
        // Optimisations for recyclerlayout
        recyclerView = view.findViewById(R.id.recyclerViewUser);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //Dummy data
        users.add(new User("Ronald", "bruh"));
        users.add(new User("Johnson", "bruh"));
        users.add(new User("Ronald", "bruh"));
        users.add(new User("Johnson", "bruh"));
        users.add(new User("Ronald", "bruh"));
        users.add(new User("Johnson", "bruh"));
        users.add(new User("Ronald", "bruh"));
        users.add(new User("Johnson", "bruh"));
        users.add(new User("Ronald", "bruh"));
        users.add(new User("Johnson", "bruh"));
        users.add(new User("Ronald", "bruh"));
        users.add(new User("Johnson", "bruh"));
        users.add(new User("Ronald", "bruh"));
        users.add(new User("Johnson", "bruh"));
        UserAdapter adapter = new UserAdapter(users, this);

        // Setting adapter to generate card items in recycler
        recyclerView.setAdapter(adapter);
        //Customizing FAB
        mainFab = requireActivity().findViewById(R.id.main_fab);
        mainFab.setImageResource(R.drawable.ic_add);

        // Setting FAB to open create user dialog
        mainFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = getActivity().getLayoutInflater();

                builder.setView(inflater.inflate(R.layout.dialog_create_user, null));
                builder.create();
                builder.show();
            }
        });



        mainFab.show();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FragmentUsersViewModel.class);
    }

    @Override
    public void onClick(int position, View view) {
        Log.d(TAG, "onClick: clicked with id: " + position);
        // Create popup Dialog

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        mViewModel.getUser();

        builder.setView(inflater.inflate(R.layout.dialog_edit_user, null));
        Log.d(TAG, "Trying to inflate dialog");
        builder.create();
        builder.show();
    }
}
