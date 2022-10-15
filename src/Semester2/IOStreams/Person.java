package Semester2.IOStreams;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String familyName;
    private String fullName;

    public Person(String name, String familyName){
        this.name = name;
        this.familyName = familyName;
        this.setFullName();
    }

    private void setFullName(){
        this.fullName= this.name + this.familyName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getFamilyName() {
        return familyName;
    }
}
