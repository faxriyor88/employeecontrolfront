package sample.dto;



public class ShowEmployee {
    private Integer id;
    private String fullname;
    private String district;
    private String company;
    private String birthday;
    private String lavozimivaQachondan;

    public ShowEmployee(Integer id, String fullname, String district, String company, String birthday, String lavozimivaQachondan) {
        this.id = id;
        this.fullname = fullname;
        this.district = district;
        this.company = company;
        this.birthday = birthday;
        this.lavozimivaQachondan = lavozimivaQachondan;
    }

    public Integer getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getDistrict() {
        return district;
    }

    public String getCompany() {
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
        return "ShowEmployee{" +
                "id='" + id + '\'' +
                ", fullname='" + fullname + '\'' +
                ", district='" + district + '\'' +
                ", company='" + company + '\'' +
                ", birthday='" + birthday + '\'' +
                ", lavozimivaQachondan='" + lavozimivaQachondan + '\'' +
                '}';
    }
}
