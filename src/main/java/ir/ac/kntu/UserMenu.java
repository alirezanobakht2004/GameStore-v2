package ir.ac.kntu;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class UserMenu {
    private User user;
    public void userMenu(int i) {
        user=UserManagement.getUsersArr().get(i);
        System.out.println("\033[1;92m" + "User Menu" + "\033[0m");
        System.out.println("Enter 1 for profile");
        System.out.println("Enter 2 for library");
        System.out.println("Enter 3 for store");
        System.out.println("Enter 4 for friends");
        System.out.println("Enter 5 for back");
        Scanner input = new Scanner(System.in);
        int in = input.nextInt();
        switch (in) {
            case 1:
                profile();
                break;
            case 2:
                library(i);
                break;
            case 3:
                store(i);
                break;
            case 4:
                friends(i);
                break;
            case 5:
                long endTime = System.nanoTime();
                long duration = endTime-user.getStartTime();
                user.setStartTime(0);
                System.out.println();
                user.setTime(user.getTime()+TimeUnit.SECONDS.convert(duration, TimeUnit.NANOSECONDS));
                user.setLevel((int) user.getTime()/60);
                Sign back = new Sign();
                back.sign();
            default:
                break;
        }
    }

    public void profile() {
        System.out.println("\033[1;94m" + "profile menu" + "\033[0m");
        System.out.println("1.show information");
        System.out.println("2.change information");
        System.out.println("3.wallet charging");
        System.out.println("4.Back");
        Scanner input = new Scanner(System.in);
        int in = input.nextInt();
        if (in == 1) {

            System.out.println("your username:");
            System.out.println(user.getUsername());
            System.out.println("your password:");
            System.out.println(user.getPassword());
            System.out.println("your email:");
            System.out.println(user.getEmail());
            System.out.println("your phonenumber:");
            System.out.println(user.getPhoneNumber());
            System.out.println("your wallet amount:");
            System.out.println(user.getWallet());
            System.out.println("\n Enter 1 for back");
            System.out.println(" Enter 2 for exit");

            int back = input.nextInt();
            if (back == 1) {
                profile();
            }
            if (back == 2) {
                System.exit(0);
            }
        }

        if (in == 2) {
            editProfile();
        }
        if (in == 3) {
            wallet();
        }
        if (in == 4) {
            userMenu(UserManagement.getUsersArr().indexOf(user));
        }
    }

    public void editProfile() {
        Scanner input = new Scanner(System.in);
        System.out.println("\033[1;97m" + "edit profile menu" + "\033[0m");
        System.out.println("1.change username");
        System.out.println("2.change password");
        System.out.println("3.change email");
        System.out.println("4.change phonenumber");
        System.out.println("5.back");
        int inner = input.nextInt();
        switch (inner) {
            case 1:
                System.out.println("Enter new username:");
                Scanner inputOne = new Scanner(System.in);
                String t = inputOne.nextLine();
                user.setUsername(t);
                System.out.println("\nyour username changed!\n");
                profile();
                break;
            case 2:
                System.out.println("Enter new password:");
                Scanner inputTwo = new Scanner(System.in);
                String pass = inputTwo.nextLine();
                if (pass.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")) {
                    user.setPassword(pass);
                    System.out.println("\nyour password changed!\n");
                } else {
                    System.out.println("\nwrong pattern!\n");
                }
                profile();
                break;
            case 3:
                System.out.println("Enter new email:");
                Scanner inputThree = new Scanner(System.in);
                String l = inputThree.nextLine();
                user.setEmail(l);
                System.out.println("\nyour email changed!\n");
                profile();
                break;
            case 4:
                System.out.println("Enter new phonenumber:");
                Scanner inputFour = new Scanner(System.in);
                String p = inputFour.nextLine();
                user.setPhoneNumber(p);
                System.out.println("\nyour phonenumber changed!\n");
                profile();
                break;
            case 5:
                profile();
                break;
            default:
                break;
        }
    }

    public void wallet() {
        System.out.println("enter amount of money you want to add:");
        Scanner input = new Scanner(System.in);
        int g = input.nextInt();
        user.setWallet(user.getWallet()+g);
        System.out.println("\nYou charged your wallet!\n");
        this.profile();
    }

    public void store(int i) {
        StoreMenu x = new StoreMenu();
        x.start(i);
    }

    public void library(int i) {
        LibraryMenu x = new LibraryMenu();
        x.start(i);
    }

    public void friends(int i) {
        Friends x = new Friends();
        x.start(i);
    }
}
