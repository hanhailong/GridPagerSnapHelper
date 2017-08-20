package com.hhl.gridpagersnaphelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HanHailong on 2017/5/11.
 */

public class GridPagerUtils {

    /**
     * transform and fill empty data
     *
     * @param srcList the source of data
     * @param row     the row of grid
     * @param column  the column of grid
     * @param <T>
     * @return
     */
    public static <T> List<T> transformAndFillEmptyData(List<T> srcList, int row, int column) {

        //1. new a empty ArrayList
        List<T> destList = new ArrayList<T>();

        int size = srcList.size();
        int pageCount = row * column;

        //2. get the traverseCount
        int traverseCount = 0;
        if (size < pageCount) {
            traverseCount = pageCount;
        } else if (size % pageCount == 0) {
            traverseCount = size;
        } else {
            traverseCount = (size / pageCount + 1) * pageCount;
        }

        //3. travrse the list
        for (int i = 0; i < traverseCount; i++) {
            int pre = i / pageCount;
            int divisor = i % pageCount;

            int index = -1;
            if (divisor % 2 == 0) {//even
                index = divisor / 2;
            } else {//odd
                index = column + divisor / 2;
            }

            //this is very important
            index += pre * pageCount;

            if (index >= 0 && index < size) {
                destList.add(srcList.get(index));
            } else {
                destList.add(null);
            }
        }

        //4. back
        return destList;
    }
}
