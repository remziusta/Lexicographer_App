package com.app.lexicographer.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "WordList")
public class WordList {
    @Id
    @GeneratedValue(generator = "wordListSeq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "wordListSeq", sequenceName = "WORDLIST_TB_ID_SEQ", allocationSize = 1)
    private Long Id;

    @Column(name = "WORD", unique = true)
    private String WORD;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    private Language LANGUAGE;

    @Column(name = "CREATED_AT_DATE",updatable = false)
    private LocalDate CREATED_AT_DATE = LocalDate.now();

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "wordList"
    )
    private Set<MeaningListForWord> meanings = new HashSet<>();

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getWORD() {
        return WORD;
    }

    public void setWORD(String WORD) {
        this.WORD = WORD;
    }

    public Language getLANGUAGE() {
        return LANGUAGE;
    }

    public void setLANGUAGE(Language LANGUAGE) {
        this.LANGUAGE = LANGUAGE;
    }

    public LocalDate getCREATED_AT_DATE() {
        return CREATED_AT_DATE;
    }

    public void setCREATED_AT_DATE(LocalDate CREATED_AT_DATE) {
        this.CREATED_AT_DATE = CREATED_AT_DATE;
    }

    public Set<MeaningListForWord> getMeanings() {
        return meanings;
    }

    public void setMeanings(Set<MeaningListForWord> meanings) {
        this.meanings = meanings;
    }
}
