package com.example.mondechetapp.BDD;

import com.google.firebase.firestore.Exclude;

public class Dechet {
    private String documentId;
    private String code_barre;
    private String name;
    private String bac;

    public Dechet() {
        //public no-arg constructor needed
    }

    @Exclude
    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public Dechet(String code_barre, String name, String bac) {
        this.code_barre = code_barre;
        this.name = name;
        this.bac = bac;
    }

    public String getCode_barre() {
        return code_barre;
    }

    public String getName() {
        return name;
    }

    public String getBac() {
        return bac;
    }
}
