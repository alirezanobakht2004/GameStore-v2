package ir.ac.kntu;

import java.util.Arrays;
import java.util.Scanner;

public class AccessoriesSellerMenu {
    private AccessoriesSeller accessoriesSeller;

    public void start(int i) {
        accessoriesSeller = AccessoriesSellerManagement.getAccessoriesSellerArr().get(i);
        if (accessoriesSeller.isAdmin()) {
            accessories();
        }
        for (String s : Arrays.asList("\033[1;93m" + "Welcome to AccessoriesSeller menu!" + "\033[0m", "1.Profile", "2.Accessories", "3.back")) {
            System.out.println(s);
        }
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        switch (n) {
            case 1:
                profile();
                break;
            case 2:
                accessories();
                break;
            case 3:
                Sign sign = new Sign();
                sign.sign();
                break;
            default:
                break;
        }
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
                start(AccessoriesSellerManagement.getAccessoriesSellerArr().indexOf(accessoriesSeller));
                break;
            default:
                break;
        }
    }

    public void showInfo() {
        System.out.println("your username:");
        System.out.println(accessoriesSeller.getAccessoriesSellerName());
        System.out.println("your password:");
        System.out.println(accessoriesSeller.getPassword());
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
                System.out.println("Enter new accSellerName:");
                Scanner inputOne = new Scanner(System.in);
                accessoriesSeller.setAccessoriesSellerName(inputOne.nextLine());
                System.out.println("\nyour username changed!\n");
                this.profile();
            }
            case 2 -> {
                System.out.println("Enter new password:");
                Scanner inputTwo = new Scanner(System.in);
                String pass = inputTwo.nextLine();
                accessoriesSeller.setPassword(inputTwo.nextLine());
                this.profile();
            }
            case 3 -> this.profile();
            default -> {
            }
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
                if (accessoriesSeller.isAdmin()) {
                    for (int i = 0; i < AdminManagement.getAdminsArr().size(); i++) {
                        if (AdminManagement.getAdminsArr().get(i).getAdminName().equals(accessoriesSeller.getAccessoriesSellerName())) {
                            if (AdminManagement.getAdminsArr().get(i).getPassword().equals(accessoriesSeller.getPassword())) {
                                AdminManagement.getAdminsArr().get(i).getAdminMenu().startMenu(i);
                            }
                        }
                    }
                }
                start(AccessoriesSellerManagement.getAccessoriesSellerArr().indexOf(accessoriesSeller));
            default:
                break;
        }
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
            GamingController gameC = new GamingController(systemKind, SystemConnection.WIRELESS, numberOfAccessory, title, info, price);
            gameC.getAccessoriesSellers().add(accessoriesSeller);
            accessoriesSeller.getAccessories().add(gameC);
            AccessoriesManagement.getAccessoriesArr().add(gameC);
            AccessoriesManagement.getAccessoriesArr().get(AccessoriesManagement.getAccessoriesArr().indexOf(gameC)).setSystemKind(systemKind);
            AccessoriesManagement.getAccessoriesArr().get(AccessoriesManagement.getAccessoriesArr().indexOf(gameC)).setSystemConnection(SystemConnection.WIRELESS);
            System.out.println("\nYour Accessory has been successfully created!\n");
            createAccessories();
        } else if (des.equals("2")) {
            GamingController gameC = new GamingController(systemKind, SystemConnection.WIRED, numberOfAccessory, title, info, price);
            gameC.getAccessoriesSellers().add(accessoriesSeller);
            accessoriesSeller.getAccessories().add(gameC);
            AccessoriesManagement.getAccessoriesArr().add(gameC);
            AccessoriesManagement.getAccessoriesArr().get(AccessoriesManagement.getAccessoriesArr().indexOf(gameC)).setSystemKind(systemKind);
            AccessoriesManagement.getAccessoriesArr().get(AccessoriesManagement.getAccessoriesArr().indexOf(gameC)).setSystemConnection(SystemConnection.WIRED);
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
        gameM.getAccessoriesSellers().add(accessoriesSeller);
        accessoriesSeller.getAccessories().add(gameM);
        AccessoriesManagement.getAccessoriesArr().add(gameM);
        AccessoriesManagement.getAccessoriesArr().get(AccessoriesManagement.getAccessoriesArr().indexOf(gameM)).setFps(fps);
        AccessoriesManagement.getAccessoriesArr().get(AccessoriesManagement.getAccessoriesArr().indexOf(gameM)).setSize(size);
        AccessoriesManagement.getAccessoriesArr().get(AccessoriesManagement.getAccessoriesArr().indexOf(gameM)).setAnswerTime(answerTime);
        System.out.println("\nYour Accessory has been successfully created!\n");
        createAccessories();
    }

    public void searchAccessories() {
        if (accessoriesSeller.isAdmin()) {
            System.out.println("Enter name of accessory you want:");
            Scanner inputOne = new Scanner(System.in);
            String t = inputOne.nextLine();
            int c = 0;
            for (int i = 0; i < AccessoriesManagement.getAccessoriesArr().size(); i++) {
                if (AccessoriesManagement.getAccessoriesArr().get(i).getTitle().startsWith(t)) {
                    System.out.println(AccessoriesManagement.getAccessoriesArr().get(i).getTitle() + " index: " + i);
                    c++;
                }
            }
            if (c == 0) {
                System.out.println("NO SUCH GAME FOUND!");
                accessories();
            }
        } else {
            int c = 0;
            System.out.println("\033[1;96m" + "Your Accessories" + "\033[0m");
            for (int i = 0; i < accessoriesSeller.getAccessories().size(); i++) {
                System.out.println("Accessory title: " + accessoriesSeller.getAccessories().get(i).getTitle() + " with index of: " + AccessoriesManagement.getAccessoriesArr().indexOf(accessoriesSeller.getAccessories().get(i)));
                c++;
            }
            if (c == 0) {
                accessories();
            }
        }
        Scanner input = new Scanner(System.in);
        System.out.println("\033[1;96m" + "Modify or Delete selection Menu" + "\033[0m");
        System.out.println("1.Modify Accessory");
        System.out.println("2.delete Accessory");
        System.out.println("3.back");
        int des = input.nextInt();
        switch (des) {
            case 1:
                System.out.println("enter the index of the accessory you want to modify:");
                int index = input.nextInt();
                if (AccessoriesManagement.getAccessoriesArr().get(index) instanceof GamingController) {
                    gameControllerModify(index);
                    accessories();
                } else {
                    gameMonitorModify(index);
                    accessories();
                }
                break;
            case 2:
                System.out.println("enter the index of the accessory you want to delete:");
                int index1 = input.nextInt();
                AccessoriesManagement.getAccessoriesArr().remove(index1);
                accessoriesSeller.getAccessories().remove(index1);
                System.out.println("\nYour Accessory has been successfully deleted!\n");
                accessories();
            case 3:
                accessories();
            default:
                break;
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
                System.out.println("Enter new:");
                Scanner inputOne = new Scanner(System.in);
                String title = inputOne.nextLine();
                AccessoriesManagement.getAccessoriesArr().get(i).setTitle(title);
                break;
            case 2:
                System.out.println("Enter new:");
                Scanner inputTwo = new Scanner(System.in);
                String titl = inputTwo.nextLine();
                AccessoriesManagement.getAccessoriesArr().get(i).setInfo(titl);
                break;
            case 3:
                System.out.println("Enter new:");
                Scanner inputThree = new Scanner(System.in);
                String tit = inputThree.nextLine();
                AccessoriesManagement.getAccessoriesArr().get(i).setPrice(tit);
                break;
            case 4:
                System.out.println("Enter new:");
                Scanner inputFour = new Scanner(System.in);
                String ti = inputFour.nextLine();
                AccessoriesManagement.getAccessoriesArr().get(i).setNumberOfAccessory(ti);
                break;
            case 5:
                if (AccessoriesManagement.getAccessoriesArr().get(i).getSystemConnection().equals(SystemConnection.WIRED)) {
                    AccessoriesManagement.getAccessoriesArr().get(i).setSystemConnection(SystemConnection.WIRELESS);
                } else {
                    AccessoriesManagement.getAccessoriesArr().get(i).setSystemConnection(SystemConnection.WIRED);
                }
                break;
            case 6:
                System.out.println("Enter new:");
                Scanner inputFive = new Scanner(System.in);
                String t = inputFive.nextLine();
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
                System.out.println("Enter new:");
                AccessoriesManagement.getAccessoriesArr().get(i).setTitle(inputOne.nextLine());
                break;
            case 2:
                System.out.println("Enter new:");
                AccessoriesManagement.getAccessoriesArr().get(i).setInfo(inputOne.nextLine());
                break;
            case 3:
                System.out.println("Enter new:");
                AccessoriesManagement.getAccessoriesArr().get(i).setPrice(inputOne.nextLine());
                break;
            case 4:
                System.out.println("Enter new:");
                AccessoriesManagement.getAccessoriesArr().get(i).setNumberOfAccessory(inputOne.nextLine());
                break;
            case 5:
                System.out.println("Enter new:");
                AccessoriesManagement.getAccessoriesArr().get(i).setFps(inputOne.nextLine());
                break;
            case 6:
                System.out.println("Enter new:");
                AccessoriesManagement.getAccessoriesArr().get(i).setSize(inputOne.nextLine());
                break;
            case 7:
                System.out.println("Enter new:");
                AccessoriesManagement.getAccessoriesArr().get(i).setAnswerTime(inputOne.nextLine());
            case 8:
                accessories();
            default:
                break;
        }
        accessories();
    }
}
