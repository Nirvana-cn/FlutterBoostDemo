package com.example.mnist;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

public class ImageUtils {

    public static final int IMAGE_SIZE = 28;

    private static final ColorMatrix INVERT = new ColorMatrix(
            new float[]{
                    -1, 0, 0, 0, 255,
                    0, -1, 0, 0, 255,
                    0, 0, -1, 0, 255,
                    0, 0, 0, 1, 0
            });

    private static final ColorMatrix BLACK_WHITE = new ColorMatrix(
            new float[]{
                    0.5f, 0.5f, 0.5f, 0, 0,
                    0.5f, 0.5f, 0.5f, 0, 0,
                    0.5f, 0.5f, 0.5f, 0, 0,
                    0, 0, 0, 1, 0,
                    -1, -1, -1, 0, 1
            }
    );

    /**
     * Make bitmap appropriate size, greyscale and inverted. MNIST model is originally trained on
     * data-set of images 28x28px with white letter written on black background.
     */
    public static Bitmap prepareImageForClassification(Bitmap bitmap) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0);
        colorMatrix.postConcat(BLACK_WHITE);
        colorMatrix.postConcat(INVERT);
        ColorMatrixColorFilter f = new ColorMatrixColorFilter(colorMatrix);

        Paint paint = new Paint();
        paint.setColorFilter(f);

        Bitmap bmpGrayscale = Bitmap.createScaledBitmap(
                bitmap,
                IMAGE_SIZE,
                IMAGE_SIZE,
                false);
        Canvas canvas = new Canvas(bmpGrayscale);
        canvas.drawBitmap(bmpGrayscale, 0, 0, paint);
        return bmpGrayscale;
    }
}
