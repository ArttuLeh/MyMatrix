/****************************
 * Arttu Lehtovaara         *
 * Opiskelija nro 1701848   *
 * **************************/

package fi.lamk.mymatrix;

import java.util.Scanner;

/**
 *
 * @author Arttu Lehtovaara
 */
public class MyMatrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Menu();
    }
    public static void Menu()
    {
        boolean ok = true;
        Scanner in = new Scanner(System.in);
        System.out.print("-----------Menu!----------\n");
        
        while (ok)
        {
            System.out.print("Print matrix, press(p),\n"
                              + "Print sum, press(s),\n"
                              + "Print coefficient, press(c)\n"
                              + "exit, press(e): ");

            String valinta = in.nextLine();
            //String ok = "";
            Matrix m = new Matrix();
            Matrix m2 = new Matrix();
            switch (valinta)
            {
                case "s":
                    System.out.println();
                    m.set(0, 2, 1);
                    m.set(1, 1, 2);
                    m.set(3, 0, -1);
                    m.set(3, 2, 5);
                    m.set(4, 1, 3);
                    m2.set(0, 2, 1);
                    m2.set(1, 1, 2);
                    m2.set(3, 0, -1);
                    m2.set(3, 2, 5);
                    m2.set(4, 1, 3);
                    System.out.println("\n"+m.sum(m2)+"\n");
                    break;
                case "p":
                    System.out.println();
                    m.set(0, 2, 1);
                    m.set(1, 1, 2);
                    m.set(3, 0, -1);
                    m.set(3, 2, 5);
                    m.set(4, 1, 3);
                    m.print();
                    System.out.println();
                    break;
                case "c":
                    System.out.println();
                    m.set(0, 2, 1);
                    m.set(1, 1, 2);
                    m.set(3, 0, -1);
                    m.set(3, 2, 5);
                    m.set(4, 1, 3);
                    m.product(3);
                    m.print();
                    System.out.println();
                    break;
                case "e":
                    ok = false;
                    break;
            }
        }
    }
}
