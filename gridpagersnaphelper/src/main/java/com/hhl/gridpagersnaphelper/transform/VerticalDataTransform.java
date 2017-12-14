package com.hhl.gridpagersnaphelper.transform;

/**
 * Created by hanhailong on 2017/12/14.
 */

public class VerticalDataTransform<T> extends AbsRowDataTransform<T> {

    public VerticalDataTransform(int row, int column) {
        super(row, column);
    }

    @Override
    protected int transformIndex(int index, int row, int column) {
        return index;
    }
}
