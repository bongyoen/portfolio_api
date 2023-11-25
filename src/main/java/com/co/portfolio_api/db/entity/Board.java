package com.co.portfolio_api.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_no")
    private Integer boardNo;

    @ManyToOne
    @JoinColumn(name = "board_upper_no", referencedColumnName = "board_no")
    private Board boardUpper;

    @Column(name = "board_cl", nullable = false, length = 6)
    private String boardCl;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "text")
    private String text;
}
