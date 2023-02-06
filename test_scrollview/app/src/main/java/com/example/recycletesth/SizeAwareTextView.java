package com.example.recycletesth;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class SizeAwareTextView extends AppCompatTextView {
  private OnTextSizeChangedListener mOnTextSizeChangedListener;
  private float mLastTextSize;
  private int mHeight;

  public SizeAwareTextView(Context context) {
    super(context);
  }

  public SizeAwareTextView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public SizeAwareTextView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    if(mOnTextSizeChangedListener!=null)
      mOnTextSizeChangedListener.onTextSizeChanged(getHeight());
  }

  public void changeHeight(int height){
    if(height > mHeight){
      mHeight = height;
      this.setHeight(height);
    }
  }

  public void setOnTextSizeChangedListener(OnTextSizeChangedListener onTextSizeChangedListener) {
    mOnTextSizeChangedListener = onTextSizeChangedListener;
  }

  public interface OnTextSizeChangedListener {
    void onTextSizeChanged(int textSize);
  }
}
