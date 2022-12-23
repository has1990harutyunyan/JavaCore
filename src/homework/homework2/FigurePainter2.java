package homework.homework2;

public class FigurePainter2 {

    public static void main(String[] args) {

        /*
         * Printing this figure
                     * * * *
                       * * *
                         * *
                           *
         * */

        int num = 4;
        for (int i = 1; i <= num; i++) {

            for (int j = 1; j < i; j++) {
                System.out.print("  ");

            }
            for (int k = num; k >= i; k--) {
                System.out.print("* ");

            }


            System.out.println();
        }


        System.out.println();

        /*
         * Printing this figure
         *               *
                        *  *
                      *  *  *
                     *  *  *  *
                      *  *  *
                        *  *
                         *
         *
         * */


        for (int i = 1; i <= 4; i++) {

            for (int j = 3; j >= i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print(" *");
            }
            System.out.println();
        }


        for (int i = 1; i <= 3; i++) {
            for (int l = 1; l <= i; l++) {
                System.out.print(" ");
            }
            for (int m = 3; m >= i; m--) {
                System.out.print(" *");
            }
            System.out.println();

        }



    }


}









