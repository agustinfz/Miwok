package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by afonts on 8/17/16.
 */
public class WordAdapter extends ArrayAdapter<Word>{

    private int mBackgroundColor;

    /**
     * Custom contructor.The context is used to inflate the new layout file and the list of
     * data we want to populate into the list
     * @param context current context. Used to inflate the layout file
     * @param words A list of Word objects to display in a List
     */
    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceID){
        // Initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.

        super (context, 0, words);
        mBackgroundColor = colorResourceID;
    }

    /**
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Check if the exisitng view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        //Get the Word object located at this position in the list
        Word currentWord = getItem(position);

        //Find the TextView in the list_item.xml layout with the ID default_text_view
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);

        //Get the default word from the current Word object and set that text on the default TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        //Find the TextView in the list_item.xml layout with the ID miwok_text_view
        TextView englishTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);

        //Get the miwok word from the current Word object and set that text on the miwok TextView
        englishTextView.setText(currentWord.getMiworkTranslation());

        //Find the ImageView in the list_item.cml layout with the ID image
        ImageView imageView = (ImageView)listItemView.findViewById(R.id.image);

        //Check if there is an Image resource for that word and if so, set the view to VISIBLE and get the right image.
        if (currentWord.hasImage()){
            //Get the image from the current Word object and set that image on the Imageview
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(currentWord.getImageResourceId());
        }

        else {
            //If there is no image resource hide the view
            imageView.setVisibility(View.GONE);

        }



        //Set the theme color for the ListView item
        View textContainer = listItemView.findViewById(R.id.text_container);
        //Find the color that the Resource ID maps to
        int color = ContextCompat.getColor(getContext(), mBackgroundColor);
        //Set the background color to the text container view;
        textContainer.setBackgroundColor(color);


        return listItemView;
    }

       //return super.getView(position, convertView, parent);
}

