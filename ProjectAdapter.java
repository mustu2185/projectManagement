package com.anahad.projectmanagement;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;

public class ProjectAdapter extends FirestoreRecyclerAdapter<Project,ProjectAdapter.ProjectHolder> {

    private static final String TAG = ProjectAdapter.class.getSimpleName();
    OnItemClickListner listner;

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ProjectAdapter(@NonNull FirestoreRecyclerOptions<Project> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ProjectHolder holder, int position, @NonNull Project model) {
        Log.d(TAG, "onBindViewHolder: Mustafa: creating card for " + model.getName());
        holder.nameTextView.setText(model.getName());
    }

    @NonNull
    @Override
    public ProjectHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_general_item,viewGroup,false);
        Log.d(TAG, "onCreateViewHolder: Mustafa: called");
        return new ProjectHolder(v);
    }

    class ProjectHolder extends RecyclerView.ViewHolder
    {
        TextView nameTextView;

        public ProjectHolder(@NonNull View itemView) {
            super(itemView);
            this.nameTextView = (TextView)itemView.findViewById(R.id.text_view_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && listner != null)
                    {
                        listner.onItemClick(getSnapshots().getSnapshot(position),position);
                    }
                }
            });
        }
    }

    public void deleteItem(int adapterPosition) {
        getSnapshots().getSnapshot(adapterPosition).getReference().delete();
    }

    public interface OnItemClickListner
    {
        void onItemClick(DocumentSnapshot document, int position);
    }

    void setOnItemClickListner(OnItemClickListner listner)
    {
        this.listner = listner;
    }

}
