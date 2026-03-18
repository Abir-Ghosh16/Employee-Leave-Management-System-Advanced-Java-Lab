import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Officer extends Employee
{

    public Officer(int id, String name, String dateOfBirth, String email, String joiningDate, String type)
    {
        super(id, name, dateOfBirth, email, joiningDate,type);
    }
}
