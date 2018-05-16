package com.javarush.task.task35.task3507;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain()
                .getCodeSource().getLocation().getPath() + Solution.class.getPackage()
                .getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        XLoader xLoader = new XLoader(pathToAnimals);
        try {
            return xLoader.loadClass();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static class XLoader extends ClassLoader {
        // карта отображения имен классов на файлы .class, где хранятся их определения
        private String path;

        public XLoader(String file) {
            path = file;
        }

        public synchronized Set<Animal> loadClass() throws ClassNotFoundException {
            Set<Animal> resultClasses = new HashSet<>();
            try {
                File[] files = new File(path).listFiles();
                ArrayList<Class> classes = new ArrayList<>();
                for (File file : files) {
                    String name = Solution.class.getPackage().getName() + ".data." + file.getName().substring(0, file.getName().length() - 6);
                    byte[] bbuf = Files.readAllBytes(file.toPath());
                    classes.add(defineClass(name, bbuf, 0, bbuf.length));
                    int i;
                }

                for (Class cl : classes) {
                    Class[] interfaces = cl.getInterfaces();
                    if (interfaces.length == 0) continue;
                    int inter=0;
                    for(Class clas:interfaces){
                        if(clas.getSimpleName().toString().equals("Animal")) inter++;
                    }
                    if (inter==0) continue;
                    Constructor[] constructors = cl.getConstructors();
                    if (constructors.length == 0) continue;
                    for (Constructor c : constructors) {
                        if (c.getParameterCount() == 0) {
                            try {
                                resultClasses.add((Animal) cl.newInstance());
                            } catch (InstantiationException e) {
                                e.printStackTrace();
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    int q = 0;
                }

            } catch (IOException e) {
                e.printStackTrace();
                throw new ClassNotFoundException(e.getMessage(), e);
            }
            return resultClasses;
        }
    }

}
