package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    MyPredicate mypredicate;
    public FilterDecorator(SmartArray smartArray, MyPredicate mypredicate) {
        super(smartArray);
        this.mypredicate = mypredicate;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = smartArray.toArray();
        Object[] arrnew = new Object[arr.length];
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            if (mypredicate.test(arr[i])) {
                arrnew[len] = arr[i];
                len++;

            }
        }
        return Arrays.copyOf(arrnew, len);
    }

    @Override
    public String operationDescription() {
        return "remove elements which doesn't satisfy MyPredicate";
    }

    @Override
    public int size() {
        return toArray().length;
    }
}
