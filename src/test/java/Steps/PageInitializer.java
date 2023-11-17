package Steps;

import Pages.AddEmployeePage;
import Pages.EmployeeListPage;
import Pages.HomePage;
import Pages.LoginPage;

public class PageInitializer {
    public static LoginPage loginPage;
    public static HomePage homePage;
    public static EmployeeListPage employeeListPage;
    public static AddEmployeePage addEmployeePage;


public static void initializePageObjects(){
    loginPage=new LoginPage();
    homePage=new HomePage();
    employeeListPage=new EmployeeListPage();
    addEmployeePage=new AddEmployeePage();


}
}
