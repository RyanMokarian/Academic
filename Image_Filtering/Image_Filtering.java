/*
COMP 5201 ASSIGNMENT 3
Ryan Mokarian, 40080413
NOV. 10, 2018
 */

public class COMP5201_Assignment3 {

    public static void main(String[] args) {

        {
            // all submissions _must_ contain this prelude or equivalent

            int[] bg = {4, 2, 4, 2, 4, 5, 2, 7, 3, 7, 3, 7, 3, 2}; // background image
            int[] a = {0, 1, 2, 3, 3, 2, 1, 0}; // pixels
            int[] b = new int[8]; // filtered pixels

            int sr0 = loadRegister(0,bg);
            int sr1 = loadRegister(1,bg);
            int sr2 = loadRegister(2,bg);
            int sr3 = loadRegister(3,bg);
            int sr4 = loadRegister(4,bg);

            int r = 5;
            int min_sad = 100; // absurdly high value

            for (int i = 0; i < a.length; i++) {
                b[i] = convolve(a, sr0, sr1, sr2, sr3, sr4, i);
                min_sad = b[i]<=min_sad?b[i]:min_sad;
                sr0 =sr1;
                sr1 =sr2;
                sr2 =sr3;
                sr3 =sr4;
                sr4 = loadRegister(r++,bg);
            }

            System.out.print(" ");
            System.out.print("The eight original pixels are:  \n\n");

            for (int i = 0; i < 8; i++) {
                System.out.print(" ");
                System.out.print(a[i]);
            }
            System.out.println("\n\n");
            System.out.print("The eight filtered pixels are:  \n\n");

            for (int i = 0; i < 8; i++) {
                System.out.print(" ");
            System.out.print(b[i]);
            }
            System.out.println("\n\n");

            System.out.println("\"The minimum SAD value is: \n");
        System.out.println(" "+ min_sad + "\n\n");

            System.out.println("The final SRAM register values are: \n\n"+
            sr0 + ", "+ sr1+ ", "+ sr2+ ", "+ sr3+ ", "+ sr4);
        }
    }

    private static int convolve(int[] a, int sr0, int sr1, int sr2, int sr3, int sr4, int i) {
        return Math.abs(a[i] - sr0) +
                Math.abs(a[i] - sr1) +
                Math.abs(a[i] - sr2) +
                Math.abs(a[i] - sr3) +
                Math.abs(a[i] - sr4);
    }

    public static int loadRegister(int index, int[] bg) {
        return bg[index];
    }

}
