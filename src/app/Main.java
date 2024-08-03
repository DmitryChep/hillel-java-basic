package app;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("John", 30, "Engineer");
        Person person2 = new Person("Mary", 25, "Teacher");
        Person person3 = new Person("Bob", 35, "Doctor");
        Person person4 = new Person("Alice", 28, "Architect");
        PrintResults printResults = new PrintResults();
        printResults.printDetails(1);
        printResults.printResult(person1);
        printResults.printResult(person2);
        printResults.printResult(person3);
        printResults.printDetails(2);
        printResults.printResult(person4);
        person4.setProfessionPerson("Designer");
        printResults.printDetails(3);
        printResults.printResult(person4);

    }
}

class Person {
    private String namePerson;
    private int agePerson;
    private String professionPerson;

    public Person(){
    }

    public Person(String namePerson, int agePerson, String profession){
        this.namePerson = namePerson;
        this.agePerson = agePerson;
        this.professionPerson = profession;
    }
    public String getNamePerson() {
        return namePerson;
    }
    public int getAgePerson() {
        return agePerson;
    }
    public String getProfessionPerson() {
        return professionPerson;
    }
    public void setProfessionPerson (String professionPerson){
        this.professionPerson = professionPerson;
    }
}

class PrintResults {
    public void printResult(Person person) {
        System.out.println("\tName: " + person.getNamePerson() + ", age: " + person.getAgePerson()
                + ", Profession: " + person.getProfessionPerson());
    }
    public void printDetails(int step) {
        switch (step) {
            case 1: System.out.print("1. ");
            break;
            case 2: System.out.print("2. ");
            break;
            case 3: System.out.print("\t(After update profession)\n");
            break;
        }
    }
}
