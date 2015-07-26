package nitishp.com.caencomputerstatus.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Nitish on 7/9/2015.
 */
public class SquareImageView extends ImageView
{
    public SquareImageView(Context c)
    {
        super(c);
    }

    public SquareImageView(Context c, AttributeSet attributeSet)
    {
        super(c, attributeSet);
    }

    public SquareImageView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int measureWidthSpec, int measureHeightSpec)
    {
        super.onMeasure(measureWidthSpec, measureHeightSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }

}
