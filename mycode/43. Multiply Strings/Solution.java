class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        StringBuilder res = new StringBuilder();

        int[] product = new int[num1.length() + num2.length() - 1];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int sum = 0;
            int carry = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int tmp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                //System.out.println(tmp);
                product[i + j] += tmp;
            }
        }

        int carry = 0;
        for (int i = product.length - 1; i >= 0; i--) {
            res.insert(0, (product[i] + carry) % 10);

            carry = (product[i] + carry) / 10;
        }
        if (carry != 0) res.insert(0, carry);

        return res.toString();
    }
}