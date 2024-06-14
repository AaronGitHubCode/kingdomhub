package app.kh.ui;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public final class ItemMoveCallback extends ItemTouchHelper.Callback {
    private static final int GENERAL_MOVE = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;

    private final MoveHelperContract contract;

    public ItemMoveCallback(final MoveHelperContract contract) {
        this.contract = contract;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        return makeMovementFlags(GENERAL_MOVE, 0);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        /*
        * TODO: Implementar acción al realizar movimiento.
        *  contract.onItemMoved(viewHolder);
        * */
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {}
}
