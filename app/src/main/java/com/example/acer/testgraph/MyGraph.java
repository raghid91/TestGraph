package com.example.acer.testgraph;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Acer on 11/16/2016.
 */

public class MyGraph extends View {

    public MyGraph(Context context) {
        super(context);
    }

    public MyGraph(Fragment fragment){
        super(fragment.getContext());
    }

    public MyGraph(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGraph(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //set the coordinates and variables

        int xAxisStart = canvas.getWidth()*2/16;
        int xAxisEnd = canvas.getWidth()*14/16;
        int yAxisStart = canvas.getHeight()*3/4;
        int yAxisEnd = canvas.getHeight()*1/4;

        int delta = canvas.getWidth()*1/32;

        int firstLim = xAxisStart;
        int firstBarStart = firstLim + 1*delta;
        int firstBarEnd = firstBarStart + 6*delta;
        int secondLim = firstBarEnd + delta;
        int secondBarStart = secondLim + delta;
        int secondBarEnd = secondBarStart + 6*delta;
        int thirdLim = secondBarEnd + delta;
        int thirdBarStart = thirdLim + delta;
        int thirdBarEnd = thirdBarStart + 6*delta;

        int thirdBarTop = (yAxisStart-yAxisEnd)*1/4 + yAxisEnd;
        int secondBarTop = (yAxisStart-yAxisEnd)*2/4 + yAxisEnd;
        int firstBarTop = (yAxisStart-yAxisEnd)*3/4 + yAxisEnd;

        //draw the text

        Paint text = new Paint();
        text.setColor(Color.BLACK);
        text.setTextSize(40);
        canvas.drawText("Date 1",firstBarStart+delta,yAxisStart+3*delta,text);
        canvas.drawText("Date 2",secondBarStart+delta,yAxisStart+3*delta,text);
        canvas.drawText("Date 3",thirdBarStart+delta,yAxisStart+3*delta,text);
        canvas.drawText("75",xAxisStart-3*delta,thirdBarTop,text);
        canvas.drawText("50",xAxisStart-3*delta,secondBarTop,text);
        canvas.drawText("25",xAxisStart-3*delta,firstBarTop,text);
        text.setTextSize(30);
        canvas.drawText("minutes",xAxisStart-3*delta,yAxisEnd,text);
        text.setTextSize(80);
        text.setTextAlign(Paint.Align.CENTER);
        text.setFakeBoldText(true);
        canvas.drawText("Chart Title",secondBarStart+3*delta,yAxisEnd*3/4,text);

        //draw the lines

        Paint line = new Paint();
        line.setColor(Color.BLACK);
        line.setStrokeWidth(3);
        canvas.drawLine(xAxisStart,yAxisStart,xAxisEnd,yAxisStart,line);
        canvas.drawLine(xAxisStart,yAxisStart,xAxisStart,yAxisEnd,line);
        canvas.drawLine(secondLim,yAxisStart+delta/4,secondLim,yAxisStart-delta/4,line);
        canvas.drawLine(thirdLim,yAxisStart+delta/4,thirdLim,yAxisStart-delta/4,line);
        canvas.drawLine(xAxisStart-delta/4,firstBarTop,xAxisStart+delta/4,firstBarTop,line);
        canvas.drawLine(xAxisStart-delta/4,thirdBarTop,xAxisStart+delta/4,thirdBarTop,line);
        canvas.drawLine(xAxisStart-delta/4,secondBarTop,xAxisStart+delta/4,secondBarTop,line);

        //draw the bars

        //first bar

        Paint green = new Paint();
        green.setColor(Color.GREEN);
        green.setStyle(Paint.Style.FILL);

        Rect firstRect = new Rect();
        firstRect.set(firstBarStart,firstBarTop,firstBarEnd,yAxisStart);
        canvas.drawRect(firstRect,green);

        //second bar

        Paint cyan = new Paint();
        cyan.setColor(Color.CYAN);
        cyan.setStyle(Paint.Style.FILL);

        Rect secondRect = new Rect();
        secondRect.set(secondBarStart,thirdBarTop,secondBarEnd,yAxisStart);
        canvas.drawRect(secondRect,cyan);

        //third bar

        Paint magenta = new Paint();
        magenta.setColor(Color.MAGENTA);
        magenta.setStyle(Paint.Style.FILL);

        Rect thirdRect = new Rect();
        thirdRect.set(thirdBarStart,secondBarTop,thirdBarEnd,yAxisStart);
        canvas.drawRect(thirdRect,magenta);


    }
}
