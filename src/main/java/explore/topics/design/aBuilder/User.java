package explore.topics.design.aBuilder;

public class User {
    //All final attributes
    private final String firstName; // required
    private final String lastName; // required
    private final int age; // optional
    private final String phone; // optional
    private final String address; // optional

    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    //All getter, and NO setter to provide immutability
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User: "+this.firstName+", "+this.lastName+", "+this.age+", "+this.phone+", "+this.address;
    }

    public static class UserBuilder {
        private final String firstName;
        private final String lastName;
        private int age;
        private String phone;
        private String address;

        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
        public UserBuilder setAge(int age) {
            this.age = age;
            return this;
        }
        public UserBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }
        public UserBuilder setAddress(String address) {
            this.address = address;
            return this;
        }
        //Return the finally constructed User object
        public User build() {
            return new User(this);
        }

    }


    public static void main(String[] args) {
        User user1 = new User.UserBuilder("Lokesh", "Gupta")
                .setAge(30)
                .setPhone("1234567")
                .setAddress("Fake address 1234")
                .build();

        System.out.println(user1);

        User user2 = new User.UserBuilder("Jack", "Reacher")
                .setAge(40)
                .setPhone("5655")
                //no address
                .build();

        System.out.println(user2);

        User user3 = new User.UserBuilder("Super", "Man")
                //No age
                //No phone
                //no address
                .build();

        System.out.println(user3);
    }
}