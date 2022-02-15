package sample.dto;

import javafx.scene.image.ImageView;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ShowDocument {
    private Integer id;

    private String taskSection;                 //topshiriq bandi
    private String documentTypeNumberDate;                //hujjatning turi,sanasi,raqami
    private String registrDayNumber;//date         //ro'yxatga olingan kun va N

    private String documentNameOrContent;       //hujjatning nomi yoki mazmuni
    private String organizationName;            //tashkilot
    private String directorResolution;          //rahbarning rezolyutsiyasi
    private String effectorName;                //ijrochilar
    private String effectorSection;             //ijrochi bo'limi
    private String executionDeadline;//date  //ijro muddati
    private Integer deadLineDay;                //qolgan kun
    private String originalFileName;             //hujjatning kontenti
}
