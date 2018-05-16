package com.javarush.task.task36.task3611;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/* 
Сколько у человека потенциальных друзей?
*/

public class Solution {
    private boolean[][] humansRelationships;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.humansRelationships = generateRelationships();

        Set<Integer> allFriendsAndPotentialFriends = solution.getAllFriendsAndPotentialFriends(7, 3);
        System.out.println(allFriendsAndPotentialFriends);                              //expected: [0, 1, 2, 3, 5, 7]
        Set<Integer> potentialFriends = solution.removeFriendsFromSet(allFriendsAndPotentialFriends, 7);
        System.out.println(potentialFriends);                                           //expected: [2, 5, 7]
    }

    public Set<Integer> getAllFriendsAndPotentialFriends(int index, int deep) {
        //напишите тут ваш код
        /*ArrayDeque<Integer> people = new ArrayDeque<>();
        Set<Integer> result = new TreeSet<>();
        people.add(index);deep--;
        int hrSize = humansRelationships.length;
        while (!people.isEmpty()) {
            int nomerChela = people.poll();
            for (int i = 0; i < nomerChela; i++) {
                if (humansRelationships[nomerChela][i]) {
                    result.add(i);
                    if (deep > 0) people.add(i);
                }
            }

            for (int j = nomerChela + 1; j < hrSize; j++) {
                if (humansRelationships[j][nomerChela]) {
                    result.add(j);
                    if (deep > 0) people.add(j);
                }
            }
            deep--;
        }
        result.removeIf(x->x==index);
        return result;*/
        Set<Integer> result = new HashSet<>();
        if (deep == 0) return result;
        for (int i = 0; i < humansRelationships.length; i++) {
            if (i < index) {
                if (humansRelationships[index][i]) {
                    result.add(i);
                    result.addAll(getAllFriendsAndPotentialFriends(i, deep - 1));
                }
            } else {
                if (humansRelationships[i][index]) {
                    result.add(i);
                    result.addAll(getAllFriendsAndPotentialFriends(i, deep - 1));
                }
            }
        }
        result.remove(index);
        return result;
    }

    //remove people from set, with which you have already had relationship
    public Set<Integer> removeFriendsFromSet(Set<Integer> set, int index) {
        for (int i = 0; i < humansRelationships.length; i++) {
            if ((i < index) && (index < humansRelationships.length) && humansRelationships[index][i]) {
                set.remove(i);
            } else if ((i > index) && humansRelationships[i][index]) {
                set.remove(i);
            }
        }
        return set;
    }

    //return test data
    private static boolean[][] generateRelationships() {
        return new boolean[][]{
                {true},                                                                 //0
                {true, true},                                                           //1
                {false, true, true},                                                    //2
                {false, false, false, true},                                            //3
                {true, true, false, true, true},                                        //4
                {true, false, true, false, false, true},                                //5
                {false, false, false, false, false, true, true},                        //6
                {false, false, false, true, false, false, false, true}                  //7
        };
    }
}