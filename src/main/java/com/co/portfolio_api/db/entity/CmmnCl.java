package com.co.portfolio_api.db.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cmmn_cl")
@Getter
@Setter
public class CmmnCl {
    @Id
    @Column(name = "cl_code", length = 3)
    private String clCode;

    @Column(name = "cl_code_alt", nullable = false)
    private String clCodeAlt;

    @OneToMany(mappedBy = "clCode")
    private List<CmmnDtlCl> cmmnDtlCls = new ArrayList<>();

    public void addCmmnDtlCl(CmmnDtlCl cmmnDtlCl) {
        cmmnDtlCls.add(cmmnDtlCl);
        cmmnDtlCl.setClCode(this);
    }
}