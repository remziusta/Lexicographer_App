package com.app.lexicographer.model;

import javax.persistence.*;


@Entity
@Table(name = "Type")
public class Type {
    @Id
    @GeneratedValue(generator = "typesSeq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "typesSeq" ,sequenceName = "TYPE_TB_SEQ", allocationSize = 1)
    private Long Id;

    @Column(name = "TYPE", nullable = false)
    private String TYPE;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

}
