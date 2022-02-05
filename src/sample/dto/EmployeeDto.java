package sample.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
public class EmployeeDto {
    String fullname;
    Integer regionId;
    Integer districtId;
    Integer companyId;
    private String lavozimivaQachondan;

    private List<InformationAboutRelativeDTO> aboutRelative;
    private String birthday;
    private String nationality;
    private String malumoti;
    private String malumotiboyichamutaxasisligi;
    private String ilmiydarajasi;
    private String ilmiyunvoni;
    private String chettillari;
    private String davlatmukofotibilantaqdirlanganligiqanaqa;
    private String saylovorganiazosi;
    private String partiyaviyligi;
    private String tamomlaganjoyi;
    private String harbiyunvoni;
    private List<MehnatFaoliyatiDto> mehnatfaoliyati;

    public EmployeeDto(String fullname, Integer regionId, Integer districtId, Integer companyId, String lavozimivaQachondan, List<InformationAboutRelativeDTO> aboutRelative, String birthday, String nationality, String malumoti, String malumotiboyichamutaxasisligi, String ilmiydarajasi, String ilmiyunvoni, String chettillari, String davlatmukofotibilantaqdirlanganligiqanaqa, String saylovorganiazosi, String partiyaviyligi, String tamomlaganjoyi, String harbiyunvoni, List<MehnatFaoliyatiDto> mehnatfaoliyati) {
        this.fullname = fullname;
        this.regionId = regionId;
        this.districtId = districtId;
        this.companyId = companyId;
        this.lavozimivaQachondan = lavozimivaQachondan;
        this.aboutRelative = aboutRelative;
        this.birthday = birthday;
        this.nationality = nationality;
        this.malumoti = malumoti;
        this.malumotiboyichamutaxasisligi = malumotiboyichamutaxasisligi;
        this.ilmiydarajasi = ilmiydarajasi;
        this.ilmiyunvoni = ilmiyunvoni;
        this.chettillari = chettillari;
        this.davlatmukofotibilantaqdirlanganligiqanaqa = davlatmukofotibilantaqdirlanganligiqanaqa;
        this.saylovorganiazosi = saylovorganiazosi;
        this.partiyaviyligi = partiyaviyligi;
        this.tamomlaganjoyi = tamomlaganjoyi;
        this.harbiyunvoni = harbiyunvoni;
        this.mehnatfaoliyati = mehnatfaoliyati;
    }

    public String getFullname() {
        return fullname;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public String getLavozimivaQachondan() {
        return lavozimivaQachondan;
    }

    public List<InformationAboutRelativeDTO> getAboutRelative() {
        return aboutRelative;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getNationality() {
        return nationality;
    }

    public String getMalumoti() {
        return malumoti;
    }

    public String getMalumotiboyichamutaxasisligi() {
        return malumotiboyichamutaxasisligi;
    }

    public String getIlmiydarajasi() {
        return ilmiydarajasi;
    }

    public String getIlmiyunvoni() {
        return ilmiyunvoni;
    }

    public String getChettillari() {
        return chettillari;
    }

    public String getDavlatmukofotibilantaqdirlanganligiqanaqa() {
        return davlatmukofotibilantaqdirlanganligiqanaqa;
    }

    public String getSaylovorganiazosi() {
        return saylovorganiazosi;
    }

    public String getPartiyaviyligi() {
        return partiyaviyligi;
    }

    public String getTamomlaganjoyi() {
        return tamomlaganjoyi;
    }

    public String getHarbiyunvoni() {
        return harbiyunvoni;
    }

    public List<MehnatFaoliyatiDto> getMehnatfaoliyati() {
        return mehnatfaoliyati;
    }
}

//import java.util.List;
//
//
//public class EmployeeDto {
//    String fullname;
//    Integer regionId;
//    Integer districtId;
//    Integer companyId;
//    private String lavozimivaQachondan;
//
//    private List<InformationAboutRelativeDTO> aboutRelative;
//    private String birthday;
//    private String nationality;
//    private String malumoti;
//    private String malumotiboyichamutaxasisligi;
//    private String ilmiydarajasi;
//    private String ilmiyunvoni;
//    private String chettillari;
//    private String davlatmukofotibilantaqdirlanganligiqanaqa;
//    private String saylovorganiazosi;
//    private String partiyaviyligi;
//    private String tamomlaganjoyi;
//    private String harbiyunvoni;
//    private String mehnatfaoliyati;
//
//    public EmployeeDto(String fullname, Integer regionId, Integer districtId, Integer companyId, String lavozimivaQachondan, List<InformationAboutRelativeDTO> aboutRelative, String birthday, String nationality, String malumoti, String malumotiboyichamutaxasisligi, String ilmiydarajasi, String ilmiyunvoni, String chettillari, String davlatmukofotibilantaqdirlanganligiqanaqa, String saylovorganiazosi, String partiyaviyligi, String tamomlaganjoyi, String harbiyunvoni, String mehnatfaoliyati) {
//        this.fullname = fullname;
//        this.regionId = regionId;
//        this.districtId = districtId;
//        this.companyId = companyId;
//        this.lavozimivaQachondan = lavozimivaQachondan;
//        this.aboutRelative = aboutRelative;
//        this.birthday = birthday;
//        this.nationality = nationality;
//        this.malumoti = malumoti;
//        this.malumotiboyichamutaxasisligi = malumotiboyichamutaxasisligi;
//        this.ilmiydarajasi = ilmiydarajasi;
//        this.ilmiyunvoni = ilmiyunvoni;
//        this.chettillari = chettillari;
//        this.davlatmukofotibilantaqdirlanganligiqanaqa = davlatmukofotibilantaqdirlanganligiqanaqa;
//        this.saylovorganiazosi = saylovorganiazosi;
//        this.partiyaviyligi = partiyaviyligi;
//        this.tamomlaganjoyi = tamomlaganjoyi;
//        this.harbiyunvoni = harbiyunvoni;
//        this.mehnatfaoliyati = mehnatfaoliyati;
//    }
//
//    public EmployeeDto() {
//    }
//
//    public String getFullname() {
//        return fullname;
//    }
//
//    public Integer getRegionId() {
//        return regionId;
//    }
//
//    public Integer getDistrictId() {
//        return districtId;
//    }
//
//    public Integer getCompanyId() {
//        return companyId;
//    }
//
//    public String getLavozimivaQachondan() {
//        return lavozimivaQachondan;
//    }
//
//    public List<InformationAboutRelativeDTO> getAboutRelative() {
//        return aboutRelative;
//    }
//
//    public String getBirthday() {
//        return birthday;
//    }
//
//    public String getNationality() {
//        return nationality;
//    }
//
//    public String getMalumoti() {
//        return malumoti;
//    }
//
//    public String getMalumotiboyichamutaxasisligi() {
//        return malumotiboyichamutaxasisligi;
//    }
//
//    public String getIlmiydarajasi() {
//        return ilmiydarajasi;
//    }
//
//    public String getIlmiyunvoni() {
//        return ilmiyunvoni;
//    }
//
//    public String getChettillari() {
//        return chettillari;
//    }
//
//    public String getDavlatmukofotibilantaqdirlanganligiqanaqa() {
//        return davlatmukofotibilantaqdirlanganligiqanaqa;
//    }
//
//    public String getSaylovorganiazosi() {
//        return saylovorganiazosi;
//    }
//
//    public String getPartiyaviyligi() {
//        return partiyaviyligi;
//    }
//
//    public String getTamomlaganjoyi() {
//        return tamomlaganjoyi;
//    }
//
//    public String getHarbiyunvoni() {
//        return harbiyunvoni;
//    }
//
//    public String getMehnatfaoliyati() {
//        return mehnatfaoliyati;
//    }
//
//    public void setAboutRelative(List<InformationAboutRelativeDTO> aboutRelative) {
//        this.aboutRelative = aboutRelative;
//    }
//}
