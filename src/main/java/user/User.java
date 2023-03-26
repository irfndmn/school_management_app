package user;

public class User {

    public  String name;

    protected  String tcNo;

    public  String cinsiyet;

    public User() {

    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, String tcNo, String cinsiyet) {
        this.name = name;
        this.tcNo = tcNo;
        this.cinsiyet = cinsiyet;
    }

    public String getTcNo() {
        return tcNo;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", tcNo='" + tcNo + '\'' +
                ", cinsiyet='" + cinsiyet + '\'' +
                '}';
    }
}
