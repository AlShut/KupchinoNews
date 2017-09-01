package com.example.helen.kupchinonews;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ExtendedMail extends Activity {

	int SELECTION = 3;
	
	Context mainContext;
	
	String title;
	String text;
	String from;
	String where;
	String attach;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.extended_mail);
        
        mainContext = this;
        attach = "";
        
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        
        ((Button)findViewById(R.id.screen_sendnews_btn_selectVideo)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(mainContext, ExtendedMailVideoSelect.class);
				startActivityForResult(i, SELECTION);
			}
		});
        
        ((Button)findViewById(R.id.screen_sendnews_btn_send)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sender_mail_async async_sending = new sender_mail_async();
				async_sending.execute();
			}
		});
    }
    
    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) {
            case 5:
            	((Button)findViewById(R.id.screen_sendnews_btn_selectVideo)).setText(data.getExtras().getString("video_path"));
            	attach = data.getExtras().getString("video_path");
            default:
                break;
        }
    }
    
    private class sender_mail_async extends AsyncTask<Object, String, Boolean> {
    	ProgressDialog WaitingDialog;

		@Override
		protected void onPreExecute() {
			WaitingDialog = ProgressDialog.show(ExtendedMail.this, "Отправка данных", "Отправляем сообщение...", true);
		}
		
		@Override
		protected void onPostExecute(Boolean result) {
			WaitingDialog.dismiss();
			Toast.makeText(mainContext, "Отправка завершена!!!", Toast.LENGTH_LONG).show();
			((Activity)mainContext).finish();
		}

		@Override
		protected Boolean doInBackground(Object... params) {

			try {
				title = ((EditText)findViewById(R.id.screen_sendnews_et_title)).getText().toString();
				text = ((EditText)findViewById(R.id.screen_sendnews_et_text)).getText().toString();
				
				from = "";
				where = "";
				
                MailSenderClass sender = new MailSenderClass("email", "password");
                
                sender.sendMail(title, text, from, where, attach);
			} catch (Exception e) {
				Toast.makeText(mainContext, "Ошибка отправки сообщения!", Toast.LENGTH_SHORT).show();
			}
			
			return false;
		}
	}
}
