package rooms

class Person {
    String  firstName
    String  lastName
    Integer yearOfBirth

    SecUser secUser

    String toString() {
        return firstName + " " + lastName
    }

    static constraints = {
        firstName nullable: true
        lastName  nullable: true
        secUser   nullable: true
    }
}
