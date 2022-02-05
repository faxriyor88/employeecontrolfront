package sample.model;

import lombok.Data;

@Data
public class Company {

    private Integer id;
    private String companyname;

    private Region region;

    public Company(String companyname, Region region) {
        this.companyname = companyname;
        this.region = region;
    }


}
