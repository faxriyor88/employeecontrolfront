package sample.dto;

public class InformationAboutRelativeDTO {
    private String name;
    private String relativefullname;
    private String birthdayandbirthofplace;
    private String ishjoyivalavozimi;
    private String turarjoyi;

    public InformationAboutRelativeDTO(String name, String relativefullname, String birthdayandbirthofplace, String ishjoyivalavozimi, String turarjoyi) {
        this.name = name;
        this.relativefullname = relativefullname;
        this.birthdayandbirthofplace = birthdayandbirthofplace;
        this.ishjoyivalavozimi = ishjoyivalavozimi;
        this.turarjoyi = turarjoyi;
    }

    public String getName() {
        return name;
    }

    public String getRelativefullname() {
        return relativefullname;
    }

    public String getBirthdayandbirthofplace() {
        return birthdayandbirthofplace;
    }

    public String getIshjoyivalavozimi() {
        return ishjoyivalavozimi;
    }

    public String getTurarjoyi() {
        return turarjoyi;
    }
}
