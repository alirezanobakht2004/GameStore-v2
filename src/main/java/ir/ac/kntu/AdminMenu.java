package ir.ac.kntu;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {
    private Admin admin;

    public void startMenu(int i) {
        admin = AdminManagement.getAdminsArr().get(i);
        System.out.println("\033[1;93m" + "which do you want?" + "\033[0m");
        System.out.println("1.Profile");
        System.out.println("2.Accessories");
        System.out.println("3.Games");
        System.out.println("4.Users");
        System.out.println("5.Add New Admin");
        System.out.println("6.back");
        Sign s = new Sign();
        Scanner input = new Scanner(System.in);
        int adminDes = input.nextInt();
        switch (adminDes) {
            case 1:
                profile();
                break;
            case 2:
                accessories();
                break;
            case 3:
                gameManage();
                break;
            case 4:
                userManage();
                break;
            case 5:
                addAdmin();
                break;
            case 6:
                s.sign();
            default:
                break;
        }
    }

    public void accessories() {
        admin.getAdminAccessorySeller().getAccessoriesSellerMenu().start(AccessoriesSellerManagement.getAccessoriesSellerArr().indexOf(admin.getAdminAccessorySeller()));
    }

    public void gameManage() {
        admin.getAdminDevelpoer().getDeveloperMenu().start(DeveloperManagement.getDevelopersArr().indexOf(admin.getAdminDevelpoer()));
    }

    public void profile() {
        System.out.println("\033[1;94m" + "profile menu" + "\033[0m");
        System.out.println("1.show information");
        System.out.println("2.change information");
        System.out.println("3.Back");
        Scanner input = new Scanner(System.in);
        int in = input.nextInt();
        if (in == 1) {
            System.out.println("your username:");
            System.out.println(admin.getAdminName());
            System.out.println("your password:");
            System.out.println(admin.getPassword());
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
            startMenu(AdminManagement.getAdminsArr().indexOf(admin));
        }
    }

    public void editProfile() {
        Scanner input = new Scanner(System.in);
        System.out.println("\033[1;97m" + "edit profile menu" + "\033[0m");
        System.out.println("1.change adminName");
        System.out.println("2.change password");
        System.out.println("3.back");
        int inner = input.nextInt();
        switch (inner) {
            case 1:
                System.out.println("Enter new adminName:");
                Scanner inputOne = new Scanner(System.in);
                String t = inputOne.nextLine();
                admin.setAdminName(t);
                System.out.println("\nyour username changed!\n");
                profile();
                break;
            case 2:
                System.out.println("Enter new password:");
                Scanner inputTwo = new Scanner(System.in);
                String pass = inputTwo.nextLine();
                admin.setPassword(pass);
                System.out.println("\nyour password changed!\n");
                profile();
                break;
            case 3:
                profile();
                break;
            default:
                break;
        }
    }

    public void addAdmin() {
        System.out.println("\033[1;95m" + "create admin menu" + "\u001B[0m");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter username:");
        String adminName = input.nextLine();
        System.out.println("Enter password");
        String password = input.nextLine();
        int count = 0;
        for (int i = 0; i < AdminManagement.getAdminsArr().size(); i++) {
            if (AdminManagement.getAdminsArr().get(i).getAdminName().equals(adminName)) {
                System.out.println("already taken adminName!");
                count++;
            }
        }
        if (count == 0) {
            Admin admin = new Admin(adminName, password);
            AdminManagement.getAdminsArr().add(admin);
            System.out.println("\naccount has been succesfully created!\n");
        }
        startMenu(AdminManagement.getAdminsArr().indexOf(admin));
    }


    public void userManage() {
        System.out.println("\033[0;91m" + "user manage menu" + "\033[0m");
        System.out.println("1.Users Setting");
        System.out.println("2.create a user");
        System.out.println("3.see most active users");
        System.out.println("4.back");
        Scanner input = new Scanner(System.in);
        int adminDes = input.nextInt();
        switch (adminDes) {
            case 1:
                searchUser();
                break;
            case 2:
                createUser();
                break;
            case 3:
                seeMostActive();
            case 4:
                startMenu(AdminManagement.getAdminsArr().indexOf(admin));
            default:
                break;
        }
    }

    public void seeMostActive() {
        List<User> sortedList = UserManagement.getUsersArr().stream().sorted(Comparator.comparingInt(User::getScore)).toList();
        for (int i = 0; i < sortedList.size(); i++) {
            System.out.println(sortedList.get(i).getUsername() + " with score: " + sortedList.get(i).getScore());
        }
        userManage();
    }

    public void createUser() {
        System.out.println("\033[1;95m" + "create user menu" + "\u001B[0m");
        Scanner input = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = input.nextLine();
        System.out.println("Enter password");
        String password = input.nextLine();
        if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")) {
            System.out.println("not correct password!");
            createUser();
        }
        System.out.println("Enter email:");
        String email = input.nextLine();
        System.out.println("Enter phonenumber");
        String phoneNumber = input.nextLine();

        User user = new User(username, password, phoneNumber, email);
        int count = 0;
        for (int i = 0; i < UserManagement.getUsersArr().size(); i++) {
            if (UserManagement.getUsersArr().get(i).getUsername().equals(user.getUsername())) {
                System.out.println("already taken username!");
                count++;
            }
        }
        if (count == 0) {
            UserManagement.getUsersArr().add(user);
            System.out.println("\naccount has been succesfully created!\n");
        }
        userManage();
    }

    public void searchUser() {
        Scanner input = new Scanner(System.in);
        searchUser1();
        int in = input.nextInt();
        int count = 0;
        switch (in) {
            case 1:
                System.out.println("Enter username:");
                Scanner inputOne = new Scanner(System.in);
                String user = inputOne.nextLine();
                for (int i = 0; i < UserManagement.getUsersArr().size(); i++) {
                    if (UserManagement.getUsersArr().get(i).getUsername().equals(user)) {
                        userSetting(i);
                        count++;
                    }
                }
                countAlarm(count);
                break;
            case 2:
                System.out.println("Enter email:");
                Scanner inputTwo = new Scanner(System.in);
                String email = inputTwo.nextLine();
                for (int i = 0; i < UserManagement.getUsersArr().size(); i++) {
                    if (UserManagement.getUsersArr().get(i).getEmail().equals(email)) {
                        userSetting(i);
                        count++;
                    }
                }
                countAlarm(count);
                break;
            case 3:
                System.out.println("Enter phone number:");
                Scanner inputThree = new Scanner(System.in);
                String phone = inputThree.nextLine();
                for (int i = 0; i < UserManagement.getUsersArr().size(); i++) {
                    if (UserManagement.getUsersArr().get(i).getPhoneNumber().equals(phone)) {
                        userSetting(i);
                        count++;
                    }
                }
                countAlarm(count);
                break;
            case 4:
                userManage();
                break;
            default:
                break;
        }
        searchUser();
    }

    public void searchUser1() {
        System.out.println("\033[46m" + "Search user menu" + "\033[0m");
        System.out.println("how do you want to search user?");
        System.out.println("1.search by username");
        System.out.println("2.search by email");
        System.out.println("3.search by phone number");
        System.out.println("4.back");
    }

    public void searchUser2() {

    }

    public void userSetting(int i) {
        System.out.println("\033[1;96m" + "User Setting Menu" + "\033[0m");
        System.out.println("\n index of user is: " + "\033[1;93m" + String.valueOf(i) + "\033[0m" + "\n");
        System.out.println("What do you want to do?");
        System.out.println("1.Show information of user");
        System.out.println("2.modifying user information");
        System.out.println("3.delete user");
        System.out.println("4.back");
        Scanner input = new Scanner(System.in);
        switch (input.nextInt()) {
            case 1:
                System.out.println("username: " + UserManagement.getUsersArr().get(i).getUsername());
                System.out.println("password: " + UserManagement.getUsersArr().get(i).getPassword());
                System.out.println("email: " + UserManagement.getUsersArr().get(i).getEmail());
                System.out.println("phonenumber: " + UserManagement.getUsersArr().get(i).getPhoneNumber());
                System.out.println("wallet amount: " + UserManagement.getUsersArr().get(i).getWallet());
                userSetting(i);
                break;
            case 2:
                adminmodifyingUser(i);
                userSetting(i);
                break;
            case 3:
                UserManagement.getUsersArr().remove(i);
                System.out.println("\033[41m" + "\nuser has been successfully deleted!\n" + "\033[0m");
                userSetting(i);
                break;
            case 4:
                userManage();
            default:
                break;
        }
    }

    public void adminmodifyingUser(int i) {
        Scanner input = new Scanner(System.in);
        adminmodifyingUser1();
        int inner = input.nextInt();
        switch (inner) {
            case 1:
                System.out.println("Enter new username:");
                Scanner inputOne = new Scanner(System.in);
                UserManagement.getUsersArr().get(i).setUsername(inputOne.nextLine());
                System.out.println("\nusername changed!\n");
                adminmodifyingUser(i);
                break;
            case 2:
                System.out.println("Enter new email:");
                Scanner inputThree = new Scanner(System.in);
                UserManagement.getUsersArr().get(i).setEmail(inputThree.nextLine());
                System.out.println("\nemail changed!\n");
                adminmodifyingUser(i);
                break;
            case 3:
                System.out.println("Enter new phonenumber:");
                Scanner inputFour = new Scanner(System.in);
                UserManagement.getUsersArr().get(i).setPhoneNumber(inputFour.nextLine());
                System.out.println("\nphonenumber changed!\n");
                adminmodifyingUser(i);
                break;
            case 4:
                System.out.println("Enter new wallet amount:");
                Scanner inputFive = new Scanner(System.in);
                UserManagement.getUsersArr().get(i).setWallet(inputFive.nextInt());
                System.out.println("\nwallet changed!\n");
                adminmodifyingUser(i);
                break;
            case 5:
                userSetting(i);
                break;
            default:
                break;
        }
    }

    public void adminmodifyingUser1() {
        System.out.println("\033[1;97m" + "edit user  menu" + "\033[0m");
        System.out.println("1.change username");
        System.out.println("2.change email");
        System.out.println("3.change phonenumber");
        System.out.println("4.change wallet");
        System.out.println("5.back");
    }

    public void countAlarm(int h) {
        if (h == 0) {
            System.out.println("\nThere was no such this!\n");
        }
    }
}
