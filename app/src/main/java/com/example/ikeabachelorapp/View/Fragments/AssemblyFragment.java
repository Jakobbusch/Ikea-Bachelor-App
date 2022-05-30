package com.example.ikeabachelorapp.View.Fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ikeabachelorapp.R;
import com.example.ikeabachelorapp.databinding.FragmentAssemblyBinding;
import com.example.ikeabachelorapp.ViewModel.AssemblyViewModel;

public class AssemblyFragment extends Fragment {

    private FragmentAssemblyBinding binding;

    /**
     * Creates the fragments view
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return root
     */
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AssemblyViewModel assemblyViewModel =
                new ViewModelProvider(this).get(AssemblyViewModel.class);

        binding = FragmentAssemblyBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final Button buttonHelp = binding.buttonHelp;
        final TextView textViewError = binding.textViewError;
        final TextView textView = binding.textAssembly;
        textView.setText(assemblyViewModel.getProduct().getName());
        final WebView webView = binding.assemblyWebview;

        final Dialog dialog = new Dialog(getActivity()); // Context, this, etc.



        buttonHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.setContentView(R.layout.dialog);
                dialog.show();
            }
        });

        if (assemblyViewModel.getProduct().getAssembly().getWebGL() != null){

            webView.loadUrl(assemblyViewModel.getProduct().getAssembly().getWebGL());
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);

        }
        else {

            textViewError.setText("No 3D Assembly Available");
            webView.setVisibility(webView.GONE);
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
        }






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