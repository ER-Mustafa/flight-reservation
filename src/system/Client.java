package system;

public class Client {
    private String name;
    private int age;
    private String surname;
    private String nationality;
    private String gender;
    private String nationalId;

    public Client(String name, int age, String surname,
                  String nationality, String gender, String nationalId) {
        this.name = name;
        this.age = age;
        this.surname = surname;
        this.nationality = nationality;
        this.gender = gender;
        this.nationalId = nationalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }
}
