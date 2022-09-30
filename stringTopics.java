package Homework1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1) Given string “Algorithms”, return  “go” and “Algo” using substring 
 * 2) Given two strings, compare if these two two strings are equal by comparing each character 
 * 3) Given string “https://www.amazon.com/demo?test=abc”, return [“https”,”www”,”amazon”,”com”,”demo”,”test”,”abc”] 
 * 4) Given a list of string array, combine them into one string sentence, return the string sentence 
 */

 class stringTopics {

    private static boolean ifSameStrings(String s1, String s2) {
        int m = s1.length(), n = s2.length();

        if (m != n)
            return false;

        for (int i = 0; i < m; i++) {
            if (s1.charAt(i) != s2.charAt(i))
                return false;
        }
        return true;
    }

    private static List<String> getToekn(String url) {
        int n = url.length();
        List<String> output = new ArrayList<>();

        if (n < 1 || url == null)
            return output;

        StringTokenizer stk = new StringTokenizer(url, "://.?=");
        while (stk.hasMoreTokens()) {
            output.add(stk.nextToken());
        }

        return output;
    }

    private static String combineStrings(List<String[]> list) {
        int n = list.size();
        StringBuilder output = new StringBuilder();

        if (n < 1 || list == null)
            return "";

        for (String[] arr : list) {
            for (String s : arr) {
                output.append(s);
            }
        }

        return output.toString();
    }

    public static void main(String[] args) {
        String s = "Algorithms";
        System.out.println(s.substring(2,4));
        System.out.println(s.substring(0, 4));

        System.out.println(ifSameStrings("Algo", "DS"));

        System.out.println(getToekn("https://www.amazon.com/demo?test=abc"));

        System.out.println(combineStrings(Arrays.asList(new String[]{"Hello", " World", "! "}, new String[]{"How", " are", " you?"})));
    }
 }