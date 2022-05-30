package com.example.ikeabachelorapp.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.util.Size;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ikeabachelorapp.Model.QRCodeFoundListener;
import com.example.ikeabachelorapp.Model.QRCodeImageAnalyser;
import com.example.ikeabachelorapp.Model.Repository;
import com.example.ikeabachelorapp.R;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

public class CameraView extends AppCompatActivity {
    private PreviewView pv;
    private ListenableFuture<ProcessCameraProvider> cameraLProvider;
    private static final int PERMISSION_REQUEST_CAMERA = 0;
    private Button qrFoundButton;
    private String qrCode;
    Repository rep;
    private boolean qrfound = false;

    /**
     * Creates camera view
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        qrFoundButton = findViewById(R.id.qrFoundButton);
        qrFoundButton.setVisibility(View.INVISIBLE);
        pv = findViewById(R.id.camPreview);
        rep = Repository.getInstance();

        qrFoundButton.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(),qrCode,Toast.LENGTH_SHORT).show();
            Log.i(CameraView.class.getSimpleName(),"QR Code Found: " + qrCode);

                Intent i = new Intent(CameraView.this, productPageView.class);
                i.putExtra("qr",qrCode);
                rep.setSelectedByQr(Integer.parseInt(qrCode));
                startActivity(i);
        });
        cameraLProvider = ProcessCameraProvider.getInstance(this);
        requestCam();

    }

    /**
     * Ask camera request
     */
    private void requestCam(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            System.out.println("Open Cam");
            openCam();
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                ActivityCompat.requestPermissions(CameraView.this, new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST_CAMERA);
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST_CAMERA);
            }
        }
    }

    /**
     * Open camera
     */
    private void openCam(){
        cameraLProvider.addListener(() -> {
            try{
                ProcessCameraProvider cameraProvider = cameraLProvider.get();
               bindCamPrev(cameraProvider);
            }catch (ExecutionException | InterruptedException e){
                Toast.makeText(this,"Cam Error " + e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }, ContextCompat.getMainExecutor(this));
    }

    /**
     * Bind camera
     * @param cameraProvider
     */
    private void bindCamPrev(@NonNull ProcessCameraProvider cameraProvider){
        pv.setPreferredImplementationMode(pv.getPreferredImplementationMode().SURFACE_VIEW);
        Preview p = new Preview.Builder().build();

        CameraSelector cameraSelector = new CameraSelector.Builder().requireLensFacing(CameraSelector.LENS_FACING_BACK).build();

        p.setSurfaceProvider(pv.createSurfaceProvider());

        ImageAnalysis imageAnalysis = new ImageAnalysis.Builder().setTargetResolution(new Size(1280,720))
                .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                .build();

        imageAnalysis.setAnalyzer(ContextCompat.getMainExecutor(this),new QRCodeImageAnalyser(new QRCodeFoundListener() {
            @Override
            public void onQRCodeFound(String qrCode_) {
                qrfound = true;
                qrCode = qrCode_;
                qrFoundButton.setVisibility(View.VISIBLE);

            }

            @Override
            public void qrCodeNotFound() {
                if(!qrfound){
                    qrFoundButton.setVisibility(View.INVISIBLE);
                }

            }
        }));

        Camera camera = cameraProvider.bindToLifecycle(this,cameraSelector,imageAnalysis,p);
    }



}