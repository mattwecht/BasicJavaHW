package wechthw8;

public class Car {
    public String make;
    public String model;
    public int year;
    public double mpg;
    public int miles;
    public int fuelCapacity;
    public double fuelRemaining;

    //constructor that takes in all fields available 
    public Car(String make, String model, int year, double mpg, int miles, int fuelCapacity, double fuelRemaining) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mpg = mpg;
        this.miles = miles;
        this.fuelCapacity = fuelCapacity;
        this.fuelRemaining = fuelRemaining;
    }
    
    //constructor without input
    public Car(){
        make = "Honda";
        model = "Fit";
        year = 2012;
        mpg = 30;
        miles = 0;
        fuelCapacity = 10;
        fuelRemaining = 0;
    }
    
    //adds value to the fuel remaining up to the fuel capacity 
    public void fillTank (double g){
        if((g+fuelRemaining) <=fuelCapacity)//only runs if will not overfill
            fuelRemaining+=g;
        else
            System.out.println("You tried to put to much gas in");//error message is printed
    }

    //prints all values for the car
    public String toString() {
        return "make=" + make + ", model=" + model + ", year=" + year + ", mpg=" + mpg + ", miles=" + miles + ", fuelCapacity=" + fuelCapacity + ", fuelRemaining=" + fuelRemaining;
    }

    //adds miles to the car and uses gas
    public void drive (double m){
        if(m/mpg>fuelRemaining){
            double fixedm = fuelRemaining*mpg;//sets new m to max amount of miles you can drive
            System.out.println("You can only drive " + fixedm + " miles with the gas you have");
            miles += fixedm;
            fuelRemaining = 0;          
        }
        else{
            miles += m;//adds miles
            fuelRemaining -= (m/mpg);//takes miles divded by mpg out of fuel left
        }
    }
    
    //prints just the fuel left in the car
    public String getFuelRemaining (){
        return String.valueOf(fuelRemaining);
    }
}
