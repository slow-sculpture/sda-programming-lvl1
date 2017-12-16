package pl.sda.poznan.personComparision;



public class Person implements Comparable<Person>{
    private String name;
    private String surname;
    private int age;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        //zaimplementuj porownywanie osob po wieku
        //this - pierwszy obiektu - drugi wywolany na pierwszym w ()
        if(this.age < o.getAge()){
            return -1;
        } else if (this.age > o.getAge()){
            return 1;
        } else
        return 0;

        //podpowiedz javy jak zrobic to samo szybciej
        //ponizej analogiczny zapis bo porownujemy inty
        //        return Integer.compare(this.age, o.getAge());


        //porownanie po nazwiskach - porzadek leksykograficzny
        //return this.surname.compareTo(o.getSurname());
        //analogiczny zapis choc mniej czytelny (bez get bo w tym scopie jest widoczne)
        // return this.surname.compareTo(o.surname);

    }
}
