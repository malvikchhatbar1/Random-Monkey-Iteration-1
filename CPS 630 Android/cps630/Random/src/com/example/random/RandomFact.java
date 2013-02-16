package com.example.random;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RandomFact extends Activity {
	TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        
        tv =(TextView)findViewById(R.id.textView1);
        final Button show = (Button)findViewById(R.id.button1);
        final Button pause = (Button)findViewById(R.id.button2);
		

        tv.setVisibility(0);
        show.setVisibility(0);
        pause.setVisibility(4);
        
		show.setOnClickListener(new View.OnClickListener() 
		{
            @Override
            public void onClick(View v) 
            {
                // Read in the file into a list of strings
                BufferedReader reader = null;
        		try {
        			reader = new BufferedReader(new FileReader("facts.txt"));
        		} catch (FileNotFoundException e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		}
			    List<String> lines = new ArrayList<String>();
			
			    String line = null;
				try {
					line = reader.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			    while( line != null ) {
			        lines.add(line);
			        try {
						line = reader.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			
			    // Choose a random one from the list
			    Random r = new Random();
			    int arraySize = lines.size();
			    String randomString = lines.get(r.nextInt(arraySize));
			    tv.setText(randomString);
			    tv.setVisibility(0);
			    pause.setVisibility(0);
            }
		});
		pause.setOnClickListener(new View.OnClickListener() 
		{
            @Override
            public void onClick(View v) 
            {
            	tv.setText(4);
            	pause.setVisibility(4);
            	show.setVisibility(0);
            }
		});
    }
      
          

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_random, menu);
        return true;
    }
    
}
