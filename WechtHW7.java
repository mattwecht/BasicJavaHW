/*
Matt Wecht
HW 7
Array practice
 */
package wechthw7;
import java.util.*;
public class WechtHW7 {

    public static void main(String[] args) {
        int r[]= {10,1,1,2,3,2,4,4};
        Scanner scan = new Scanner(System.in);
        System.out.println("This is your array: " + Arrays.toString(r));
        System.out.println("this is the average of all values: " + average(r));
        
        System.out.println("Input a number to find the number of times it occurs");
        int find = scan.nextInt();
        System.out.println(find+ " occurs: " + numOccurrences(r,find) + " times.");
        
        System.out.println("Input a number to find in the array");
        find = scan.nextInt();
        System.out.println(find + " was found first at position: " +find(r,find));
        System.out.println("It was found last at: " + findLast(r,find));
        
        System.out.println("This is the largest number in the array: " + largest(r) + " and is found at:"+
                             indexOfLargest(r));
        System.out.println("This is the index of largest odd number in the array: " + indexOfLargestOdd(r) );
        
        System.out.println("Input a number to put in this array, followed by the spot to put it in: ");
        int n = scan.nextInt();
        int index = scan.nextInt();
        System.out.println("Here is a copy of the old array: " + Arrays.toString(copy(r)));
        insert(r,n,index);
        System.out.println("Here is the new array: " + Arrays.toString(r));
        
        int r3[] = {1,2,3,4,5};
        System.out.println("Here is the array and another combined: " + Arrays.toString(copyAll(r,r3)));

        reverse(r);
        System.out.println("Here is the reversed array: " + Arrays.toString(r));
        
        System.out.println("Here is the array with only unique numbers: " + Arrays.toString(unique(r)));
        
        int [][]r2 = {{1,2,3},
                      {4,5,6},
                      {1,1,0},
                      {10,10,10}};//new array of arrays to use in later functions
        System.out.println("here is a multidemensional array: \n"+Arrays.toString(r2[0]) + "\n" + 
                           Arrays.toString(r2[1]) + "\n" + Arrays.toString(r2[2])+"\n" +Arrays.toString(r2[3]));
        System.out.println("Here is the sum of the largest row: "+ largestRow(r2));
        System.out.println("Here is the sum of the largest colum: "+ largestCol(r2));
    }
    /* returns the average of the items in A */
    public static double average(int A[]) {
        double sum = 0;
        for(int i = 0; i<A.length; i++)
            sum += A[i];
        return sum/A.length;
    }

    /* returns the number of times that x appears in A[] */
    public static int numOccurrences(int A[], int x) {
        int counter = 0;
        for (int i = 0; i <A.length; i++)
            if(A[i]==x)
                counter++;
        return counter;
    }

    /* returns the index of the first occurrence of
     * x in A[] or -1 if x doesn't exist in A[] */
    public static int find(int A[], int x) {
        for(int i = 0; i<A.length; i++)
            if(A[i]==x)
                return i;
        return -1;
    }

    /* returns the index of the last occurrence of
     * x in A[] or -1 if x doesn't exist in A[] */
    public static int findLast(int A[], int x) {
       for(int i = A.length-1; i>= 0; i--)
            if(A[i]==x)
                return i;
        return -1;
    }

    /* returns the largest item found in A */
    public static int largest(int A[]) {
        int largest = A[0];
        for(int i = 1; i<A.length; i++)
            if(A[i]>largest)
                largest=A[i];
        return largest;
    }

    /* returns the index of the largest item found in A */
    public static int indexOfLargest(int A[]) {
        for(int i = 0; i<A.length; i++)
            if(A[i]==largest(A))
                return i;
        return -1;//never reached but needed to run

    }

    /* returns the index of the largest odd number
     * in A[] or -1 if A[] contains no odd numbers */
    public static int indexOfLargestOdd(int A[]) {
        int largest = Integer.MIN_VALUE;
        for(int i = 0; i<A.length; i++)
            if(A[i]>largest && A[i]%2!=0)
                largest=i;
        if(largest == Integer.MIN_VALUE)
            return -1;//if the largest was never replaced with a real number  
        else
            return largest;
    }

    /* inserts n into A[] at A[index] shifting all */
    /*  the previous items one place to the right. For example */
    /*  if A is  */
    /*   |---+---+---+---+---+---+---+---+---+---| */
    /*   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | */
    /*   |---+---+---+---+---+---+---+---+---+---| */
    /*   | 5 | 7 | 6 | 9 | 4 | 3 | 0 | 0 | 0 | 0 | */
    /*   |---+---+---+---+---+---+---+---+---+---| */

    /*   and we call insert(A, 15, 1), A then becomes */

    /*   |---+----+---+---+---+---+---+---+---+---| */
    /*   | 0 |  1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | */
    /*   |---+----+---+---+---+---+---+---+---+---| */
    /*   | 5 | 15 | 7 | 6 | 9 | 4 | 3 | 0 | 0 | 0 | */
    /*   |---+----+---+---+---+---+---+---+---+---| */
    public static void insert(int A[], int n, int index) {
        int A2[] = new int[A.length];
        int temp =A[index];
        int x = 0;
        for(int i=0; i<A.length; i++){
            if(i==index){
                A2[i]= n;
                x=i-1;
            }
            else    
                A2[i]=A[x];
        x++;
        }
        for(int i=0; i<A.length; i++)
            A[i]=A2[i];//copies new array into old
    }

    /* returns a new array consisting of all of the
     * elements of A[] */
    public static int[] copy(int A[]) {
        int A2[] = new int[A.length];
        for(int i=0; i<A.length; i++)
            A2[i]=A[i];
        return A2;
    }

    /* returns a new array consisting of all of the
     * elements of A[] followed by all of the
     * elements of B[]. For example, if 
         A[] is: {10,20,30} and 
	 B[] is: {5, 9, 38}, the method returns the
	 array : {10,20,30,5,9,38} */
    public static int[] copyAll(int A[], int B[]) {
        int C[] = new int[A.length+B.length];
        int x = 0;
        for(int i=0; i<C.length; i++){
            if(i<A.length)
                C[i]=A[i];
            else{
                C[i]=B[x];
                x++;
            }
        }
        return C;
    }

    /* reverses the order of the elements in A[].
     * For example, if A[] is:
       {10,20,30,40,50}, after the method, A[] would
       be {50,40,30,20,10} */
    public static void reverse(int A[]) {
        int x=0;
        int i = A.length-1;
        int temp;

        while (x<i){
            temp= A[x];
            A[x]=A[i];
            A[i]=temp;
            i--;
            x++;
        }
    }

    /* returns a new array consisting of all of the
     * elements of A, but with no duplicates. For example,
     * if A[] is {10,20,5,32,5,10,9,32,8}, the method returns
     * the array {10,20,5,32,9,8} */
    //added new function for this
    public static int[] unique(int A[]) {
        int C[] = new int[A.length];
        int x =0;//used to find of correct array
        for(int i=0; i<A.length; i++){//runs for length of I
            if(find(A,A[i],i+1)==-1){//if find function for that int does not work than puts this value in new array
                C[x]=A[i];
                x++;
            }
        }
        int B[] = new int[x];//creates new array to fill without the zeros 
        for(int y=0; y<x; y++)
            B[y]=C[y];//fills new propper sized array 
        return B;
    }
   
    //new method to use during unique
    //same as find but includes a start position to avoid finding the initial occurence
    public static int find(int A[],int x, int start){
        for(int i = start; i<A.length; i++)
            if(A[i]==x)
                return i;
        return -1;
    }

    /* returns the sum of the row in A that has the largest
     * sum */
    public static int largestRow(int A[][]) {
        int largestSum =Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0; i<A.length; i++){
            for(int x =0; x<A[i].length; x++)
                sum += A[i][x];//adds the value of number in row i colum x
            if(sum>largestSum)
                largestSum = sum;//tracks largest sum
            sum =0;//reset sum
        }
        return largestSum;
    }

    /* returns the sum of the column in A that has the largest
     * sum. You may assume that each row has the same number
     * of columns. */
    public static int largestCol(int A[][]) {
        int largestSum =Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0; i<A[0].length; i++){//runs to number of colums  
            for(int x =0; x<A.length; x++)//runs for number of rows
                sum += A[x][i];//adds the value of number in row i colum x
            if(sum>largestSum)
                largestSum = sum;//tracks largest sum
            sum =0;//reset sum
        }
        return largestSum;
    }
    
}
