import java.util.Scanner;

public class Entrades {
    private Scanner scanner;

    public Entrades(){
        this.scanner = new Scanner(System.in);
    }

    public int obtenirCoordenada(String missatge) {
        int coordenada = -1;
        boolean valid = false;

        while (!valid) {
            Sortides.imprimirMissatge(missatge);

            if (scanner.hasNextInt()) {
                coordenada = scanner.nextInt();
                valid = true;
            } else {
                Sortides.mostrarErrorNumero();
                scanner.next();
            }
        }
        return coordenada;
    }

    public Orientacio obtenirOrientacio() {
        Orientacio orientacioTriada = null;

        while (orientacioTriada == null) {
            Sortides.imprimirMissatge("Vols el vaixell en Horitzontal (H) o en Vertical (V)? ");

            String entrada = scanner.next().toUpperCase();

            if (entrada.equals("H")) {
                orientacioTriada = Orientacio.HORITZONTAL;
            } else if (entrada.equals("V")) {
                orientacioTriada = Orientacio.VERTICAL;
            } else {
                Sortides.mostrarErrorOrientacio();
            }
        }
        return orientacioTriada;
    }
}