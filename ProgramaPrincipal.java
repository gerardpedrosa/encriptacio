import java.util.Scanner;

public class ProgramaPrincipal {

    public static void main(String[] args) {
        new ProgramaPrincipal().principal();
    }

    public void principal() {

        Scanner sc = new Scanner(System.in);
        ClasseCriptografica criptografica = new ClasseCriptografica();

        int opcio;

        do {

            System.out.println();
            System.out.println("1. Encriptar");
            System.out.println("2. Desencriptar");
            System.out.println("3. Sortir");
            System.out.print("Opció: ");

            String entrada = sc.nextLine();

            try {
                opcio = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                opcio = 0;
            }

            switch (opcio) {

                case 1:
                    System.out.print("Missatge: ");
                    String missatge = sc.nextLine();

                    System.out.print("Clau: ");
                    String clau = sc.nextLine();

                    System.out.println("Resultat: " + criptografica.Encripta(missatge, clau));
                    break;

                case 2:
                    System.out.print("Missatge encriptat: ");
                    String missatgeEncriptat = sc.nextLine();

                    System.out.print("Clau: ");
                    String clauDesencriptar = sc.nextLine();

                    System.out.println("Resultat: " + criptografica.Desencripta(missatgeEncriptat, clauDesencriptar));
                    break;

                case 3:
                    System.out.println("Sortint...");
                    break;

                default:
                    System.out.println("Opció incorrecta.");
                    break;
            }

        } while (opcio != 3);

    }
}