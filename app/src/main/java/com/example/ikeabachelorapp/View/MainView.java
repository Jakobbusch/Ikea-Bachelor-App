package com.example.ikeabachelorapp.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ExpandableListView;

import com.example.ikeabachelorapp.ViewModel.MainViewModel;
import com.example.ikeabachelorapp.Model.ExpandableListAdapter;
import com.example.ikeabachelorapp.Model.ExpandableItems;
import com.example.ikeabachelorapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainView extends AppCompatActivity {
    private MainViewModel viewModel;
    Button qrButton;
    private ExpandableListView drawerList;
    ExpandableListAdapter expandableListAdapter;
    List<String> titleList;
    HashMap<String,List<String>> expandableDetailList;
    private int previousGroupSelect;

    /**
     * Creates main view
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        qrButton = findViewById(R.id.qrbutton);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.getProductList();

        expandableDetailList = ExpandableItems.getData();
        drawerList = (ExpandableListView) findViewById(R.id.drawerl);
        titleList = new ArrayList<>(expandableDetailList.keySet());
        expandableListAdapter = new ExpandableListAdapter(this,titleList,expandableDetailList);
        drawerList.setAdapter(expandableListAdapter);

        viewModel.getProducts().observe(this,product -> {

            ArrayList<String> tempTypes = new ArrayList<>();
            for (int i = 0; i < product.size(); i++) {
                if(!tempTypes.contains(product.get(i).getType())){
                    tempTypes.add(product.get(i).getType());
                }
            }

            List<String> temp;
            for (int i = 0; i < tempTypes.size(); i++) {
                temp = new ArrayList<>();
                for (int j = 0; j < product.size(); j++) {
                    if(product.get(j).getType().equals(tempTypes.get(i))){
                        temp.add(product.get(j).getName());
                    }
                }
                expandableDetailList.put(tempTypes.get(i),temp);
            }
        } );

        qrButton.setOnClickListener(view -> navigateToCamera());




        drawerList.setOnGroupExpandListener(groupPosition -> {
            if(groupPosition != previousGroupSelect){
                drawerList.collapseGroup(previousGroupSelect);
                previousGroupSelect = groupPosition;
            }
        });




        drawerList.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            navigateToProductView(expandableDetailList.get(titleList.get(groupPosition)).get(childPosition));
            return false;
        });

    }

    /**
     * Navigates to Product View
     * @param name
     */
    private void navigateToProductView(String name){
        viewModel.setSelected(name);
        Intent i = new Intent(MainView.this, productPageView.class);
        i.putExtra("click",name);
        startActivity(i);
    }


    /**
     * Navigates to Camera
     */
    private void navigateToCamera(){
        Intent i = new Intent(MainView.this, CameraView.class);
        startActivity(i);
    }
}




