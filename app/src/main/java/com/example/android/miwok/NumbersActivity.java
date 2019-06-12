package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        int count = 0;
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("One","lutti"));
        words.add(new Word("Two","otiiko"));
        words.add(new Word("Three","tolookosu"));
        words.add(new Word("Four","oyyisa"));
        words.add(new Word("Five","massokka"));
        words.add(new Word("Six","temmokka"));
        words.add(new Word("Seven","kenekaku"));
        words.add(new Word("Eight","kawinta"));
        words.add(new Word("Nine","wo’e"));
        words.add(new Word("Ten","na’aacha"));

        WordAdaptor itemsAdapter = new WordAdaptor(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

//        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);
//
//        while(count < words.size()) {
//            TextView wordView = new TextView(this);
//            wordView.setText(words.get(count));
//            rootView.addView(wordView);
//            count += 1;
//        }

    }
}