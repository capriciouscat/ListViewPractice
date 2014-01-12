package com.example.listviewtest;

import android.os.Handler;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.TextView;

import android.view.Menu;

public class ListViewTestActivity extends Activity {
	private Handler handler = new Handler();
	
	private TextView curryText;
	private TextView ramenText;
	private TextView omuriceText;
	private LunchMenu curryObject;
	private LunchMenu ramenObject;
	private LunchMenu omuriceObject;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view_test);
		
		LunchMenu[] menu = 
			{ new LunchMenu("カレー", 850), 
			  new LunchMenu("ラーメン", 780), 
			  new LunchMenu("オムライス", 900)};
		
		ArrayAdapter<LunchMenu> adapter = new ArrayAdapter<LunchMenu>(this, R.layout.list_item02, R.id.list02, menu );
		
		ListView listView = (ListView) findViewById(R.id.listView1);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener(){
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id){
				switch(position) {
				case 0 : curryText = (TextView)view.findViewById(R.id.list02);
				         curryObject = (LunchMenu) parent.getItemAtPosition(position);
				         currySetMethod();
				         break;
				
				case 1 : ramenText = (TextView)view.findViewById(R.id.list02);
				         ramenObject = (LunchMenu) parent.getItemAtPosition(position);
				         ramenSetMethod();
				         break;
				
				case 2 : omuriceText = (TextView)view.findViewById(R.id.list02);
				         omuriceObject = (LunchMenu) parent.getItemAtPosition(position);
				         omuriceSetMethod();
				         break;
				}
				
				((TextView)view.findViewById(R.id.list02)).setText("注文しました");
				
				
				LunchMenu clickMenu = (LunchMenu) parent.getItemAtPosition(position);
				Toast.makeText(ListViewTestActivity.this, clickMenu.lunchName() + "を注文しました。", Toast.LENGTH_SHORT).show();
			}
		});
	}
	

	private void currySetMethod(){
		new Thread(new Runnable(){
			@Override
			public void run(){
				try{
				    Thread.sleep(3000);
				}catch (Exception e) {
					e.printStackTrace();
				}
				
				handler.post(new Runnable(){
					@Override
					public void run(){
						curryText.setText(curryObject.toString());
					} 
				});
			}
		}).start();
	}
	
	private void ramenSetMethod(){
		new Thread(new Runnable(){
			@Override
			public void run(){
				try{
				    Thread.sleep(3000);
				}catch (Exception e) {
					e.printStackTrace();
				}
				
				handler.post(new Runnable(){
					@Override
					public void run(){
						ramenText.setText(ramenObject.toString());
					} 
				});
			}
		}).start();
	}
	
	private void omuriceSetMethod(){
		new Thread(new Runnable(){
			@Override
			public void run(){
				try{
				    Thread.sleep(3000);
				}catch (Exception e) {
					e.printStackTrace();
				}
				
				handler.post(new Runnable(){
					@Override
					public void run(){
						omuriceText.setText(omuriceObject.toString());
					}
					
				});
			}
		}).start();
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_view_test, menu);
		return true;
	}
		
}
