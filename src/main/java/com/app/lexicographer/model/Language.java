package com.app.lexicographer.model;

import javax.persistence.*;

@Entity
@Table(name = "Language")
public class Language {
    @Id
    @GeneratedValue(generator = "languagesSeq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "languagesSeq" ,sequenceName = "LANGUAGE_TB_SEQ", allocationSize = 1)
    private Long Id;

    @Column(name = "LANGUAGE",nullable = false)
    private String LANGUAGE;
    
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getLANGUAGE() {
        return LANGUAGE;
    }

    public void setLANGUAGE(String LANGUAGE) {
        this.LANGUAGE = LANGUAGE;
    }


}
