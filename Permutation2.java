public class Permutation2 {
    public static void main(String[] args) {
        String input = "ABCD";
        int length = 4;

        genPerm(input, "", length);

    }

    public static void genPerm(String str, String result, int length) {
        if (result.length() == length) {
            System.out.println(result);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            genPerm(str, result + str.charAt(i), length);
        }
    }
}
