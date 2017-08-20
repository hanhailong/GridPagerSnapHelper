package com.hhl.gridpagersnaphelper;

import com.hhl.gridpagersnaphelper.transform.AbsDataTransform;

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
        if (row == 0 || column == 0)
            throw new IllegalArgumentException("row or column must be not null");

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
            if (divisor % row == 0) {//even
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

    /**
     * transform and fill empty data
     *
     * @param orderTransform order transform
     * @param dataList
     * @param <T>
     * @return
     */
    public static <T> List<T> transformAndFillEmptyData(AbsDataTransform<T> orderTransform, List<T> dataList) {
        if (orderTransform == null)
            throw new IllegalArgumentException("orderTransform must be not null");

        if (dataList == null || dataList.size() == 0)
            throw new IllegalArgumentException("data list must be not null or size must > 0");

        return orderTransform.transform(dataList);
    }
}
