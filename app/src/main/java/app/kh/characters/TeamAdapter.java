package app.kh.characters;

import static app.kh.utils.ApplicationSingletonData.applicationUser;
import static app.kh.utils.ApplicationSingletonData.firebaseDatabase;

import app.kh.R;

import app.kh.utils.database.SimpleValueListener;

import app.kh.ui.SwipeHelperContract;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;

import static androidx.recyclerview.widget.RecyclerView.ViewHolder;

import androidx.annotation.NonNull;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import com.google.firebase.database.DatabaseReference;

import lombok.Setter;

import java.util.Objects;

final class TeamAdapter extends FirebaseRecyclerAdapter<Team, TeamViewHolder>
implements SwipeHelperContract {
    private final Context context;

    private String key;

    @FunctionalInterface
    interface OnTeamSelectListener {
        void onSelect(final Team team);
    }

    @Setter
    private OnTeamSelectListener onTeamSelectListener;

    public TeamAdapter(final Context context, final FirebaseRecyclerOptions<Team> firebaseRecyclerOptions) {
        super(firebaseRecyclerOptions);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull TeamViewHolder teamViewHolder, int i, @NonNull Team team) {
        final View root = teamViewHolder.getRoot();
        final DatabaseReference reference = firebaseDatabase.getReference();

        reference.child(applicationUser.getUsername()).child("teams").addListenerForSingleValueEvent((SimpleValueListener) snapshot -> {
            if (Objects.equals(snapshot.getKey(), team.getUid())) {
                key = snapshot.getKey();
            }
        });

        root.setOnClickListener(v -> onTeamSelectListener.onSelect(team));
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TeamViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.team_row_layout, parent, false));
    }


    /**
     * Método a ejecutar al deslizar un 'team' a la derecha.
     * Este método eliminará un equipo de la base de datos.
     * */
    @Override
    public void onItemSwiped(ViewHolder viewHolder) {
        final DatabaseReference reference = firebaseDatabase.getReference();

        if (applicationUser != null) {
            reference.child(applicationUser.getUsername()).child("teams").addListenerForSingleValueEvent((SimpleValueListener) snapshot -> {
                if (Objects.equals(snapshot.getKey(), key)) {
                    final DatabaseReference snapshotReference = snapshot.getRef();
                    snapshotReference.removeValue()
                            .addOnFailureListener( e -> Toast.makeText(context, Objects.requireNonNull(e.getMessage()), Toast.LENGTH_SHORT).show());
                }
            });
        }
    }
}

final class TeamViewHolder extends ViewHolder {
    private final View root;

    TeamViewHolder(final View root) {
        super(root);
        this.root = root;
    }

    View getRoot() {
        return root;
    }
}
