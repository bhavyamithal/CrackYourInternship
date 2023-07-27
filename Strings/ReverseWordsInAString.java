package Strings;

import java.util.ArrayList;

public class ReverseWordsInAString {

    static String better(String s) {
        int i = s.length() - 1;
        StringBuilder ans = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            int j = i;
            if (i < 0) {
                break;
            }
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            if (ans.isEmpty()) {
                ans.append(s.substring(i + 1, j + 1));
            } else {
                ans.append(" " + s.substring(i + 1, j + 1));
            }
        }
        return ans.toString();
    }

    static String solution(String s) {
        char[] letters = s.toCharArray();
        ArrayList<String> ans = new ArrayList<>();
        String curr = "";
        for (char ch : letters) {
            if (ch == ' ') {
                if (!curr.equals("")) {
                    ans.add(curr);
                }
            } else {
                curr = curr + ch;
            }
        }
        int left = 0, right = ans.size() - 1;
        while (left < right) {
            // swap
            String temp = ans.get(left);
            ans.set(left, ans.get(right));
            ans.set(right, temp);
            left++;
            right--;
        }
        return String.join(" ", ans);
    }
}
