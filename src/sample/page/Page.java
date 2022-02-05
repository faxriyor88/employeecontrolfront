package sample.page;

import sample.model.Employee;

import java.util.List;

public class Page {
private List<Employee> content;
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

    public List<Employee> getContent() {
        return content;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public boolean isLast() {
        return last;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public Long getSize() {
        return size;
    }

    public Long getNumber() {
        return number;
    }

    public Sort getSort() {
        return sort;
    }

    public Long getNumberOfElements() {
        return numberOfElements;
    }

    public boolean isFirst() {
        return first;
    }

    public boolean isEmpty() {
        return empty;
    }

    @Override
    public String toString() {
        return "Page{" +
                "content=" + content +
                ", pageable=" + pageable +
                ", last=" + last +
                ", totalPages=" + totalPages +
                ", totalElements=" + totalElements +
                ", size=" + size +
                ", number=" + number +
                ", sort=" + sort +
                ", numberOfElements=" + numberOfElements +
                ", first=" + first +
                ", empty=" + empty +
                '}';
    }
}
