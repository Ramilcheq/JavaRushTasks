package com.javarush.task.task18.task1815;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements ATableInterface{
        private ATableInterface wrapee;

        public TableInterfaceWrapper(ATableInterface atable){
            this.wrapee=atable;
        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            wrapee.setModel(rows);
        }

        @Override
        public String getHeaderText() {
            return wrapee.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            wrapee.setHeaderText(newHeaderText);
        }
    }

    public interface ATableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}