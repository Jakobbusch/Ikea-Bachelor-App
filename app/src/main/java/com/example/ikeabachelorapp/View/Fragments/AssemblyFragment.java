package com.example.ikeabachelorapp.View.Fragments;

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
import com.example.ikeabachelorapp.ViewModel.AssemblyViewModel;

public class AssemblyFragment extends Fragment {

    private FragmentAssemblyBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AssemblyViewModel assemblyViewModel =
                new ViewModelProvider(this).get(AssemblyViewModel.class);

        binding = FragmentAssemblyBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textAssembly;

        final WebView webView = binding.assemblyWebview;
        //webView.loadUrl("https://irongarden.github.io/ZoomRotate/");
        webView.loadUrl("https://irongarden.github.io/test/");

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