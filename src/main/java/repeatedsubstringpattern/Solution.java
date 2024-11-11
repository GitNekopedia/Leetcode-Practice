package repeatedsubstringpattern;

public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] lps = new int[n];

        lps[0] = 0;
        int j = 0;
        for (int i = 1; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = lps[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }

        if ((lps[n - 1] >0 ) && (n % (n - lps[n - 1]) == 0)){
            return true;
        }
        return false;


    }
}
