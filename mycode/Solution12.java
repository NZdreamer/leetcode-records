class Solution12 {

    public static StringBuilder sb = new StringBuilder();

    public static String insDelChar(String[][] str) {
        // INSERT,a

        for (String[] s : str) {
            if (s[0].equals("INSERT"))  {
                sb.append(s[1]);
            }
//            else {
//                sb.delete()
//            }
        }

        for (int i = 0; i < str.length; i++) {
            if ()
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String[][] str = new String[][]{
                {"INSERT", "a"},
                {"INSERT", "b"},
                {"INSERT", "c"}        };
        System.out.println(insDelChar(str));
    }
}