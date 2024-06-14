package app.kh.keyblades;

import app.kh.R;

import static androidx.recyclerview.widget.RecyclerView.ViewHolder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import lombok.Setter;

@Setter
final class KeybladeAdapter extends FirebaseRecyclerAdapter<Keyblade, KeybladeViewHolder> {
    @FunctionalInterface
    interface OnKeybladeSelectListener {
        void onSelect(final Keyblade keyblade);
    }

    private OnKeybladeSelectListener onKeybladeSelectListener;

    public KeybladeAdapter(final FirebaseRecyclerOptions<Keyblade> firebaseRecyclerOptions) {
        super(firebaseRecyclerOptions);
    }

    @Override
    protected void onBindViewHolder(@NonNull KeybladeViewHolder keybladeViewHolder, int i, @NonNull Keyblade keyblade) {
        final View root = keybladeViewHolder.getRoot();

        root.setOnClickListener( v -> onKeybladeSelectListener.onSelect(keyblade));
    }

    @NonNull
    @Override
    public KeybladeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new KeybladeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.keyblade_row_layout, parent, false));
    }
}

final class KeybladeViewHolder extends ViewHolder {
    private View root;

    KeybladeViewHolder(final View root) {
        super(root);
        this.root = root;
    }

    View getRoot() {
        return root;
    }
}