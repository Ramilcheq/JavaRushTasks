package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object n) {
        if (this == n)
            return true;
        if (n == null)
            return false;
        if (!(n instanceof Solution))
            return false;
        Solution s = (Solution) n;
        if (s.first != null && !s.first.equals(first))
            return false;
        return s.last == null || s.last.equals(last);
    }

    public int hashCode() {
        int f = first == null ? 0 : first.hashCode();
        int l = last == null ? 0 : last.hashCode();
        return 31 * (f + l);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution(null, "Duck"));
        System.out.println(s.contains(new Solution(null, "Duck")));
    }
}
