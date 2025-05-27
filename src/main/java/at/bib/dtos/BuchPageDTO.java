package at.bib.dtos;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BuchPageDTO {
    private List<BuchDTO> content;
    private int page;
    private int size;
    private long totalItems;
    private int totalPages;
}
