Packagecom.example.exno9; 

Importandroid.app.Notification; 

Importandroid.app.NotificationManager; 

Importandroid.app.PendingIntent; 

Importandroid.content.Intent; 

Importandroid.os.Bundle; 

Importandroid.support.v7.app.AppCompatActivity; 

Importandroid.view.View; 

Importandroid.widget.Button; 

Importandroid.widget.EditText; 

 

PublicclassMainActivity extendsAppCompatActivity 

{ 

 Button notify; 

 EditText e; 

 @Override 

 ProtectedvoidonCreate(Bundle savedInstanceState) 

 { 

super.onCreate(savedInstanceState); 

setContentView(R.layout.activity_main); 

 

notify= (Button) findViewById(R.id.button); 

 e= (EditText) findViewById(R.id.editText); 

 

notify.setOnClickListener(newView.OnClickListener() 

 { 

 @Override 

 PublicvoidonClick(View v) 

 { 

 Intent intent = newIntent(MainActivity.this, SecondActivity.class); 

 PendingIntent pending = PendingIntent.getActivity(MainActivity.this, 0, intent, 0); 

H:\p9-output1.png
H:\p9-output2.png 
Notification noti = newNotification.Builder(MainActivity.this).setContentTitle("New 
Message").setContentText(e.getText().toString()).setSmallIcon(R.mipmap.ic_launcher).setContentIntent(pending).build(); 

 NotificationManager manager = (NotificationManager) 
getSystemService(NOTIFICATION_SERVICE); 

 noti.flags |= Notification.FLAG_AUTO_CANCEL; 

manager.notify(0, noti); 

 } 

 }); 

 } 

} 

} 
