package com.example.ikeabachelorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

public class CameraActivity extends AppCompatActivity {
    private PreviewView pv;
    private ListenableFuture<ProcessCameraProvider> cameraProviderListenableFuture;
    private static final int PERMISSION_REQUEST_CAMERA = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        pv = findViewById(R.id.camPreview);
        cameraProviderListenableFuture = ProcessCameraProvider.getInstance(this);
        requestCam();

    }
    private void requestCam(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            System.out.println("Open Cam");
            openCam();
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                ActivityCompat.requestPermissions(CameraActivity.this, new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST_CAMERA);
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST_CAMERA);
            }
        }
    }

    private void openCam(){
        cameraProviderListenableFuture.addListener(() -> {
            try{
                ProcessCameraProvider cameraProvider = cameraProviderListenableFuture.get();
               bindCamPrev(cameraProvider);
            }catch (ExecutionException | InterruptedException e){
                Toast.makeText(this,"Cam Error " + e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }, ContextCompat.getMainExecutor(this));
    }

    private void bindCamPrev(@NonNull ProcessCameraProvider cameraProvider){
        pv.setPreferredImplementationMode(pv.getPreferredImplementationMode().SURFACE_VIEW);
        Preview p = new Preview.Builder().build();

        CameraSelector cameraSelector = new CameraSelector.Builder().requireLensFacing(CameraSelector.LENS_FACING_BACK).build();

        p.setSurfaceProvider(pv.createSurfaceProvider());

        Camera camera = cameraProvider.bindToLifecycle((LifecycleOwner)this,cameraSelector,p);
    }
}