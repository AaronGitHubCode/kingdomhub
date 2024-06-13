package app.kh.utils;

import com.google.firebase.database.FirebaseDatabase;

import app.kh.auth.User;

public final class ApplicationSingletonData {
    @Singleton
    public static User applicationUser;

    @Singleton
    public static FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
}
