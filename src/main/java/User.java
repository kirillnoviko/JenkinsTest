import java.util.Objects;

public class User {
    String name;
    String surname;
    String city;
    int numberPassport;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCity() {
        return city;
    }

    public int getNumberPassport() {
        return numberPassport;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setNumberPassport(int numberPassport) {
        this.numberPassport = numberPassport;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", city='" + city + '\'' +
                ", numberPassport=" + numberPassport +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return numberPassport == user.numberPassport && name.equals(user.name) && surname.equals(user.surname) && city.equals(user.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, city, numberPassport);
    }
}
