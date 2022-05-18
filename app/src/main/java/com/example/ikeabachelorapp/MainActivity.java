package com.example.ikeabachelorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AppViewModel viewModel;
    Button qrButton;
    private List<Product> productList;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    private ExpandableListView drawerList;
    ExpandableListAdapter expandableListAdapter;
    List<String> titleList;
    HashMap<String,List<String>> expandableDetailList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        qrButton = findViewById(R.id.qrbutton);
        viewModel = new ViewModelProvider(this).get(AppViewModel.class);
        viewModel.repository.getProductList();
        expandableDetailList = ExpandableListDataItems.getData();

        viewModel.getProducts().observe(this,product -> {

            ArrayList<String> tempTypes = new ArrayList<>();
            for (int i = 0; i < product.size(); i++) {
                if(!tempTypes.contains(product.get(i).productType)){
                    tempTypes.add(product.get(i).productType);
                }
            }
            System.out.println("& Temptypes: "+tempTypes);

            List<String> temp;
            for (int i = 0; i < tempTypes.size(); i++) {
                temp = new ArrayList<>();
                System.out.println("& Type: "+tempTypes.get(i));
                for (int j = 0; j < product.size(); j++) {
                    if(product.get(j).productType==tempTypes.get(i)){
                        temp.add(product.get(j).productName);
                        System.out.println(product.get(j).productName + " & Added to type: "+tempTypes.get(i));
                    }
                }
                expandableDetailList.put(tempTypes.get(i),temp);

                System.out.println("& Array: " + temp);
                System.out.println("& ExpandList: "+expandableDetailList);

            }
            productList = product;
        } );

        qrButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            navigateToCamera("Hello");
            }
        });
        drawerList = (ExpandableListView) findViewById(R.id.drawerl);
        titleList = new ArrayList<String>(expandableDetailList.keySet());
        expandableListAdapter = new CustomizedExpandableListAdapter(this,titleList,expandableDetailList);
        drawerList.setAdapter(expandableListAdapter);

        // This method is called when the group is expanded
        drawerList.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(), titleList.get(groupPosition) + " List Expanded.", Toast.LENGTH_SHORT).show();
            }
        });

        // This method is called when the group is collapsed
        drawerList.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(), titleList.get(groupPosition) + " List Collapsed.", Toast.LENGTH_SHORT).show();
            }
        });

        // This method is called when the child in any group is clicked
        // via a toast method, it is shown to display the selected child item as a sample
        // we may need to add further steps according to the requirements
        drawerList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(), titleList.get(groupPosition)
                        + " -> "
                        + expandableDetailList.get(
                        titleList.get(groupPosition)).get(
                        childPosition), Toast.LENGTH_SHORT
                ).show();
                navigateToProductView(expandableDetailList.get(titleList.get(groupPosition)).get(childPosition));
                return false;
            }
        });

    }
    private void navigateToProductView(String name){
        viewModel.setSelected(name);
        Intent i = new Intent(MainActivity.this, productpage.class);
        i.putExtra("click",name);
        startActivity(i);
    }
    private void navigateToCamera(String name){
        viewModel.setSelected(name);
        Intent i = new Intent(MainActivity.this, CameraActivity.class);
        i.putExtra("click",name);
        startActivity(i);
    }
}




