package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        HashMap<String, String> map = new LinkedHashMap<>();
        map.put("name", "Ivanov");
        map.put("contry", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);
        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getValue() != null) {
                if(!sb.toString().equals(""))
                    sb.append(" and ");
                sb.append(entry.getKey()).append(" = '").append(entry.getValue()).append("'");
            }
        }
        return sb.toString();
    }
}
