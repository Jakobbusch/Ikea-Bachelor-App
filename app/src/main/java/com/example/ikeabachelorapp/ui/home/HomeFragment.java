package com.example.ikeabachelorapp.ui.home;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
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
import com.example.ikeabachelorapp.productpage;
import com.squareup.picasso.Picasso;

import java.net.URL;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    TextView tv;
    URL url;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        productpage activity = (productpage) getActivity();

        View view = inflater.inflate(R.layout.fragment_home,container,false);
        tv = view.findViewById(R.id.text_home);

        tv.setText(activity.getdata());

        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        final ImageView imageViewFront = binding.imageViewFront;
        final ImageView imageViewDraw = binding.imageViewDraw;

        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

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