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

import com.example.ikeabachelorapp.databinding.FragmentInfoBinding;
import com.example.ikeabachelorapp.ViewModel.InfoViewModel;
import com.squareup.picasso.Picasso;

public class InfoFragment extends Fragment {

    private FragmentInfoBinding binding;

    /**
     * Creates the fragments view
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return root
     */
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        InfoViewModel infoViewModel =
                new ViewModelProvider(this).get(InfoViewModel.class);

        binding = FragmentInfoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final TextView headerinfo = binding.textInfo;
        final TextView ptype = binding.infoPtype;
        final TextView pprice = binding.infoPprice;
        final TextView pcolor = binding.infoPcolor;
        final TextView pscale = binding.infoPscale;
        final TextView pweight = binding.infoPweight;
        final TextView pbuildtime = binding.infoPbuildtime;
        final TextView pbuilddiff = binding.infoPbuildifficulty;
        final ImageView imageInfo = binding.infoImage;


        Picasso.get().load(infoViewModel.getUrl().get("info")).into(imageInfo);
        headerinfo.setText(infoViewModel.getProduct().getName());
        ptype.setText(infoViewModel.getProduct().getType());
        pprice.setText(String.valueOf(infoViewModel.getProduct().getPrice()));
        pcolor.setText("Missing val");
        pscale.setText(infoViewModel.getProduct().getHeight()+"Cm /"+infoViewModel.getProduct().getWidth()+"Cm");
        pweight.setText(String.valueOf(infoViewModel.getProduct().getWeight()));
        pbuildtime.setText(String.valueOf(infoViewModel.getProduct().getAssembly().getBuildTime()));
        pbuilddiff.setText(String.valueOf(infoViewModel.getProduct().getAssembly().getBuildDifficulty()));
        return root;
    }

    /**
     * Destroys view
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}