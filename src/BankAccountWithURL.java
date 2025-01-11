import java.io.*;
import java.net.*;
import java.util.*;

public class BankAccountWithURL {
    public static void main(String[] args) throws IOException {

        URL url = new URL("https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt");

        try (BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Wprowadz 3 pierwsze cyfry numeru konta::");
            String accountNumber = userInput.readLine().trim();

            try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
                String line;

                boolean bankFound = false;
                while ((line = br.readLine()) != null) {

                    String[] words = line.split("\\t+");
                    if (words.length >= 2) {
                        String bankNumber = words[0].trim();
                        String bankName = words[1].trim();

                        if (bankNumber.equals(accountNumber)) {
                            System.out.println("Numer banku: " + bankNumber + " | Nazwa Banku: " + bankName);
                            bankFound = true;
                            break;
                        }
                    }
                }

                if (!bankFound) {
                    System.out.println("Podany kod nie ma dopasowania do żadnego banku.");
                }
            } catch (IOException e) {
                System.out.println("Blad zgrywania danych z pliku: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Blad przy odczycie danych uzytkownika: " + e.getMessage());
        }
    }
}
