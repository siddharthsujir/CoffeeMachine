package com.company;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.io.FileReader;
import java.util.Map;


public class Main {

    static long hot_water = 0;
    static long hot_milk= 0;
    static long ginger_syrup= 0;
    static long sugar_syrup = 0;
    static long tea_leaves=0;
    static long green_mixture=0;
    static Map beverage = null;
    static Map hot_tea=null;
    static Map hot_coffee=null;
    static Map black_tea=null;
    static Map green_tea=null;
    static CoffeeMachine cm;
    static Map total_items;
    static Map machine;

    public static void main(String[] args) throws  Exception {

        Object jsonObj = new JSONParser().parse(new FileReader("input_json"));

        JSONObject jo = (JSONObject) jsonObj;

        machine = (Map) jo.get("machine");
        total_items=(Map)machine.get("total_items_quantity");
        refillMachine(machine);

        // Sample Run
        start_machine(machine);

        // Reinitialize the coffee Machine and execute Test Case 1
        System.out.println("\n\n");
        System.out.println("Executing Test case 1");
        refillMachine(machine);
        cm= new CoffeeMachine(hot_water,hot_milk,ginger_syrup,sugar_syrup,tea_leaves,green_mixture);
        testCase1();

        // Reinitialize the coffee machine and execute Test Case 2
        System.out.println("\n\n");
        System.out.println("Executing Test Case 2");
        refillMachine(machine);
        cm= new CoffeeMachine(hot_water,hot_milk,ginger_syrup,sugar_syrup,tea_leaves,green_mixture);
        testCase2();

    }

    public static void refillMachine(Map machine)
    {
        parseMachine(machine);
        parseTotalItems(total_items);
        cm= new CoffeeMachine(hot_water,hot_milk,ginger_syrup,sugar_syrup,tea_leaves,green_mixture);
    }

    public static void  parseTotalItems(Map total_items)
    {
        hot_water = total_items.containsKey("hot_water")?(long)total_items.get("hot_water"):0;
        hot_milk= total_items.containsKey("hot_milk")?(long) total_items.get("hot_milk"):0;
        ginger_syrup= total_items.containsKey("ginger_syrup")?(long) total_items.get("ginger_syrup"):0;
        sugar_syrup = total_items.containsKey("sugar_syrup")?(long) total_items.get("sugar_syrup"):0;
        tea_leaves = total_items.containsKey("tea_leaves_syrup")?(long) total_items.get("tea_leaves_syrup"):0;
        green_mixture = total_items.containsKey("green_mixture")?(long) total_items .get("green_mixture"):0;

    }


    public static void start_machine(Map machine)
    {

        parse_beverage(hot_tea);
        cm.prepareHotTea(hot_water,hot_milk,ginger_syrup,sugar_syrup,tea_leaves);

        parse_beverage(hot_coffee);
        cm.prepareHotCoffee(hot_water,hot_milk,ginger_syrup,sugar_syrup,tea_leaves);

        parse_beverage(black_tea);
        cm.prepareblackTea(hot_water,ginger_syrup,sugar_syrup,tea_leaves);

        parse_beverage(green_tea);
        cm.prepareGreenTea(hot_water,ginger_syrup,sugar_syrup,green_mixture);
    }

    public static void parseMachine(Map machine)
    {

         beverage = (Map)machine.get("beverages");
         hot_tea=(Map)beverage.get("hot_tea");
         hot_coffee=(Map)beverage.get("hot_coffee");
         black_tea=(Map)beverage.get("black_tea");
         green_tea=(Map)beverage.get("green_tea");
    }

    public static void parse_beverage(Map beverage)
    {
        hot_water = beverage.containsKey("hot_water")?(long)beverage.get("hot_water"):0;
        hot_milk= beverage.containsKey("hot_milk")?(long) beverage.get("hot_milk"):0;
        ginger_syrup= beverage.containsKey("ginger_syrup")?(long) beverage.get("ginger_syrup"):0;
        sugar_syrup = beverage.containsKey("sugar_syrup")?(long) beverage.get("sugar_syrup"):0;
        tea_leaves = beverage.containsKey("tea_leaves_syrup")?(long) beverage.get("tea_leaves_syrup"):0;
        green_mixture = beverage.containsKey("green_mixture")?(long) beverage.get("green_mixture"):0;
    }

    public static void testCase1()
    {
        boolean op1;
        boolean op2;
        boolean op3;
        boolean op4;

        parse_beverage(hot_tea);
        op1=cm.prepareHotTea(hot_water,hot_milk,ginger_syrup,sugar_syrup,tea_leaves);

        parse_beverage(hot_coffee);
        op2=cm.prepareHotCoffee(hot_water,hot_milk,ginger_syrup,sugar_syrup,tea_leaves);

        parse_beverage(black_tea);
        op3=cm.prepareblackTea(hot_water,ginger_syrup,sugar_syrup,tea_leaves);

        parse_beverage(green_tea);
        op4=cm.prepareGreenTea(hot_water,ginger_syrup,sugar_syrup,green_mixture);

        if((op1 && op2) && !(op3 && op4))
            System.out.println("Pass");
        else
            System.out.println("Fail");

    }

    // To test if preparing green team is successful or not. As per the given input the preparation of
    // green tea should be failure
    public static void testCase2()
    {
        boolean op1;
        boolean op2;
        boolean op3;
        boolean op4;

        parse_beverage(green_tea);
        op4=cm.prepareGreenTea(hot_water,ginger_syrup,sugar_syrup,green_mixture);

        parse_beverage(hot_tea);
        op1=cm.prepareHotTea(hot_water,hot_milk,ginger_syrup,sugar_syrup,tea_leaves);

        parse_beverage(hot_coffee);
        op2=cm.prepareHotCoffee(hot_water,hot_milk,ginger_syrup,sugar_syrup,tea_leaves);

        parse_beverage(black_tea);
        op3=cm.prepareblackTea(hot_water,ginger_syrup,sugar_syrup,tea_leaves);


        if(op4)
            System.out.println("Fail");
        else
        {
            if((op1) && !(op2 && op3))
                System.out.println("Pass");
            else
                System.out.println("Fail");
        }

    }

}
