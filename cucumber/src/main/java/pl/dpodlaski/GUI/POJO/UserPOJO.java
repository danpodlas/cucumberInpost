package pl.dpodlaski.GUI.POJO;


import com.github.javafaker.Faker;

public class UserPOJO {

    Faker faker = new Faker();

    public UserPOJO() {
    }

    String name;
    String surname;
    String email;
    String phone;
    String country;
    String region;
    String city;
    String pathCV;
    String money;

    public UserPOJO(String name, String surname, String email, String phone, String country, String region, String city, String pathCV, String money) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.country = country;
        this.region = region;
        this.city = city;
        this.pathCV = pathCV;
        this.money = money;
    }


    public UserPOJO generateRandomUser(){
        UserPOJO randomUser = new UserPOJO(faker.name().firstName(), faker.name().lastName(),faker.internet().emailAddress(),faker.phoneNumber().phoneNumber(),
                "Polska","mazowieckie",faker.address().city(),"src/main/resources/files/CVTest.pdf",faker.random().nextInt(3,4).toString());
        return randomUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPathCV() {
        return pathCV;
    }

    public void setPathCV(String pathCV) {
        this.pathCV = pathCV;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
