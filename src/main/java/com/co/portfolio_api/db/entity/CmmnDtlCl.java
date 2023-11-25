package com.co.portfolio_api.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "cmmn_dtl_cl")
public class CmmnDtlCl {
    @Id
    @Column(name = "cl_dtl_code", length = 6)
    private String clDtlCode;

    @ManyToOne
    @JoinColumn(name = "cl_code", nullable = false)
    private CmmnCl clCode;

    @Column(name = "cl_code_dtl_alt", nullable = false)
    private String clCodeDtlAlt;
}
