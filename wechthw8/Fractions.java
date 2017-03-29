package wechthw8;

public class Fractions {
    public int numerator;
    public int denominator;

    //constructor with input
    public Fractions(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator ==0)
            throw new ArithmeticException();//error if D is not valid 
        this.denominator = denominator;
        this.reduce();//reduces new fraction 
    }
    
    //constructor with no input to create default of .5
    public Fractions(){
        numerator =1;
        denominator =2;
    }
    
    //returns value of numerator
    public int getNum(){
        return numerator;
    }

    //returns value of denominator
    public int getDenom(){
        return denominator;
    }
    
    //overrights num to be argument value
    public void setNum(int n){
        numerator = n;
        this.reduce();
    }
    
    //overrights denom to be argument value or error if 0
    public void setDenum(int d){
        if (d==0)
            throw new ArithmeticException();//error message
        denominator = d;
        this.reduce();
    }
    
    //adds fraction called on and argument passed
    public Fractions add(Fractions a){
        Fractions b = new Fractions((this.numerator * a.denominator) +(this.denominator * a.numerator),this.denominator*a.denominator);
        return b;
    }
    
    //returns true if equal false if not
    public boolean equals(Fractions a){
        a.reduce();//ensures that any new fraction is reduced 
        if(this.numerator==a.numerator && this.denominator==a.denominator)//if both are equal
            return true;
        else
            return false;
    }

    //returns fractions as a string 
    public String toString() {
        return numerator + "/"+ denominator;
    }
    
    //finds GCD and reduces fraction
    public void reduce () {
       int gcd;
       int num = numerator;
       int denom = denominator; 
        if (num == 0)//finds gcd 
            gcd = denom;
        while (denom != num) {
            if (num > denom)
                num -=denom;
            else
                denom -= num;
        }
        gcd = num;
        if (gcd !=1){//if fraction can be reduced it is
            setNum(numerator/gcd);
            setDenum(denominator/gcd);
        }
    }
    
}
