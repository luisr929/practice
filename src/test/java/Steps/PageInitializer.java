package Steps;

import Pages.*;

public class PageInitializer {
    public static LoginPage loginPage;
    public static HomePage homePage;
    public static EmployeeListPage employeeListPage;
    public static AddEmployeePage addEmployeePage;
    public static EmployeePage employeePage;


public static void initializePageObjects(){
    loginPage=new LoginPage();
    homePage=new HomePage();
    employeeListPage=new EmployeeListPage();
    addEmployeePage=new AddEmployeePage();
    employeePage=new EmployeePage();


}
}
