package com.timor.test;

import java.util.ArrayList;

public class ListOfNull {
    public static void main(String[] args) {
        ArrayList<Object> list1 = new ArrayList<>();
        list1.add(null);
        System.out.println(list1.size());
    }
}
