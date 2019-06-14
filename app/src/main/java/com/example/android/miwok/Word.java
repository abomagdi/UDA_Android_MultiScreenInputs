package com.example.android.miwok;

public class Word {

    private String mDefaultTranslation;

    private String mMiwokTranslation;

    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private int mAudioResourceId;
    private static final int NO_IMAGE_PROVIDED  = -1;

    public Word(String defualtTranslation, String MiwokTranslation, int audioResource){
        mDefaultTranslation = defualtTranslation;
        mMiwokTranslation = MiwokTranslation;
        mAudioResourceId = audioResource;

    }

    public Word(String defualtTranslation, String MiwokTranslation, int imageResourceId, int audioResource){
        mDefaultTranslation = defualtTranslation;
        mMiwokTranslation = MiwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResource;

    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getAudioResourceId() { return mAudioResourceId; }

}
