package com.example.lutemonv10;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.lutemonv10.Fragments.EditLutemonFragment;
import com.example.lutemonv10.Fragments.ListFragment;
import com.example.lutemonv10.Fragments.RecordsFragment;

public class TabPagerAdapter extends FragmentStateAdapter {

    public TabPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new ListFragment();
            case 1:
                return new EditLutemonFragment();
            case 2:
                return new RecordsFragment();
            default:
                return new ListFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
