package exercise.generics;

import java.util.ArrayList;

public class ArrayAndListDiff {
    public static void main(String[] args) {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add("String");
        arrayList.add(1);

        //
        Object[] la = new Object[2];
        la[0] = "String";
        la[1] = 1;
    }
}
