package com.example.ikeabachelorapp.View;

import android.os.Bundle;
import android.widget.Toast;

import com.example.ikeabachelorapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.ikeabachelorapp.databinding.ActivityProductpageBinding;

public class productPageView extends AppCompatActivity {

    private ActivityProductpageBinding binding;
    String val;
    String val1;

    /**
     * Creates product page view
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    Bundle extras = getIntent().getExtras();
    if(extras!=null){
         val = extras.getString("click");
        System.out.println("From product: "+val);

        val1 = extras.getString("qr");
        Toast.makeText(this,val1,Toast.LENGTH_SHORT);
    }
        binding = ActivityProductpageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_info, R.id.navigation_assembly)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_productpage);
     //   NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    /**
     * Get data
     * @return val
     */
    public String getdata(){
        return val;
    }
}