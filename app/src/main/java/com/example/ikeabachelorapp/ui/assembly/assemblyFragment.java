package com.example.ikeabachelorapp.ui.assembly;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ikeabachelorapp.databinding.FragmentAssemblyBinding;

public class assemblyFragment extends Fragment {

    private FragmentAssemblyBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        assemblyViewModel assemblyViewModel =
                new ViewModelProvider(this).get(assemblyViewModel.class);

        binding = FragmentAssemblyBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textAssembly;
        assemblyViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        final WebView webView = binding.assemblyWebview;
        webView.loadUrl("https://irongarden.github.io/ZoomRotate/");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}