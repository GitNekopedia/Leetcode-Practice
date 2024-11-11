package strstr;

class Solution {
    public int strStr(String haystack, String needle) {


        int[] next = match(needle);
        int n = haystack.length();

        int l = needle.length();

        int i = 0;
        int j = 0;
        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = next[j - 1];
                }
            }

            if (j == l) {
                return i - l;
            }
        }
        return -1;
    }


    public int[] match(String str) {
        int n = str.length();
        int[] next = new int[n];
        next[0] = 0;
        int i = 1;
        int len = 0;

        while (i < n) {
            char cur = str.charAt(i);
            char lastMatchNext = str.charAt(len);
            if (cur == lastMatchNext) {
                next[i] = ++len;
                i++;
            } else {
                if (len == 0) {
                    next[i] = 0;
                    i++;
                } else {
                    len = next[len - 1];
                }
            }
        }

        return next;
    }

}

