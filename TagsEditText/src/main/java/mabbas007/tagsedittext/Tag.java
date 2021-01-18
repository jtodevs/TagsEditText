package mabbas007.tagsedittext;

import android.os.Parcel;
import android.os.Parcelable;

public final class Tag implements Parcelable {

    private int mPosition;
    private int mIndex;
    private String mSource;
    private boolean mSpan;
    private TagProperties tagProperties;

    public static final Creator<Tag> CREATOR = new Creator<Tag>() {
        @Override
        public Tag createFromParcel(Parcel in) {
            return new Tag(in);
        }

        @Override
        public Tag[] newArray(int size) {
            return new Tag[size];
        }
    };

    Tag() {
        tagProperties = new TagProperties();
    }

    protected Tag(Parcel in) {
        mPosition = in.readInt();
        mIndex = in.readInt();
        mSource = in.readString();
        mSpan = in.readInt() == 1;
        tagProperties = new TagProperties();
    }

    void setPosition(int pos) {
        mPosition = pos;
    }

    int getPosition() {
        return mPosition;
    }

    void setIndex(int index) {
        mIndex = index;
    }

    int getIndex() {
        return mIndex;
    }

    public void setSource(String source) {
        mSource = source;
    }

    public String getSource() {
        return mSource;
    }

    public void setSpan(boolean span) {
        mSpan = span;
    }

    public boolean isSpan() {
        return mSpan;
    }

    public TagProperties getTagProperties() {
        return tagProperties;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mPosition);
        dest.writeInt(mIndex);
        dest.writeString(mSource);
        dest.writeInt(mSpan ? 1 : 0);
    }
}
