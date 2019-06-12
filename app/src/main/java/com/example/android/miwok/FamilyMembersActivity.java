package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        int count = 0;
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("father","әpә"));
        words.add(new Word("mother","әṭa"));
        words.add(new Word("son","angsi"));
        words.add(new Word("daughter","tune"));
        words.add(new Word("older brother","taachi"));
        words.add(new Word("younger brother","chalitti"));
        words.add(new Word("older sister","teṭe"));
        words.add(new Word("younger sister","kolliti"));
        words.add(new Word("grandmother","ama"));
        words.add(new Word("grandfather","paapa"));

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