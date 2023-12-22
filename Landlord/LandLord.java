package Landlord;

public class LandLord {
    private String name;
    private String email;
    private String password;
    private String phone;
    private String address;

    public LandLord(String name, String email, String password, String phone, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

    public LandLord() {
        this.name = "";
        this.email = "";
        this.password = "";
        this.phone = "";
        this.address = "";
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword(){
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}
