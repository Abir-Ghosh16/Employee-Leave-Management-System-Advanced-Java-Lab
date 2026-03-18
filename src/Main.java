import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("\n\nAdd 5 User info");
        Scanner sc = new Scanner(System.in);
        Report allEmployeeReport = new Report();
        for(int i=1; i<=5; i++)
        {
            System.out.println("\n--- Enter Employee " + i + " data ---");

            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("DOB (YYYY-MM-DD): ");
            String dob = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Joining Date (YYYY-MM-DD): ");
            String joining = sc.nextLine();

            System.out.print("Enter Type (Officer/Staff/etc): ");
            String type = sc.nextLine();

            // Create Employee object & add to list
            allEmployeeReport.addEmployee(new Officer(id, name, dob, email, joining, type));
        }
        boolean tempFlag = false;
        Employee e = null;
        while(true)
        {
            System.out.print("Do you want Leave Application??If(YES) Type (Y/N): ");
            String input = sc.nextLine();
            if(input.toLowerCase().contains("y"))
            {
                while(true)
                {
                    if(!tempFlag) {
                        System.out.print("Please Give me Your Employee Id: ");
                        int id = sc.nextInt();
                        Employee temp = allEmployeeReport.getEmployee(id);
                        if (temp == null) {
                            System.out.println("No Employee Found Please Try Again With Valid Employee Id");
                        }
                        else {
                            tempFlag = true;
                            e = temp;
                            ReportGenerator<Employee> report = new ReportGenerator<>(e);
                            System.out.println("Employee Verified");
                        }
                    }
                    if(tempFlag)
                    {
                        boolean flag = true;
                        while(true)
                        {
                            if(flag)
                                System.out.print("Leave Information(vacation or sick): ");
                            String vacationType = sc.nextLine();
                            flag = false;
                            if(vacationType.isEmpty()) continue;

                            if(!vacationType.toLowerCase().contains("v") && !vacationType.toLowerCase().contains("s"))
                            {
                                flag = true;
                                System.out.println("Invalid Selection Try Again with Valid Leave information");
                            }
                            else
                            {
                                e.Details();
                                while(true)
                                {
                                    System.out.print("Please Provide Leave Date From(Format Year-Month-Date): ");
                                    String startDate = sc.nextLine();
                                    System.out.print("Please Provide Leave Date To(Format Year-Month-Date): ");
                                    String endDate = sc.nextLine();
                                    try
                                    {
                                        long vacationDays = ChronoUnit.DAYS.between(LocalDate.parse(startDate),LocalDate.parse(endDate)) + 1;
                                        //System.out.println(vacationDays);
                                        if(vacationDays <= 0)
                                        {
                                            System.out.println("Invalid Leave Date Format Please Try Again");
                                        }
                                        else
                                        {
                                            if(vacationType.toLowerCase().contains("v"))
                                            {
                                                int remain = e.getVacationLeave() - (int)vacationDays;
                                                if(remain >= 0)
                                                {
                                                    System.out.println("Vacation Leave Accepted");
                                                    e.setVacationLeave(remain);
                                                    break;
                                                }
                                                else
                                                {
                                                    System.out.println("Vacation Leave Rejected");
                                                    break;
                                                }
                                            }
                                            else
                                            {
                                                int remain = e.getSickLeave() - (int)vacationDays;
                                                if(remain >= 0)
                                                {
                                                    System.out.println("Sick Leave Accepted");
                                                    e.setSickLeave(remain);
                                                    break;
                                                }
                                                else
                                                {
                                                    System.out.println("Sick Leave Rejected");
                                                    break;
                                                }
                                            }
                                        }

                                    }
                                    catch (Exception ex) {
                                        throw new RuntimeException(ex);
                                    }
                                }
                                break;
                            }
                        }
                        break;
                    }
                }

            }
            else
            {
                System.out.println("Thank You For Your Valuable Time");
                break;
            }
        }
    }
}