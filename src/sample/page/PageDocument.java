package sample.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import sample.dto.DocumentEffectorDtoResponse;

import java.util.List;
@Data
@AllArgsConstructor
public class PageDocument {
    private List<DocumentEffectorDtoResponse> content;
    private Pageable pageable;
    boolean last;
    private Long totalPages;
    private Long totalElements;
    private Long size;
    private Long number;
    private Sort sort;
    private Long numberOfElements;
    private boolean first;
    private boolean empty;


}