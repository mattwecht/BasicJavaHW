/*
Matt Wecht
Car thing
 */
package wechthw8;
import java.util.*;
public class WechtHW8 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        //test for car class 
        Car[] carArray = new Car[5];//creates array of cars leaving one default
        carArray[0] = new Car("Ford", "Pinto", 1972, 17.5, 12, 8, 8); // creates a new Car object in spot 0
        carArray[1] = new Car("Honda", "Civic", 2000, 20, 2000,10,0);
        carArray[2] = new Car("Toyta", "Camri", 2016, 25, 0,10,0);
        carArray[3] = new Car("Ferd", "FTEENHUNDRED", 2020, 2, 100000,10,0);
        carArray[4] = new Car();
        
        printAll(carArray);//calls printing method to show all cars 
        System.out.println("type an amount to add to a tank followed by which car");
        double amount = scan.nextDouble();
        int carNum = scan.nextInt();
        carArray[carNum].fillTank(amount);//adds amount gallons to car carNum
        printAll(carArray);//reprints chaged cars
        
        System.out.println("type a distance to drive followed by what car to drive: ");
        amount = scan.nextInt();
        carNum = scan.nextInt();
        carArray[carNum].drive(amount);//drives amount miles on car carNum
        printAll(carArray);//reprints chaged cars
        
        System.out.println("Input a car to check how much gas is left: ");
        carNum = scan.nextInt();
        System.out.println(carArray[carNum].getFuelRemaining() + " gallons are left.");   
        
        //test for Fractions class
        Fractions test = new Fractions (20,15);
        System.out.println(test.getNum() + "/" + test.getDenom());//tests two get functions
        test.setNum(3);//tests setting num
        System.out.println(test.toString());        
        test.setDenum(100);//tests setting denom
        System.out.println(test.toString());
        
        Fractions test2 = new Fractions (1,4);
        test = test.add(test2);//tests adding two fractions 
        System.out.println(test.toString());
        Fractions test3 = new Fractions (13,50);//same as test one to test equals 
        System.out.println(test.equals(test2));
        System.out.println(test.equals(test3));

    }
    
    //used to quickly print all the instances in an array of cars
    public static void printAll(Car array[]){
        for(int i=0; i<=array.length-1; i++)
            System.out.println("Car:" + i + " "+ array[i].toString());
    }
}
