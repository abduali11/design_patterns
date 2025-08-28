

public class Main {
    public static void main(String[] args) {


        Employee emp1 = new Employee("Abdu", 40000);
        Employee emp2 = new Employee("Jave", 60000);
        Employee emp3 = new Employee("Kalis", 50000);

        Departments dep1 = new Departments("Logistics");
        Departments dep2 = new Departments("Marketing");
        Departments dep3 = new Departments("Delivery");

        dep1.add(emp1);
        dep1.add(emp2);
        dep2.add(emp3);

        Departments company = new Departments("Company");
        company.add(dep1);
        company.add(dep2);
        company.add(dep3);


        System.out.println("Total Salary of the Company: " + company.getSalary());

        System.out.println("Organization Structure:");
        company.printStructure("");

        System.out.println("Organization Structure in XML Format:");
        company.printXML("");

    }

}