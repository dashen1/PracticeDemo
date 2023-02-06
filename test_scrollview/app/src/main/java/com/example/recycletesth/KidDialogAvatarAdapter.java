package com.example.recycletesth;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class KidDialogAvatarAdapter extends RecyclerView.Adapter<KidDialogAvatarAdapter.ViewHolder>{
  private List<Book> mBookList;
  private Context context;
  RecyclerView recyclerView;

  static class ViewHolder extends RecyclerView.ViewHolder{
    ImageView bookImage;
    TextView bookName;
    ConstraintLayout id_item_layout;
    public ViewHolder(View view){
      super(view);
      bookImage=view.findViewById(R.id.id_book_image);
      bookName=view.findViewById(R.id.id_book_name);
      id_item_layout=view.findViewById(R.id.id_item_layout);
    }
  }

  public KidDialogAvatarAdapter(Context context, List<Book> bookList, RecyclerView recyclerView){
    this.context = context;
    this.mBookList=bookList;
    this.recyclerView = recyclerView;
  }

  @Override
  public KidDialogAvatarAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle,parent,false);
    RecyclerView.ViewHolder holder=new ViewHolder(view);
    return (ViewHolder) holder;
  }

  @Override
  public void onBindViewHolder(KidDialogAvatarAdapter.ViewHolder holder, int position) {
    Book book=mBookList.get(position);
    int minItem = Math.min(mBookList.size(), 3);
    int width = recyclerView.getWidth() / minItem;
    ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(width, ViewGroup.LayoutParams.WRAP_CONTENT);
    holder.id_item_layout.setLayoutParams(params);
    holder.bookImage.setBackgroundResource(book.getImageId());
    holder.bookName.setText(book.getName());
  }

  @Override
  public int getItemCount() {
    return mBookList.size();
  }

}
