package app.kh.ui.fragment;

import app.kh.utils.IAudioService;

import app.kh.ui.viewmodel.PlayerViewModel;

import android.content.Context;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;

import androidx.lifecycle.ViewModelProvider;

public final class PlayerFragment extends Fragment {
    private final Context context = requireContext();

    private IAudioService audiService;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        final PlayerViewModel playerViewModel = new ViewModelProvider(this).get(PlayerViewModel.class);

        /*
        * Observar constantement el nivel del usuario, ya que se puede obtener puntos de nivel incluso estando en pausa
        * la actividad.
        * */
        playerViewModel.getImmutableLevel().observe(getViewLifecycleOwner(), level -> {

        });
    }
}
