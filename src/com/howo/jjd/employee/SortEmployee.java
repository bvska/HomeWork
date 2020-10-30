package com.howo.jjd.employee;


import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class SortEmployee {
    public static void sortAndPrint(List<Employee> employees) {
        Comparator<Employee> nameComparator = new NameComparator();
        Comparator<Employee> nameSalComparator = new NameComparator().thenComparing(new SalaryComparator());
        Comparator<Employee> nameSalAgeCoComparator = new NameComparator()
                .thenComparing(new SalaryComparator()
                        .thenComparing(new AgeComparator()
                                .thenComparing(new CompanyComparator())));
        TreeSet<Employee> employeeSort = new TreeSet<>(nameComparator);
        for (Employee employee : employees) {
            employeeSort.add(employee);
        }
        System.out.println(employeeSort);
        employeeSort = new TreeSet<>(nameSalComparator);
        for (Employee employee : employees) {
            employeeSort.add(employee);
        }
        System.out.println(employeeSort);

        employeeSort = new TreeSet<>(nameSalAgeCoComparator);
        for (Employee employee : employees) {
            employeeSort.add(employee);
        }
        System.out.println(employeeSort);
    }

}

class NameComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class SalaryComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getSalary(), o2.getSalary());
    }
}

class AgeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

class CompanyComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getCompany().compareTo(o2.getCompany());
    }
}