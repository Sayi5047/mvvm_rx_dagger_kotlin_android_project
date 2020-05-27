package io.hustler.freshcopartner.utils;

import android.content.res.Resources;
import android.util.TypedValue;

public class DimenUtils {
    public static float convertDptoPixels(float dp, Resources resources) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics());
    }

    public static float converPxtoDp(float px, Resources resources) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, px, resources.getDisplayMetrics());

    }
}
