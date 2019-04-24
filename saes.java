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
public class saes {
    
    public static ArrayList<Integer> xor(List<Integer> arr1, List<Integer> arr2)
    {
        ArrayList<Integer> newArr = new ArrayList<>();
        for(int i=0;i<arr1.size();i++)
        {
            if(arr1.get(i).equals(arr2.get(i)))
            {
                newArr.add(0);
            }
            else
            {
                newArr.add(1);
            }
        }
        return newArr;
    }
    
    public static List<Integer> shift(List<Integer> arr)
    {
        List<Integer> newArr = new ArrayList<>();
        List<Integer> arrTemp1 = new ArrayList<>();
        List<Integer> arrTemp2 = new ArrayList<>();
        int count=0;
        for(Integer a:arr)
        {
            if(count>=4 && count<8)
            {
                arrTemp1.add(a);
            }
            if(count>=12 && count<16)
            {
                arrTemp2.add(a);
            }
            count++;
        }
        for(int i=0;i<16;i++)
        {
            if(i<4)
            {
                newArr.add(arr.get(i));
            }
            else if(i >= 4  && i<8)
            {
                newArr.add(arrTemp2.get(i-4));
            }
            else if(i>=8 && i<12)
            {
                newArr.add(arr.get(i));
            }
            else if(i>=12 && i<16)
            {
                newArr.add(arrTemp1.get(i-12));
            }
        }
        return newArr;
    }
    
    public static List<Integer> subnib(List<Integer> arr1)
    {
        List<String> keyArr = new ArrayList<>();
        List<String> valueArr = new ArrayList<>();
        List<Integer> newArr = new ArrayList<>();
        keyArr = Arrays.asList("0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111");
        valueArr = Arrays.asList("1001","0100","1010","1011","1101","0001","1000","0101","0110","0010","0000","0011","1100","1110","1111","0111");
        String str = "";
        for(int i=0;i<arr1.size();i++)
        {
            if(i%4==0 && i>0)
            {
                for(String a:valueArr.get(keyArr.indexOf(str)).split(""))
                {
                    newArr.add(Integer.parseInt(a));
                }
                str = "";
                str += arr1.get(i);
            }
            else
            {
                str += arr1.get(i);
            }
        }
        for(String a:valueArr.get(keyArr.indexOf(str)).split(""))
        {
            newArr.add(Integer.parseInt(a));
        }
        return newArr;
    }
    
    public static List<Integer> invSubNib(List<Integer> arr1)
    {
        List<String> keyArr = new ArrayList<>();
        List<String> valueArr = new ArrayList<>();
        List<Integer> newArr = new ArrayList<>();
        valueArr = Arrays.asList("0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111");
        keyArr = Arrays.asList("1001","0100","1010","1011","1101","0001","1000","0101","0110","0010","0000","0011","1100","1110","1111","0111");

        String str = "";
        for(int i=0;i<arr1.size();i++)
        {
            if(i%4==0 && i>0)
            {
                for(String a:valueArr.get(keyArr.indexOf(str)).split(""))
                {
                    newArr.add(Integer.parseInt(a));
                }
                str = "";
                str += arr1.get(i);
            }
            else
            {
                str += arr1.get(i);
            }
        }
        for(String a:valueArr.get(keyArr.indexOf(str)).split(""))
        {
            newArr.add(Integer.parseInt(a));
        }
        return newArr;
    }
    
    public static int elementXor(int a, int b)
    {
        if(a == b)
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }
    
    public static List<Integer> integerXor(int x, int y)
    {
        int result = (x | y) & (~x | ~y);
        List<Integer> newArr = new ArrayList<>();
        String temp = Integer.toString(result, 2);
        for(int i=0;i<(4-Integer.toString(result, 2).length());i++)
        {
            temp = "0"+temp;
        }
        for(String a:temp.split(""))
        {
            newArr.add(Integer.parseInt(a));
        }
        return newArr;
    }
    
    public static List<Integer> mixcolumns(List<Integer> arr)
    {
        List<String> two = new ArrayList<>();
        two = Arrays.asList("2","4","6","8","A","C","E","3","1","7","5","B","9","F","D");
        List<String> four = new ArrayList<>();
        four = Arrays.asList("4","8","C","3","7","B","F","6","2","E","A","5","1","D","9");
        List<String> nine = new ArrayList<>();
        nine = Arrays.asList("9","1","8","2","B","3","A","4","D","5","C","6","F","7","E");
        String mat[][] = new String[2][2];
        String constMat[][] = new String[2][2];
        mat[0][0] = ""+Integer.parseInt(arr.get(0)+""+arr.get(1)+""+arr.get(2)+""+arr.get(3),2);
        mat[1][0] = ""+Integer.parseInt(arr.get(4)+""+arr.get(5)+""+arr.get(6)+""+arr.get(7),2);
        mat[0][1] = ""+Integer.parseInt(arr.get(8)+""+arr.get(9)+""+arr.get(10)+""+arr.get(11),2);
        mat[1][1] = ""+Integer.parseInt(arr.get(12)+""+arr.get(13)+""+arr.get(14)+""+arr.get(15),2);
        constMat[0][0] = "1";
        constMat[0][1] = "4";
        constMat[1][0] = "4";
        constMat[1][1] = "1";
        List<Integer> finalArr = new ArrayList<>();
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<2;j++)
            {
                List<Integer> newArr = new ArrayList<>();
                for(int k=0;k<2;k++)
                {
                    String temp="";
                    int x = Integer.parseInt(mat[i][k]);
                    int y = Integer.parseInt(constMat[k][j]);
//                    System.out.println("X is: "+x+" Y is: "+y);
                    if(x == 2)
                    {
                        temp = two.get(y-1);
                    }
                    else if(x == 4)
                    {
                        temp = four.get(y-1);
                    }
                    else if(x == 9)
                    {
                        temp = nine.get(y-1);
                    }
                    else if(y == 2)
                    {
                        temp = two.get(x-1);
                    }
                    else if(y == 4)
                    {
                        temp = four.get(x-1);
                    }
                    else if(y == 9)
                    {
                        temp = nine.get(x-1);
                    }
                    else
                    {
                        temp = Integer.toString(x*y);
                    }
//                    System.out.println("Temp is:"+temp);
                    switch (temp) {
                        case "A":
                            newArr.add(10);
                            break;
                        case "B":
                            newArr.add(11);
                            break;
                        case "C":
                            newArr.add(12);
                            break;
                        case "D":
                            newArr.add(13);
                            break;
                        case "E":
                            newArr.add(14);
                            break;
                        case "F":
                            newArr.add(15);
                            break;
                        default:
                            newArr.add(Integer.parseInt(temp));
                            break;
                    }
                }
                finalArr.addAll(integerXor(newArr.get(0), newArr.get(1)));
            }
        }
        return finalArr;
        
//        This Alternative way was discarded because inverse matrix multiplication ka mila hi nahi aisa solution
//
//
//        List<Integer> newArr = new ArrayList<>();
//        while(newArr.size() < 8) newArr.add(0);
//        Collections.copy(newArr, arr);
//        newArr.set(0, elementXor(arr.get(0), arr.get(6)));
//        newArr.set(1, elementXor(elementXor(arr.get(1), arr.get(4)),arr.get(7)));
//        newArr.set(2, elementXor(elementXor(arr.get(2), arr.get(4)),arr.get(5)));
//        newArr.set(3, elementXor(arr.get(3), arr.get(5)));
//        newArr.set(4, elementXor(arr.get(2), arr.get(4)));
//        newArr.set(5, elementXor(elementXor(arr.get(0), arr.get(3)),arr.get(5)));
//        newArr.set(6, elementXor(elementXor(arr.get(0), arr.get(1)),arr.get(6)));
//        newArr.set(7, elementXor(arr.get(1), arr.get(7)));
//        return newArr;
    }
    
    public static List<Integer> inverseMixcolumns(List<Integer> arr)
    {
        List<String> two = new ArrayList<>();
        two = Arrays.asList("2","4","6","8","A","C","E","3","1","7","5","B","9","F","D");
        List<String> four = new ArrayList<>();
        four = Arrays.asList("4","8","C","3","7","B","F","6","2","E","A","5","1","D","9");
        List<String> nine = new ArrayList<>();
        nine = Arrays.asList("9","1","8","2","B","3","A","4","D","5","C","6","F","7","E");
        String mat[][] = new String[2][2];
        String constMat[][] = new String[2][2];
        mat[0][0] = ""+Integer.parseInt(arr.get(0)+""+arr.get(1)+""+arr.get(2)+""+arr.get(3),2);
        mat[1][0] = ""+Integer.parseInt(arr.get(4)+""+arr.get(5)+""+arr.get(6)+""+arr.get(7),2);
        mat[0][1] = ""+Integer.parseInt(arr.get(8)+""+arr.get(9)+""+arr.get(10)+""+arr.get(11),2);
        mat[1][1] = ""+Integer.parseInt(arr.get(12)+""+arr.get(13)+""+arr.get(14)+""+arr.get(15),2);
        constMat[0][0] = "9";
        constMat[0][1] = "2";
        constMat[1][0] = "2";
        constMat[1][1] = "9";
        List<Integer> finalArr = new ArrayList<>();
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<2;j++)
            {
                List<Integer> newArr = new ArrayList<>();
                for(int k=0;k<2;k++)
                {
                    String temp="";
                    int x = Integer.parseInt(constMat[i][k]);
                    int y = Integer.parseInt(mat[k][j]);
//                    System.out.println(x+" "+y);
                    if(x == 2)
                    {
                        temp = two.get(y-1);
                    }
                    else if(x == 4)
                    {
                        temp = four.get(y-1);
                    }
                    else if(x == 9)
                    {
                        temp = nine.get(y-1);
                    }
                    else if(y == 2)
                    {
                        temp = two.get(x-1);
                    }
                    else if(y == 4)
                    {
                        temp = four.get(x-1);
                    }
                    else if(y == 9)
                    {
                        temp = nine.get(x-1);
                    }
                    else
                    {
                        temp = Integer.toString(x*y);
                    }
//                    System.out.println("Temp is:"+temp);
                    switch (temp) {
                        case "A":
                            newArr.add(10);
                            break;
                        case "B":
                            newArr.add(11);
                            break;
                        case "C":
                            newArr.add(12);
                            break;
                        case "D":
                            newArr.add(13);
                            break;
                        case "E":
                            newArr.add(14);
                            break;
                        case "F":
                            newArr.add(15);
                            break;
                        default:
                            newArr.add(Integer.parseInt(temp));
                            break;
                    }
                }
//                System.out.println(newArr.toString()+" Their XOR is "+integerXor(newArr.get(0), newArr.get(1)));
                finalArr.addAll(integerXor(newArr.get(0), newArr.get(1)));
                
            }
        }
//        System.out.println(finalArr.toString());
        return finalArr;
    }
    
    public static void main(String[] args) {
//        KEY GENERATION STARTS HERE
        List<Integer> inputKey = new ArrayList<>();
        List<Integer> w0 = new ArrayList<>();
        List<Integer> w1 = new ArrayList<>();
        List<Integer> w2 = new ArrayList<>();
        List<Integer> w3 = new ArrayList<>();
        List<Integer> w4 = new ArrayList<>();
        List<Integer> w5 = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        List<Integer> key0 = new ArrayList<>();
        List<Integer> key1 = new ArrayList<>();
        List<Integer> key2 = new ArrayList<>();
        while(temp.size() < 8) temp.add(0);
        inputKey = Arrays.asList(0,1,0,0,1,0,1,0,1,1,1,1,0,1,0,1);
        w0 = inputKey.subList(0, 8);
        w1 = inputKey.subList(8, inputKey.size());
        Collections.copy(temp, w1);
        Collections.rotate(temp, 4);
        w2 = xor(xor(w0,Arrays.asList(1,0,0,0,0,0,0,0)),subnib(temp));
        w3 = xor(w2,w1);
        Collections.copy(temp, w3);
        Collections.rotate(temp, 4);
        w4 = xor(xor(w2,Arrays.asList(0,0,1,1,0,0,0,0)),subnib(temp));
        w5 = xor(w4,w3);
        key0.addAll(w0);
        key0.addAll(w1);
        key1.addAll(w2);
        key1.addAll(w3);
        key2.addAll(w4);
        key2.addAll(w5);
        System.out.println("Key Generation\n");
        System.out.println("Key 0 is:"+key0.toString()+"\n");
        System.out.println("Key 1 is:"+key1.toString()+"\n");
        System.out.println("Key 2 is:"+key2.toString()+"\n");
//        KEY GENERATION ENDS HERE

//      ENCRYPTION STARTS HERE
        System.out.println("--------------------------Encryption Code Starts-------------------------\n");
        List<Integer> plaintext = new ArrayList<>();
        List<Integer> round0Key = new ArrayList<>();
        List<Integer> round1Key = new ArrayList<>();
        List<Integer> sub0Output = new ArrayList<>();
        List<Integer> shift0Output = new ArrayList<>();
        List<Integer> mixColOutput = new ArrayList<>();
        List<Integer> cipherText = new ArrayList<>();
        plaintext = Arrays.asList(1,1,0,1,0,1,1,1,0,0,1,0,1,0,0,0);
        System.out.println("Plain text given for encryption using S-AES is:");
        System.out.println(plaintext.toString()+"\n");
        round0Key = xor(plaintext,key0);
        sub0Output = subnib(round0Key);
        shift0Output = shift(sub0Output);
        
        mixColOutput = mixcolumns(shift0Output);
        round1Key = xor(mixColOutput, key1);
        cipherText = xor(shift(subnib(round1Key)),key2);
        System.out.println("Cipher Text obtained from encryption using S-AES is");
        System.out.println(cipherText.toString());
        System.out.println("\n--------------------------Encryption Code Ends-------------------------\n");

//        ENCRYPTION ENDS HERE




//        DECRYPTION STARTS HERE
        System.out.println("\n--------------------------Decryption Code Starts-------------------------\n");
        List<Integer> dcipherText = new ArrayList<>();
        List<Integer> dround0Key;
        List<Integer> dround1Key,dround2Key;
        List<Integer> dsub0Output,dsub1Output;
        List<Integer> dshift0Output,dshift1Output;
        List<Integer> dmixColOutput;
        dcipherText = Arrays.asList(0,0,1,0,0,1,0,0,1,1,1,0,1,1,0,0);
        System.out.println("Cipher Text given for decryption using S-AES is");
        System.out.println(dcipherText.toString());
        
        dround0Key = xor(dcipherText,key2);
        dshift0Output = shift(dround0Key);
        dsub0Output = invSubNib(dshift0Output);
        dround1Key = xor(dsub0Output,key1);
        dmixColOutput = inverseMixcolumns(dround1Key);
        dshift1Output = shift(dmixColOutput);
        dsub1Output = invSubNib(dshift1Output);
        dround2Key = xor(dsub1Output,key0);
        
        
        
        System.out.println("\nPlain Text obtained after decryption using S-AES is:");
        System.out.println(dround2Key.toString());
        
        System.out.println("\n--------------------------Decryption Code Ends-------------------------\n");
    }
}
