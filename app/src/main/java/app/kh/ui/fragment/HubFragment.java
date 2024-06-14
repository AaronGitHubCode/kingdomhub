package app.kh.ui.fragment;

import app.kh.R;

import app.kh.ui.HubPagerAdapter;

import app.kh.ui.viewmodel.HubViewModel;

import android.os.Bundle;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;

import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import androidx.lifecycle.ViewModelProvider;

public final class HubFragment extends Fragment {
    private final Context context = requireContext();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.hub_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final HubViewModel viewModel = new ViewModelProvider(this).get(HubViewModel.class);

        final ViewPager2 viewPager = view.findViewById(R.id.hub_view_pager);
        viewPager.setAdapter(new HubPagerAdapter(this));

        final TabLayout tabLayout = view.findViewById(R.id.hub_tab_layout);

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Home");
                    break;
                case 1:
                    tab.setText("News");
                    break;
                case 2:
                    tab.setText("Player");
                    break;
            }
        }).attach();
    }
}
