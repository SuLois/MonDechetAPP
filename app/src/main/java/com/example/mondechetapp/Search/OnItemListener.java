package com.example.mondechetapp.Search;

import com.google.firebase.firestore.DocumentSnapshot;

public interface OnItemListener {
    void onItemClick(int position); //for redirect click
    void onItemRetrieve (DocumentSnapshot documentSnapshot, int position); //for retrieve Dechetname
}
