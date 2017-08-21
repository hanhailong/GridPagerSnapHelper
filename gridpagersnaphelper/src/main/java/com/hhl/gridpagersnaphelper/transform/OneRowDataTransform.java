package com.hhl.gridpagersnaphelper.transform;

/**
 * Created by hanhailong on 2017/8/20.
 */

public class OneRowDataTransform<T> extends AbsRowDataTransform<T> {

    private static final int ROW = 1;

    public OneRowDataTransform(int column) {
        super(ROW, column);
    }

    @Override
    protected int transformIndex(int index, int row, int column) {
        //First Order
        return index;
    }

}
