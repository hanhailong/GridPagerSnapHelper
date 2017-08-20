package com.hhl.gridpagersanphelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanhailong on 2017/8/20.
 */

public class DataSourceUtils {

    private static List<ItemData> mDataList;

    public static List<ItemData> getDataSource() {
        if (mDataList == null) {
            mDataList = new ArrayList<>();
            addItemDatas(mDataList);
        }
        return mDataList;
    }

    private static void addItemDatas(List<ItemData> dataList) {
        for (int i = 0; i < 37; i++) {
            ItemData itemData = new ItemData();
            itemData.title = "标题" + (i + 1);
            int value = i % 5;
            if (value == 0) {
                itemData.url = "http://h.hiphotos.baidu.com/zhidao/pic/item/060828381f30e9240ff2cd434c086e061d95f76a.jpg";
            } else if (value == 1) {
                itemData.url = "http://c.hiphotos.baidu.com/zhidao/pic/item/d788d43f8794a4c22fe6ab9408f41bd5ac6e3943.jpg";
            } else if (value == 2) {
                itemData.url = "http://b.hiphotos.baidu.com/zhidao/pic/item/1f178a82b9014a90e7eb9d17ac773912b21bee47.jpg";
            } else if (value == 3) {
                itemData.url = "http://e.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=75aaa91fa444ad342eea8f83e59220c2/0bd162d9f2d3572cf556972e8f13632763d0c388.jpg";
            } else if (value == 4) {
                itemData.url = "http://img1.imgtn.bdimg.com/it/u=1443817543,4124882906&fm=214&gp=0.jpg";
            } else {
                itemData.url = "http://imga.mumayi.com/android/img_google/2013/09/26/com.hd.live.wallpaper.beauty.anime/comhdlivewallpaperbeautyanime_litpic_2.jpg";
            }
            dataList.add(itemData);
        }
    }

    public static class ItemData {
        public String url;
        public String title;
    }
}
