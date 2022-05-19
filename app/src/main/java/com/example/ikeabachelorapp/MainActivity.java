package com.example.ikeabachelorapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AppViewModel viewModel;
    Button qrButton;
    private ExpandableListView drawerList;
    ExpandableListAdapter expandableListAdapter;
    List<String> titleList;
    HashMap<String,List<String>> expandableDetailList;
    private int previousGroupSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        qrButton = findViewById(R.id.qrbutton);
        viewModel = new ViewModelProvider(this).get(AppViewModel.class);
        viewModel.repository.getProductList();

        expandableDetailList = ExpandableListDataItems.getData();
        drawerList = (ExpandableListView) findViewById(R.id.drawerl);
        titleList = new ArrayList<>(expandableDetailList.keySet());
        expandableListAdapter = new CustomizedExpandableListAdapter(this,titleList,expandableDetailList);
        drawerList.setAdapter(expandableListAdapter);

        viewModel.getProducts().observe(this,product -> {
            System.out.println("From Main: "+ product);
                // Creating arraylist of product types
            ArrayList<String> tempTypes = new ArrayList<>();
            for (int i = 0; i < product.size(); i++) {
                if(!tempTypes.contains(product.get(i).getType())){
                    tempTypes.add(product.get(i).getType());
                }
            }
            // Adding products to specific type in hashmap
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
        // Navigate to camera view and start looking for QR.
        qrButton.setOnClickListener(view -> navigateToCamera());



        // This method is called when a group is expanded and collapses the previous expanded group.
        drawerList.setOnGroupExpandListener(groupPosition -> {
            if(groupPosition != previousGroupSelect){
                drawerList.collapseGroup(previousGroupSelect);
                previousGroupSelect = groupPosition;
            }
        });



        // The method navigates to the view of the selected product, when a child of a group is clicked.
        drawerList.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            navigateToProductView(expandableDetailList.get(titleList.get(groupPosition)).get(childPosition));
            return false;
        });

    }

    // The method starts a new activity and puts the name of the clicked product as an extra to the intent.
    private void navigateToProductView(String name){
        viewModel.setSelected(name);
        Intent i = new Intent(MainActivity.this, productpage.class);
        i.putExtra("click",name);
        startActivity(i);
    }

    // The method opens the camera activity for QR scan
    private void navigateToCamera(){
        Intent i = new Intent(MainActivity.this, CameraActivity.class);
        startActivity(i);
    }
}




