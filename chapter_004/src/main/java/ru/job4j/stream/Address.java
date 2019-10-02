package ru.job4j.stream;

public class Address {
    private String city;
    private String street;
    private int home;
    private int apartment;

    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHome() {
        return home;
    }

    public int getApartment() {
        return apartment;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof Address) {
            Address address = (Address) obj;
            if (this.getCity().equals(address.getCity())
                    && this.getStreet().equals(address.getStreet())
                    && this.getHome() == address.getHome()
                    && this.getApartment() == address.getApartment()) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public int hashCode() {
        return city.hashCode();
    }
}