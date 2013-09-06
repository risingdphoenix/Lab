package back.and.front;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StopWatchActivity extends Activity implements View.OnClickListener{
    private Button mStartBtn;
    private Button mPauseBtn;
    private Button mResetBtn;
    private TextView mTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        mStartBtn = (Button) findViewById(R.id.start_btn);
        mPauseBtn = (Button) findViewById(R.id.pause_btn);
        mResetBtn = (Button) findViewById(R.id.reset_btn);
        mTime = (TextView) findViewById(R.id.time);

        mStartBtn.setOnClickListener(this);
        mPauseBtn.setOnClickListener(this);
        mResetBtn.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.stop_watch, menu);
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start_btn:
                start();
                break;
            case R.id.pause_btn:
                pause();
                break;
            case R.id.reset_btn:
                reset();
                break;
        }
    }

    private void start() {

    }

    private void pause() {

    }

    private void reset() {

    }
}
