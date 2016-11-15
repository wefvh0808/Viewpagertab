package guessmusic.imooc.com.viewpagertab;

import android.content.Context;
import android.widget.RelativeLayout;

/**
 * Created by god on 2016/11/15.
 */
public abstract class PageView extends RelativeLayout {
    public PageView(Context context) {
        super(context);
    }
    public abstract void refresh();
}