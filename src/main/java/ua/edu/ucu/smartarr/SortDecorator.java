package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {

    MyComparator mycomparator;

    public SortDecorator(SmartArray smartArray, MyComparator mycomparator) {
        super(smartArray);
        this.mycomparator = mycomparator;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = smartArray.toArray();
        Arrays.sort(arr, mycomparator);
        return arr;
    }

    @Override
    public String operationDescription() {
        return " sorts elements";
    }

   @Override
    public int size() {
        return toArray().length;
    }
}
