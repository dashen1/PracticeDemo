package com.example.recycletesth;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class GridView_MainActivity extends AppCompatActivity {
  List<Book> lists = new ArrayList<>();
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_gridview);
    GridView gridView = (GridView) findViewById(R.id.gridView);
    testData(R.drawable.fruit,"图片1");
    getNewLists();
    gridView.setAdapter(new MyAdapter(this,lists));
  }

  private void testData(int imageId, String name){
    Book book = new Book(name,imageId);
    lists.add(book);
  }

  private void getNewLists(){
    if (lists.size() == 1){
      lists.add(0,null);
      lists.add(2,null);
    }
  }

  private static class MyAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    List<Book> lists = new ArrayList<>();
    public MyAdapter(Context context,List<Book> lists){
      this.lists = lists;
      layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
      return lists.size();
    }

    @Override
    public Object getItem(int position) {
      return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
      return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      View v = layoutInflater.inflate(R.layout.item_grideview_layout,null);
      ImageView iv = (ImageView) v.findViewById(R.id.iv_gridView_item);
      TextView tv = (TextView) v.findViewById(R.id.tv_gridView_item);
      if(position ==1){
        iv.setImageResource(lists.get(position).getImageId());
        tv.setText(lists.get(position).getName());
      }
      return v;
    }
  }
}