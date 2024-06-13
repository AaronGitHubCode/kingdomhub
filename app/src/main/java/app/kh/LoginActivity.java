package app.kh;

import static app.kh.utils.ApplicationSingletonData.applicationUser;

import app.kh.auth.User;

import android.os.Bundle;

import android.content.Intent;

import static androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult;

import androidx.activity.result.ActivityResultLauncher;

import androidx.fragment.app.FragmentTransaction;

import androidx.annotation.Nullable;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import com.google.firebase.FirebaseApp;

import com.google.firebase.database.FirebaseDatabase;

import app.kh.auth.LoginFragment;

public final class LoginActivity extends AppCompatActivity {
    private final ActivityResultLauncher<Intent> startActivityForResult = registerForActivityResult(new StartActivityForResult(), result -> {
        if (GoogleSignIn.getLastSignedInAccount(this) != null) {
            final Intent intent = new Intent(this, HubActivity.class);
            startActivity(intent);
        }

        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.login_fragment_container, new LoginFragment(), "login");
        fragmentTransaction.commit();
    });

    public LoginActivity() {
        super(R.layout.login_activity_layout);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        FirebaseDatabase.getInstance(getString(R.string.firebase_database_url));

        GoogleSignInAccount lastSignedAccount;

        if ((lastSignedAccount = GoogleSignIn.getLastSignedInAccount(this)) != null) {
            final User.Builder userBuilder = new User.Builder();

            userBuilder
                    .setUsername(lastSignedAccount.getDisplayName())
                    .setEmail(lastSignedAccount.getEmail())
                    .setPhotoUrl(lastSignedAccount.getPhotoUrl());


            applicationUser = userBuilder.build();

            final Intent intent = new Intent(this, HubActivity.class);
            startActivityForResult.launch(intent);
        }

        final FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.login_fragment_container, new LoginFragment(), "login");
        fragmentTransaction.commit();
    }
}
