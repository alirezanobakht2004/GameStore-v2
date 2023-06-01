package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sign {

    private static List<User> usersArr = new ArrayList<User>();

    public static List<User> getUsersArr() {
        return usersArr;
    }

    public void sign() {
        System.out.println("\u001B[33m" + "Select Your Role" + "\u001B[0m");
        System.out.println("Enter 1 if you are Admin");
        System.out.println("Enter 2 if you are User");
        System.out.println("Enter 3 for leaving");
        Scanner input = new Scanner(System.in);
        int in = input.nextInt();
        if (in == 1) {
            adminStart();
        }
        if (in == 2) {
            userStart();
        }
        if (in == 3) {
            System.exit(0);
        }
    }

    public void adminStart() {
        System.out.println("\033[1;94m" + "Admin entry menu" + "\033[0m");
        String usernamerOfAdmin;
        String passwordOfAdmin;
        System.out.println("\n" + "You can type ### and enter to comeback\n");
        System.out.println("Enter your username:");
        Scanner input1 = new Scanner(System.in);
        usernamerOfAdmin = input1.nextLine();
        if (usernamerOfAdmin.equals("###")) {
            sign();
        }
        System.out.println("Enter your password:");
        passwordOfAdmin = input1.nextLine();
        if (passwordOfAdmin.equals("###")) {
            sign();
        }
        if (usernamerOfAdmin.equals("A") && passwordOfAdmin.equals("1")) {
            Admin admin = new Admin();
            admin.startMenu();
        } else {
            System.out.println("incorrect username or password");
            adminStart();
        }
    }

    public void userStart() {
        System.out.println("\033[0;36m" + "Sign up or Sign in" + "\033[0m");
        System.out.println("Enter 1 for sign up");
        System.out.println("Enter 2 for sign in");
        System.out.println("Enter 3 for back");
        Scanner input = new Scanner(System.in);
        int in = input.nextInt();
        if (in == 1) {
            signUp();
        }
        if (in == 2) {
            signIn();
        }
        if (in == 3) {
            sign();
        }
    }

    public void signUp() {
        Scanner input = new Scanner(System.in);
        signUp1();
        String username = input.nextLine();
        if (username.equals("###")) {
            sign();
        }
        System.out.println("Enter password:");
        String password = input.nextLine();
        if (password.equals("###")) {
            sign();
        }
        passwordMatch(password);
        System.out.println("Enter email:");
        String email = input.nextLine();
        if (email.equals("###")) {
            sign();
        }
        System.out.println("Enter phonenumber:");
        String phoneNumber = input.nextLine();
        if (phoneNumber.equals("###")) {
            sign();
        }
        User user = new User(username, password, phoneNumber, email);
        int count = 0;
        for (int i = 0; i < usersArr.size(); i++) {
            if (usersArr.get(i).getUsername().equals(user.getUsername())) {
                System.out.println("already taken username!");
                count++;
            }
        }
        for (int i = 0; i < usersArr.size(); i++) {
            if (usersArr.get(i).getEmail().equals(user.getEmail())) {
                System.out.println("already taken email!");
                count++;
            }
        }
        for (int i = 0; i < usersArr.size(); i++) {
            if (usersArr.get(i).getPhoneNumber().equals(user.getPhoneNumber())) {
                System.out.println("already taken phone number!");
                count++;
            }
        }
        if (count == 0) {
            usersArr.add(user);
            System.out.println("\nYou signed up!\n");
        }
        sign();
    }

    public void signUp1() {
        System.out.println("\033[1;95m" + "sign up menu" + "\u001B[0m");
        System.out.println("\n" + "You can type ### and enter to comeback\n");
        System.out.println("Enter username:");
    }

    public void signIn() {
        System.out.println("\033[0;31m" + "sign in menu" + "\033[0m");
        Scanner input = new Scanner(System.in);
        System.out.println("\n" + "You can type ### and enter to comeback\n");
        System.out.println("Enter username:");
        String username = input.nextLine();
        if (username.equals("###")) {
            sign();
        }
        System.out.println("Enter password:");
        String password = input.nextLine();
        if (password.equals("###")) {
            sign();
        }
        int count = 0;
        for (int i = 0; i < usersArr.size(); i++) {
            if (usersArr.get(i).getUsername().equals(username)) {
                if (usersArr.get(i).getPassword().equals(password)) {
                    System.out.println("Your welcome!");
                    User usern = new User();
                    usern.userMenu(i);
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.println("Invalid Enties");
            signIn();
        }
    }

    public void passwordMatch(String password) {
        if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")) {
            System.out.println("not strong password!");
            signUp();
        }
    }
}
