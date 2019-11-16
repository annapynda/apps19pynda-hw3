package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {

        MyPredicate predicateYear = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return (((Student) t).getYear() == 2);
            }
        };

        MyPredicate predicateGPA = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return (((Student) t).getGPA() >= 4);
            }
        };

        MyComparator comparatorName = new MyComparator() {

            @Override
            public int compare(Object o1, Object o2) {
                return ((Student) o1).getSurname().compareTo(((Student) o2).getSurname());
            }
        };

        MyFunction function = new MyFunction() {

            @Override
            public Object apply(Object t) {
                return ((Student) t).getSurname() + " " + ((Student) t).getName();
            }
        };

        BaseArray studentarr = new BaseArray(students);
        DistinctDecorator distinctD = new DistinctDecorator(studentarr);
        studentarr = new BaseArray(distinctD.toArray());
        FilterDecorator YEAR = new FilterDecorator(studentarr, predicateYear);
        studentarr = new BaseArray(YEAR.toArray());
        FilterDecorator GPA = new FilterDecorator(studentarr, predicateGPA);
        studentarr = new BaseArray(GPA.toArray());
        SortDecorator names = new SortDecorator(studentarr, comparatorName);
        studentarr = new BaseArray(names.toArray());
        MapDecorator mapdec = new MapDecorator(studentarr, function);
        studentarr = new BaseArray(mapdec.toArray());
        DistinctDecorator distinctDec = new DistinctDecorator(studentarr);
        studentarr = new BaseArray(distinctDec.toArray());

        Object[] result = studentarr.toArray();

        return Arrays.copyOf(result, result.length, String[].class);

        // Hint: to convert Object[] to String[] - use the following code
        //Object[] result = studentSmartArray.toArray();
        //return Arrays.copyOf(result, result.length, String[].class);
    }
}
