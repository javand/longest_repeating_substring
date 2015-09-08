package com.company;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("============ Welcome To Longest Repeating Substring ============");
        System.out.print("Ok give me a string to evaluate: ");
        Scanner user_input = new Scanner(System.in);
        String random_string = user_input.next();
        ArrayList<String> lrs = GetLongestRepeatedSubstring(random_string);
        System.out.println("Longest Repeated Substring is: " + lrs);
    }

    private static ArrayList<String> GetLongestRepeatedSubstring (String input_string) {
        if (input_string == null || input_string.isEmpty()) { //check for null data
            return null;
        } else {
            int len = input_string.length();

            //create array
            String[] string_array = new String[len];

            for (int i = 0; i < len; i++) {
                string_array[i] = input_string.substring(i);
            }

            //sort array - really the key/cheat here
            Arrays.sort(string_array);

            String result = ""; //init result here to track string length
            ArrayList<String> result_list = new ArrayList<String>(); //Just in case there are > 1 matches

            for (int i = 0; i < len - 1; i++) {
                String lcs = GetLongestCommonString(string_array[i], string_array[i + 1]);  //find the longest matching substring in this array
                if (lcs.length() >= result.length()) {
                    result = lcs;
                    if (!result_list.contains(lcs)) {
                        result_list.add(lcs);
                    }
                }
            }

            //clean up result list
            Iterator<String> results = result_list.iterator();
            while (results.hasNext()) {
                String s = results.next();
                if (s.length() < result.length())
                    results.remove();
            }
            return result_list;
        }
    }


    private static String GetLongestCommonString (String a, String b)
    {
        String output = ""; //initialize output string
        int max_compare = Math.min(a.length(), b.length()); //get the min length so we know the max comparisons to run

        for (int i=0; i < max_compare; i++) {
            if(a.charAt(i) == b.charAt(i)) {
                output = output + a.charAt(i); //so for each matching char we're going to add them up here
            }
            else {
                break;
            }
        }
        return output;
    }
}
