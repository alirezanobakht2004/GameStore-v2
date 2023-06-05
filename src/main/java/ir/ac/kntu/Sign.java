package ir.ac.kntu;

import java.util.Scanner;

public class Sign {

    public void sign() {
        User user = new User("A","1","l","k");
        UserManagement.getUsersArr().add(user);
        System.out.println("\u001B[33m" + "Select Your Role" + "\u001B[0m");
        System.out.println("Enter 1 if you are Admin");
        System.out.println("Enter 2 if you are User");
        System.out.println("Enter 3 if you are Developer");
        System.out.println("Enter 4 if you are AccessoriesSeller");
        System.out.println("Enter 5 for leaving");
        Scanner input = new Scanner(System.in);
        int in = input.nextInt();
        if (in == 1) {
            adminStart();
        }
        if (in == 2) {
            userStart();
        }
        if (in == 3) {
            developerStart();
        }
        if (in == 4) {
            accessoriesSellerStart();
        }
        if (in == 5) {
            System.exit(0);
        }
    }

    public void accessoriesSellerStart(){
        System.out.println("\033[1;94m" + "AccessoriesSeller entry menu" + "\033[0m");
        System.out.println("\033[1;92m" + "Sign up or Sign in" + "\033[0m");
        System.out.println("Enter 1 for sign up");
        System.out.println("Enter 2 for sign in");
        System.out.println("Enter 3 for back");
        Scanner input = new Scanner(System.in);
        int in = input.nextInt();
        if (in == 1) {
            accSignUp();
        }
        if (in == 2) {
            accSignIn();
        }
        if (in == 3) {
            sign();
        }
    }

    public void accSignUp() {
        System.out.println("\033[1;95m" + "sign up menu" + "\u001B[0m");
        System.out.println("\n" + "You can type ### and enter to comeback\n");
        System.out.println("Enter username:");
        Scanner input = new Scanner(System.in);
        String accName = input.nextLine();
        if (accName.equals("###")) {
            sign();
        }
        System.out.println("Enter password:");
        String password = input.nextLine();
        if (password.equals("###")) {
            sign();
        }
        int count = 0;
        for (int i = 0; i < AccessoriesSellerManagement.getAccessoriesSellerArr().size(); i++) {
            if (AccessoriesSellerManagement.getAccessoriesSellerArr().get(i).getAccessoriesSellerName().equals(accName)) {
                System.out.println("already taken DeveloperName!");
                count++;
            }
        }
        if (count == 0) {
            AccessoriesSeller acc = new AccessoriesSeller(accName, password);
            AccessoriesSellerManagement.getAccessoriesSellerArr().add(acc);
            System.out.println("\nYou signed up!\n");
        }
        sign();
    }

    public void accSignIn() {
        System.out.println("\033[1;95m" + "sign in menu" + "\033[0m");
        Scanner input = new Scanner(System.in);
        System.out.println("\n" + "You can type ### and enter to comeback\n");
        System.out.println("Enter DeveloperName:");
        String accName = input.nextLine();
        if (accName.equals("###")) {
            sign();
        }
        System.out.println("Enter password:");
        String password = input.nextLine();
        if (password.equals("###")) {
            sign();
        }
        int count = 0;
        for (int i = 0; i < AccessoriesSellerManagement.getAccessoriesSellerArr().size(); i++) {
            if (AccessoriesSellerManagement.getAccessoriesSellerArr().get(i).getAccessoriesSellerName().equals(accName)) {
                if (AccessoriesSellerManagement.getAccessoriesSellerArr().get(i).getPassword().equals(password)) {
                    System.out.println("Your welcome!");
                    AccessoriesSellerManagement.getAccessoriesSellerArr().get(i).getAccessoriesSellerMenu().start(i);
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.println("Invalid Enties");
            sign();
        }
    }
    public void developerStart() {
        System.out.println("\033[1;94m" + "Developer entry menu" + "\033[0m");
        System.out.println("\033[1;92m" + "Sign up or Sign in" + "\033[0m");
        System.out.println("Enter 1 for sign up");
        System.out.println("Enter 2 for sign in");
        System.out.println("Enter 3 for back");
        Scanner input = new Scanner(System.in);
        int in = input.nextInt();
        if (in == 1) {
            devSignUp();
        }
        if (in == 2) {
            devSignIn();
        }
        if (in == 3) {
            sign();
        }
    }

    public void devSignUp() {
        System.out.println("\033[1;95m" + "sign up menu" + "\u001B[0m");
        System.out.println("\n" + "You can type ### and enter to comeback\n");
        System.out.println("Enter username:");
        Scanner input = new Scanner(System.in);
        String devName = input.nextLine();
        if (devName.equals("###")) {
            sign();
        }
        System.out.println("Enter password:");
        String password = input.nextLine();
        if (password.equals("###")) {
            sign();
        }
        int count = 0;
        for (int i = 0; i < DeveloperManagement.getDevelopersArr().size(); i++) {
            if (DeveloperManagement.getDevelopersArr().get(i).getDeveloperName().equals(devName)) {
                System.out.println("already taken DeveloperName!");
                count++;
            }
        }
        if (count == 0) {
            Developer dev = new Developer(devName, password);
            DeveloperManagement.getDevelopersArr().add(dev);
            System.out.println("\nYou signed up!\n");
        }
        sign();
    }

    public void devSignIn() {
        System.out.println("\033[0;31m" + "sign in menu" + "\033[0m");
        Scanner input = new Scanner(System.in);
        System.out.println("\n" + "You can type ### and enter to comeback\n");
        System.out.println("Enter DeveloperName:");
        String devName = input.nextLine();
        if (devName.equals("###")) {
            sign();
        }
        System.out.println("Enter password:");
        String password = input.nextLine();
        if (password.equals("###")) {
            sign();
        }
        int count = 0;
        for (int i = 0; i < DeveloperManagement.getDevelopersArr().size(); i++) {
            if (DeveloperManagement.getDevelopersArr().get(i).getDeveloperName().equals(devName)) {
                if (DeveloperManagement.getDevelopersArr().get(i).getPassword().equals(password)) {
                    System.out.println("Your welcome!");
                    DeveloperManagement.getDevelopersArr().get(i).getDeveloperMenu().start(i);
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.println("Invalid Enties");
            devSignIn();
        }
    }

    public void adminStart() {
        System.out.println("\033[1;94m" + "Admin entry menu" + "\033[0m");
        String usernamerOfAdmin;
        String passwordOfAdmin;
        Admin admin = new Admin("A", "1");
        AdminManagement.getAdminsArr().add(admin);
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
        int count = 0;
        for (int i = 0; i < AdminManagement.getAdminsArr().size(); i++) {
            if (AdminManagement.getAdminsArr().get(i).getAdminName().equals(usernamerOfAdmin)) {
                if (AdminManagement.getAdminsArr().get(i).getPassword().equals(passwordOfAdmin)) {
                    System.out.println("Your welcome!");
                    AdminManagement.getAdminsArr().get(i).getAdminMenu().startMenu();
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.println("Invalid Enties");
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
        for (int i = 0; i < UserManagement.getUsersArr().size(); i++) {
            if (UserManagement.getUsersArr().get(i).getUsername().equals(user.getUsername())) {
                System.out.println("already taken username!");
                count++;
            }
        }
        for (int i = 0; i < UserManagement.getUsersArr().size(); i++) {
            if (UserManagement.getUsersArr().get(i).getEmail().equals(user.getEmail())) {
                System.out.println("already taken email!");
                count++;
            }
        }
        for (int i = 0; i < UserManagement.getUsersArr().size(); i++) {
            if (UserManagement.getUsersArr().get(i).getPhoneNumber().equals(user.getPhoneNumber())) {
                System.out.println("already taken phone number!");
                count++;
            }
        }
        if (count == 0) {
            UserManagement.getUsersArr().add(user);
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
        for (int i = 0; i < UserManagement.getUsersArr().size(); i++) {
            if (UserManagement.getUsersArr().get(i).getUsername().equals(username)) {
                if (UserManagement.getUsersArr().get(i).getPassword().equals(password)) {
                    System.out.println("Your welcome!");
                    UserManagement.getUsersArr().get(i).setStartTime(System.nanoTime());
                    UserManagement.getUsersArr().get(i).getUserMenu().userMenu(i);
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
