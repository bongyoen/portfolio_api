package com.co.portfolio_api.db.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

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
    @Column(name = "board_url")
    private String boardUrl;
    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    @OrderBy("sortNo ASC")
    @Where(clause = "use_yn = 'Y'")
    private List<BoardDtl> boardDtls = new ArrayList<>();
}
