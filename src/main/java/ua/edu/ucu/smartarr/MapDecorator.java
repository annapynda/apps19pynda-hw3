package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {

    MyFunction myFunction;

    public MapDecorator(SmartArray smartArray, MyFunction myfunction) {
        super(smartArray);
        this.myFunction = myfunction;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = smartArray.toArray();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = myFunction.apply(arr[i]);
        }
        return arr;
    }


    @Override
    public String operationDescription() {
        return "change element into another object";
    }

    @Override
    public int size() {
        return toArray().length;
    }
}
