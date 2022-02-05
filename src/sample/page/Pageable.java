package sample.page;

public class Pageable {
    private Sort sort;
    private Long offset;
    private Long pageNumber;
    private Long pageSize;
    private boolean unpaged;
    private boolean paged;

    @Override
    public String toString() {
        return "Pageable{" +
                "sort=" + sort +
                ", offset=" + offset +
                ", pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", unpaged=" + unpaged +
                ", paged=" + paged +
                '}';
    }
}
