package Lesson_9_Homework.Telegram;

import static Lesson_9_Homework.Telegram.Telegram.*;

public class Main {
    public static void main(String[] args) {
        User testUser = new User("Sanjarbek", "Rakhmatov", 25, "+998944856603");
        createAccount(testUser);
        checkSMSCode(1234, "+998944856603");
        System.out.println("Foydalanuvchi akkovunt: " + getUserCount());
        deleteAccount("+998944856603");
        System.out.println("Foydalanuvchi akkovunt: " + getUserCount());
    }
}
