package com.deathhorizon.osukeyboarddroid;

import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

import com.deathhorizon.osukeyboarddroid.ControlKeyboardActivity;

public class KeyBoardStandard extends Activity{
	private Button Z;
	private Button X;
	private DatagramSocket socket;

	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.keyboard_standard);
	    Z = (Button) findViewById(R.id.Z);
	    X = (Button) findViewById(R.id.X);
	
	try {
		socket = new DatagramSocket();
	} catch (SocketException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	
	
	Z.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View arg0) {
			sendMessage("keyboard:key,Z,click");
		};
		}
   );
	
    X.setOnClickListener(new OnClickListener() {
    	@Override
		public void onClick(View arg0) {
			sendMessage("keyboard:key,X,click");
		};
      });
	};
   
	private void sendMessage(final String str) {
		try {
			// ���ȴ���һ��DatagramSocket����
			// ����һ��InetAddree
			InetAddress keyserverAddress = InetAddress.getByName(Settings.ipnum);
			byte data[] = str.getBytes();
			// ����һ��DatagramPacket���󣬲�ָ��������ݰ����͵����統�е��ĸ���ַ���Լ��˿ں�
			DatagramPacket packet = new DatagramPacket(data, data.length,keyserverAddress, Settings.scoketnum);
			// ����socket�����send��������������
			socket.send(packet);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	/**
	 * ��׽�˵��¼�
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.exit:
			Exit();
			return true;
		}
		return false;
	}
	
	//�˳�����
	private void Exit() {
		// TODO �Զ����ɵķ������
		new AlertDialog.Builder(this)
		.setMessage(getString(R.string.exit_message))
		.setPositiveButton(getString(R.string.confirm),
				new DialogInterface.OnClickListener() {
					public void onClick(
						DialogInterface dialoginterface, int i) {
						finish();
					}
				})
		.setNeutralButton(getString(R.string.cancel),
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface arg0, int arg1) {
					}
        }).show();
	}
}
