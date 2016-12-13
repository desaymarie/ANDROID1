package com.example.studentinformation;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener, OnItemSelectedListener {
	
	EditText idno, name;
	RadioGroup sex;
	Spinner course;
	Button cancel, okey;
	private int selected_sex;
	private String selected_course;
	
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
       idno=(EditText) this.findViewById(R.id.editText1);
       name=(EditText) this.findViewById(R.id.editText2);
       sex=(RadioGroup) this.findViewById(R.id.radioGroup1);
       course=(Spinner) this.findViewById(R.id.spinner1);
       cancel=(Button) this.findViewById(R.id.button1);
       okey=(Button) this.findViewById(R.id.button2);
       
       
       okey.setOnClickListener(this);
       cancel.setOnClickListener(this);
       course.setOnItemSelectedListener(this);
       
       
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		int id=arg0.getId();
		
		switch(id)
		{
		
		case R.id.button1: 
			
			 this.idno.setText("");
			this.name.setText("");
		
		
		
			
			
			break;
		case R.id.button2:
			
			selected_sex = sex.getCheckedRadioButtonId();
		
			String idn = this.idno.getText().toString();
			String nem = this.name.getText().toString();
			
			if(idn.equals("") && nem.equals(""))
			{
				
				Toast.makeText(this, "Please fill all fields", Toast.LENGTH_LONG).show();
			}
			else{
				
				RadioButton sexbutton = (RadioButton) this.findViewById(selected_sex);
				String mysex = sexbutton.getText().toString();
				
				AlertDialog.Builder builder = new AlertDialog.Builder(this);
				builder.setTitle("Student Information")
						.setMessage("ID NO: "+idn+"\n"+
									"NAME: "+nem+"\n"+
									"SEX: "+mysex+"\n"+
									"COURSE: "+selected_course)
						.setNegativeButton("CANCEL", null);
				
				AlertDialog dialog = builder.create();
				dialog.show();
			}
			
			
			
			
			
		
		}
		
	}


	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
		selected_course = course.getItemAtPosition(arg2).toString();
		
	}


	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
    
}
