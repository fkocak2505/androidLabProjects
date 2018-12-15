package com.example.com.project.expandablelistview;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;


public class MainActivity extends Activity {

	public List<String> list_parent;
	public ExpandListViewAdapter expand_adapter;
	public HashMap<String, List<String>> list_child;
	public ExpandableListView expandlist_view;
	public List<String> gs_list; 
	public List<String> fb_list;
	public int last_position = -1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		expandlist_view = (ExpandableListView)findViewById(R.id.expand_listview);
		
		Haz�rla(); // expandablelistview i�eri�ini haz�rlamak i�in
		
		// Adapter s�n�f�m�z� olu�turmak i�in ba�l�klardan olu�an listimizi ve onlara ba�l� olan elemanlar�m�z� olu�turmak i�in HaspMap t�r�n� yolluyoruz
		expand_adapter = new ExpandListViewAdapter(getApplicationContext(), list_parent, list_child);
		expandlist_view.setAdapter(expand_adapter);  // olu�turdu�umuz adapter s�n�f�n� set ediyoruz
		expandlist_view.setClickable(true);
		
		expandlist_view.setOnChildClickListener(new OnChildClickListener() {
			
			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				
			String child_name = (String)expand_adapter.getChild(groupPosition, childPosition);
			//Toast.makeText(getApplicationContext(),"hey" + child_name, Toast.LENGTH_LONG).show();
			
			AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
			builder.setMessage(child_name)
			       .setTitle("Mobilhanem Expandablelistview")
			       .setCancelable(false)
			       .setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
			           public void onClick(DialogInterface dialog, int id) {
			                
			           }
			       });
			AlertDialog alert = builder.create();
			alert.show();
			
				
				return false;
			}
		});
		
		
		/*
		expandlist_view.setOnGroupExpandListener(new OnGroupExpandListener() {
			
			@Override
			public void onGroupExpand(int groupPosition) {
				
				if(last_position != -1 && last_position != groupPosition)
				{
					expandlist_view.collapseGroup(last_position);
				}
				last_position = groupPosition;
				
			}
		});
		*/
		
	}
	public void Haz�rla()
	{
		list_parent = new ArrayList<String>();  // ba�l�klar�m�z� listemelek i�in olu�turduk
		list_child = new HashMap<String, List<String>>(); // ba�l�klara ba�l� elemenlar� tutmak i�in olu�turduk
		
		list_parent.add("GALATASARAY");  // ilk ba�l��� giriyoruz
		list_parent.add("FENERBAHCE");   // ikinci ba�l��� giriyoruz
		
		gs_list = new ArrayList<String>();  // ilk ba�l�k i�in alt elemanlar� tan�ml�yoruz
		gs_list.add("Muslera");
		gs_list.add("Sabri");
		gs_list.add("Chejdou");
		gs_list.add("Semih Kaya");
		gs_list.add("Telles");
		gs_list.add("Sel�uk �nan");
		gs_list.add("Felipe Melo");
		gs_list.add("Hamit");
		gs_list.add("Weslej Sneijder");
		gs_list.add("Bruma");
		gs_list.add("Burak Y�lmaz");
		
		fb_list = new ArrayList<String>(); // ikinci ba�l�k i�in alt elemanlar� tan�ml�yoruz
		fb_list.add("Volkan Demirel");
		fb_list.add("G�khan G�n�l");
		fb_list.add("Bekir");
		fb_list.add("Caner Erkin");
		fb_list.add("Mehmet Topal");
		fb_list.add("Emre");
		fb_list.add("Alper Potuk");
		fb_list.add("Mehmet Topuz");
		fb_list.add("Diego");
		fb_list.add("Sow");
		fb_list.add("Emenike");
		
		list_child.put(list_parent.get(0),gs_list); // ilk ba�l���m�z� ve onlar�n elemanlar�n� HashMap s�n�f�nda tutuyoruz 
		list_child.put(list_parent.get(1), fb_list); // ikinci ba�l���m�z� ve onlar�n elemanlar�n� HashMap s�n�f�nda tutuyoruz
		
		
	}

	
}
