package com.javarush.task.task20.task2028;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<String> list = new CustomTree();

        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }

        System.out.println("List size is " + list.size());
        System.out.println("Expected parent is 3, actual parent is " + ((CustomTree) list).getParent("8"));
        System.out.println("Expected parent is null, actual parent is " + ((CustomTree) list).getParent("20"));
        list.remove("3");
        System.out.println("Expected parent is null, actual parent is " + ((CustomTree) list).getParent("8"));
        for (int i = 16; i < 28; i++) {
            list.add(String.valueOf(i));
        }
        System.out.println("Expected parent is 9, actual parent is " + ((CustomTree) list).getParent("16"));
        for (int i = 16; i < 28; i++) {
            list.remove(String.valueOf(i));
        }
        list.remove("6");
        list.remove("5");
        list.add("16");
        System.out.println("Expected parent is 9, actual parent is " + ((CustomTree) list).getParent("16"));

    }
}
