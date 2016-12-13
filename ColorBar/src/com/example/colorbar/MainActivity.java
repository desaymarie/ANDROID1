package com.example.colorbar;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnSeekBarChangeListener {
	
	SeekBar red, blue, green;
	TextView result;
	int r, b, g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.red = (SeekBar) this.findViewById(R.id.seekBar1);
        this.green = (SeekBar) this.findViewById(R.id.seekBar2);
        this.blue = (SeekBar) this.findViewById(R.id.seekBar3);
        this.result = (TextView) this.findViewById(R.id.textView4);
        
        red.setOnSeekBarChangeListener(this);
        green.setOnSeekBarChangeListener(this);
        blue.setOnSeekBarChangeListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
		// TODO Auto-generated method stub
		
		switch(arg0.getId())
		{
		case R.id.seekBar1: r = this.red.getProgress();
			break;
		case R.id.seekBar2: g = this.green.getProgress();
			break;
		case R.id.seekBar3: b = this.blue.getProgress();
		}
		String rValue = String.format("%02x", r);
		String gValue = String.format("%02x", g);
		String bValue = String.format("%02x", b);
		String value = "#"+rValue+gValue+bValue;
		this.result.setBackgroundColor(Color.rgb(r, g, b));
		this.result.setText(value);
	}


	@Override
	public void onStartTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onStopTrackingTouch(SeekBar arg0) {
		// TODO Auto-generated method stub
		
	}
    
}
