package sample.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAdditonalDTO {
    private List<InformationAboutRelativeDTO> aboutRelative;
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
    private List<MehnatFaoliyatiDto> mehnatFaoliyati;
    private String imageUrl;
}
