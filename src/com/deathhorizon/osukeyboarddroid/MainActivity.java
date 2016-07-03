package com.deathhorizon.osukeyboarddroid;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText ip;
    EditText socket;
    Button button;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ip = (EditText)findViewById(R.id.ipedit);
        socket = (EditText)findViewById(R.id.socketedit);
        button = (Button)findViewById(R.id.connect);
        button.setOnClickListener(new OnClickListener() { 
        	@Override 
        	public void onClick(View v) { 
        		String ipnum = ip.getText().toString(); 
        		int socketnum = Integer.parseInt(socket.getText().toString());
        		Settings.ipnum =ipnum;
        		Settings.scoketnum = socketnum;
        		try {
        			//首先创建一个DatagramSocket对象
        			DatagramSocket socket = new DatagramSocket();
        			//创建一个InetAddree
					InetAddress keyserverAddress = InetAddress.getByName(ipnum);    			
        			Intent intent = new Intent(MainActivity.this,KeyBoardStandard.class);
        			MainActivity.this.startActivity(intent);
        			MainActivity.this.finish();
        			Toast.makeText(MainActivity.this, "连接成功，赶紧试试吧！", Toast.LENGTH_SHORT).show();
        		} catch (Exception e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
        		} 
        }); 
    }
}
