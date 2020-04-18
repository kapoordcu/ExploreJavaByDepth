package explore.topics.jdk8;

public class EmployeeDAO {
    public String name;
    public String surname;
    public Address address;

    public EmployeeDAO(String name, String surname, Address address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    @Override
    public String toString() {
        return "EmployeeDAO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address=" + address +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Address getAddress() {
        return address;
    }
}
