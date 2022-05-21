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

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;

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

        final ImageCarousel imageCarousel = binding.carousel;
        final TextView textView = binding.textHome;
        final TextView textView1 = binding.textProduct;

        textView1.setText(homeViewModel.getProduct().getText());
        imageCarousel.registerLifecycle(getLifecycle());
        textView.setText(homeViewModel.getProduct().getName());
        homeViewModel.getNameHeader().observe(getViewLifecycleOwner(), textView::setText);

        List<CarouselItem> list = new ArrayList<>();

        list.add(
                new CarouselItem(homeViewModel.getUrl().get("front"))
        );

        list.add(
                new CarouselItem(homeViewModel.getUrl().get("front2"))
        );
     //  Picasso.get().load(homeViewModel.getUrl().get("front")).into(imageViewFront);
      //  Picasso.get().load(homeViewModel.getUrl().get("drawing")).into(imageViewDraw);
        imageCarousel.setData(list);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}