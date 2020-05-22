package com.github.sep_android_app.ui.users;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.sep_android_app.R;
import com.github.sep_android_app.clientAPI.APIRepository;
import com.github.sep_android_app.data.model.User;
import com.github.sep_android_app.ui.home.HomeViewModel;



public class FragmentUsersViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private LiveData<User> name;
    private APIRepository apiRepository = new APIRepository();
    private MutableLiveData<String> email;

    public FragmentUsersViewModel() {
    }

    public LiveData<User> getUser() {
        return apiRepository.getUser("bruh");
    }


}
