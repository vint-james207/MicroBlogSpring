package com.james;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by jamesyburr on 6/20/16.
 */
@Entity

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
