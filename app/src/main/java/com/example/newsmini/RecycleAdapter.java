package com.example.newsmini;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {

    public ArrayList<String> title;
    public ArrayList<String> description;
    public ArrayList<String> date;
    public ArrayList<String> imageurl;
    public Context context;
    public TextView textView,textView2,textView3;
    public ImageView imageView2;


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

        }


    }
    public RecycleAdapter(Context cont,ArrayList<String> titl,ArrayList<String> descrip,ArrayList<String> da,ArrayList<String> image) {
                context = cont;
               title = titl;
               description = descrip;
               date = da;
               imageurl = image;

    }


    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        textView = view.findViewById(R.id.textView);
        textView2= view.findViewById(R.id.textView2);
        textView3= view.findViewById(R.id.textView3);
        imageView2= view.findViewById(R.id.imageView2);


        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
      textView.setText(title.get(position));
      textView2.setText(date.get(position));
      textView3.setText(description.get(position));
       Glide.with(context).load(imageurl.get(position)).into(imageView2);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return title.size();
    }
}



