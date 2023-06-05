package ir.ac.kntu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DeveloperMenu {

    private Developer developer;

    public void start(int i) {
        developer = DeveloperManagement.getDevelopersArr().get(i);
        for (String s : Arrays.asList("\033[1;93m" + "Welcome to developer menu!" + "\033[0m", "1.Profile", "2.Games", "3.Inbox", "4.ScheduleEvent", "5.See Feedback", "6.Add Developers", "7.Back")) {
            System.out.println(s);
        }
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        switch (n) {
            case 1:
                profile();
                break;
            case 2:
                games();
                break;
            case 3:
                inbox();
                break;
            case 4:
                break;
            case 5:
                seeFeedback();
                break;
            case 6:
                break;
            case 7:
                Sign sign = new Sign();
                sign.sign();
                break;
            default:
                break;
        }
    }

    public void seeFeedback(){
        for (int i=0;i<developer.getFeedback().size();i++){
            System.out.println(developer.getFeedback().get(i));
        }
        start(DeveloperManagement.getDevelopersArr().indexOf(developer));
    }

    public void profile() {
        System.out.println("\033[1;96m" + "profile menu" + "\033[0m");
        for (String s : Arrays.asList("1.show information", "2.change information", "3.Back")) {
            System.out.println(s);
        }
        Scanner input = new Scanner(System.in);
        int in = input.nextInt();
        switch (in) {
            case 1:
                showInfo();
                break;
            case 2:
                changeInfo();
                break;
            case 3:
                start(DeveloperManagement.getDevelopersArr().indexOf(developer));
                break;
            default:
                break;
        }
    }

    public void showInfo() {
        System.out.println("your username:");
        System.out.println(developer.getDeveloperName());
        System.out.println("your password:");
        System.out.println(developer.getPassword());
        System.out.println("\n Enter 1 for back");
        System.out.println(" Enter 2 for exit");
        Scanner input = new Scanner(System.in);
        int back = input.nextInt();
        if (back == 1) {
            this.profile();
        }
        if (back == 2) {
            System.exit(0);
        }
    }

    public void changeInfo() {
        Scanner input = new Scanner(System.in);
        for (String s : Arrays.asList("\033[1;97m" + "edit profile menu" + "\033[0m", "1.change developerName", "2.change password", "3.back")) {
            System.out.println(s);
        }
        int inner = input.nextInt();
        switch (inner) {
            case 1 -> {
                System.out.println("Enter new developerName:");
                Scanner inputOne = new Scanner(System.in);
                developer.setDeveloperName(inputOne.nextLine());
                System.out.println("\nyour username changed!\n");
                this.profile();
            }
            case 2 -> {
                System.out.println("Enter new password:");
                Scanner inputTwo = new Scanner(System.in);
                String pass = inputTwo.nextLine();
                developer.setPassword(inputTwo.nextLine());
                this.profile();
            }
            case 3 -> this.profile();
            default -> {
            }
        }

    }


    public void games() {
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
                start(DeveloperManagement.getDevelopersArr().indexOf(developer));
            default:
                break;
        }
    }

    public void createGame() {
        System.out.println("\033[1;94m" + "Create game menu" + "\033[0m");
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
        String des = input.nextLine();
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
        Game game = new Game(title, genre, info, price,level, gameVersion);
        game.getDevelopersOfGame().add(developer);
        GameManagement.getGamesArr().add(game);
        developer.getDeveloperGames().add(game);
        System.out.println("\nYour game has been succsessfully created!\n");
        games();
    }

    public void searchGame() {
        Scanner input = new Scanner(System.in);
        System.out.println("\033[1;96m" + "Your Games" + "\033[0m");
        for (int i = 0; i < developer.getDeveloperGames().size(); i++) {
            System.out.println("Game title: " + developer.getDeveloperGames().get(i).getTitle() + " with index of: " + i);
        }
        System.out.println("\033[1;96m" + "Modify or Delete selection Menu" + "\033[0m");
        System.out.println("1.Modify game");
        System.out.println("2.delete game");
        System.out.println("3.back");
        int des = input.nextInt();
        switch (des) {
            case 1:
                System.out.println("enter the index of the game you want to modify:");
                int index = input.nextInt();
                gameModify(index);
                break;
            case 2:
                System.out.println("enter the index of the game you want to delete:");
                int index1 = input.nextInt();
                GameManagement.getGamesArr().remove(index1);
                developer.getDeveloperGames().remove(index1);
                System.out.println("\nYour game has been successfully deleted!\n");
                break;
            case 3:
                games();
            default:
                break;
        }

    }

    public void gameModify(int i) {
        Scanner input = new Scanner(System.in);
        System.out.println("\033[0;91m" + "game modify menu" + "\033[0m");
        System.out.println("1.change title");
        System.out.println("2.change genre");
        System.out.println("3.change info");
        System.out.println("4.change price");
        System.out.println("5.back");
        int in = input.nextInt();
        switch (in) {
            case 1 -> {
                System.out.println("Enter new title:");
                Scanner inputOne = new Scanner(System.in);
                GameManagement.getGamesArr().get(i).setTitle(inputOne.nextLine());
                System.out.println("your game title changed!");
                gameModify(i);
            }
            case 2 -> {
                System.out.println("Enter new genre:");
                Scanner inputTwo = new Scanner(System.in);
                GameManagement.getGamesArr().get(i).setGenre(inputTwo.nextLine());
                System.out.println("your game genre changed!");
                gameModify(i);
            }
            case 3 -> {
                System.out.println("Enter new info:");
                Scanner inputThree = new Scanner(System.in);
                GameManagement.getGamesArr().get(i).setInfo(inputThree.nextLine());
                System.out.println("your game info changed!");
                gameModify(i);
            }
            case 4 -> {
                System.out.println("Enter new price:");
                Scanner inputFour = new Scanner(System.in);
                GameManagement.getGamesArr().get(i).setPrice(inputFour.nextLine());
                System.out.println("your game price changed!");
                gameModify(i);
            }
            case 5 -> {
                games();
            }
            default -> {
                break;
            }
        }
    }

    public void inbox() {
        for (int i = 0; i < developer.getInbox().size(); i++) {
            System.out.println(i + "." + "\033[0;91m" + developer.getInbox().get(i) + "\033[0m");
        }
        System.out.println("1.accept or reject a request:");
        System.out.println("2.back");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        switch (n) {
            case 1:
                accRej();
                break;
            case 2:
                start(DeveloperManagement.getDevelopersArr().indexOf(developer));
                break;
            default:
                break;
        }
    }

    public void accRej() {
        System.out.println("\033[1;96m" + "Accept & Reject Menu" + "\033[0m");
        System.out.println("1.Accept");
        System.out.println("2.Reject");
        System.out.println("3.Back");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        switch (n) {
            case 1:
                System.out.println("Enter index of request to add schedule event list:");
                int index = input.nextInt();
                developer.getScheduleEvent().add(developer.getInbox().get(index));
                developer.getInbox().remove(index);
                System.out.println("added schedule event list");
                break;
            case 2:
                System.out.println("Enter index of request to remove:");
                int indexTwo = input.nextInt();
                List<Developer> sortedList = GameManagement.getGamesArr().get(indexTwo).getDevelopersOfGame().stream().sorted(Comparator.comparingInt(Developer::getScheduleEventSize)).toList();
                sortedList.get(0).getInbox().add(developer.getInbox().get(indexTwo));
                developer.getInbox().remove(indexTwo);
                break;
            case 3:
                inbox();
                break;
            default:
                break;
        }
        inbox();
    }
}
