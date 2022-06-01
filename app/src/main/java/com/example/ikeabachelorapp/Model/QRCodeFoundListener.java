package com.example.ikeabachelorapp.Model;

public interface QRCodeFoundListener {
    /**
     * onQRCodeFound
     * @param qrCode
     */
    void onQRCodeFound(String qrCode);

    /**
     * qrCodeNotFound
     */
    void qrCodeNotFound();
}
