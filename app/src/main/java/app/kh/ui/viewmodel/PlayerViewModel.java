package app.kh.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import lombok.Getter;

public final class PlayerViewModel extends ViewModel {
    private final MutableLiveData<Integer> level = new MutableLiveData<>();

    @Getter
    private LiveData<Integer> immutableLevel = level;
}
