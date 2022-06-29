package com.lucasrb.batch.repository.criteria.params;

import lombok.Data;

@Data
public class CustomParams {
    private Integer id;
    private String country;
    private Integer page;
    private Integer pageSize;
}
