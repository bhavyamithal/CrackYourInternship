package MathematicalProblems;

public class AddBinary {
    static String solution(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0) {
                carry += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                carry += b.charAt(j) - '0';
                j--;
            }
            ans.append(carry % 2);
            carry = carry / 2;
        }
        i = 0; 
        j = ans.length() - 1;
        while (i < j) {
            // swap
            char temp = ans.charAt(i);
            ans.setCharAt(i, ans.charAt(j));
            ans.setCharAt(j, temp);
            i++;
            j--;
        }
        return ans.toString();
    }
}
