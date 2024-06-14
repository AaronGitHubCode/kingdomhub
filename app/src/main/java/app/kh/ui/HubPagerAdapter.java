package app.kh.ui;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;

import androidx.viewpager2.adapter.FragmentStateAdapter;

import app.kh.ui.fragment.HomeFragment;
import app.kh.ui.fragment.PlayerFragment;

public final class HubPagerAdapter extends FragmentStateAdapter {
    private final Fragment[] fragments = new Fragment[] {
        new HomeFragment(),
        new PlayerFragment()
    };

    public HubPagerAdapter(final Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments[position];
    }

    @Override
    public int getItemCount() {
        return fragments.length;
    }
}
