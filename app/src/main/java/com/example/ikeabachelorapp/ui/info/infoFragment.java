package com.example.ikeabachelorapp.ui.info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ikeabachelorapp.databinding.FragmentInfoBinding;

public class infoFragment extends Fragment {

    private FragmentInfoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        infoViewModel infoViewModel =
                new ViewModelProvider(this).get(infoViewModel.class);

        binding = FragmentInfoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView pname = binding.infoPname;
        final TextView ptype = binding.infoPtype;
        final TextView pprice = binding.infoPprice;
        final TextView pcolor = binding.infoPcolor;
        final TextView pscale = binding.infoPscale;
        final TextView pweight = binding.infoPweight;
        final TextView pbuildtime = binding.infoPbuildtime;
        final TextView pbuilddiff = binding.infoPbuildifficulty;


        pname.setText(infoViewModel.getProduct().getName());
        ptype.setText(infoViewModel.getProduct().getType());
        pprice.setText(String.valueOf(infoViewModel.getProduct().getPrice()));
        pcolor.setText("Missing val");
        pscale.setText(infoViewModel.getProduct().getHeight()+"Cm /"+infoViewModel.getProduct().getWidth()+"Cm");
        pweight.setText(String.valueOf(infoViewModel.getProduct().getWeight()));
        //pbuildtime.setText(infoViewModel.getProduct().get);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}