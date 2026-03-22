class Backtracking {
    public static void main(String args[]) {
        Permutation("ABCD", "", 0);

    }

    public static void Permutation(String str, String perm, int idx) {
        if (str.length() == 0) {
            System.out.println(perm);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            System.out.println("current: " + currChar);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            System.out.println("newStr: " + newStr);
            Permutation(newStr, perm + currChar, idx + 1);
        }
    }
}