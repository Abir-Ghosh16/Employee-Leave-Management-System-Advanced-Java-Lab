import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class ReportGenerator<T extends Employee>
{
    T employee;

    ReportGenerator(T employee)
    {
        this.employee = employee;
        this.LeaveCalculation();
    }

    // Leave Calculation
    public void LeaveCalculation()
    {
        int vacationDays,sickDays;
        if(employee.getType().toLowerCase().contains("o") )
        {
            vacationDays = 15;
            sickDays = 10;
        }
        else
        {
            vacationDays = 10;
            sickDays = 7;
        }

        try
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate joinDate = LocalDate.parse(employee.getJoiningDate(),formatter);
            int year = 365;
            if(joinDate.getYear()%4 == 0)
                year = 366;
            LocalDate endYearDate = LocalDate.of(joinDate.getYear(),12,31);
            long totalDays = ChronoUnit.DAYS.between(joinDate, endYearDate) + 1;
//            System.out.println(totalDays);

            // Calculate Total Vacation Leave
            float vacation = (float)(totalDays*vacationDays)/year;
            int tempVacation = (int)(totalDays*vacationDays)/year;
            float decimalPart = vacation - tempVacation;
            if(decimalPart >= 0.5)
                tempVacation++;
            employee.setVacationLeave(tempVacation);

            // Calculate Total Sick Leave
            vacation = (float)(totalDays*sickDays)/year;
            tempVacation = (int)(totalDays*sickDays)/year;
            decimalPart = vacation - tempVacation;
            if(decimalPart >= 0.5)
                tempVacation++;
            employee.setSickLeave(tempVacation);
        }
        catch (Exception e)
        {
            System.out.println("Data Parsing Issues Occurred when Leave Calculation");
        }
    }

}
