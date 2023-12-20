package com.co.portfolio_api.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity @Getter @Setter @Table(name = "board_dtl")
public class BoardDtl {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "board_dtl_no")
    private Integer boardDtlNo;
    @ManyToOne @JoinColumn(name = "board", nullable = false)
    private Board board;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "board_dtl_cl", nullable = false)
    private CmmnDtlCl boardDtlCl;
    @Column(name = "board_dtl_txt")
    private String boardDtlTxt;
}
