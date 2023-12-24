package com.co.portfolio_api.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "email")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email_no")
    private Integer emailNo;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "sender_email", nullable = false)
    private String sender_email;
    @Column(name = "subject", nullable = false)
    private String subject;
    @Column(name = "message", nullable = false)
    private String message;

    public Email() {
    }

    public Email(String name, String sender_email, String subject, String message) {
        this.name = name;
        this.sender_email = sender_email;
        this.subject = subject;
        this.message = message;
    }
}
