package com.co.portfolio_api.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "board_dtl", uniqueConstraints = {@UniqueConstraint(columnNames = {"board", "sort_no"})})
public class BoardDtl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_dtl_no")
    private Integer boardDtlNo;
    @ManyToOne
    @JoinColumn(name = "board", nullable = false)
    private Board board;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_dtl_cl", nullable = false)
    private CmmnDtlCl boardDtlCl;
    @Column(name = "board_dtl_title")
    private String boardDtlTitle;
    @Column(name = "board_dtl_txt", length = 3000)
    private String boardDtlTxt;
    @Column(name = "board_dtl_url")
    private String boardDtlUrl;
    @Column(name = "sort_no")
    private Integer sortNo;
    @Column(name = "use_yn", length = 1, nullable = false, columnDefinition = "varchar(1) default 'Y'")
    private String useYn;
}
