package com.example.android.miwok;

/**
 * Created by afonts on 8/17/16.
 * {@link Word} represents a vocabulary word the user wants to learn. Contains a default translation and a Miwok translation
 */
public class Word {

    /*Default Translation of the word*/
    private String mDefaultTranslation;

    /*Miwok translation of the word */
    private String mMiwokTranslation;

    /**
     * Create a new Word Object
     * @param defaultTranslation
     * @param miwokTranslation
     */
    public Word (String defaultTranslation, String miwokTranslation){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    /**
     * Get the default translation of the word
     * @return
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the miwok translation of the word
     * @return
     */
    public String getMiworkTranslation() {
        return mMiwokTranslation;
    }
}
