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

    @ManyToOne
    @JoinColumn(name = "cl_dtl_code", nullable = false)
    private CmmnDtlCl boardCl;

    @Column(name = "title", nullable = false)
    private String title;

    @OneToMany(mappedBy = "board")
    private List<BoardDtl> boardDtls = new ArrayList<>();

    public void addBoardDtl(BoardDtl boardDtl) {
        this.boardDtls.add(boardDtl);
        boardDtl.setBoard(this);
    }
}
