package dev.amrish.productservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchrequestDTO {
    private String query;
    private int pageNo;
    private int pageSize;
}
