package app.kh.utils.database;

import androidx.annotation.NonNull;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

@FunctionalInterface
public interface SimpleValueListener extends ValueEventListener {
    @Override
    default void onCancelled(@NonNull DatabaseError error) {
        android.util.Log.i("app-exceptions", Objects.requireNonNull(error.getMessage()));
    }
}
