package com.b_fit.application.b_fit;

/**
 * Created by Maxwell on 6/29/2017.
 */

public class DataHolder {

    private static String name;
    private static String gender;
    private static int age;
    private static int feet;
    private static int inch;
    private static String weight;
    private static String training;


    public static void setName(String n) {
       name = n;
    }

    public static void setGender(String g) {
        gender = g;
    }

    public static void setAge(int a) {
        age = a;
    }

    public static void setFeet(int ft) {
        feet = ft;
    }

    public static void setInch(int in) {
        inch = in;
    }

    public static void setWeight(String w) {
        weight = w;
    }
    public static void setTraining(String t){
        training = t;
    }



    /**  Multi instance object
  DataHolder(String n, String g, int a, int ft, int in, String w){
        this.name = n;
        this gender = g;
        this.age = a;
        this.feet = ft;
        this.inch = in;
        this. weight = w;
    }

  **/



    public static String getName() {
        return name;
    }

    public static String getGender() {
        return gender;
    }

    public static int getAge() {
        return age;
    }

    public static int getFeet() {
        return feet;
    }

    public static int getInch() {
        return inch;
    }

    public static String getWeight() {
        return weight;
    }
    public static String getTraining(){
        return training;
    }
}
