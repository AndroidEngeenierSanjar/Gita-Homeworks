package lesson_9_homework_1;

import java.util.Arrays;
import java.util.Scanner;

public class Telegram {

    private User[] users = new User[]{};

    public void createAccount(User user) {
        boolean isUserExist = isUserExist(user.getPhoneNumber());
        if (isUserExist) {
            System.out.println("Bunday user mavjud!");
        } else {
            //lesson_9_homework_1.User not exist
            Scanner scanner = new Scanner(System.in);
            System.out.println("Code ni kiriting!");
            String code = scanner.nextLine();
            boolean checkSmsCode = checkSmsCode(code, user.getPhoneNumber());
            if (checkSmsCode) {
                User[] newUsers = new User[users.length + 1];
                int index = 0;
                for (User user1 : users) {
                    newUsers[index++] = user1;
                }
                newUsers[index] = user;
                users = newUsers;
                System.out.println("lesson_9_homework_1.User count -> " + getUserCount());
            }
        }
    }

    public void deleteUser(String phoneNumber) {
        System.out.println("AAA"+phoneNumber);
        boolean isUserExist = isUserExist(phoneNumber);
        System.out.println(isUserExist);
        if (isUserExist) {
            User[] newUsers = new User[users.length - 1];
            int index = 0;
            for (User user1 : users) {
                if (user1.getPhoneNumber().equals(phoneNumber)) {
                    continue;
                }
                newUsers[index++] = user1;
            }
            users = newUsers;
            System.out.println("lesson_9_homework_1.User deleted! lesson_9_homework_1.User count -> " + getUserCount());
        } else {
            System.out.println("Bunday user mavjud emas!");
        }
    }

    public int getUserCount() {
        return users.length;
    }


    private boolean checkSmsCode(String code, String phoneNumber) {
        if (code.equals(phoneNumber)) {
            System.out.println("lesson_9_homework_1.User created!");
            return true;
        } else {
            System.out.println("Error!");
            return false;
        }
    }

    private boolean isUserExist(String phoneNumber) {
        System.out.println(Arrays.toString(users));
        boolean isUserExist = false;
        for (User user : users) {
            if (user.getPhoneNumber().equals(phoneNumber)) {
                isUserExist = true;
                break;
            }
        }
        return isUserExist;
    }

    public static void main(String[] args) {
        User user1 = new User("Sanjar", "Karimov", 28, "1714250");
        User user2 = new User("Sanja1", "Karimo1", 28, "8564250");
        Telegram telegram = new Telegram();
        telegram.createAccount(user1);
        telegram.createAccount(user2);
        telegram.deleteUser(user2.getPhoneNumber());
    }
}
