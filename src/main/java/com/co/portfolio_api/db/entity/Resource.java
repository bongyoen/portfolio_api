package com.co.portfolio_api.db.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Resource")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resource_no")
    private Integer resourceNo;

    @ManyToOne
    @JoinColumn(name = "resource_cl", nullable = false)
    private CmmnDtlCl resourceCl;

    @Column(name = "path", nullable = false)
    private String path;

    @Column(name = "extension", length = 5)
    private String extension;

    @Column(name = "name", nullable = false)
    private String name;
}
