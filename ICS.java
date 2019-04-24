/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ics;
import java.util.*;

/**
 *
 * @author Devendra M Naik
 */
public class ICS {
    
    public static int[] p10(int []arr)
    {
        int predef[] = new int[]{3,5,2,7,4,10,1,9,8,6};
        int newArr[] = new int[10];
        for(int i=0;i<10;i++)
        {
            newArr[i] = arr[predef[i]-1];
        }
        return newArr;
    }
    
    public static int[] p8(int []arr)
    {
        int predef[] = new int[]{6,3,7,4,8,5,10,9};
        int newArr[] = new int[8];
        for(int i=0;i<predef.length;i++)
        {
            newArr[i] = arr[predef[i]-1];
        }
        return newArr;
    }
    
    public static int[] p4(int []arr)
    {
        int predef[] = new int[]{2,4,3,1};
        int newArr[] = new int[predef.length];
        for(int i=0;i<predef.length;i++)
        {
            newArr[i] = arr[predef[i]-1];
        }
        return newArr;
    }
    
    public static int[] ip(int []arr)
    {
        int predef[] = new int[]{2,6,3,1,4,8,5,7};
        int newArr[] = new int[8];
        for(int i=0;i<predef.length;i++)
        {
            newArr[i] = arr[predef[i]-1];
        }
        return newArr;
    }
    
    public static int[] ipInverse(int []arr)
    {
        int predef[] = new int[]{4,1,3,5,7,2,8,6};
        int newArr[] = new int[8];
        for(int i=0;i<predef.length;i++)
        {
            newArr[i] = arr[predef[i]-1];
        }
        return newArr;
    }
    
    public static int[] ep(int []arr)
    {
        int predef[] = new int[]{4,1,2,3,2,3,4,1};
        int newArr[] = new int[8];
        for(int i=0;i<predef.length;i++)
        {
            newArr[i] = arr[predef[i]-1];
        }
        return newArr;
    }
    
    public static int[] ls1(int []arr)
    {
        int newArr[] = new int[5];
        int i=0;
        for(i=0;i<4;i++)
        {
            newArr[i] = arr[i+1];
        }
        newArr[i] = arr[0];
        return newArr;
    }
    
    public static int[] mergeArrays(int []arr1, int[]arr2)
    {
        int newArr[] = new int[arr1.length+arr2.length];
        int count = 0;
        for(int i = 0; i < arr1.length; i++) { 
           newArr[i] = arr1[i];
           count++;
        } 
        for(int j = 0; j < arr2.length;j++) { 
           newArr[count++] = arr2[j];
        }
        return newArr;
    }
    
    public static int[] xor(int []arr, int []arrXor)
    {
        int newArr[] = new int[arr.length];
        for(int i=0;i<newArr.length;i++)
        {
            if(arr[i] == arrXor[i])
            {
                newArr[i] = 0;
            }
            else
            {
                newArr[i] = 1;
            }
        }
        return newArr;
    }
    
    public static int[] s0(int []arr)
    {
        String s0[][] = {{"0 1","0 0","1 1","1 0"},{"1 1","1 0","0 1","0 0"},{"0 0","1 0","0 1","1 1"},{"1 1","0 1","1 1","1 0"}};
        String newStr;
        int newArr[] = new int[2];
        int row = Integer.parseInt(arr[0]+""+arr[3],2);
        int column = Integer.parseInt(arr[1]+""+arr[2],2);
//        String column = arr[1]+""+arr[2];
        newStr = s0[row][column];
        newArr[0] = Integer.parseInt(newStr.split(" ")[0]);
        newArr[1] = Integer.parseInt(newStr.split(" ")[1]);
        return newArr;
    }
    
    public static int[] s1(int []arr)
    {
        String s1[][] = {{"0 0","0 1","1 0","1 1"},{"1 0","0 0","0 1","1 1"},{"1 1","0 0","0 1","0 0"},{"1 0","0 1","0 0","1 1"}};
        String newStr;
        int newArr[] = new int[2];
        int row = Integer.parseInt(arr[0]+""+arr[3],2);
        int column = Integer.parseInt(arr[1]+""+arr[2],2);
//        String column = arr[1]+""+arr[2];
        newStr = s1[row][column];
        newArr[0] = Integer.parseInt(newStr.split(" ")[0]);
        newArr[1] = Integer.parseInt(newStr.split(" ")[1]);
        return newArr;
    }
    
    public static void main(String[] args) {
        int inputKey[],p10[],lptKey[],rptKey[],plainText[];
//        KEY GENERATION STARTS HERE

//      this is the input key
        inputKey = new int[]{0,0,1,0,0,1,0,1,1,1};
        
//        p10 permutation
        p10 = p10(inputKey);
        
//        splitting the output into two halves of 5 elements each
        lptKey = new int[5];
        rptKey = new int[5];
        for(int i=0;i<10;i++)
        {
            if(i<5)
            {
                lptKey[i] = p10[i];
            }
            else
            {
                rptKey[i-5] = p10[i];
            }
        }
        int []lptLs1;
        int []rptLs1;
        lptLs1 = ls1(lptKey);
        rptLs1 = ls1(rptKey);
        
//        merging the two parts and passing it to p8 permutation
        int []firstKey;
        firstKey = p8(mergeArrays(lptLs1, rptLs1));
        
//        performing left shift twice
        int []lptLs2;
        int []rptLs2;
        lptLs2 = ls1(ls1(lptLs1));
        rptLs2 = ls1(ls1(rptLs1));;
        
//        merging the two parts and passing it to p8 permutation
        int secondKey[];
        secondKey = p8(mergeArrays(lptLs2, rptLs2));
//        System.out.println(Arrays.toString(secondKey));
        
//        KEY GENERATION ENDS HERE

// ENCRYPTION STARTS HERE
        plainText = new int[]{1,0,1,0,0,1,0,1};
        
        int ipText[],xorText[],epOutput[],s0Output[],s1Output[],p4Output[],ipXorOutput[],sw[],newLpt[],newRpt[];
        ipText = ip(plainText);
        int lptIp[] = new int[4];
        int rptIp[] = new int[4];
        for(int i=0;i<8;i++)
        {
            if(i<4)
            {
                lptIp[i] = ipText[i];
            }
            else
            {
                rptIp[i-4] = ipText[i];
            }
        }
        epOutput = ep(rptIp);
        xorText = xor(epOutput,firstKey);
        int lptXor[] = new int[4];
        int rptXor[] = new int[4];
        for(int i=0;i<8;i++)
        {
            if(i<4)
            {
                lptXor[i] = xorText[i];
            }
            else
            {
                rptXor[i-4] = xorText[i];
            }
        }
        s0Output = s0(lptXor);
        s1Output = s1(rptXor);
        p4Output = p4(mergeArrays(s0Output, s1Output));
        ipXorOutput = xor(p4Output,lptIp);
        sw = mergeArrays(rptIp, ipXorOutput);
        newRpt = Arrays.copyOf(ipXorOutput,ipXorOutput.length);
        newLpt = Arrays.copyOf(rptIp,rptIp.length);
        
        int xorTextSecond[],epOutputSecond[],s0OutputSecond[],s1OutputSecond[],p4OutputSecond[],ipXorOutputSecond[];
        epOutputSecond = ep(newRpt);
        xorTextSecond = xor(epOutputSecond,secondKey);
        int lptXorSecond[] = new int[4];
        int rptXorSecond[] = new int[4];
        for(int i=0;i<8;i++)
        {
            if(i<4)
            {
                lptXorSecond[i] = xorTextSecond[i];
            }
            else
            {
                rptXorSecond[i-4] = xorTextSecond[i];
            }
        }
        s0OutputSecond = s0(lptXorSecond);
        s1OutputSecond = s1(rptXorSecond);
        p4OutputSecond = p4(mergeArrays(s0OutputSecond, s1OutputSecond));
        ipXorOutputSecond = xor(p4OutputSecond,newLpt);
        int cipherText[];
        cipherText= ipInverse(mergeArrays(ipXorOutputSecond, newRpt));
        System.out.println(Arrays.toString(cipherText));
// ENCRYPTION ENDS HERE

//For decryption process 
//replace firstkey and secondkey and just give the input text as cipher text
    }
    
}
