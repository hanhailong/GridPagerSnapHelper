package com.hhl.gridpagersnaphelper.transform;

/**
 * Created by hanhailong on 2017/8/20.
 */

public class ThirdOrderTransform<T> extends AbsDataTransform<T> {

    private static final int ROW = 3;

    public ThirdOrderTransform(int column) {
        super(ROW, column);
    }

    @Override
    protected int transformIndex(int index, int row, int column) {
        int pageCount = row * column;

        //current page index
        int curPageIndex = index / pageCount;
        int divisor = index % pageCount;

        int transformIndex;
        if (divisor % row == 0) {//even
            transformIndex = divisor / row;
        } else if (divisor % row == 1) {//odd
            transformIndex = column + divisor / row;
        } else {
            transformIndex = column * 2 + divisor / row;
        }

        //this is very important
        transformIndex += curPageIndex * pageCount;

        return transformIndex;
    }

}
