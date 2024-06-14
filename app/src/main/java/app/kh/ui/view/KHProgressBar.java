package app.kh.ui.view;

import app.kh.ui.OnProgressBarListener;

import android.content.Context;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Paint;
import android.graphics.Color;

import android.util.AttributeSet;

import androidx.core.widget.ContentLoadingProgressBar;

import lombok.Setter;

@Setter
public final class KHProgressBar extends ContentLoadingProgressBar {
    private OnProgressBarListener onProgressBarListener;

    private int actualPoints;
    private int nextLevelPoints;
    private int percentage = (actualPoints / nextLevelPoints) * 100;

    private final Paint valueIndicatorPaint = new Paint();
    private final Rect valueIndicatorRect = new Rect();

    public KHProgressBar(final Context context) {
        this(context, null);
    }

    public KHProgressBar(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        percentage = attrs.getAttributeIntValue("", "percentage", 1);
        actualPoints = attrs.getAttributeIntValue("", "actual_points", 0);
        nextLevelPoints = attrs.getAttributeIntValue("", "next_level_points", 0);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        percentage = (actualPoints / nextLevelPoints) * 100;
        setProgress(percentage, true);

        canvas.restore();
        valueIndicatorPaint.setColor(Color.GREEN);
        valueIndicatorRect.left = percentage;
        canvas.save();
    }
}
