package tr.com.fkocak.settingpreferences;

/**
 * Created by fatihkocak on 4.10.2018.
 */

import android.content.res.ColorStateList;
import android.support.annotation.ColorInt;

public class Utils {
    public static ColorStateList colorToStateList(@ColorInt int color, @ColorInt int disabledColor) {
        return new ColorStateList(
                new int[][]{
                        new int[]{-android.R.attr.state_enabled},
                        new int[]{-android.R.attr.state_checked},
                        new int[]{},
                },
                new int[]{
                        disabledColor,
                        disabledColor,
                        color,
                });
    }
}