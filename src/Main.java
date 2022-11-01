import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Run();
    }

    public static void Run()  {
        String filePath = "src/CustomersFile.txt";
        String CreatFile = "NewCustomersFile.txt";


        List<Customers> c = new ArrayList<>();
        Metoder m = new Metoder();
        c = m.readFromPath(filePath);

        Scanner scan = new Scanner(System.in);
        System.out.println("Sök efter en kund, skriv namn eller personnr");
        String input = scan.nextLine();

        boolean b = false;
        for (Customers var : c) {

            if (var.idNumb.equals(input) || var.name.equals(input)) {
                if (m.LessThanOneYearAgo(var.getDateAnnualFee())) {
                    System.out.println(var.getName() + " Finns registrerad och HAR betalat årsavgiften!!!");
                    m.writeToFile(CreatFile, "Namn: " + var.getName() + "\n" + "Personnummer: " + var.getIdNumb() +
                            "\n" + "Dagens datum: " + LocalDate.now());
                    b = true;

                } else {
                    System.out.println(var.getName() + " Finns registrerad men har INTE betalat årsavgiften!!!");
                    b = true;
                }

            }
        }
        if (b != true)
            System.out.println("Finns inte registrerad!");

    }

}

