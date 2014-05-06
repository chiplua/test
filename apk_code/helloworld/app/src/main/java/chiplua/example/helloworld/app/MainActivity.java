package chiplua.example.helloworld.app;

import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.os.Handler;
import android.os.Message;
import android.text.format.DateFormat;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class MainActivity extends ActionBarActivity {

    private static final int msgKey1 = 1;
    private TextView mTime;
    private int i = 2;
    public CharSequence sysTimeStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTime = (TextView) findViewById(R.id.myTime);
        new TimeThread().start();
    }

    public class TimeThread extends Thread {
        @Override
        public void run() {
            do {
                try {
                    URL url = new URL("http://bjtime.cn/");//取得资源对象
                    URLConnection uc = url.openConnection();//生成连接对象
                    uc.connect();//发出连接
                    long ld = uc.getDate(); //取得网站日期时间
                    Date datee = new Date(ld); //转换为标准时间对象
                    //分别取得时间中的小时，分钟和秒，并输出
                    //System.out.print(datee.getHours()+"时"+datee.getMinutes()+"分"+datee.getSeconds()+"秒");
                    Log.d("TAG",datee.getHours()+"时"+datee.getMinutes()+"分"+datee.getSeconds()+"秒");
                    sysTimeStr = DateFormat.format("hh:mm:ss", datee);

                    //mTime.setText(date);

                    Thread.sleep(1000);
                    Message msg = new Message();
                    msg.what = msgKey1;
                    mHandler.sendMessage(msg);

                }
                catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

                catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } while (true);
        }
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage (Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case msgKey1:
                    //CharSequence sysTimeStr = DateFormat.format("hh:mm:ss", "date");
                    //mTime.setText(sysTimeStr);
                    //mTime.append("\n");
                    //mTime.append("time is ok");
                    mTime.setText(sysTimeStr);
                    //mTime.append("\n");
                    //mTime.append("TimeDisplay Over");

                    break;

                default:
                    break;
            }
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
