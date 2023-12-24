package com.co.portfolio_api.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_no")
    private Integer boardNo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_cl", nullable = false)
    private CmmnDtlCl boardCl;
    @Column(name = "board_nm", nullable = false)
    private String boardNm;
    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    private List<BoardDtl> boardDtls = new ArrayList<>();
}
