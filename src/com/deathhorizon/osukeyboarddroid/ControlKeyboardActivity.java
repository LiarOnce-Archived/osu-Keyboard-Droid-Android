package com.deathhorizon.osukeyboarddroid;

import android.app.Activity;
import android.content.Intent;


public class ControlKeyboardActivity extends Activity {

	public void keyboard() {
		/*
		 * // EditText et = (EditText) this.findViewById(R.id.editText); //
		 * ��ÿ��Ƽ��̵���Ķ��� InputMethodManager imm = (InputMethodManager)
		 * ControlActivity.this .getSystemService(INPUT_METHOD_SERVICE);
		 * 
		 * // �򿪣��Զ����Ƶ��ٴε����ť�ͻ���ʧ�ģ� imm.toggleSoftInput(0,
		 * InputMethodManager.HIDE_NOT_ALWAYS);
		 */
		Intent intent = new Intent(this, KeyBoardStandard.class);
		this.startActivity(intent);
		this.finish();
	}
}
