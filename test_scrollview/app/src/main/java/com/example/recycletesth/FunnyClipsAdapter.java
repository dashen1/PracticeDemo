package com.example.recycletesth;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FunnyClipsAdapter extends RecyclerView.Adapter<FunnyClipsAdapter.FunnyClipsViewHolder> {
  public static final String TAG = "FunnyClipsAdapter";
  private List<Book> bookList;
  private LifecycleOwner lifecycleOwner;

  public FunnyClipsAdapter(LifecycleOwner context, List<Book> bookList) {
    this.lifecycleOwner = context;
    this.bookList = bookList;
  }

  @NonNull
  @Override
  public FunnyClipsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new FunnyClipsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle, parent, false));
  }

  @Override
  public void onBindViewHolder(@NonNull FunnyClipsViewHolder holder, int position) {
    Book book=bookList.get(position);

  }

  @Override
  public int getItemCount() {
    return null != bookList ? bookList.size() : 0;
  }

  static class FunnyClipsViewHolder extends RecyclerView.ViewHolder {

    public FunnyClipsViewHolder(@NonNull View itemView) {
      super(itemView);
    }
  }


  public void setVideoMsgList(List<Book> videoMsgList) {
    this.bookList = videoMsgList;
  }
}
