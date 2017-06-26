/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alusimulation;

/**
 *
 * @author noura
 */
public class nonRestoring {

    public void lshift(int a[], int q[]) {
        for (int i = 0; i < 3; i++) {
            a[i] = a[i + 1];
        }
        a[3] = q[0];
        for (int i = 0; i < 3; i++) {
            q[i] = q[i + 1];
        }
        q[3] = 0;
    }
    public static int[] add(int a[],int m1[]){
        int carry =0;
        int sum[]=new int [4];
        for(int i=3 ; i>=0 ; i--){
            sum[i]=(a[i]+m1[i]+carry)%2;
            carry=(a[i]+m1[i]+carry)/2;
        }
        return sum;
    }
    
    public static int[] comp2(int m1[]) {
        int z[] = {0, 0, 0, 1};
        for (int i = 0; i < 3; i++) {
            if (m1[i] == 0) {
                m1[i] = 1;
            } else {
                m1[i] = 0;
            }
        }
        m1 = add(m1, z);
        return m1;
    } 
    public static void display(int a[], int q[], int m[]) {
        for (int i = 0; i < 4; i++) {
            System.out.print(a[i]);
        }

        System.out.print("\t");
        for (int i = 0; i < 4; i++) {
            System.out.print(q[i]);
        }
        System.out.print("\t");

        for (int i = 0; i < 4; i++) {
            System.out.print(m[i]);
        }
        System.out.print("\t");
    }
    
}
