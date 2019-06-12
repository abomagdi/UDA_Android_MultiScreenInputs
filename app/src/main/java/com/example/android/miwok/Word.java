package com.example.android.miwok;

public class Word {

    private String mDefaultTranslation;

    private String mMiwokTranslation;

    public Word(String defualtTranslation, String MiwokTranslation){
        mDefaultTranslation = defualtTranslation;
        mMiwokTranslation = MiwokTranslation;
    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }


}
