package explore.topics.jdk8;

public class Address {
    public String street;
    public String city;
    public Integer postcode;

    public Address(String street, String city, Integer postcode) {
        this.street = street;
        this.city = city;
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", postcode=" + postcode +
                '}';
    }
}
