package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {

    private Object[] basearray;

    public BaseArray(Object[] basearray) {
        this.basearray = basearray;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(basearray, basearray.length);
    }

    @Override
    public String operationDescription() {
        return null;
    }

    @Override
    public int size() {
        return basearray.length;
    }
}
