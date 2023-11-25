package com.co.portfolio_api.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "board_dtl")
public class BoardDtl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_dtl_no")
    private Integer boardDtlNo;

    @ManyToOne
    @JoinColumn(name = "board_no", nullable = false)
    private Board board; // Board

    @ManyToOne
    @JoinColumn(name = "cl_dtl_code", nullable = false)
    private CmmnDtlCl boardDtlCl;

    @Column(name = "text")
    private String text;
}
