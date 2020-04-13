packagecom.example.exno8; 

importandroid.os.Bundle; 

importandroid.support.v7.app.AppCompatActivity; 

importandroid.view.View; 

importandroid.widget.Button; 

importandroid.widget.EditText; 

importandroid.widget.Toast; 

importjava.io.BufferedReader; 

importjava.io.File; 

importjava.io.FileInputStream; 

importjava.io.FileOutputStream; 

importjava.io.InputStreamReader; 

 

publicclassMainActivity extendsAppCompatActivity 

{ 

 EditText e1; 

 Button write,read,clear; 

 @Override 

protectedvoidonCreate(Bundle savedInstanceState) 

 { 

super.onCreate(savedInstanceState); 


setContentView(R.layout.activity_main); 

 

 e1= (EditText) findViewById(R.id.editText); 

write= (Button) findViewById(R.id.button); 

read= (Button) findViewById(R.id.button2); 

clear= (Button) findViewById(R.id.button3); 

 

write.setOnClickListener(newView.OnClickListener() 

 { 

 @Override 

publicvoidonClick(View v) 

 { 

 String message=e1.getText().toString(); 

try 

 { 

 File f=newFile("/sdcard/myfile.txt"); 

f.createNewFile(); 

 FileOutputStream fout=newFileOutputStream(f); 

fout.write(message.getBytes()); 

fout.close(); 

Toast.makeText(getBaseContext(),"Data Written in 
SDCARD",Toast.LENGTH_LONG).show(); 

 } 

catch(Exception e) 

 { 

Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_LONG).show(); 

 } 

 } 

 }); 

 

read.setOnClickListener(newView.OnClickListener() 

 { 

 @Override 

publicvoidonClick(View v) 

 { 

 String message; 

 String buf = ""; 

try 

 { 

 File f = newFile("/sdcard/myfile.txt"); 

 FileInputStream fin = newFileInputStream(f); 

 BufferedReader br = newBufferedReader(newInputStreamReader(fin)); 

while((message = br.readLine()) != null) 

 { 

buf += message; 

 } 


e1.setText(buf); 

br.close(); 

fin.close(); 

Toast.makeText(getBaseContext(),"Data Recived from 
SDCARD",Toast.LENGTH_LONG).show(); 

 } 

catch(Exception e) 

 { 

Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show(); 

 } 

 } 

 }); 

 

clear.setOnClickListener(newView.OnClickListener() 

 { 

 @Override 

publicvoidonClick(View v) 

 { 

e1.setText(""); 

 } 

 }); 

 } 

} 
