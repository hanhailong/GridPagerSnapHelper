package com.hhl.gridpagersanphelper;

import android.content.Context;
import android.view.WindowManager;

/**
 * Created by hanhailong on 2017/8/20.
 */

public class ScreenUtils {

    @SuppressWarnings("deprecation")
    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        int width = wm.getDefaultDisplay().getWidth();
        return width;
    }

}
