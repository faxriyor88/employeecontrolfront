package sample.model;


public class District {

    private Integer id;
    private String districtname;

    private Region region;

    public District(String districtname, Region region) {
        this.districtname = districtname;
        this.region = region;
    }

    public Integer getId() {
        return id;
    }

    public String getDistrictname() {
        return districtname;
    }

    public Region getRegion() {
        return region;
    }

    @Override
    public String toString() {
        return "District{" +
                "id=" + id +
                ", districtname='" + districtname + '\'' +
                ", region=" + region +
                '}';
    }
}
