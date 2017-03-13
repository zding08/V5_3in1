package com.phenix.pcr_v1;

import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	/*
	 * 控件变量定义
	 */
	private Button btnLogin;
	private Button btnCnctBTdev;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnLogin = (Button)findViewById(R.id.login);
		
		btnLogin.setOnClickListener(new btnLoginListener());
	}
	
	// Login button process
		private class btnLoginListener implements OnClickListener{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				String user=((EditText)findViewById(R.id.user)).getText().toString();
				String pwd=((EditText)findViewById(R.id.pwd)).getText().toString();
				String repwd=((EditText)findViewById(R.id.repwd)).getText().toString();
				
				if(!"".equals(user) && !"".equals(pwd)){
					if(!pwd.equals(repwd))
					{
						Toast.makeText(MainActivity.this, "The repeat password don't match"
								+ "password, please input password again", Toast.LENGTH_LONG).show();
						
						((EditText)findViewById(R.id.pwd)).setText("");
						((EditText)findViewById(R.id.repwd)).setText("");
						((EditText)findViewById(R.id.pwd)).requestFocus();
					}else{
						Intent intent=new Intent(MainActivity.this,WorkActivity.class);
						Bundle bundle=new Bundle();
						bundle.putCharSequence("user", user);
						bundle.putCharSequence("pwd", pwd);
						intent.putExtras(bundle);
						startActivity(intent);
						}
				}else{
					Toast.makeText(MainActivity.this, "Please input user information completely", 
							Toast.LENGTH_LONG).show();
				}
			}
			
		}

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
