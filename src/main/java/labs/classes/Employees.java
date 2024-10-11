package labs.classes;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Employees implements Comparable<Employees>{
    private String passportSeriesNumber;
    private String fullName;
    private String birthDay;
    private String position;
    private int salary;

    private Employees(Builder builder){
        this.passportSeriesNumber = builder.passportSeriesNumber;
        this.fullName = builder.fullName;
        this.birthDay = builder.birthDay;
        this.position = builder.position;
        this.salary = builder.salary;
    }
    @Override
    public String toString(){
        return "Full name: " + fullName + " - Position: " + position + " - Salary: " + salary;
    }

    public static class Builder{
        private String passportSeriesNumber;
        private String fullName;
        private String birthDay;
        private String position;
        private int salary;

        public Builder setPassportSeriesNumber(String passportSeriesNumber){
            this.passportSeriesNumber = passportSeriesNumber;
            return this;
        }

        public Builder setFullName(String fullName){
            this.fullName = fullName;
            return this;
        }

        public Builder setBirthDay(String birthDay){
            this.birthDay = birthDay;
            return this;
        }

        public Builder setPosition(String position){
            this.position = position;
            return this;
        }

        public Builder setSalary(int salary){
            this.salary = salary;
            return this;
        }

        public Employees build(){
            return new Employees(this);
        }
    }

    @Override
    public int compareTo(Employees other) {
        return Integer.compare(this.salary, other.salary);
    }

    public static void main(String[] args) {
        List<Employees> employees = new ArrayList<>();
        Employees employe_1 = new Builder()
                .setPassportSeriesNumber("AD2132")
                .setFullName("Nina Dobro")
                .setBirthDay("2001-12-11")
                .setPosition("Оfficial")
                .setSalary(18000)
                .build();

        Employees employe_2 = new Builder()
                .setPassportSeriesNumber("AD5632")
                .setFullName("Miko Lomiko")
                .setBirthDay("2002-03-19")
                .setPosition("Оfficial")
                .setSalary(17090)
                .build();

        Employees employe_3 = new Builder()
                .setPassportSeriesNumber("UJ5032")
                .setFullName("Vasyl Vasylov")
                .setBirthDay("1999-12-28")
                .setPosition("Meneger")
                .setSalary(21090)
                .build();

        employees.add(employe_1);
        employees.add(employe_2);
        employees.add(employe_3);

        Collections.sort(employees);



        System.out.println(employees);
    }
}
