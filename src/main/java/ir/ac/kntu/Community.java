package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Community {


    private List<User> userList = new ArrayList<User>();

    private String comments="comments:";

    private float Rating=0;

    private int ratingNumber = 0;

    public List<User> getUserList() {
        return userList;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getRatingNumber() {
        return ratingNumber;
    }

    public void setRatingNumber(int ratingNumber) {
        this.ratingNumber = ratingNumber;
    }

    public float getRating() {
        return Rating;
    }

    public void setRating(float rating) {
        Rating = rating;
    }


    public void start(int indexOfUser) {
        System.out.println("\033[1;95m" + "Community Menu" + "\033[0m");
        System.out.println("1.see community of users");
        System.out.println("2.add a comment");
        System.out.println("3.rate the game");
        System.out.println("4.back");
        Scanner input = new Scanner(System.in);
        int des = input.nextInt();
        switch (des) {
            case 1:
                showCommunity();
                break;
            case 2:
                addComment(indexOfUser);
                break;
            case 3:
                setRatingNumber(getRatingNumber() + 1);
                System.out.println("Enter your rate:");
                Scanner inputTwo = new Scanner(System.in);
                Float rate = inputTwo.nextFloat();
                setRating((rate + getRating()) / getRatingNumber());
                System.out.println("\nrate added successfully!\n");
                break;
            case 4:
                break;
            default:
                break;
        }
    }

    public void showCommunity() {
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i).getUsername());
        }
    }

    public void addComment(int indexOfUser) {
        System.out.println("Enter your comment:");
        Scanner inputOne = new Scanner(System.in);
        String comment = inputOne.nextLine();
        String oldCommuent = "\033[1;96m" + comments + "\033[0m";
        setComments(oldCommuent + "\n" + "Username: "
                + Sign.getUsersArr().get(indexOfUser).getUsername() + " commented: " + "\033[1;96m"
                + comment + "\033[0m");
        System.out.println("\ncomment added successfully!\n");
    }


}
