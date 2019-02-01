package com.mycompany.app;

/**
 * Hello world!
 *
 */
public class App 
{
    public static int app(int[] arr1 , int[] arr2 , int index1 , int index2 , char operand){
        if(index1>arr1.length-1 || index2 > arr2.length-1){
            System.out.println("Given index is higer than legnth of the array.");
            return -1;
        }
        else if (operand=='+') {
            return arr1[index1]+arr2[index2];
        }else if(operand=='-'){
            return arr1[index1]-arr2[index2];
        }else if(operand=='/'){
            return arr1[index1]/arr2[index2];
        }else if(operand=='*'){
            return arr1[index1]*arr2[index2];
	}
	return 0;
    }
}
