package com.edufabricio.server.jpa;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by eduardo on 16/07/2017.
 */
@Data
@Entity
@Table(name = "MESSAGE_RECEIVED")
public class MessageReceived {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "SEND_AT")
    private Date sendAt;

    @Column(name = "MESSAGE")
    private String message;


}
