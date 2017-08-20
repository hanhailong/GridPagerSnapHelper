package com.hhl.gridpagersnaphelper.transform;

/**
 * Created by hanhailong on 2017/8/20.
 */

public class SecondOrderTransform<T> extends AbsDataTransform<T> {

    private static final int ROW = 2;

    public SecondOrderTransform(int column) {
        super(ROW, column);
    }

    @Override
    protected int transformIndex(int index, int row, int column) {
        int pageCount = row * column;
        int pre = index / pageCount;
        int divisor = index % pageCount;

        int transformIndex;
        if (divisor % row == 0) {//even
            transformIndex = divisor / row;
        } else {//odd
            transformIndex = column + divisor / row;
        }

        //this is very important
        transformIndex += pre * pageCount;
        return transformIndex;
    }

}
