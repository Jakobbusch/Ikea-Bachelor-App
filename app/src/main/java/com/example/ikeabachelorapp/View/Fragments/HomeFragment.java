package com.example.ikeabachelorapp.View.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ikeabachelorapp.R;
import com.example.ikeabachelorapp.databinding.FragmentHomeBinding;
import com.example.ikeabachelorapp.View.productPageView;
import com.example.ikeabachelorapp.ViewModel.HomeViewModel;
import com.squareup.picasso.Picasso;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        productPageView activity = (productPageView) getActivity();

        View view = inflater.inflate(R.layout.fragment_home,container,false);

        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        final ImageView imageViewFront = binding.imageViewFront;
        final ImageView imageViewDraw = binding.imageViewDraw;

        homeViewModel.getNameHeader().observe(getViewLifecycleOwner(), textView::setText);

        Picasso.get().load(homeViewModel.getUrl().get("front")).into(imageViewFront);
        Picasso.get().load(homeViewModel.getUrl().get("drawing")).into(imageViewDraw);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}