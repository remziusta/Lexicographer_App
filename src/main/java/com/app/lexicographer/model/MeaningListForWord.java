package com.app.lexicographer.model;

import javax.persistence.*;

@Entity
@Table(name = "Meaning")
public class MeaningListForWord {
    @Id
    @GeneratedValue(generator = "meaningListSeq", strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "WORD_MEANING")
    private String WORDMEANING;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    private Language LANGUAGE;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    private Category CATEGORY;

    @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    private Type TYPE;

    @ManyToOne(
    		cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    private WordList wordList;

    
	public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getWORDMEANING() {
        return WORDMEANING;
    }

    public void setWORDMEANING(String WORDMEANING) {
        this.WORDMEANING = WORDMEANING;
    }

    public Language getLANGUAGE() {
        return LANGUAGE;
    }

    public void setLANGUAGE(Language LANGUAGE) {
        this.LANGUAGE = LANGUAGE;
    }

    public Category getCATEGORY() {
        return CATEGORY;
    }

    public void setCATEGORY(Category CATEGORY) {
        this.CATEGORY = CATEGORY;
    }

    public Type getTYPE() {
        return TYPE;
    }

    public void setTYPE(Type TYPE) {
        this.TYPE = TYPE;
    }

    public WordList getWordList() {
        return wordList;
    }

    public void setWordList(WordList wordList) {
        this.wordList = wordList;
    }
}
