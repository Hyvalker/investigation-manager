package model;

public abstract class Person {
    private String name;
    private int age;
    private String description;

    public Person(String name, int age, String description) {
        this.name = name;
        this.age = age;
        this.description = description;
    }
    public Person() {

    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getDescription(){
        return description;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setAge(int age){
        this.age= age;
    }

    public void setDescription(String description){
        this.description = description;
    }

}
