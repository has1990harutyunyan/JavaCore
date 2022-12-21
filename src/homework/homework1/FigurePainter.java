package homework.homework1;

public class FigurePainter {
    public static void main(String[] args) {

        /*
        Printing a half pyramid

        #
        ##
        ###
        ####
        #####
        * */
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }


        System.out.println();
       /*
       Printing an inverted half pyramid
       #####
       ####
       ###
       ##
       #
       * */

        for (int i = 1; i <= 5; i++) {
            for (int j = 5; j >= i; j--) {
                System.out.print("#");
            }
            System.out.println();

        }
        /*
        Printing a right side half pyramid
            #
           ##
          ###
         ####
        #####
        * */
        int num = 4;
        for (int i = 1; i <= 5; i++) {

            for (int j = num; j >= i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("#");

            }
            System.out.println();
        }


        /*
        Printing a half pyramid with numbers
        1
        1 2
        1 2 3
        1 2 3 4
        1 2 3 4 5
        * */

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");

            }
            System.out.println();


        }

        System.out.println();

        /*
        Printing a full inverted pyramid
        * * * * * * *
         * * * * * *
          * * * * *
           * * * *
            * * *
             * *
              *
        * */

        for (int i = 1; i <= 7; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print(" ");

            }
            for (int k = 7; k >= i; k--) {
                System.out.print("* ");
            }


            System.out.println();

        }

    }


}
