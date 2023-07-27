package Strings;

import java.util.Arrays;

public class LongestCommanPrefix {

    // This code is used to find the longest common prefix of an array of strings,
    // which is defined as the longest string that is a prefix of all the strings in
    // the array. By sorting the array and then comparing the first and last
    // elements, the code is able to find the common prefix that would be shared by
    // all strings in the array.

    // Sort the elements of an array of strings called "strs" in lexicographic
    // (alphabetical) order using the Arrays.sort(strs) method.
    // Assign the first element of the sorted array (the lexicographically smallest
    // string) to a string variable s1.
    // Assign the last element of the sorted array (the lexicographically largest
    // string) to a string variable s2.
    // Initialize an integer variable idx to 0.
    // Start a while loop that continues while idx is less than the length of s1 and
    // s2.
    // Within the while loop, check if the character at the current index in s1 is
    // equal to the character at the same index in s2. If the characters are equal,
    // increment the value of idx by 1.
    // If the characters are not equal, exit the while loop.
    // Return the substring of s1 that starts from the first character and ends at
    // the idxth character (exclusive).

    static String optimal(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        int i = 0;
        while (i < s1.length() && i < s2.length()) {
            if (s1.charAt(i) == s2.charAt(i)) {
                i++;
            } else {
                break;
            }
        }
        return s1.substring(0, i);

    }

    // below solution is bruteforce, O(N square)
    static String bruteforce(String[] strs) {
        String maxComman = strs[0];
        for (int i = 0; i < strs.length; i++) {
            maxComman = getComman(strs[i], maxComman);
            if (maxComman == "") {
                return "";
            }
        }
        return maxComman;
    }

    static String getComman(String s1, String s2) {
        char[] word1 = s1.toCharArray();
        char[] word2 = s2.toCharArray();
        String ans = "";
        int i = 0, j = 0;
        while (i < word1.length && j < word2.length && word1[i] == word2[j]) {
            ans = ans.concat(Character.toString(word1[i]));
            i++;
            j++;
        }
        return ans;
    }
}
