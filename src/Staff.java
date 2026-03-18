public class Staff extends Employee
{
    int vacationLeave,sickLeave;

    public Staff(int id, String name, String dateOfBirth, String email, String joiningDate, String type)
    {
        super(id, name, dateOfBirth, email, joiningDate,type);
    }
}
