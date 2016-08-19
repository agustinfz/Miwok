package com.example.android.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by afonts on 8/17/16.
 */
public class WordAdapter extends ArrayAdapter<Word>{

    /**
     * Custom contructor.The context is used to inflate the new layout file and the list of
     * data we want to populate into the list
     * @param context current context. Used to inflate the layout file
     * @param words A list of Word objects to display in a List
     */
    public WordAdapter(Activity context, ArrayList<Word> words){
        // Initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super (context, 0, words);
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

        return listItemView;
    }

       //return super.getView(position, convertView, parent);
}

