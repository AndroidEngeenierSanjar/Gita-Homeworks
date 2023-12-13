package Lesson_9_Homework.Telegram;

public class User {
    private final String lastName;
    private final String firstName;
    private final int age;
    private final String phoneNumber;

    public User(String lastName, String firstName, int age, String phoneNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }
}
