package com.nandur.qrcodescanner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.nandur.qrcodescanner.ItemFragment.OnListFragmentInteractionListener;
import com.nandur.qrcodescanner.picture.PictureItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PictureItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

  private final List<PictureItem> mValues;
  private final OnListFragmentInteractionListener mListener;

  public MyItemRecyclerViewAdapter(List<PictureItem> items, OnListFragmentInteractionListener listener) {
    mValues = items;
    mListener = listener;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.fragment_item, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    holder.mItem = mValues.get(position);
    holder.mImageView.setImageURI(mValues.get(position).uri);
    //holder.mDateView.setText(mValues.get(position).date);

    holder.mView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (null != mListener) {
          // Notify the active callbacks interface (the activity, if the
          // fragment is attached to one) that an item has been selected.
          mListener.onListFragmentInteraction(holder.mItem);
        }
      }
    });
  }

  @Override
  public int getItemCount() {
    return mValues.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    public final View mView;
    public final ImageView mImageView;
    public final TextView mQrContentView;
    //public final TextView mDateView;
    public PictureItem mItem;

    public ViewHolder(View view) {
      super(view);
      mView = view;
      mImageView = view.findViewById(R.id.item_image_view);
      mQrContentView =  view.findViewById(R.id.item_qr_content_view);
      //mDateView = view.findViewById(R.id.item_date_tv);
    }
  }
}
