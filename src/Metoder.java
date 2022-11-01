import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Metoder {



    public boolean LessThanOneYearAgo(LocalDate dateAnnualFee) {
        LocalDate todayDate = LocalDate.now();
        LocalDate oneYearAgo = todayDate.minusYears(1);
        return dateAnnualFee.isAfter(oneYearAgo);
    }

    public static List<Customers> readFromPath(String inPath) {
        List<Customers> list = new ArrayList<>();
        String firstrow = "";
        String secondrow = "";
        File file = new File(inPath);

        try (Scanner sc = new Scanner(file)) {

            while (sc.hasNextLine()) {
                firstrow = sc.nextLine();
                if (sc.hasNextLine()) {
                    secondrow = sc.nextLine();
                }
                String[] firstArr = firstrow.split(",");
                Customers c = new Customers(firstArr[0].trim(), firstArr[1].trim(), secondrow);
                list.add(c);
            }
        } catch (IOException e){
            System.out.println("Filen kunde inte hittas!");
        }

        return list;
    }
    public void AddNewCustomers(String file_path, boolean append_value){
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Ange kundens namn: ");
            String n = scan.nextLine();
            //String namn = System.console().readLine();

            System.out.println("Ange kundens personnummer: ");
            String pnr = scan.nextLine();

            System.out.println("Ange dagens datum: ");
            String date = scan.nextLine();

            writeToFile(file_path, ("Namn: " + n + "\nPersonnummer: " + pnr + "\nDagens datum: " + date));

            System.exit(0);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    public void writeToFile(String path, String text) {
        try (PrintWriter print = new PrintWriter(new FileWriter(path, true))) {
       /* boolean append = true;
        FileWriter write = new FileWriter(path, append);
        PrintWriter print = new PrintWriter(write);*/

            print.printf("%s" + "%n", text);
            print.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }



    }










