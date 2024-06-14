package app.kh.auth;

import static app.kh.utils.ApplicationSingletonData.applicationUser;

import app.kh.HubActivity;
import app.kh.R;

import android.os.Bundle;

import android.text.Editable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.content.Intent;

import android.widget.Toast;

import static androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult;

import androidx.activity.result.ActivityResultLauncher;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import com.google.android.gms.tasks.Task;

import com.google.android.material.textfield.TextInputEditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public final class LoginFragment extends Fragment {
    private GoogleSignInClient googleSignInClient;

    private final ActivityResultLauncher<Intent> startActivityForResult = registerForActivityResult(new StartActivityForResult(), result -> {});

    /**
     * Resultado obtenido al llamar al Intent de GoogleSignInClient.
     * Devuelve la cuenta de usuario de Google con la que se quiere iniciar sesión si se realizó la operación correctamente.
     * */
    private final ActivityResultLauncher<Intent> startGoogleActivityForResult = registerForActivityResult(new StartActivityForResult(), result -> {
        final Intent data = result.getData();
        final Task<GoogleSignInAccount> taskGoogleSignInAccount = GoogleSignIn.getSignedInAccountFromIntent(data);

        taskGoogleSignInAccount.addOnCompleteListener( auth -> auth.addOnSuccessListener( a -> {
            final User.Builder userBuilder = new User.Builder();

            userBuilder
                    .setUsername(a.getDisplayName())
                    .setEmail(a.getEmail());

            applicationUser = userBuilder.build();
        })).addOnFailureListener( e -> Toast.makeText(requireContext(), Objects.requireNonNull(e.getMessage()), Toast.LENGTH_SHORT).show());
    });

    private void loginUser(final String email, final String password) {
        final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener( auth -> auth.addOnSuccessListener( a -> {
            final User.Builder userBuilder = new User.Builder();
            final FirebaseUser firebaseUser = a.getUser();

            assert firebaseUser != null;

            userBuilder
                    .setUsername(firebaseUser.getDisplayName())
                    .setEmail(firebaseUser.getEmail())
                    .setPhotoUrl(firebaseUser.getPhotoUrl());

            applicationUser = userBuilder.build();

            final Intent intent = new Intent(requireContext(), HubActivity.class);
            startActivityForResult.launch(intent);
        })).addOnFailureListener( e -> Toast.makeText(requireContext(), Objects.requireNonNull(e.getMessage()), Toast.LENGTH_SHORT).show());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(requireContext(), googleSignInOptions);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final View googleButton = view.findViewById(R.id.google_button);
        final View registerButton = view.findViewById(R.id.register_button);
        final View loginButton = view.findViewById(R.id.login_button);

        final TextInputEditText emailInput = view.findViewById(R.id.login_email_input);
        final TextInputEditText passwordInput = view.findViewById(R.id.login_password_input);

        loginButton.setOnClickListener( v -> {
            final Editable emailEditable = emailInput.getText();
            final Editable passwordEditable = passwordInput.getText();

            if (emailEditable != null && passwordEditable != null)
                loginUser(emailEditable.toString(), passwordEditable.toString());
            else
                Toast.makeText(requireContext(), "All the fields should be filled!", Toast.LENGTH_SHORT).show();
        });

        registerButton.setOnClickListener( v -> {
            final FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.login_fragment_container, new RegisterFragment(), "register");
            fragmentTransaction.commit();
        });

        googleButton.setOnClickListener( v -> {
            final Intent googleIntent = googleSignInClient.getSignInIntent();
            startGoogleActivityForResult.launch(googleIntent);
        });
    }
}
