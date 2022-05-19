package com.example.ikeabachelorapp.Model;

import androidx.annotation.NonNull;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;

import static android.graphics.ImageFormat.YUV_420_888;
import static android.graphics.ImageFormat.YUV_422_888;
import static android.graphics.ImageFormat.YUV_444_888;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.multi.qrcode.QRCodeMultiReader;

import java.nio.ByteBuffer;

public class QRCodeImageAnalyser implements ImageAnalysis.Analyzer{
    private QRCodeFoundListener listener;

    public QRCodeImageAnalyser(QRCodeFoundListener listener){
        this.listener = listener;
    }
    @Override
    public void analyze(@NonNull ImageProxy image) {
        if(image.getFormat() == YUV_420_888 || image.getFormat() == YUV_422_888 || image.getFormat() == YUV_444_888){
            ByteBuffer byteBuffer = image.getPlanes()[0].getBuffer();
            byte[] idata = new byte[byteBuffer.capacity()];
            byteBuffer.get(idata);

            PlanarYUVLuminanceSource source = new PlanarYUVLuminanceSource(
                    idata,
                    image.getWidth(),image.getHeight(),0,0,
                    image.getWidth(), image.getHeight(), false
            );

            BinaryBitmap bm = new BinaryBitmap(new HybridBinarizer(source));

            try{
                Result result = new QRCodeMultiReader().decode(bm);
                listener.onQRCodeFound(result.getText());
            }catch(FormatException | ChecksumException | NotFoundException e){
                listener.qrCodeNotFound();
            }
        }
        image.close();
    }
}
