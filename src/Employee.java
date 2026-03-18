import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public abstract class Employee
{
    int id;
    String name,dateOfBirth,email,joiningDate,type;
    int vacationLeave,sickLeave;

    public Employee(int id, String name, String dateOfBirth, String email, String joiningDate,String type)
    {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.joiningDate = joiningDate;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public String getEmail() {
        return email;
    }

    public void setSickLeave(int sickLeave) {
        this.sickLeave = sickLeave;
    }

    public void setVacationLeave(int vacationLeave) {
        this.vacationLeave = vacationLeave;
    }

    public int getVacationLeave() {
        return vacationLeave;
    }

    public int getSickLeave() {
        return sickLeave;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void Details()
    {
        System.out.println("\n\nEmployee Details---------\n");
        System.out.println("ID: " + this.getId());
        System.out.println("Employee Type: " + this.getType());
        System.out.println("Name: " + this.getName());
        System.out.println("Date of Birth: " + this.getDateOfBirth());
        System.out.println("Email: " + this.getEmail());
        System.out.println("Joining Date: " + this.getJoiningDate());
        System.out.println("Vacation Leave Remaining: " + this.getVacationLeave());
        System.out.println("Sick Leave Remaining:" + this.getSickLeave());
    }
}
