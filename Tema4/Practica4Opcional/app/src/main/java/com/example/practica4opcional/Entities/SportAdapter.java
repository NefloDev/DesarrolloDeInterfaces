package com.example.practica4opcional.Entities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practica4opcional.R;

import java.util.ArrayList;
import java.util.List;

/**
 * SportAdapter class that represents an adapter for the ViewHolder {@link com.example.practica4opcional.Entities.SportViewHolder}
 * that handles the data that will be shown in the recycler view
 * @see SportViewHolder
 * @author Alejandro Nebot Fores
 * @version 2023-11-27
 */

public class SportAdapter extends RecyclerView.Adapter<SportViewHolder> {

    /**
     * List of Strings containing the names of the sports that will be shown
     */
    private List<String> names;
    /**
     * List of Integers containing the id of the drawables of the sports that will be shown
     */
    private List<Integer> images;
    /**
     * ArrayList of SportViewHolders containing the ViewHolders of that class that are successfully
     * created
     */
    private ArrayList<SportViewHolder> viewHolderList;

    /**
     * SportAdapter's class constructor
     * @param names A List of Strings containing the names of the sports that will be shown
     * @param images A List of Integers containing the id of the drawables of the sports that
     *               will be shown
     */
    public SportAdapter(List<String> names, List<Integer> images){
        this.names = names;
        this.images = images;
        viewHolderList = new ArrayList<>();
    }

    /**
     * OnCreateViewHolder method that creates a view out of the layout of the View Holder's class
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return A view of the View Holder's class
     */
    @NonNull
    @Override
    public SportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_layout, parent, false);
        return new SportViewHolder(layoutView);
    }

    /**
     * OnBindViewHolder method that sets the data into the layout elements before showing them
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull SportViewHolder holder, int position) {
        String name = names.get(position);
        int imageId = images.get(position);

        holder.checkBox.setText(name);
        holder.image.setImageResource(imageId);
        viewHolderList.add(holder);
    }

    /**
     * GetItemCount method that gets the amount of elements that will be shown in the RecyclerView
     * @return An integer representing the amount of elements that will be shown in the RecyclerView
     */
    @Override
    public int getItemCount() {
        return images != null && names != null ? images.size() : 0;
    }

    /**
     * GetViewHolderList method that gets the amount of elements in the ArrayList "viewHolderList"
     * @return An ArrayList representing all the viewHolders that were created
     */
    public ArrayList<SportViewHolder> getViewHolderList(){
        return viewHolderList;
    }
}
