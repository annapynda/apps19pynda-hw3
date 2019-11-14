package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    @Override
    public Object[] toArray() {
        Object[] arr = smartArray.toArray();
        Object[] arrnew = new Object[arr.length];
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].equals(arr[j])) {
                    break;
                }
                if (j == arr.length - 1) {
                    arrnew[len] = arr[i];
                    len++;
                }

            }
        }
        arrnew[len] = arr[arr.length - 1];
        len++;
        Object[] result = Arrays.copyOf(arrnew, len);
        return result;
    }


    @Override
    public String operationDescription() {
        return "deletes dublicates";
    }

    @Override
    public int size() {
        return toArray().length;
    }
}