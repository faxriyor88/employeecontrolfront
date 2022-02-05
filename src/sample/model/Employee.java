package sample.model;


import java.util.UUID;


public class Employee /*extends AbstractEntity*/ {

    private UUID id;
    private String fullname;

    private District district;

    private Company company;
    private String birthday;
    private String lavozimivaQachondan;


    public Employee(String fullname, District district, Company company, String birthday, String lavozimivaQachondan) {
        this.fullname = fullname;
        this.district = district;
        this.company = company;
        this.birthday = birthday;
        this.lavozimivaQachondan = lavozimivaQachondan;
    }

    public UUID getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public District getDistrict() {
        return district;
    }

    public Company getCompany() {
        return company;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getLavozimivaQachondan() {
        return lavozimivaQachondan;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", district=" + district +
                ", company=" + company +
                ", birthday='" + birthday + '\'' +
                ", lavozimivaQachondan='" + lavozimivaQachondan + '\'' +
                '}';
    }
}
