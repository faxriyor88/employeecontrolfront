package sample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ManagerDtoOfDocumentEffector {
    private String managerName;
    private Integer managerId;
}
