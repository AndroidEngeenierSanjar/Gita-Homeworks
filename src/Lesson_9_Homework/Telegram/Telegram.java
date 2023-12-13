package Lesson_9_Homework.Telegram;

import java.util.Arrays;

public class Telegram {
    private static User[] userList = new User[0];

    public static boolean createAccount(User user) {
        if (!isProfileExist(user.getPhoneNumber())) {
            sendSMSCode(user.getPhoneNumber());
            return true;
        }
        return false;
    }

    public static void checkSMSCode(int code, String phoneNumber) {
        if (isValidCode(code, phoneNumber)) {
            createUserAccount(phoneNumber);
        } else {
            System.out.println("Xato: SMS kodi yoki telefon raqami noto'g'ri.");
        }
    }

    public static int getUserCount() {
        return userList.length;
    }

    public static boolean deleteAccount(String phoneNumber) {
        for (int i = 0; i < userList.length; i++) {
            if (userList[i].getPhoneNumber().equals(phoneNumber)) {
                deleteUserAtIndex(i);
                return true;
            }
        }
        return false;
    }

    private static boolean isProfileExist(String phoneNumber) {
        for (User user : userList) {
            if (user.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    private static void sendSMSCode(String phoneNumber) {
        System.out.println("SMS kodi yuborildi " + phoneNumber);
    }

    private static boolean isValidCode(int code, String phoneNumber) {
        String realSMSCode = "1234";
        return code == Integer.parseInt(realSMSCode);
    }

    private static void createUserAccount(String phoneNumber) {
        userList = Arrays.copyOf(userList, userList.length + 1);
        userList[userList.length - 1] = new User("Sanjek", "Rahmatov", 18, phoneNumber);
        System.out.println("yaratilgan foydalanuvchi hisobi " + phoneNumber);
    }

    private static void deleteUserAtIndex(int index) {
        User[] newArr = new User[userList.length - 1];
        System.arraycopy(userList, 0, newArr, 0, index);
        System.arraycopy(userList, index + 1, newArr, index, newArr.length - index);
        userList = newArr;
        System.out.println("\n" +
                "Foydalanuvchi hisobi oʻchirildi");
    }
}