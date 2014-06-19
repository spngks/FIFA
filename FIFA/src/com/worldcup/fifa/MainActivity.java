package com.worldcup.fifa;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

/*
 * Simple Main Activity with Redirect Intends without additional 
 * Activity. Just shuffles the images based on onclick event programatically.
 * uploaded to GIT 
 * Reduced space by having an array of Resource integers.
 */
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);

	if (savedInstanceState == null) {
	    getSupportFragmentManager().beginTransaction()
		    .add(R.id.container, new PlaceholderFragment()).commit();
	}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.main, menu);
	return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
	// Handle action bar item clicks here. The action bar will
	// automatically handle clicks on the Home/Up button, so long
	// as you specify a parent activity in AndroidManifest.xml.
	int id = item.getItemId();
	if (id == R.id.action_settings) {
	    System.exit(1);
	    return true;
	} else if (id == R.id.action_feedback) {
	    // Redirecting to the Feedback URL
	    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
		    Uri.parse(getString(R.string.feedback_URL)));
	    startActivity(browserIntent);

	    return true;
	} else if (id == R.id.action_comment) {
	    // Redirecting user to Comments URL
	    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
		    Uri.parse(getString(R.string.comment_URL)));
	    startActivity(browserIntent);
	    return true;
	}

	return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

	public PlaceholderFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	    View rootView = inflater.inflate(R.layout.fragment_main, container,
		    false);

	    ImageView imgView = (ImageView) rootView
		    .findViewById(R.id.imageview);

	    imgView.setImageResource(R.drawable.group11);
	    imgView.setContentDescription(getString(R.string.img_min));
	    imgView.setOnClickListener(OnimageclickListener);
	    // imgView.setOnDragListener(dragListener);

	    return rootView;
	}

	OnClickListener OnimageclickListener = new OnClickListener() {

	    @Override
	    public void onClick(View arg0) {
		// TODO Auto-generated method stub

		// Local identifier for imageView
		ImageView imageView = (ImageView) arg0
			.findViewById(R.id.imageview);		

		// Array of Resources integer values to display in order.
		Object[] obj = { R.drawable.group11, R.drawable.group1,
			R.drawable.group2, R.drawable.group3,
			R.drawable.group4, R.drawable.group5,
			R.drawable.group6, R.drawable.group7,
			R.drawable.group8, R.drawable.group9,
			R.drawable.group10, R.drawable.group12, };

		// interger to identifier the current Image being displayed
		int i = Integer.parseInt(imageView.getContentDescription()
			.toString());

		// Keeps incrementing untill the last one
		if (i < obj.length) {
		    i++;
		} else {
		    i = 1;
		}

		imageView.setImageResource((int) obj[i - 1]);
		imageView.setContentDescription(String.valueOf(i));

	    }
	};

    }

}
