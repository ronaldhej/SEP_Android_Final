package com.github.sep_android_app.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.sep_android_app.R;
import com.github.sep_android_app.data.model.Room;

import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.ViewHolder> {

    public List<Room> rooms;
    private onClickListener onClickListener;

    public RoomAdapter(List<Room> rooms, onClickListener onClickListener) {
        this.rooms = rooms;
        this.onClickListener = onClickListener;
    }

    //Creating item template
    @NonNull
    @Override
    public RoomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_room, parent, false);
        return new ViewHolder(view, onClickListener);
    }

    //Binding data to items
    @Override
    public void onBindViewHolder(@NonNull RoomAdapter.ViewHolder holder, int position) {
        holder.name.setText(rooms.get(position).getName());
    }

    public int getItemCount() {
        return rooms.size();
    }

    //Provides instance of buttons and fields for binding use
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        Button btn_delete;
        Button btn_edit;
        Button btn_view_data;

        ViewHolder(View itemView, onClickListener onClickListener) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_room_name);

            // Setting ID of buttons
            btn_delete = itemView.findViewById(R.id.delete_room_button);
            btn_edit = itemView.findViewById(R.id.edit_room_button);
            btn_view_data = itemView.findViewById(R.id.view_data_button);
            Log.d("credit", "ViewHolder: " + R.string.r_credit);
            // Assigning same clickListener to all buttons, specific actions handled in fragment controller
            btn_delete.setOnClickListener(this);
            btn_edit.setOnClickListener(this);
            btn_view_data.setOnClickListener(this);
        }

        //Implementation of onClick interface for room adapter
        @Override
        public void onClick(View itemView) {
            onClickListener.onClick(getAdapterPosition(), itemView);

        }

    }

    public interface onClickListener {
        void onClick(int position, View view);
    }

}
