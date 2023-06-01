package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin {
    private static List<Game> gamesArr = new ArrayList<Game>();

    public static List<Game> getGamesArr() {
        return gamesArr;
    }

    public void startMenu() {
        System.out.println("\033[1;93m" + "which do you want to modify?" + "\033[0m");
        System.out.println("1.Games");
        System.out.println("2.Users");
        System.out.println("3.back");
        Sign s = new Sign();
        Scanner input = new Scanner(System.in);
        int adminDes = input.nextInt();
        switch (adminDes) {
            case 1:
                gameManage();
                break;
            case 2:
                userManage();
                break;
            case 3:
                s.sign();
            default:
                break;
        }
    }

    public void gameManage() {
        System.out.println("\033[0;91m" + "game manage menu" + "\033[0m");
        System.out.println("1.create games");
        System.out.println("2.modify games or delete games");
        System.out.println("3.back");
        Scanner input = new Scanner(System.in);
        int adminDes = input.nextInt();
        switch (adminDes) {
            case 1:
                createGame();
                break;
            case 2:
                searchGame();
                break;
            case 3:
                startMenu();
            default:
                break;
        }
    }

    public void createGame() {
        System.out.println("\033[43m" + "Create game menu" + "\033[0m");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter title:");
        String title = input.nextLine();
        System.out.println("Enter genre");
        String genre = input.nextLine();
        System.out.println("Enter info:");
        String info = input.nextLine();
        System.out.println("Enter price:");
        int price = input.nextInt();
        Game game = new Game(title, genre, info, price);
        gamesArr.add(game);
        System.out.println("\nYour game has been succsessfully created!\n");
        gameManage();
    }

    public void searchGame() {
        Scanner input = new Scanner(System.in);
        System.out.println("\033[46m" + "Modify or Delete game menu" + "\033[0m");
        System.out.println("Enter name of game:");
        String name = input.nextLine();
        int count = 0;
        for (int i = 0; i < gamesArr.size(); i++) {
            if (gamesArr.get(i).getTitle().startsWith(name)) {
                System.out.println("name of game: " + gamesArr.get(i).getTitle() +
                        " genre " + gamesArr.get(i).getGenre() +
                        " info: " + gamesArr.get(i).getInfo() + " index of game is: " +
                        "\033[1;93m" + String.valueOf(i) + "\033[0m");
                count++;
            }
        }

        if (count == 0) {
            System.out.println("there was no such a game!");
            searchGame();
        } else {
            System.out.println("\033[1;96m" + "Modify or Delete selection Menu" + "\033[0m");
            System.out.println("1.Modify game");
            System.out.println("2.delete game");
            System.out.println("3.back");
            int des = input.nextInt();
            switch (des) {
                case 1:
                    System.out.println("enter the index of the game you want to modify:");
                    int index = input.nextInt();
                    Game game = new Game();
                    game.gameModify(index);
                    break;
                case 2:
                    System.out.println("enter the index of the game you want to delete:");
                    int index1 = input.nextInt();
                    gamesArr.remove(index1);
                    System.out.println("\nYour game has been succsessfully deleted!\n");
                case 3:
                    gameManage();
                default:
                    break;
            }

        }
    }

    public void userManage() {
        System.out.println("\033[0;91m" + "user manage menu" + "\033[0m");
        System.out.println("1.Users Setting");
        System.out.println("2.create a user");
        System.out.println("3.back");
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
                startMenu();
            default:
                break;
        }
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
        for (int i = 0; i < Sign.getUsersArr().size(); i++) {
            if (Sign.getUsersArr().get(i).getUsername().equals(user.getUsername())) {
                System.out.println("already taken username!");
                count++;
            }
        }
        if (count == 0) {
            Sign.getUsersArr().add(user);
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
                for (int i = 0; i < Sign.getUsersArr().size(); i++) {
                    if (Sign.getUsersArr().get(i).getUsername().equals(user)) {
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
                for (int i = 0; i < Sign.getUsersArr().size(); i++) {
                    if (Sign.getUsersArr().get(i).getEmail().equals(email)) {
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
                for (int i = 0; i < Sign.getUsersArr().size(); i++) {
                    if (Sign.getUsersArr().get(i).getPhoneNumber().equals(phone)) {
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
                System.out.println("username: " + Sign.getUsersArr().get(i).getUsername());
                System.out.println("password: " + Sign.getUsersArr().get(i).getPassword());
                System.out.println("email: " + Sign.getUsersArr().get(i).getEmail());
                System.out.println("phonenumber: " + Sign.getUsersArr().get(i).getPhoneNumber());
                System.out.println("wallet amount: " + Sign.getUsersArr().get(i).getWallet());
                userSetting(i);
                break;
            case 2:
                adminmodifyingUser(i);
                userSetting(i);
                break;
            case 3:
                Sign.getUsersArr().remove(i);
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
                Sign.getUsersArr().get(i).setUsername(inputOne.nextLine());
                System.out.println("\nusername changed!\n");
                adminmodifyingUser(i);
                break;
            case 2:
                System.out.println("Enter new email:");
                Scanner inputThree = new Scanner(System.in);
                Sign.getUsersArr().get(i).setEmail(inputThree.nextLine());
                System.out.println("\nemail changed!\n");
                adminmodifyingUser(i);
                break;
            case 3:
                System.out.println("Enter new phonenumber:");
                Scanner inputFour = new Scanner(System.in);
                Sign.getUsersArr().get(i).setPhoneNumber(inputFour.nextLine());
                System.out.println("\nphonenumber changed!\n");
                adminmodifyingUser(i);
                break;
            case 4:
                System.out.println("Enter new wallet amount:");
                Scanner inputFive = new Scanner(System.in);
                Sign.getUsersArr().get(i).setWallet(inputFive.nextInt());
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
