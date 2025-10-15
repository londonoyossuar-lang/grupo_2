

package com.sena.taller;
import java.util.Scanner;

public class Taller {
    static Scanner dato=new Scanner(System.in);

    public static void main(String[] args) {
        String sexo;
        int edad,gene=0,urg=0,contr=0;
        int citas,cont=0;
        System.out.println("ingrese numero de citas");
        citas=dato.nextInt();
        System.out.println("ingrese su edad");
        edad=dato.nextInt();
        System.out.println("ingrese su sexo");
        sexo=dato.nextLine();
         dato.nextLine();
        System.out.println("cuantas citas general fue la ´persona");
        gene=dato.nextInt();
        System.out.println("cuantas citas de urgencia fue la persona");
        urg=dato.nextInt();
        System.out.println("cuantas citas de control fue la persona");
        contr=dato.nextInt();
        while (citas==-1){
        System.out.println("ingrese numero de citas");
        citas=dato.nextInt();
        if(citas==-1){
            break;
        }
        System.out.println("ingrese su edad");
        edad=dato.nextInt();
        
        System.out.println("ingrese su sexo");
        sexo=dato.nextLine();
        dato.nextLine();
        System.out.println("cuantas citas general fue la ´persona");
        gene=dato.nextInt();
        
         System.out.println("cuantas citas de urgencia fue la persona");
        urg=dato.nextInt();
        System.out.println("cuantas citas de control fue la persona");
        contr=dato.nextInt();
        cont--;

        }
        System.out.println("total de citas general son  "+gene);
                System.out.println("total de citas de urgencia son  "+urg);
                        System.out.println("total de citas de conto¿rol son  "+contr);


    }
}
