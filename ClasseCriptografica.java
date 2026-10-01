import java.util.Scanner;

public class ClasseCriptografica {

    public static void main(String[] args) {
        new ClasseCriptografica().principal();
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

            if (opcio == 1) {

                System.out.print("Missatge: ");
                String missatge = sc.nextLine();

                System.out.println("Resultat: " + Encripta(missatge));

            } else if (opcio == 2) {

                System.out.print("Missatge encriptat: ");
                String missatge = sc.nextLine();

                System.out.println("Resultat: " + Desencripta(missatge));

            } else if (opcio == 3) {

                System.out.println("Sortint...");

            } else {

                System.out.println("Opció incorrecta.");
            }

        } while (opcio != 3);

        sc.close();
    }

    public String Encripta(String missatge) {

        String resultat = "";

        for (int i = 0; i < missatge.length(); i++) {

            char lletra = Character.toUpperCase(missatge.charAt(i));

            if (lletra == 'Á' || lletra == 'À') {
                lletra = 'A';
            } else if (lletra == 'É' || lletra == 'È') {
                lletra = 'E';
            } else if (lletra == 'Í' || lletra == 'Ì') {
                lletra = 'I';
            } else if (lletra == 'Ó' || lletra == 'Ò') {
                lletra = 'O';
            } else if (lletra == 'Ú' || lletra == 'Ù') {
                lletra = 'U';
            }

            if (lletra == ' ') {
                resultat += "/ ";
                continue;
            }

            if (lletra < 'A' || lletra > 'Z') {
                continue;
            }

            int n = lletra - 'A' + 1;

            int n1 = n - 5;

            if (n1 < 1) {
                n1 += 26;
            }

            int n2 = n + 5;

            if (n2 > 26) {
                n2 -= 26;
            }

            String binari1 = Integer.toBinaryString(n1);
            String binari2 = Integer.toBinaryString(n2);

            while (binari1.length() < 5) {
                binari1 = "0" + binari1;
            }

            while (binari2.length() < 5) {
                binari2 = "0" + binari2;
            }

            binari1 = new StringBuilder(binari1).reverse().toString();
            binari2 = new StringBuilder(binari2).reverse().toString();

            resultat += binari1 + binari2 + " ";
        }

        return resultat.trim();
    }

    public String Desencripta(String missatge) {

        String resultat = "";

        String[] blocs = missatge.trim().split("\\s+");

        for (String bloc : blocs) {

            if (bloc.equals("/")) {
                resultat += " ";
                continue;
            }

            if (bloc.length() != 10) {
                continue;
            }

            String binari1 = bloc.substring(0, 5);

            binari1 = new StringBuilder(binari1).reverse().toString();

            int n1 = Integer.parseInt(binari1, 2);

            int n = n1 + 5;

            if (n > 26) {
                n -= 26;
            }

            char lletra = (char) ('A' + n - 1);

            resultat += lletra;
        }

        return resultat;
    }
}