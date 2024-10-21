public class Permutation1 {
    public static void main(String[] args) {
        String input = "ABCD";
        int length = 4;

        for (int a = 0; a< input.length(); a++) {
            for (int b = 0; b< input.length(); b++) {
                for (int c = 0; c< input.length(); c++) {
                    for (int d = 0; d< input.length(); d++) {
                        System.out.println(""+input.charAt(a)+input.charAt(b)+input.charAt(c)+input.charAt(d));

                    }
                }
            }
        }

    }
}
