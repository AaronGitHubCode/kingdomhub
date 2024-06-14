package app.kh.ui.fragment;

import app.kh.R;

import app.kh.ui.viewmodel.HomeViewModel;

import android.os.Bundle;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;

import androidx.lifecycle.ViewModelProvider;

public final class HomeFragment extends Fragment {
    private final Context context = requireContext();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final HomeViewModel viewModel = new ViewModelProvider(this).get(HomeViewModel.class);


    }
}
