
import java.util.*;

public class Report
{
    List<Employee> employeeList;

    Report()
    {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee e)
    {
        employeeList.add(e);
    }


    public Employee getEmployee(int id)
    {
        for (Employee e : employeeList)
        {
            if(e.getId() == id)
                return e;
        }
        return null;
    }

}
