/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alusimulation;

import java.util.ArrayList;

/**
 *
 * @author noura
 */
public class Restoring {
    ArrayList<String> CycList = new ArrayList<> () ;
    ArrayList<String> numList = new ArrayList<> () ;

    /** Function to shift shift array **/
    public void leftShift(int A[])
    {        
        for(int i =0 ;i <= 6 ; i++){
            A[i] = A[i+1] ;

        } 
        A[A.length-1] = 0 ;
    }
    
    /** Function to add two binary arrays **/
    public void add(int[] A, int[] B)
    {
        int carry = 0;
        int i = 3 ; 
        while(i != -1 ){
            int temp = A[i] + B[i] + carry;
            A[i] = temp % 2;
            carry = temp / 2;
            i-- ;
        }
               
    }
    
        public int[] binary(int n)
    {
        int[] bin = new int[4];
        int ctr = 3;
        int num = n;
        /** for negative numbers 2 complment **/
        if (n < 0)
            num = 16 + n;
        while (num != 0)
        {
            bin[ctr--] = num % 2;
            num /= 2;
        }
        return bin;
    }
    
    /** Function to print array **/
    public void display(int[] P, char ch)
    {   
        System.out.print("\n"+ ch +" : ");
        for (int i = 0; i < P.length; i++)
        {  
            
            if (i == 4)
                System.out.print("     ");
            if (i == 8)
                System.out.print("     ");
            System.out.print(P[i]);
            
        } 
    }
    
    /** Function to get Decimal equivalent of P **/
    public int getDecimal(int[] B)
    {
        int p = 0;
        int t = 1;
        for (int i = 7; i >= 0; i--, t *= 2)
            p += (B[i] * t);
        if (p > 64)
            p = -(256 - p);
        return p;        
    }
    
    public int division(int n1, int n2)
    {   String cycle = "Init" ;
        String number = "" ;
        int[] m = binary(n1);
        int[] m1 = binary(n2);
        int[] r = binary(-n2);        
        int[] A = new int[8];
        int[] S = new int[8];
        int[] P = new int[8];        
        for (int i = 0; i < 4; i++)
        {
            A[i] = m[i];      // Dividend
            S[i] = m1[i];    //Divisor
            
            P[i + 4] = A[i];
        }
        display(A, 'A');
        display(S, 'S');
        display(P, 'P'); 
        display(r, 'R');
        
        saveInitNumber(P,S,numList) ;
        System.out.println();
        
        CycList.add(cycle) ;
        for (int i = 0; i < 4; i++) {
            cycle = "cycle : " + (i+1) ;
            CycList.add(cycle) ;
            leftShift(P);  // left shifting 
            
            add(P, r);
            if (P[0] == 0) {
                // A > 0
                P[P.length - 1] = 1; //set Q0 = 1
            } else {
                // A < 0 
                P[P.length - 1] = 0; //set Q0 = 0
                add(P, S); // Restoring
            }
            display(P, 'P');
            saveArrayNumber(P,numList); 
        }
        
        return getDecimal(P);
    }
    public ArrayList getCycleList(){
        return CycList ;
    }
    
    public void saveArrayNumber(int[] A , ArrayList list){
        String numbers = "" ;
        
        for (int j = 0 ; j< A.length ; j++) {
            if(j == 4 || j == 8){
                numbers += "       " ;
                numbers += A[j] ;
            }else
            {
            numbers += A[j] ;
            }
        } 
        
        list.add(numbers);
    }
    public void saveInitNumber(int[] A, int[] P,ArrayList list){
        String numbers = "" ;
        
        for (int j = 0 ; j< A.length ; j++) {
            if(j == 4 || j == 8){
                numbers += "       " ;
                numbers += A[j] ;
            }
            else
            {
                numbers += A[j] ;
            }
        }
        numbers += "       " ;
        for(int k=0 ; k<4 ; k++){
            numbers += P[k] ;
        }
        
        list.add(numbers);
    }
    public ArrayList getNumberList() {
     return  numList ;
    }
    
    
    
}
