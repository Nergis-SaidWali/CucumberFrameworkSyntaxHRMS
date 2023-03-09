package steps;

import pages.*;

public class PageInitializer {
    public static LoginPage login;
    public static DashboardPage dashboard;
    public static AddEmployeePage addEmployee;
    public static EmployeeListPage employeeList;

    public static AdminPage adminPage;

    public static MembershipsPage membershipsPage;

    public static void initializePageObjects(){
        login=new LoginPage();
        dashboard=new DashboardPage();
        addEmployee=new AddEmployeePage();
        employeeList=new EmployeeListPage();
        adminPage=new AdminPage();
        membershipsPage=new MembershipsPage();
    }
}
