package com.company;

public class CoffeeMachine {

    private long hot_water=0;
    private long hot_milk=0;
    private long ginger_syrup=0;
    private long sugar_syrup=0;
    private long tea_leaves=0;
    private long coffee_syrup=0;
    private long green_mixture =0;


    // Initialization of Coffee Machine Ingredients
    CoffeeMachine(long hot_milk,long hot_water,long ginger_syrup, long sugar_syrup,long tea_leaves, long green_mixture)
    {
        this.hot_milk=hot_milk;
        this.hot_water=hot_water;
        this.ginger_syrup=ginger_syrup;
        this.sugar_syrup=sugar_syrup;
        this.tea_leaves = tea_leaves;
        this.green_mixture=green_mixture;
    }

    public long getHot_water() {
        return hot_water;
    }

    public void setHot_water(long hot_water) {
        this.hot_water = this.hot_water-hot_water;
    }

    public long getHot_milk() {
        return hot_milk;
    }

    public void setHot_milk(long hot_milk) {
        this.hot_milk = this.hot_milk-hot_milk;
    }

    public long getGinger_syrup() {
        return ginger_syrup;
    }

    public void setGinger_syrup(long ginger_syrup) {
        this.ginger_syrup = this.ginger_syrup-ginger_syrup;
    }

    public long getSugar_syrup() {
        return sugar_syrup;
    }

    public void setSugar_syrup(long sugar_syrup) {
        this.sugar_syrup = this.sugar_syrup-sugar_syrup;
    }

    public long getTea_leaves() {
        return tea_leaves;
    }

    public void setTea_leaves(long tea_leaves) {
        this.tea_leaves = this.tea_leaves-tea_leaves;
    }

    public long getCoffee_syrup() {
        return coffee_syrup;
    }

    public void setCoffee_syrup(long coffee_syrup) {
        this.coffee_syrup = this.coffee_syrup-coffee_syrup;
    }

    public long getGreen_mixture() {
        return green_mixture;
    }

    public void setGreen_mixture(long green_mixture) {
        this.green_mixture = this.green_mixture - green_mixture;
    }

    /* Hot Tea Preparation - we first check if all the ingredients are in sufficient quantity
    If yes we prepare the beverage and deduct the ingredients from the machine
    * */
    public boolean prepareHotTea(long hotWater, long hot_milk,long ginger_syrup,long sugar_syrup,long tea_leaves)
    {
        if(this.hot_water<hotWater)
        {
            printError("hot_tea","hot_water");
            return false;
        }

        if(this.hot_milk<hot_milk)
        {
            printError("hot_tea","hot_milk");
            return false;
        }

        if(this.ginger_syrup<ginger_syrup)
        {
            printError("hot_tea","ginger_syrup");
            return false;
        }

        if(this.sugar_syrup<sugar_syrup)
        {
            printError("hot_tea","sugar_syrup");
            return false;
        }

        if(this.tea_leaves<tea_leaves)
        {
            printError("hot_tea","tea_leaves");
            return false;
        }

        this.setHot_milk(hot_milk);
        this.setHot_water(hotWater);
        this.setGinger_syrup(ginger_syrup);
        this.setSugar_syrup(sugar_syrup);
        this.setTea_leaves(tea_leaves);
        printSuccess("hot_tea");
        return true;
    }

    /* Hot Coffee Preparation - we first check if all the ingredients are in sufficient quantity
     If yes we prepare the beverage and deduct the ingredients from the machine
     * */
    public boolean prepareHotCoffee(long hotWater, long hot_milk,long ginger_syrup,long sugar_syrup,long tea_leaves)
    {
        
        if(this.tea_leaves<tea_leaves)
        {
            printError("hot_Coffee","tea_leaves");
            return false;
        }

        if(this.hot_water<hotWater)
        {
            printError("hot_Coffee","hot_water");
            return false;
        }

        if(this.hot_milk<hot_milk)
        {
            printError("hot_Coffee","hot_milk");
            return false;
        }

        if(this.ginger_syrup<ginger_syrup)
        {
            printError("hot_Coffee","ginger_syrup");
            return false;
        }

        if(this.sugar_syrup<sugar_syrup)
        {
            printError("hot_Coffee","sugar_syrup");
            return false;
        }



        this.setHot_milk(hot_milk);
        this.setHot_water(hotWater);
        this.setGinger_syrup(ginger_syrup);
        this.setSugar_syrup(sugar_syrup);
        this.setTea_leaves(tea_leaves);
        printSuccess("hot_Coffee");
        return true;
    }

    /* Black tea Preparation - we first check if all the ingredients are in sufficient quantity
     If yes we prepare the beverage and deduct the ingredients from the machine
     * */
    public boolean prepareblackTea(long hotWater, long ginger_syrup,long sugar_syrup,long tea_leaves)
    {
        if(this.tea_leaves<tea_leaves)
        {
            printError("black_tea","tea_leaves");
            return false;
        }
        if(this.hot_water<hotWater)
        {
            printError("black_tea","hot_water");
            return false;
        }

        if(this.ginger_syrup<ginger_syrup)
        {
            printError("black_tea","ginger_syrup");
            return false;
        }

        if(this.sugar_syrup<sugar_syrup)
        {
            printError("black_tea","sugar_syrup");
            return false;
        }



        this.setHot_milk(hotWater);
        this.setGinger_syrup(ginger_syrup);
        this.setSugar_syrup(sugar_syrup);
        this.setTea_leaves(tea_leaves);
        printSuccess("black_tea");
        return true;
}

    /* Green Tea Preparation - we first check if all the ingredients are in sufficient quantity
     If yes we prepare the beverage and deduct the ingredients from the machine
     * */
    public boolean prepareGreenTea(long hotWater, long ginger_syrup,long sugar_syrup,long green_mixture)
    {
        if(this.green_mixture<green_mixture)
        {
            printError("green_tea","green_mixture");
            return false;
        }

        if(this.hot_water<hotWater)
        {
            printError("green_tea","hot_water");
            return false;
        }

        if(this.ginger_syrup<ginger_syrup)
        {
            printError("green_tea","ginger_syrup");
            return false;
        }

        if(this.sugar_syrup<sugar_syrup)
        {
            printError("green_tea","sugar_syrup");
            return false;
        }



        this.setHot_milk(hotWater);
        this.setGinger_syrup(ginger_syrup);
        this.setSugar_syrup(sugar_syrup);
        this.setGreen_mixture(green_mixture);
        printSuccess("green_tea");
        return true;
    }

    // Prints error in case any ingredient is not available
    public void printError(String beverage, String item_out_of_stock)
    {
        System.out.println(beverage+ " cannot be prepare because "+ item_out_of_stock +" is not available");
    }

    // Success when the preparation was successful
    public void printSuccess(String beverage)
    {
        System.out.println(beverage +" is prepared");
    }
}
