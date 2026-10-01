import java.util.Scanner;

public class ProgramaPrincipalAES {

    public static void main(String[] args) {
        new ProgramaPrincipalAES().principal();
    }

    public void principal() {

        Scanner sc = new Scanner(System.in);

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

                    

                    break;

                case 2:

                    

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