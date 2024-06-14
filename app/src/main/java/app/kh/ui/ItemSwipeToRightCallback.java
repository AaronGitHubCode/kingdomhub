package app.kh.ui;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public final class ItemSwipeToRightCallback extends ItemTouchHelper.Callback {
    private final SwipeHelperContract contract;

    public ItemSwipeToRightCallback(final SwipeHelperContract contract) {
        this.contract = contract;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        return makeMovementFlags(0, ItemTouchHelper.RIGHT);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        contract.onItemSwiped(viewHolder);
    }
}
