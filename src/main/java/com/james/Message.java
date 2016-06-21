package com.james;

import com.fasterxml.jackson.annotation.JsonSubTypes;

import javax.persistence.*;

/**
 * Created by jamesyburr on 6/20/16.
 */
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue
    Integer id;

    @Column(nullable = false)
    String text;

    public Message(String text) {
        this.text = text;
    }

    public Message() {
    }

    public Message(Integer id, String text) {
        this.id = id;
        this.text = text;
    }
}
