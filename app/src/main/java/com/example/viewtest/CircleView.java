package com.example.viewtest;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.StaticLayout;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * User: Lazy_xu
 * Data: 2019/08/20
 * Description:
 * FIXME
 */
public class CircleView extends View {
    private Paint mPaint;
    private Path path = new Path();
    /**
     * 文字
     */
    private String text;
    /**
     * 文字颜色
     */
    private int textColor;
    /**
     * 默认文字颜色
     */
    private int textColorDefaut = Color.BLACK;
    /**
     * 文字大小
     */
    private int textSize;
    private StaticLayout staticLayout;

    public CircleView(Context context) {
        this(context, null);
    }

    public CircleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleView, defStyleAttr, 0);
        text = typedArray.getString(R.styleable.CircleView_text);
        textColor = typedArray.getColor(R.styleable.CircleView_textColor, textColorDefaut);

        textSize = typedArray.getDimensionPixelSize(R.styleable.CircleView_textSize, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
        typedArray.recycle();
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
//        mPaint.setAntiAlias(true);
        mPaint.setTextSize(textSize);

        path.addArc(200, 200, 400, 400, -225, 225);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GREEN);


        mPaint.setColor(textColor);//设置字体大小
//        mPaint.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "Satisfy-Regular.ttf"));//设置字体样式
//        mPaint.setFakeBoldText(true);//是否使用伪粗体
//        mPaint.setStrikeThruText(true);//是否加删除线
//        mPaint.setUnderlineText(true);//是否加下划线
//        mPaint.setTextSkewX(-0.1f);//设置文字倾斜度（+往左倾，-往右倾）
//        mPaint.setTextScaleX(1.5f);
        mPaint.setLetterSpacing(0.2f);
        canvas.drawText(text, 100, 100, mPaint);

        mPaint.setColor(Color.BLUE);
        canvas.drawLine(100, 100, 600, 100, mPaint);


//        TextPaint textPaint=new TextPaint(Paint.ANTI_ALIAS_FLAG);
//        textPaint.setColor(Color.RED);
//        textPaint.setStyle(Paint.Style.FILL);
//        textPaint.setTextSize(50);
//        String text="在Android开发中，Canvas.drawText不会换行，即使一个很长的字符串也只会显示一行，超出部分会隐藏在屏幕之外.StaticLayout是android中处理文字的一个工具类，StaticLayout 处理了文字换行的问题";
//        staticLayout=new StaticLayout(text, textPaint, canvas.getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f,0.0f , false);
//        staticLayout.draw(canvas);

    }
}
