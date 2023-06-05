package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;

public class User {

    private UserMenu userMenu ;

    private String username;

    private String password;

    private String phoneNumber;

    private String email;

    private int wallet = 0;

    private long time;

    private long startTime;

    private int score;

    private String friendsRequest="Friends request:";

    private String friends="Friends:";

    private List<Game> gamesOfUser = new ArrayList<Game>();

    private List<Accessories> accessoriesOfUser = new ArrayList<Accessories>();

    public List<Game> getGamesOfUser() {
        return gamesOfUser;
    }

    public List<Accessories> getAccessoriesOfUser() {
        return accessoriesOfUser;
    }


    public User(String username, String password, String phoneNumber, String email) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        userMenu =new UserMenu();
    }

    public User() {
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public int getWallet() {
        return wallet;
    }

    public String getFriends() {
        return friends;
    }

    public String getFriendsRequest() {
        return friendsRequest;
    }

    public void setFriendsRequest(String friendsRequest) {
        this.friendsRequest = friendsRequest;
    }

    public void setFriends(String friends) {
        this.friends = friends;
    }



    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getLevel() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public UserMenu getUserMenu() {
        return userMenu;
    }

    public void setUserMenu(UserMenu userMenu) {
        this.userMenu = userMenu;
    }

    public int getScore() {
        return score;
    }
}
