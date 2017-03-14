package com.example.sms_and_location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MySms extends BroadcastReceiver {
	
	Location location;
	double lng, lat;
	private String address;
	private String message;

	@Override
	public void onReceive(Context arg0, Intent arg1) {
	
		
		try{
			Bundle b = arg1.getExtras();
			Object[] pdus = (Object[]) b.get("pdus");
			
			for(int i=0; i<pdus.length; i++)
			{
				SmsMessage sms = SmsMessage.createFromPdu((byte[])pdus[i]);
				address = sms.getOriginatingAddress();
				message = sms.getMessageBody();
				
				
				Toast.makeText(arg0, "Sender: "+address+" Message: "+message, Toast.LENGTH_LONG).show();
				
				location = new Location(arg0);
				lng = location.getLong();
				lat = location.getLat();
				
				if(message.equals("Paulina"))
				{
					SmsManager m = SmsManager.getDefault();
					m.sendTextMessage(address, null, ""+address+"\nLongitude: "+lng+" Latitude: "+lat, null, null);
				}
			

			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		

	}

}
