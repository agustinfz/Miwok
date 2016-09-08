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

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    private int mSoundResourceId = NO_SOUND_PROVIDED;

    private static final int NO_SOUND_PROVIDED = -1;

    /**
     * Create a new Word Object
     * @param defaultTranslation
     * @param miwokTranslation
     */
    public Word (String defaultTranslation, String miwokTranslation, int soundResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mSoundResourceId = soundResourceId;
    }


    /**
     * Word constructor that take 2 Strings and an image
     * @param defaultTranslation
     * @param miwokTranslation
     * @param imageResourceId
     */
    public Word (String defaultTranslation, String miwokTranslation, int imageResourceId, int soundResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mSoundResourceId = soundResourceId;
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

    public int getImageResourceId() {return mImageResourceId;}

    public boolean hasImage(){ return mImageResourceId != NO_IMAGE_PROVIDED;}

    public int getSoundResourceId(){return mSoundResourceId;}

    public boolean hasSound(){return mSoundResourceId != NO_SOUND_PROVIDED;}
}
