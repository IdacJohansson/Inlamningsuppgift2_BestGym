import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Customers {

    protected String idNumb;
    protected String name;
    protected LocalDate dateAnnualFee;


    public Customers(String idNumb, String name, String dateAnnualFee) {

        this.idNumb = idNumb;
        this.name = name;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.dateAnnualFee = LocalDate.parse(dateAnnualFee, formatter);


    }

    public String getName() {
        return name;
    }

    public String getIdNumb() {
        return idNumb;
    }

    public LocalDate getDateAnnualFee() {
        return dateAnnualFee;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setIdNumb(String idNumb) {
        this.idNumb = idNumb;
    }

    public void setDateAnnualFee(LocalDate dateAnnualFee) {
        this.dateAnnualFee = dateAnnualFee;
    }

}










