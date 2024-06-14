package app.kh.utils;

import com.google.firebase.FirebaseApp;

import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.storage.FirebaseStorage;

import app.kh.auth.User;

public final class ApplicationSingletonData {
    @Singleton
    public static User applicationUser;

    @Singleton
    public static final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance(FirebaseApp.getInstance());

    @Singleton
    public static final FirebaseStorage firebaseStorage = FirebaseStorage.getInstance(FirebaseApp.getInstance());
}
