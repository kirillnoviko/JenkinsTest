package domain;



import javax.persistence.*;
import java.util.Objects;
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;


    public User( String name, String surname) {
        this.name = name;
        this.surname = surname;

    }

    public User() {
    }

    public Long getId(){return id;}

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

 /*   public String getCity() {
        return city;
    }

    public Long getNumberPassport() {
        return numberPassport;
    }*/

    public void setId(Long id){this.id=id;}

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

/*
    public void setCity(String city) {
        this.city = city;
    }

    public void setNumberPassport(Long numberPassport) {
        this.numberPassport = numberPassport;
    }
*/


    @Override
    public String toString() {
        return "domain.User{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
         /*       ", city='" + city + '\'' +
                ", numberPassport=" + numberPassport +*/
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return /*numberPassport == user.numberPassport &&*/ name.equals(user.name) && surname.equals(user.surname) /*&& city.equals(user.city)*/;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,name, surname /*city, numberPassport*/);
    }
}
