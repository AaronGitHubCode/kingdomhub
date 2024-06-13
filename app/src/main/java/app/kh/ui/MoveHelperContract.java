package app.kh.ui;

import static androidx.recyclerview.widget.RecyclerView.ViewHolder;

public interface MoveHelperContract extends SwipeHelperContract {
    void onItemMoved(final ViewHolder viewHolder);
}
