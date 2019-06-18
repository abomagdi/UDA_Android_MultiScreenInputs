package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private AudioManager mAudioManager;
    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListner = new AudioManager.OnAudioFocusChangeListener() {
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
            // Pause playback
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
        } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
            // Resume playback
                mediaPlayer.start();
        } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
            // Stop playback
                releaseMediaPlayer();
        }
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        int count = 0;
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("One","lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("Two","otiiko", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("Three","tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("Four","oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("Five","massokka", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("Six","temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("Seven","kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("Eight","kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("Nine","wo’e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("Ten","na’aacha", R.drawable.number_ten, R.raw.number_ten));

        WordAdaptor itemsAdapter = new WordAdaptor(this, words, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Word word = words.get(position);
                Log.v("NumbersActivity", "Current word: " + word);
                releaseMediaPlayer();

                // Request audio focus for playback
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListner,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Start playback.


                    mediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            Toast.makeText(NumbersActivity.this, "I am done", Toast.LENGTH_SHORT).show();
                            NumbersActivity.this.releaseMediaPlayer();
                        }
                    });
                    Toast.makeText(NumbersActivity.this, "List item clicked", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);
//
//        while(count < words.size()) {
//            TextView wordView = new TextView(this);
//            wordView.setText(words.get(count));
//            rootView.addView(wordView);
//            count += 1;
//        }

    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;

            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListner);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}