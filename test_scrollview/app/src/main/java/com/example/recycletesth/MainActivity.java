package com.example.recycletesth;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.recycletesth.pagelayoutmanager.PagerGridLayoutManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private List<Book> bookList=new ArrayList<>();
  private FunnyClipsAdapter funnyClipsAdapter;
  private RecyclerView recyclerView;
  private TextView arrow_right;
  private TextView arrow_left;
  private final int OFFSET_ITEM = 3;

  @RequiresApi(api = Build.VERSION_CODES.M)
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initBooks();
    arrow_right = findViewById(R.id.arrow_right);
    arrow_left = findViewById(R.id.arrow_left);
    recyclerView = findViewById(R.id.recycle_avatar1);

    final KidDialogAvatarAdapter adapter=new KidDialogAvatarAdapter(this,bookList,recyclerView);
    final int itemCounts = adapter.getItemCount();
    recyclerView.setAdapter(adapter);
    if (itemCounts > OFFSET_ITEM){
      arrow_right.setVisibility(View.VISIBLE);
    }
    final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    layoutManager.setOrientation(RecyclerView.HORIZONTAL);
    recyclerView.setLayoutManager(layoutManager);
    PagerSnapHelper snapHelper = new PagerSnapHelper();
    snapHelper.attachToRecyclerView(recyclerView);

    recyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
      @Override
      public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        int first = layoutManager.findFirstCompletelyVisibleItemPosition();
        int last = layoutManager.findLastCompletelyVisibleItemPosition();
        if (last == itemCounts - 1) {
          arrow_right.setVisibility(View.INVISIBLE);
        }else {
          arrow_right.setVisibility(View.VISIBLE);
        }
        if (first == 0) {
          arrow_left.setVisibility(View.INVISIBLE);
        }else {
          arrow_left.setVisibility(View.VISIBLE);
        }
      }
    });
    arrow_right.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        int last = layoutManager.findLastCompletelyVisibleItemPosition();
        if(itemCounts > last && (itemCounts - last) >= OFFSET_ITEM){
          layoutManager.scrollToPositionWithOffset(last+1,OFFSET_ITEM);
        }else {
          layoutManager.scrollToPositionWithOffset(last+1,itemCounts - last-1);
        }
        adapter.notifyDataSetChanged();
      }
    });

    arrow_left.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        int first = layoutManager.findFirstCompletelyVisibleItemPosition();
        if((first - OFFSET_ITEM) >= 0){
          layoutManager.scrollToPositionWithOffset(first-OFFSET_ITEM,OFFSET_ITEM);
        }else {
          layoutManager.scrollToPositionWithOffset(0, OFFSET_ITEM);
        }
        adapter.notifyDataSetChanged();
      }
    });
  }


  private void initBooks(){
    for (int i=1;i<10;i++){
      Book book=new Book("春起之苗"+i,R.drawable.fruit);
      bookList.add(book);
    }
  }

}