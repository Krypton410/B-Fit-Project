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
    private static boolean isLogged;
    private static float protein,carbs,fats, gainCarb, gainFat, lossCarb, lossFat;

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
    public static void setIsLogged(boolean l){
        isLogged = l;
    }
    public static void setProtein(float p){
        protein = p;
    }
    public static void setCarbs(float c){
        carbs = c;
    }
    public static void setFats(float f){
        fats = f;
    }
    public static void setGainCarb(float carb){
        gainCarb = carb;
    }
    public static void setGainFat(float fat){
        gainFat = fat;
    }
    public static void setLossCarb(float lCarb){
        lossCarb = lCarb; //WeightLoss Carb
    }
    public static void setLossFat(float lo){
        lossFat = lo;//WeightLoss Fat
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
    public static boolean getLogged(){
        return isLogged;
    }
    public static double getProtein()
    {
        return protein;
    }
    public static double getCarbs()
    {
        return carbs;
    }
    public static double getFats()
    {
        return fats;
    }
    public static float getGainCarb(){
        return gainCarb;
    }
    public static float getGainFat(){
        return gainFat;
    }
    public static float getLossCarb(){
        return lossCarb;
    }
    public static float getLossFat(){
        return lossFat;
    }
}
