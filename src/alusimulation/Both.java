/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alusimulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

/**
 *
 * @author noura
 */
public class Both {
        
    
    protected List<String> cycle_list = new ArrayList<>();
    protected List<String> first_initList = new ArrayList<>();
    protected List<String> numbers_list = new ArrayList<String>();

    public void getInitValue(int[] A, int[] B){
        String initValue = "0000" ;
        initValue += "       " ;
        for(int i=4 ; i<B.length -1 ; i++){
             initValue += B[i];
            
        }
            initValue += "       " ;
            initValue +="0" ;
            initValue += "       " ;
        for(int i=0 ; i<A.length ; i++){
            if(i == 4){
                break;
            }else {
                
                initValue += A[i];
            }
        }
        numbers_list.add(initValue) ;
    }    
    public int multiply(int n1, int n2)
    {
        int[] m = binary(n1);
        int[] m1 = binary(-n1);
        int[] r = binary(n2);        
        int[] A = new int[9];
        int[] S = new int[9];
        int[] P = new int[9];        
        for (int i = 0; i < 4; i++)
        {
            A[i] = m[i];
            S[i] = m1[i];
            P[i + 4] = r[i];
        }
        display(A, 'A');
        display(S, 'S');
        display(P, 'P');        
        System.out.println();
         getInitValue(A,P) ;
        for (int i = 0; i < 4; i++)
        {   
            if(i==0)
                {
                cycle_list.add("Init") ;
                }
            String cycle = "cycle: " + (i+1) ;
            cycle_list.add(cycle);
            if (P[7] == 0 && P[8] == 0);
                // do nothing            
            else if (P[7] == 1 && P[8] == 0)
                add(P, S);                            
            else if (P[7] == 0 && P[8] == 1)
                add(P, A);            
            else if (P[7] == 1 && P[8] == 1);
                // do nothing
 
            rightShift(P);
            saveArrayNumber(P, (ArrayList) numbers_list);
            display(P, 'P');
        }
        return getDecimal(P);
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
    /** Function to right shift array **/
    public void rightShift(int[] A)
    {        
        for (int i = 8; i >= 1; i--)
            A[i] = A[i - 1];        
    }
    /** Function to add two binary arrays **/
    public void add(int[] A, int[] B)
    {
        int carry = 0;
        for (int i = 8; i >= 0; i--)
        {
            int temp = A[i] + B[i] + carry;
            A[i] = temp % 2;
            carry = temp / 2;
        }        
    }
    /** Function to get binary of a number **/
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
                System.out.print(" ");
            if (i == 8)
                System.out.print(" ");
            System.out.print(P[i]);
            
        } 
    }
    
    public ArrayList getCycleList() {
        
        return (ArrayList) cycle_list ;
    }
    
    public ArrayList getNumberList() {
        
        return (ArrayList) numbers_list ;
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
    
   }
