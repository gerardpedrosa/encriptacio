public class ClasseCriptografica {

    public String Encripta(String missatge, String clau) {

        int desplazament = Integer.parseInt(clau);
        String resultat = "";

        for (int i = 0; i < missatge.length(); i++) {

            char lletra = Character.toUpperCase(missatge.charAt(i));

            // "\u00C1" és equivalent a una lletra amb accent

            if (lletra == '\u00C1' || lletra == '\u00C0') {
                lletra = 'A';
            }

            if (lletra == '\u00C9' || lletra == '\u00C8') {
                lletra = 'E';
            }

            if (lletra == '\u00CD' || lletra == '\u00CC') {
                lletra = 'I';
            }

            if (lletra == '\u00D3' || lletra == '\u00D2') {
                lletra = 'O';
            }

            if (lletra == '\u00DA' || lletra == '\u00D9') {
                lletra = 'U';
            }

            if (lletra == '\uFFFD') {
                lletra = 'O';
            }

            if (lletra == ' ') {
                resultat += "/ ";
                continue;
            }

            if (lletra < 'A' || lletra > 'Z') {
                continue;
            }

            int n = lletra - 'A' + 1;

            int n1 = (n - desplazament - 1 + 26) % 26 + 1;
            int n2 = (n + desplazament - 1) % 26 + 1;

            String binari1 = Integer.toBinaryString(n1);
            String binari2 = Integer.toBinaryString(n2);

            for (int j = binari1.length(); j < 5; j++) {
                binari1 = "0" + binari1;
            }

            for (int j = binari2.length(); j < 5; j++) {
                binari2 = "0" + binari2;
            }

            binari1 = new StringBuilder(binari1).reverse().toString();
            binari2 = new StringBuilder(binari2).reverse().toString();

            resultat += binari1 + binari2 + " ";
        }

        return resultat;
    }

    public String Desencripta(String missatgeXifrat, String clau) {

        int desplazament = Integer.parseInt(clau);
        String resultat = "";

        String[] blocs = missatgeXifrat.split(" ");

        for (int i = 0; i < blocs.length; i++) {

            String bloc = blocs[i];

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

            int n = (n1 + desplazament - 1) % 26 + 1;

            char lletra = (char) ('A' + n - 1);

            resultat += lletra;
        }

        return resultat;
    }
}