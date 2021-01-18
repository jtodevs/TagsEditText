package mabbas007.tagsedittext;

import android.graphics.drawable.Drawable;

public class TagProperties {
    private float mTagTextSize;
    private int mTagTextColor;
    private Drawable mTagBackground;

    TagProperties() {

    }

    public TagProperties setTextSize(float size) {
        this.mTagTextSize = size;
        return this;
    }

    public float getTextSize() {
        return mTagTextSize;
    }

    public TagProperties setTextColor(int color) {
        mTagTextColor = color;
        return this;
    }

    public TagProperties setBackgroundDrawable(Drawable drawable) {
        mTagBackground = drawable;
        return this;
    }

    public int getTextColor() {
        return mTagTextColor;
    }

    public Drawable getBackgroundDrawable() {
        return mTagBackground;
    }
}
