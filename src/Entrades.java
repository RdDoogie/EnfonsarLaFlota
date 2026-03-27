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
            System.out.print(missatge);

            if (scanner.hasNextInt()) {
                coordenada = scanner.nextInt();
                valid = true;
            } else {
                System.out.println("Error: Perfavor, introdueix un numero valid.");

                scanner.next();
            }
        }
        return coordenada;
    }

    public Orientacio obtenirOrientacio() {
        Orientacio orientacioTriada = null;

        while (orientacioTriada == null) {
            System.out.print("Vols el vaixell en Horitzontal (H) o en Vertical (V)? ");

            String entrada = scanner.next().toUpperCase();

            if (entrada.equals("H")) {
                orientacioTriada = Orientacio.HORITZONTAL;
            } else if (entrada.equals("V")) {
                orientacioTriada = Orientacio.VERTICAL;
            } else {
                System.out.println("Error: Perfavor, introdueix H o V.");
            }
        }
        return orientacioTriada;
    }

}
