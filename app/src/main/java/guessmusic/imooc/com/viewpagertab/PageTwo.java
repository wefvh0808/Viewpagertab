package guessmusic.imooc.com.viewpagertab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by god on 2016/11/15.
 */
public class PageTwo extends PageView {
    public PageTwo(Context context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.page_content, null);
        TextView textView = (TextView) view.findViewById(R.id.text);
        textView.setText("Page two");
        addView(view);
    }

    @Override
    public void refresh() {

    }
}