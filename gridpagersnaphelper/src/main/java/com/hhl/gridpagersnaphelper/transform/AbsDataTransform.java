package com.hhl.gridpagersnaphelper.transform;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanhailong on 2017/8/20.
 */

public abstract class AbsDataTransform<T> {

    private static final int DEFAULT_ROW = 1;
    private static final int DEFAULT_COLUMN = 1;

    private int mRow = DEFAULT_ROW;
    private int mColumn = DEFAULT_COLUMN;

    public AbsDataTransform(int row, int column) {
        if (row <= 0 || column <= 0)
            throw new IllegalArgumentException("row or column must be not null");

        this.mRow = row;
        this.mColumn = column;
    }

    public List<T> transform(List<T> dataList) {
        List<T> destList = new ArrayList<T>();

        int pageSize = mRow * mColumn;
        int size = dataList.size();

        int afterTransformSize;
        if (size < pageSize) {
            afterTransformSize = pageSize;
        } else if (size % pageSize == 0) {
            afterTransformSize = size;
        } else {
            afterTransformSize = (size / pageSize + 1) * pageSize;
        }

        for (int i = 0; i < afterTransformSize; i++) {
            int index = transformIndex(i, mRow, mColumn);
            if (index >= 0 && index < size) {
                destList.add(dataList.get(index));
            } else {
                destList.add(null);
            }
        }

        return destList;
    }

    protected abstract int transformIndex(int index, int row, int column);

}
