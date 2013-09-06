package back.and.front;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{
    private CheckBox mSwitch;
    private Button mStartBtn;
    private Button mStopBtn;
    private TextView mTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSwitch = (CheckBox) findViewById(R.id.bg_switch);
        mStartBtn = (Button) findViewById(R.id.start_btn);
        mStopBtn = (Button) findViewById(R.id.stop_btn);
        mTime = (TextView) findViewById(R.id.time);

        mStartBtn.setOnClickListener(this);
        mStopBtn.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start_btn:
                startCountDown();
                break;
            case R.id.stop_btn:
                stopCountDown();
                break;
        }
    }

    private boolean running = false;

    private void startCountDown() {
        running = true;

        if(mSwitch.isChecked()) {
            /* solution A create new Thread
            Thread timerA = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i = 10; i > -1; i--){
                        if(!running)
                            break;
                        final String currentTimeLeft = i + "";
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mTime.setText(currentTimeLeft);
                            }
                        });
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                        }
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            stopCountDown();
                        }
                    });
                }
            });
            timerA.start();
            */

            /* solution B use AsyncTask */
            AsyncTask<String, String, String> timerB = new AsyncTask<String, String, String>() {
                @Override
                protected String doInBackground(String... strings) {
                    int countDownFrom = Integer.parseInt(strings[0]);
                    for (int i = countDownFrom; i > -1; i--) {
                        if(!running)
                            break;
                        publishProgress(i + "");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                        }
                    }
                    return null;
                }

                @Override
                protected void onProgressUpdate(String... values) {
                    mTime.setText(values[0]);
                }

                @Override
                protected void onPostExecute(String s) {
                    stopCountDown();
                }
            };
            timerB.execute(mTime.getText().toString());
        } else {
            for(int i = 10; i > -1; i--){
                if(!running)
                    break;
                mTime.setText(i + "");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
            stopCountDown();
        }
    }

    private void stopCountDown() {
        running = false;
        mTime.setText("10");
    }
}
