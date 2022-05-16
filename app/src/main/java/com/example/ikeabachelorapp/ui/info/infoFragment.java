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

import org.w3c.dom.Text;

public class infoFragment extends Fragment {

    private FragmentInfoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        infoViewModel infoViewModel =
                new ViewModelProvider(this).get(infoViewModel.class);

        binding = FragmentInfoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textInfo;
        final TextView pname = binding.infoPname;
        final TextView ptype = binding.infoPtype;
        final TextView pprice = binding.infoPprice;
        final TextView pcolor = binding.infoPcolor;
        final TextView pscale = binding.infoPscale;
        final TextView pweight = binding.infoPweight;

        infoViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        pname.setText(infoViewModel.getProduct().productName);
        ptype.setText(infoViewModel.getProduct().productType);
        pprice.setText(String.valueOf(infoViewModel.getProduct().productPrice));
        pcolor.setText("Missing val");
        pscale.setText(infoViewModel.getProduct().productHeight+"Cm /"+infoViewModel.getProduct().productWidth+"Cm");
        pweight.setText(String.valueOf(infoViewModel.getProduct().productWeight));
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}