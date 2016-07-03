package com.deathhorizon.osukeyboarddroid;

import android.app.Activity;
import android.content.Intent;


public class ControlKeyboardActivity extends Activity {

	public void keyboard() {
		/*
		 * // EditText et = (EditText) this.findViewById(R.id.editText); //
		 * 获得控制键盘的类的对象 InputMethodManager imm = (InputMethodManager)
		 * ControlActivity.this .getSystemService(INPUT_METHOD_SERVICE);
		 * 
		 * // 打开（自动控制的再次点击按钮就会消失的） imm.toggleSoftInput(0,
		 * InputMethodManager.HIDE_NOT_ALWAYS);
		 */
		Intent intent = new Intent(this, KeyBoardStandard.class);
		this.startActivity(intent);
		this.finish();
	}
}
