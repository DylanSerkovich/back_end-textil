package com.guianella.backend_textil.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Investment {
    private long id;
    private String investorName;
    private String unitSales;
    private List<Fabric> fabricList = new ArrayList<>();
    private Instant createDate;
    private Instant completeDate;
}
