package dongting.bwei.com.weekonea;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 作者:${董婷}
 * 日期:2017/6/11
 * 描述:
 */

public class DetailActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.detail);
        TextView tv = (TextView) findViewById(R.id.detatil_content);
        Intent intent = getIntent();
        String content = intent.getStringExtra("content");

        tv.setText(content);

        int image = intent.getIntExtra("image", 0);
        ImageView iv = (ImageView) findViewById(R.id.image);

            iv.setImageResource(image);
    }
}
