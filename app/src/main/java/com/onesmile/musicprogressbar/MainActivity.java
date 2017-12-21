package com.onesmile.musicprogressbar;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import com.onesmile.musicprogressbar.view.MusicProgressBar_New;

public class MainActivity extends Activity {

	private MusicProgressBar_New mCounter;
	private int time = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mCounter = (MusicProgressBar_New) findViewById(R.id.musicProgressBar);
		mCounter.setChangeListener(new MusicProgressBar_New.OnProgressChangeListener() {
			
			@Override
			public void onProgressChangeEnd(int duration, int progress) {
				
			}
			
			@Override
			public void onProgressChange(int duration, int progress) {
				time = progress;
			}
		});
		
		mCounter.setMax(60 * 3 + 20);
		
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				mCounter.setProgress(++time);
			}
		}, 1000, 1000);
	}
}
