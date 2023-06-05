package ir.ac.kntu;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class AdminMenu {
    Admin admin;

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
        System.out.println("\033[0;91m" + "accessories manage menu" + "\033[0m");
        System.out.println("1.create accessories");
        System.out.println("2.modify accessories or delete accessories");
        System.out.println("3.back");
        Scanner input = new Scanner(System.in);
        int adminDes = input.nextInt();
        switch (adminDes) {
            case 1:
                createAccessories();
                break;
            case 2:
                searchAccessories();
                break;
            case 3:
                startMenu(AdminManagement.getAdminsArr().indexOf(admin));
            default:
                break;
        }
    }
    public void searchAccessories(){
        System.out.println("Enter name of accessory you want:");
        Scanner input = new Scanner(System.in);
        String t = input.nextLine();
        int c=0;
        for (int i=0;i<AccessoriesManagement.getAccessoriesArr().size();i++){
            System.out.println("*"+AccessoriesManagement.getAccessoriesArr().get(i)+"*");
        }
        for (int i=0;i<AccessoriesManagement.getAccessoriesArr().size();i++){
            if (AccessoriesManagement.getAccessoriesArr().get(i).getTitle().startsWith(t)){
                System.out.println(AccessoriesManagement.getAccessoriesArr().get(i).getTitle()+" index: "+i);
                c++;
            }
            if(c==0){
                System.out.println("NO SUCH GAME FOUND!");
                accessories();
            }
            Scanner inputOne = new Scanner(System.in);
            System.out.println("\033[1;96m" + "Modify or Delete selection Menu" + "\033[0m");
            System.out.println("1.Modify Accessory");
            System.out.println("2.delete Accessory");
            System.out.println("3.back");
            int des = inputOne.nextInt();
            switch (des) {
                case 1:
                    System.out.println("enter the index of the game you want to modify:");
                    int index = input.nextInt();
                    if (AccessoriesManagement.getAccessoriesArr().get(index).getFps()==null) {
                        gameControllerModify(index);
                        accessories();
                    } else {
                        gameMonitorModify(index);
                        accessories();
                    }
                    break;
                case 2:
                    System.out.println("enter the index of the game you want to delete:");
                    int index1 = input.nextInt();
                    AccessoriesManagement.getAccessoriesArr().remove(index1);
                    admin.getAccessories().remove(index1);
                    System.out.println("\nYour Accessory has been successfully deleted!\n");
                    accessories();
                case 3:
                    accessories();
                default:
                    break;
            }
        }
    }
    public void gameControllerModify(int i) {
        Scanner input = new Scanner(System.in);
        System.out.println("\033[0;91m" + "gameController modify menu" + "\033[0m");
        System.out.println("1.Modify Title");
        System.out.println("2.Modify Info");
        System.out.println("3.Modify Price");
        System.out.println("4.Modify NumberOfAccessory");
        System.out.println("5.Modify SystemConnection");
        System.out.println("6.Modify SystemKind");
        System.out.println("7.Back");
        int des = input.nextInt();
        switch (des) {
            case 1:
                System.out.println("Enter new title:");
                Scanner inputOne = new Scanner(System.in);
                String title=inputOne.nextLine();
                AccessoriesManagement.getAccessoriesArr().get(i).setTitle(title);
                break;
            case 2:
                Scanner inputTwo = new Scanner(System.in);
                String titl=inputTwo.nextLine();
                AccessoriesManagement.getAccessoriesArr().get(i).setInfo(titl);
                break;
            case 3:
                Scanner inputThree = new Scanner(System.in);
                String tit=inputThree.nextLine();
                AccessoriesManagement.getAccessoriesArr().get(i).setPrice(tit);
                break;
            case 4:
                Scanner inputFour = new Scanner(System.in);
                String ti=inputFour.nextLine();
                AccessoriesManagement.getAccessoriesArr().get(i).setNumberOfAccessory(ti);
                break;
            case 5:
                if (AccessoriesManagement.getAccessoriesArr().get(i).getSystemConnection().equals("Wired")) {
                    AccessoriesManagement.getAccessoriesArr().get(i).setSystemConnection("Wireless");
                } else {
                    AccessoriesManagement.getAccessoriesArr().get(i).setSystemConnection("Wired");
                }
                break;
            case 6:
                Scanner inputFive = new Scanner(System.in);
                String t=inputFive.nextLine();
                AccessoriesManagement.getAccessoriesArr().get(i).setSystemKind(t);
                break;
            case 7:
                accessories();
            default:
                break;
        }
        accessories();
    }

    public void gameMonitorModify(int i) {
        Scanner input = new Scanner(System.in);
        System.out.println("\033[0;91m" + "gameMonitor modify menu" + "\033[0m");
        System.out.println("1.Modify Title");
        System.out.println("2.Modify Info");
        System.out.println("3.Modify Price");
        System.out.println("4.Modify NumberOfAccessory");
        System.out.println("5.Modify Fps");
        System.out.println("6.Modify Size");
        System.out.println("7.Modify AnswerTime");
        System.out.println("8.Back");
        int des = input.nextInt();
        Scanner inputOne = new Scanner(System.in);
        switch (des) {
            case 1:
                System.out.println("Enter new value");
                AccessoriesManagement.getAccessoriesArr().get(i).setTitle(inputOne.nextLine());
                break;
            case 2:
                System.out.println("Enter new value");
                AccessoriesManagement.getAccessoriesArr().get(i).setInfo(inputOne.nextLine());
                break;
            case 3:
                System.out.println("Enter new value");
                AccessoriesManagement.getAccessoriesArr().get(i).setPrice(inputOne.nextLine());
                break;
            case 4:
                System.out.println("Enter new value");
                AccessoriesManagement.getAccessoriesArr().get(i).setNumberOfAccessory(inputOne.nextLine());
                break;
            case 5:
                System.out.println("Enter new value");
                AccessoriesManagement.getAccessoriesArr().get(i).setFps(inputOne.nextLine());
                break;
            case 6:
                System.out.println("Enter new value");
                AccessoriesManagement.getAccessoriesArr().get(i).setSize(inputOne.nextLine());
                break;
            case 7:
                System.out.println("Enter new value");
                AccessoriesManagement.getAccessoriesArr().get(i).setAnswerTime(inputOne.nextLine());
            case 8:
                accessories();
            default:
                break;
        }
        accessories();
    }
    public void createAccessories() {
        System.out.println("\033[1;94m" + "Create Accessories menu" + "\033[0m");
        System.out.println("which do you want to add?");
        System.out.println("1.GameController");
        System.out.println("2.GameMonitor");
        System.out.println("3.Back");
        Scanner input = new Scanner(System.in);
        int d = input.nextInt();
        switch (d) {
            case 1:
                createGameController();
                break;
            case 2:
                createGameMonitor();
                break;
            case 3:
                accessories();
            default:
                break;
        }
    }

    public void createGameController() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Title:");
        String title = input.nextLine();
        System.out.println("Enter Price:");
        String price = input.nextLine();
        System.out.println("Enter Info:");
        String info = input.nextLine();
        System.out.println("Enter NumberOfAccessory:");
        String numberOfAccessory = input.nextLine();
        System.out.println("Enter SystemKind:");
        String systemKind = input.nextLine();
        System.out.println("\033[1;94m" + "Enter Connection Way:" + "\033[0m");
        System.out.println("1.Wireless");
        System.out.println("2.Wired");
        String des = input.nextLine();
        if (des.equals("1")) {
            GamingController gameC = new GamingController(systemKind, "Wireless", numberOfAccessory, title, info, price);
            gameC.getAdminAccessoriesSellers().add(admin);
            admin.getAccessories().add(gameC);
            AccessoriesManagement.getAccessoriesArr().add(gameC);
            AccessoriesManagement.getAccessoriesArr().get(AccessoriesManagement.getAccessoriesArr().indexOf(gameC)).setSystemKind(systemKind);
            AccessoriesManagement.getAccessoriesArr().get(AccessoriesManagement.getAccessoriesArr().indexOf(gameC)).setSystemConnection("Wireless");
            System.out.println("\nYour Accessory has been successfully created!\n");
            createAccessories();
        } else if (des.equals("2")) {
            GamingController gameC = new GamingController(systemKind, "Wired", numberOfAccessory, title, info, price);
            gameC.getAdminAccessoriesSellers().add(admin);
            admin.getAccessories().add(gameC);
            AccessoriesManagement.getAccessoriesArr().add(gameC);
            AccessoriesManagement.getAccessoriesArr().get(AccessoriesManagement.getAccessoriesArr().indexOf(gameC)).setSystemKind(systemKind);
            AccessoriesManagement.getAccessoriesArr().get(AccessoriesManagement.getAccessoriesArr().indexOf(gameC)).setSystemConnection("Wired");
            System.out.println("\nYour Accessory has been successfully created!\n");
            createAccessories();
        } else {
            System.out.println("Wrong entries");
            createAccessories();
        }
    }

    public void createGameMonitor() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Title:");
        String title = input.nextLine();
        System.out.println("Enter Price:");
        String price = input.nextLine();
        System.out.println("Enter Info:");
        String info = input.nextLine();
        System.out.println("Enter NumberOfAccessory:");
        String numberOfAccessory = input.nextLine();
        System.out.println("Enter Fps:");
        String fps = input.nextLine();
        System.out.println("Enter Size:");
        String size = input.nextLine();
        System.out.println("Enter AnswerTime:");
        String answerTime = input.nextLine();
        GamingMonitor gameM = new GamingMonitor(title, info, price, numberOfAccessory, fps, size, answerTime);
        gameM.getAdminAccessoriesSellers().add(admin);
        admin.getAccessories().add(gameM);
        AccessoriesManagement.getAccessoriesArr().add(gameM);
        AccessoriesManagement.getAccessoriesArr().get(AccessoriesManagement.getAccessoriesArr().indexOf(gameM)).setFps(fps);
        AccessoriesManagement.getAccessoriesArr().get(AccessoriesManagement.getAccessoriesArr().indexOf(gameM)).setSize(size);
        AccessoriesManagement.getAccessoriesArr().get(AccessoriesManagement.getAccessoriesArr().indexOf(gameM)).setAnswerTime(answerTime);
        System.out.println("\nYour Accessory has been successfully created!\n");
        createAccessories();
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

    public void gameManage() {
        System.out.println("\033[0;91m" + "game manage menu" + "\033[0m");
        System.out.println("1.create games");
        System.out.println("2.modify games or delete games");
        System.out.println("3.destruction report to developers");
        System.out.println("4.back");
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
                reportGame();
                break;
            case 4:
                startMenu(AdminManagement.getAdminsArr().indexOf(admin));
            default:
                break;
        }
    }

    public void reportGame() {
        System.out.println("\033[1;91m" + "Report Game Menu" + "\033[0m");
        for (int i = 0; i < GameManagement.getGamesArr().size(); i++) {
            System.out.println("\n" + "Title of game: " + "\033[1;93m" + GameManagement.getGamesArr().get(i).getTitle() + "\033[0m" + " Index of game is: " + i + "\n");
        }
        if (GameManagement.getGamesArr().size() == 0) {
            gameManage();
        }
        System.out.println("\nEnter index of the game you want:");
        Scanner input = new Scanner(System.in);
        int report = input.nextInt();
        List<Developer> sortedList = GameManagement.getGamesArr().get(report).getDevelopersOfGame().stream().sorted(Comparator.comparingInt(Developer::getScheduleEventSize)).toList();
        System.out.println("Enter ExpiryTime by minute:");
        int expiry = input.nextInt();
        InboxGames inboxGames = new InboxGames(GameManagement.getGamesArr().get(report), expiry, TimeUnit.MINUTES.convert(System.nanoTime(), TimeUnit.NANOSECONDS));
        sortedList.get(0).getInbox().add(inboxGames);
        gameManage();
    }

    public void createGame() {
        System.out.println("\033[1;92m" + "Create game menu" + "\033[0m");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter title:");
        String title = input.nextLine();
        System.out.println("Enter genre");
        String genre = input.nextLine();
        System.out.println("Enter info:");
        String info = input.nextLine();
        System.out.println("Enter price:");
        String price = input.nextLine();
        System.out.println("Enter level:");
        int level = input.nextInt();
        System.out.println("\033[1;94m" + "Enter game version:" + "\033[0m");
        System.out.println("1.Beta");
        System.out.println("2.Original");
        Scanner inputOne = new Scanner(System.in);
        String des = inputOne.nextLine();
        GameVersion gameVersion;
        if (des.equals("1")) {
            gameVersion = GameVersion.BETA;
        } else if (des.equals("2")) {
            gameVersion = GameVersion.ORIGINAL;
        } else {
            System.out.println("Wrong entries");
            gameVersion = GameVersion.ORIGINAL;
            createGame();
        }
        Game game = new Game(title, genre, info, price, level, gameVersion);
        GameManagement.getGamesArr().add(game);
        System.out.println("\nYour game has been succsessfully created!\n");
        gameManage();
    }

    public void searchGame() {
        Scanner input = new Scanner(System.in);
        System.out.println("\033[46m" + "Modify or Delete game menu" + "\033[0m");
        System.out.println("Enter name of game:");
        String name = input.nextLine();
        int count = 0;
        for (int i = 0; i < GameManagement.getGamesArr().size(); i++) {
            if (GameManagement.getGamesArr().get(i).getTitle().startsWith(name)) {
                System.out.println("name of game: " + GameManagement.getGamesArr().get(i).getTitle() +
                        " genre " + GameManagement.getGamesArr().get(i).getGenre() +
                        " info: " + GameManagement.getGamesArr().get(i).getInfo() + " index of game is: " +
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
                    GameManagement.getGamesArr().remove(index1);
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
        System.out.println("3.see most active users");
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
                seeMostActive();
            case 4:
                startMenu(AdminManagement.getAdminsArr().indexOf(admin));
            default:
                break;
        }
    }

    public void seeMostActive(){
        List<User> sortedList = UserManagement.getUsersArr().stream().sorted(Comparator.comparingInt(User::getScore)).toList();
        for (int i=0;i<sortedList.size();i++){
            System.out.println(sortedList.get(i).getUsername()+" with score: "+ sortedList.get(i).getScore());
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
