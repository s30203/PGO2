import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //dane od użytkownika
        System.out.println("Podaj  wiek: ");
        int wiek = scanner.nextInt();

        System.out.println("Czy jest mieszkańcem Warszawy (t/n)? ");
        boolean mieszkaniecWarszawy = scanner.next().equalsIgnoreCase("t");

        System.out.println(" Dzisiaj jest czwartek? (t/n)? ");
        boolean czwartek = scanner.next().equalsIgnoreCase("t");

        double cena = obliczCeneBiletu(wiek, mieszkaniecWarszawy, czwartek);

        // Wyświetl wynik
//                System.out.println("Wiek klienta: " + wiek);
        System.out.printf("Cena biletu: %.2f zł", cena);

        if (czwartek) {
            System.out.println("Wstęp wolny w czwartki!");
        } else if (wiek < 10) {
            System.out.println("Wstęp wolny dla dzieci poniżej 10 roku życia");
        } else if (mieszkaniecWarszawy) {
            System.out.println(" 10% zniżki dla mieszkańców Warszawy");
        } else if (wiek < 18) {
            System.out.println(" 50% zniżki dla osób w wieku 10-18 lat");
        }
    }

    private static double obliczCeneBiletu(int wiek, boolean mieszkaniecWarszawy, boolean czwartek) {
        double cenaBazowa = 40.0;

        // Wstęp wolny w czwartki
        if (czwartek) {
            return 0.0;
        }

        // Wstęp wolny dla dzieci poniżej 10 lat
        if (wiek < 10) {
            return 0.0;
        }

        // Zniżka 50% dla osób w wieku 10-18 lat
        if (wiek < 18) {
            cenaBazowa *= 0.5;
        }

        // Zniżka 10% dla mieszkańców Warszawy
        if (mieszkaniecWarszawy) {
            cenaBazowa *= 0.9;
        }

        return cenaBazowa;
    }
}

