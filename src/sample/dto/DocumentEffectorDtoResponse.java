package sample.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentEffectorDtoResponse {
    private UUID id;
    private String taskSection;                 //topshiriq bandi
    private String documentType;                //hujjatning turi
    private String documentNumber;              //hujjatning raqami
    private String documentDate;//date       //hujjatning sanasi
    private String registrDay;//date         //ro'yxatga olingan kun
    private String registrNumber;               //N_0
    private String documentNameOrContent;       //hujjatning nomi yoki mazmuni
    private String organizationName;            //tashkilot
    private String directorResolution;          //rahbarning rezolyutsiyasi
    private String effectorName;                //ijrochilar
    private String effectorSection;             //ijrochi bo'limi
    private String executionDeadline;//date  //ijro muddati
    private Integer deadLineDay;                //qolgan kun
    private String originalFileName;             //hujjatning kontenti
 }
