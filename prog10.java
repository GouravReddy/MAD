Packagecom.example.exn 

 

Importandroid.app.AlarmManager; 


Importandroid.app.PendingIntent; 

Importandroid.content.Intent; 

Importandroid.os.Bundle; 

Importandroid.support.v7.app.AppCompatActivity; 

Importandroid.view.View; 

Importandroid.widget.TimePicker; 

Importandroid.widget.Toast; 

Importandroid.widget.ToggleButton; 

Importjava.util.Calendar; 

 

publicclassMainActivity extendsAppCompatActivity 

{ 

 TimePicker alarmTimePicker; 

 PendingIntent pendingIntent; 

 AlarmManager alarmManager; 

 

 @Override 

 ProtectedvoidonCreate(Bundle savedInstanceState) 

 { 

super.onCreate(savedInstanceState); 

setContentView(R.layout.activity_main); 

alarmTimePicker = (TimePicker) findViewById(R.id.timePicker); 

alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE); 

 } 

 PublicvoidOnToggleClicked(View view) 

 { 

longtime; 

if(((ToggleButton) view).isChecked()) 

 { 

Toast.makeText(MainActivity.this, "ALARM ON", Toast.LENGTH_SHORT).show(); 

 Calendar calendar = Calendar.getInstance(); 

calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getCurrentHour()); 

calendar.set(Calendar.MINUTE, alarmTimePicker.getCurrentMinute()); 

 Intent intent = newIntent(this, AlarmReceiver.class); 

pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0); 

 

time=(calendar.getTimeInMillis()-(calendar.getTimeInMillis()%60000)); 

if(System.currentTimeMillis()>time) 

 { 

if(calendar.AM_PM == 0) 

time = time + (1000*60*60*12); 

else 

time = time + (1000*60*60*24); 

 } 

alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, time, 10000, pendingIntent); 

 } 


AlarmActivity-java
else 

 { 

alarmManager.cancel(pendingIntent); 

Toast.makeText(MainActivity.this, "ALARM OFF", Toast.LENGTH_SHORT).show(); 

 } 

 } 

} 



Code for AndroidManifest.xml: 

<?xml version="1.0" encoding="utf-8"?> 

<manifest xmlns:android="http://schemas.android.com/apk/res/android" 

package="com.example.exno11"> 

 

<application 

android:allowBackup="true" 

 android:icon="@mipmap/ic_launcher" 

 android:label="@string/app_name" 

android:supportsRtl="true" 

 android:theme="@style/AppTheme"> 

<activityandroid:name=".MainActivity"> 

<intent-filter> 

<actionandroid:name="android.intent.action.MAIN"/> 

 

<categoryandroid:name="android.intent.category.LAUNCHER"/> 

</intent-filter> 

</activity> 

<receiverandroid:name=".AlarmReceiver"> 

</receiver> 

</application> 

</manifest>



Code for AlarmReceiver.java: 

package com.example.exno11; 

 

import android.content.BroadcastReceiver; 

import android.content.Context; 

import android.content.Intent; 

import android.media.Ringtone; 

import android.media.RingtoneManager; 

import android.net.Uri; 

import android.widget.Toast; 

 

public class AlarmReceiver extends BroadcastReceiver 

{ 

 @Override 

public void onReceive(Context context, Intent intent) 

 { 

Toast.makeText(context, "Alarm! Wake up! Wake up!", Toast.LENGTH_LONG).show(); 

 Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM); 

if(alarmUri == null) 

C:\Users\Admin\Desktop\p10-output.png 
{ 

alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION); 

 } 

 Ringtone ringtone = RingtoneManager.getRingtone(context, alarmUri); 

ringtone.play(); 

 }   
