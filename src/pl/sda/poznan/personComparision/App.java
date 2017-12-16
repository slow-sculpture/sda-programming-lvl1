package pl.sda.poznan.personComparision;

public class App {
    public static void main(String[] args) {
        Person onePerson = new Person();
        Person twoPerson = new Person();

        onePerson.setAge(27);
        twoPerson.setAge(25);
        int comaprisioneResult = onePerson.compareTo(twoPerson);
        System.out.println(comaprisioneResult);

    }
}
