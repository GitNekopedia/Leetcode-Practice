package monotone_increasing_digits;

class Solution {
    public int monotoneIncreasingDigits(int n) {
        /*
        * 思路：将数字转换为字符数组，从右向左遍历，如果当前数字小于前一个数字，则将前一个数字减1，并将当前数字置为9，然后继续向左遍历。
        * */
        char[] charArray = String.valueOf(n).toCharArray();
        int mark = charArray.length;
        for (int i = charArray.length - 1; i > 0; i--) {
            if (charArray[i] < charArray[i - 1]){
                mark = i;
                charArray[i - 1]--;
            }
        }
        for (int i = mark; i < charArray.length; i++) {
            charArray[i] = '9';
        }

        return Integer.parseInt(String.valueOf(charArray));
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.monotoneIncreasingDigits(100);
        System.out.println(i);
    }
}