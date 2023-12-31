package ir.ac.kntu;

import java.util.*;

public class StoreMenu {

    int indexOfUser;

    public void start(int t) {
        indexOfUser = t;
        System.out.println("\033[1;94m" + "welcome to store" + "\033[0m");
        System.out.println("1.Show all games and accessories");
        System.out.println("2.Search game and accessories");
        System.out.println("3.Filter games and accessories by price");
        System.out.println("4.See Best Sellers");
        System.out.println("5.back");
        try {
            Scanner input = new Scanner(System.in);
            switch (input.nextInt()) {
                case 1:
                    showGamesAndAcc();
                    break;
                case 2:
                    searchGameAndAcc();
                    break;
                case 3:
                    filterPrice();
                    break;
                case 4:
                    bestSellers();
                    break;
                case 5:
                    UserManagement.getUsersArr().get(indexOfUser).getUserMenu().userMenu(indexOfUser);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println("\nwrong entry!");
            start(indexOfUser);
        }
    }

    public void bestSellers() {
        List<Game> sortedList = new ArrayList<>(GameManagement.getGamesArr().stream().sorted(Comparator.comparingInt(Game::getNumberBought)).toList());
        Collections.reverse(sortedList);
        List<Accessories> sortedListTwo = new ArrayList<>(AccessoriesManagement.getAccessoriesArr().stream().sorted(Comparator.comparingInt(Accessories::getNumberBought)).toList());
        Collections.reverse(sortedListTwo);
        System.out.println("\033[1;93m" + "Best seller games" + "\033[0m");
        for (int i = 0; i < sortedList.size(); i++) {
            System.out.println("Title: " + sortedList.get(i).getTitle() + " sold " + sortedList.get(i).getNumberBought() + " times");
        }
        System.out.println("\033[1;93m" + "Best seller Accessories" + "\033[0m");
        for (int i = 0; i < sortedListTwo.size(); i++) {
            System.out.println("Title: " + sortedListTwo.get(i).getTitle() + " sold " + sortedListTwo.get(i).getNumberBought() + " times");
        }
        start(indexOfUser);
    }

    public void showGamesAndAcc() {
        for (int i = 0; i < GameManagement.getGamesArr().size(); i++) {
            String game = "* Title of game: " + "\033[1;93m" + GameManagement.getGamesArr().get(i).getTitle() + "\033[0m" + " Index of game is: " + i + " *";
            System.out.println();
            for (int u = 0; u < game.length() - 11; u++) {
                System.out.print('*');
            }
            System.out.println();
            System.out.println(game);
            for (int u = 0; u < game.length() - 11; u++) {
                System.out.print('*');
            }
        }
        for (int i = 0; i < AccessoriesManagement.getAccessoriesArr().size(); i++) {
            String acc = "| Title of accessory: " + "\033[1;93m" + AccessoriesManagement.getAccessoriesArr().get(i).getTitle() + "\033[0m" + " Index of accessory is: " + i + " |";
            printkhat(acc);
            System.out.println(acc);
            printkhat(acc);
        }
        printShowGames();
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        switch (t) {
            case 1:
                System.out.println("\nEnter index of the game you want:");
                Scanner inputOne = new Scanner(System.in);
                showGame(inputOne.nextInt());
                break;
            case 2:
                System.out.println("\nEnter index of the accessory you want:");
                Scanner inputTwo = new Scanner(System.in);
                showAccessory(inputTwo.nextInt());
                break;
            case 3:
                sumItems(0);
                break;
            case 4:
                start(indexOfUser);
                break;
            default:
                break;
        }
    }

    public void printkhat(String acc) {
        System.out.println();
        for (int u = 0; u < acc.length() - 11; u++) {
            System.out.print('-');
        }
        System.out.println();
    }

    public void printShowGames() {
        System.out.println();
        System.out.println("Do you want to see games or accessories?");
        System.out.println("1.Game");
        System.out.println("2.Accessory");
        System.out.println("3.Seeing sum of few items price");
        System.out.println("4.Back");
    }

    public void sumItems(int count) {
        System.out.println("Enter Item Category");
        System.out.println("1.Game");
        System.out.println("2.Accessory");
        System.out.println("3.back");
        Scanner input = new Scanner(System.in);
        int d = input.nextInt();
        switch (d) {
            case 1:
                System.out.println("Enter index of game");
                int t = input.nextInt();
                count += GameManagement.getGamesArr().get(t).getPrice();
                System.out.println(count);
                System.out.println("1.continue");
                System.out.println("2.back");
                int k = input.nextInt();
                if (k == 1) {
                    sumItems(count);
                } else {
                    showGamesAndAcc();
                }
                break;
            case 2:
                System.out.println("Enter index of accessory");
                int o = input.nextInt();
                count += AccessoriesManagement.getAccessoriesArr().get(o).getPrice();
                System.out.println(count);
                System.out.println("1.continue");
                System.out.println("2.back");
                int u = input.nextInt();
                if (u == 1) {
                    sumItems(count);
                } else {
                    showGamesAndAcc();
                }
                break;
            case 3:
                showGamesAndAcc();
                break;
            default:
                break;
        }
    }

    public void showAccessory(int i) {
        Accessories acc = AccessoriesManagement.getAccessoriesArr().get(i);
        beforeShowAccessory(acc, i);
        System.out.println("1." + "\033[1;92m" + "Buy the accessory" + "\033[0m");
        System.out.println("2.Back");
        Scanner input = new Scanner(System.in);
        int in = input.nextInt();
        switch (in) {
            case 1:
                if (UserManagement.getUsersArr().get(indexOfUser).getWallet() >= acc.getPrice()) {
                    if (acc.getNumberOfAccessory() > 0) {
                        if (UserManagement.getUsersArr().get(indexOfUser).getAccessoriesOfUser().contains(acc)) {
                            acc.setNumberBought(acc.getNumberBought() + 1);
                            acc.setNumberOfAccessory(acc.getNumberOfAccessory() - 1);
                            UserManagement.getUsersArr().get(indexOfUser).setWallet(UserManagement.getUsersArr().get(indexOfUser).getWallet() - acc.getPrice());
                            System.out.println("\n" + "You bought the accessory again!" + "\n");
                        } else {
                            acc.setNumberBought(acc.getNumberBought() + 1);
                            acc.setNumberOfAccessory(acc.getNumberOfAccessory() - 1);
                            UserManagement.getUsersArr().get(indexOfUser).getAccessoriesOfUser().add(acc);
                            acc.getCommunity().getUserList().add(UserManagement.getUsersArr().get(indexOfUser));
                            UserManagement.getUsersArr().get(indexOfUser).setWallet(UserManagement.getUsersArr().get(indexOfUser).getWallet() - acc.getPrice());
                            System.out.println("\n" + "You bought the accessory successfully!" + "\n");
                        }
                    } else {
                        System.out.println("not enough in storage!");
                    }

                } else {
                    System.out.println("\033[1;91m" + "Not enough money in wallet" + "\033[0m");
                }
                break;
            case 2:
                start(indexOfUser);
                break;
            default:
                break;
        }
        start(indexOfUser);
    }

    public void beforeShowAccessory(Accessories acc, int i) {
        if (acc.getFps() == null) {
            for (String s : Arrays.asList("\n" + "Title of accessory: " + "\033[1;93m" + acc.getTitle() + "\033[0m", "\n" + "Info of accessory: " + "\033[1;93m" + acc.getInfo() + "\033[0m", "\n" + "price of accessory: " + "\033[1;93m" + acc.getPrice() + "\033[0m", "\n" + "systemConnection of accessory: " + "\033[1;93m" + acc.getSystemConnection() + "\033[0m", "\n" + "systemKind of accessory: " + "\033[1;93m" + acc.getSystemKind() + "\033[0m")) {
                System.out.println(s);
            }
        } else {
            for (String s : Arrays.asList("\n" + "Title of accessory: " + "\033[1;93m" + acc.getTitle() + "\033[0m", "\n" + "Info of accessory: " + "\033[1;93m" + acc.getInfo() + "\033[0m", "\n" + "price of accessory: " + "\033[1;93m" + acc.getPrice() + "\033[0m", "\n" + "fps of accessory: " + "\033[1;93m" + acc.getFps() + "\033[0m", "\n" + "size of accessory: " + "\033[1;93m" + acc.getSize() + "\033[0m", "\n" + "answerTime of accessory: " + "\033[1;93m" + acc.getAnswerTime() + "\033[0m")) {
                System.out.println(s);
            }
        }
    }

    public void showGame(int i) {
        for (String s : Arrays.asList("\n" + "Title of game: " + "\033[1;93m" + GameManagement.getGamesArr().get(i).getTitle() + "\033[0m", "\n" + "Info of game: " + "\033[1;93m" + GameManagement.getGamesArr().get(i).getInfo() + "\033[0m", "\n" + "level of game: " + "\033[1;93m" + GameManagement.getGamesArr().get(i).getLevel() + "\033[0m", "\n" + "genre of game: " + "\033[1;93m" + GameManagement.getGamesArr().get(i).getGenre() + "\033[0m", "\n" + "price of game: " + "\033[1;93m" + GameManagement.getGamesArr().get(i).getPrice() + "\033[0m", "\n" + "version of game: " + "\033[1;93m" + GameManagement.getGamesArr().get(i).getVersion() + "\033[0m")) {
            System.out.println(s);
        }
        if (GameManagement.getGamesArr().get(i).getVersion() == GameVersion.ORIGINAL) {
            System.out.println("\n" + "rating of game: " + "\033[1;93m" + GameManagement.getGamesArr().get(i).getCommunity().getRating() + "\033[0m");
            System.out.println("\n" + GameManagement.getGamesArr().get(i).getCommunity().getComments() + "\n");
        }
        if (!UserManagement.getUsersArr().get(indexOfUser).getGamesOfUser().contains(GameManagement.getGamesArr().get(i))) {
            float afterDiscountPercent = (100 - levelScore(i)) / (float) 100;
            System.out.println("2.Back");
            Scanner input = new Scanner(System.in);
            int in = input.nextInt();
            switch (in) {
                case 1:
                    if (UserManagement.getUsersArr().get(indexOfUser).getWallet() >= afterDiscountPercent * GameManagement.getGamesArr().get(i).getPrice()) {
                        UserManagement.getUsersArr().get(indexOfUser).getGamesOfUser().add(GameManagement.getGamesArr().get(i));
                        GameManagement.getGamesArr().get(i).getCommunity().getUserList().add(UserManagement.getUsersArr().get(indexOfUser));
                        UserManagement.getUsersArr().get(indexOfUser).setWallet(
                                UserManagement.getUsersArr().get(indexOfUser).getWallet()
                                        - afterDiscountPercent * GameManagement.getGamesArr().get(i).getPrice());
                        GameManagement.getGamesArr().get(i).setNumberBought(GameManagement.getGamesArr().get(i).getNumberBought() + 1);
                        System.out.println("\n" + "You bought the game successfully!" + "\n");
                    } else {
                        System.out.println("\033[1;91m" + "Not enough money in wallet" + "\033[0m");
                    }
                    break;
                case 2:
                    start(indexOfUser);
                    break;
                default:
                    break;
            }
        }
        start(indexOfUser);
    }

    public float levelScore(int i) {
        if (GameManagement.getGamesArr().get(i).getLevel() == 1) {
            System.out.println("1." + "\033[1;92m" + "Buy the game with 0% discount" + "\033[0m");
            return 0;
        }
        if (GameManagement.getGamesArr().get(i).getLevel() == 2 && UserManagement.getUsersArr().get(indexOfUser).getScore() >= 2) {
            System.out.println("1." + "\033[1;92m" + "Buy the game with 10% discount" + "\033[0m");
            return 10;
        }
        if (GameManagement.getGamesArr().get(i).getLevel() == 3 && UserManagement.getUsersArr().get(indexOfUser).getScore() >= 3) {
            System.out.println("1." + "\033[1;92m" + "Buy the game with 20% discount" + "\033[0m");
            return 20;
        }
        if (GameManagement.getGamesArr().get(i).getLevel() == 4 && UserManagement.getUsersArr().get(indexOfUser).getScore() >= 4) {
            System.out.println("1." + "\033[1;92m" + "Buy the game with 30% discount" + "\033[0m");
            return 30;
        }
        System.out.println("\033[1;91m" + "\n not enough score to buy the game!\n" + "\033[0m");
        return 0;
    }

    public void searchGameAndAcc() {
        Scanner input = new Scanner(System.in);
        for (String s : Arrays.asList("\033[46m" + "Search game and accessory menu" + "\033[0m", "Enter what do you want to search?", "1.Games", "2.Accessories")) {
            System.out.println(s);
        }
        int t = input.nextInt();
        switch (t) {
            case 1:
                gameSearchResult();
                break;
            case 2:
                accessorySearchResult();
                break;
            default:
                break;
        }
        start(indexOfUser);
    }

    public void gameSearchResult() {
        Scanner input = new Scanner(System.in);
        System.out.println("\n" + "You can type ### and enter to comeback\n");
        System.out.println("Enter name of game:");
        String name = input.nextLine();
        if (name.equals("###")) {
            start(indexOfUser);
        }
        int count = 0;
        for (int i = 0; i < GameManagement.getGamesArr().size(); i++) {
            if (GameManagement.getGamesArr().get(i).getTitle().startsWith(name)) {
                System.out.println("name of game: " + GameManagement.getGamesArr().get(i).getTitle() +
                        " genre: " + GameManagement.getGamesArr().get(i).getGenre() +
                        " info: " + GameManagement.getGamesArr().get(i).getInfo() + " index of game is: " +
                        "\033[1;93m" + i + "\033[0m");
                count++;
            }
        }
        if (count == 0) {
            System.out.println("there was no such a game!");
            searchGameAndAcc();
        } else {
            System.out.println("\033[1;96m" + "Enter the index of the game you want to see:" + "\033[0m");
            int des = input.nextInt();
            showGame(des);
        }
    }

    public void accessorySearchResult() {
        int categoryChecker = 0;
        Scanner input1 = new Scanner(System.in);
        System.out.println("1.search among all accessories");
        System.out.println("2.search by category");
        System.out.println("3.back");
        int y = input1.nextInt();
        categoryChecker = kindChecker(y);
        Scanner input = new Scanner(System.in);
        System.out.println("\n" + "You can type ### and enter to comeback\n");
        System.out.println("Enter name of accessory:");
        String name = input.nextLine();
        if (name.equals("###")) {
            start(indexOfUser);
        }
        int count = 0;
        switch (categoryChecker) {
            case 0:
                count = categoryCheckerOne(name);
                break;
            case 1:
                count = categoryCheckerTwo(name);
                break;
            case 2:
                count = categoryCheckerThree(name);
                break;
            case 3:
                count = categoryCheckerFour(name);
                break;
            default:
                break;
        }
        if (count == 0) {
            System.out.println("there was no such a accessory!");
            searchGameAndAcc();
        } else {
            System.out.println("\033[1;96m" + "Enter the index of the accessory you want to see:" + "\033[0m");
            int des = input.nextInt();
            showAccessory(des);
        }
    }

    public int kindChecker(int y) {
        Scanner input1 = new Scanner(System.in);
        switch (y) {
            case 1:
                return 0;
            case 2:
                System.out.println("1.search among game monitors\n2.search among game controllers\n3.back\"");
                int r = input1.nextInt();
                switch (r) {
                    case 1:
                        return 1;
                    case 2:
                        System.out.println("1.wired\n2.wireless\n3.back\"");
                        int k = input1.nextInt();
                        switch (k) {
                            case 1:
                                return 2;
                            case 2:
                                return 3;
                            case 3:
                                accessorySearchResult();
                                break;
                            default:
                                break;
                        }
                        break;
                    case 3:
                        accessorySearchResult();
                        break;
                    default:
                        break;
                }
                break;
            case 3:
                start(indexOfUser);
                break;
            default:
                break;
        }
        return 0;
    }

    public int categoryCheckerOne(String name) {
        int count = 0;
        for (int i = 0; i < AccessoriesManagement.getAccessoriesArr().size(); i++) {
            if (AccessoriesManagement.getAccessoriesArr().get(i).getTitle().startsWith(name)) {
                System.out.println("name of accessory: " + AccessoriesManagement.getAccessoriesArr().get(i).getTitle() + " index of accessory is: " +
                        "\033[1;93m" + i + "\033[0m");
                count++;
            }
        }
        return count;
    }

    public int categoryCheckerTwo(String name) {
        int count = 0;
        for (int i = 0; i < AccessoriesManagement.getAccessoriesArr().size(); i++) {
            if (AccessoriesManagement.getAccessoriesArr().get(i).getTitle().startsWith(name)) {
                if (AccessoriesManagement.getAccessoriesArr().get(i).getSize() != null) {
                    System.out.println("name of accessory: " + AccessoriesManagement.getAccessoriesArr().get(i).getTitle() + " index of accessory is: " +
                            "\033[1;93m" + i + "\033[0m");
                    count++;
                }
            }
        }
        return count;
    }

    public int categoryCheckerThree(String name) {
        int count = 0;
        for (int i = 0; i < AccessoriesManagement.getAccessoriesArr().size(); i++) {
            if (AccessoriesManagement.getAccessoriesArr().get(i).getTitle().startsWith(name)) {
                if (AccessoriesManagement.getAccessoriesArr().get(i).getSystemConnection() == SystemConnection.WIRED) {
                    System.out.println("name of accessory: " + AccessoriesManagement.getAccessoriesArr().get(i).getTitle() + " index of accessory is: " +
                            "\033[1;93m" + i + "\033[0m");
                    count++;
                }
            }
        }
        return count;
    }

    public int categoryCheckerFour(String name) {
        int count = 0;
        for (int i = 0; i < AccessoriesManagement.getAccessoriesArr().size(); i++) {
            if (AccessoriesManagement.getAccessoriesArr().get(i).getTitle().startsWith(name)) {
                if (AccessoriesManagement.getAccessoriesArr().get(i).getSystemConnection() == SystemConnection.WIRELESS) {
                    System.out.println("name of accessory: " + AccessoriesManagement.getAccessoriesArr().get(i).getTitle() + " index of accessory is: " +
                            "\033[1;93m" + i + "\033[0m");
                    count++;
                }
            }
        }
        return count;
    }

    public void filterPrice() {
        System.out.println("\033[0;101m" + "Filter by price menu" + "\033[0m");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter lower level:");
        int low = input.nextInt();
        System.out.println("Enter higher level:");
        int count = 0;
        int high = input.nextInt();
        for (int i = 0; i < GameManagement.getGamesArr().size(); i++) {
            if (GameManagement.getGamesArr().get(i).getPrice() <= high && GameManagement.getGamesArr().get(i).getPrice() >= low) {
                System.out.println("name of game: " + GameManagement.getGamesArr().get(i).getTitle() + " genre: " + GameManagement.getGamesArr().get(i).getGenre() + " info: " + GameManagement.getGamesArr().get(i).getInfo() + " index of game is: " + "\033[1;93m" + i + "\033[0m");
                count++;
            }
        }
        for (int i = 0; i < AccessoriesManagement.getAccessoriesArr().size(); i++) {
            if (AccessoriesManagement.getAccessoriesArr().get(i).getPrice() <= high && AccessoriesManagement.getAccessoriesArr().get(i).getPrice() >= low) {
                System.out.println("name of accessory: " + AccessoriesManagement.getAccessoriesArr().get(i).getTitle() + " index of accessory is: " + "\033[1;93m" + i + "\033[0m");
                count++;
            }
        }
        if (count == 0) {
            System.out.println("there was no such a game or accessory!");
            start(indexOfUser);
        } else {
            System.out.println("1.see game\n2.see accessory");
            int f = input.nextInt();
            if (f == 1) {
                System.out.println("\033[1;96m" + "Enter the index of the game you want to see:" + "\033[0m");
                int des = input.nextInt();
                showGame(des);
            } else {
                System.out.println("\033[1;96m" + "Enter the index of the accessory you want to see:" + "\033[0m");
                int des1 = input.nextInt();
                showAccessory(des1);
            }
        }
    }
}
