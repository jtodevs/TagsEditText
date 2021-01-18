package mabbas007.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import mabbas007.tagsedittext.Tag;
import mabbas007.tagsedittext.TagsEditText;

public class MainActivity extends AppCompatActivity
        implements TagsEditText.TagsEditListener, View.OnClickListener {

    private static final String TAG = "MainActivity";
    private TagsEditText mTagsEditText;
    private List<String> fruitList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTagsEditText = (TagsEditText) findViewById(R.id.tagsEditText);
        mTagsEditText.setHint("Enter names of fruits");
        mTagsEditText.setTagsListener(this);
        mTagsEditText.setTagsWithSpacesEnabled(true);
        final String[] fruits = getResources().getStringArray(R.array.fruits);
        fruitList = Arrays.asList(fruits);
        mTagsEditText.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, fruits));
        mTagsEditText.setThreshold(1);

        setButtonClickListener(R.id.btnChangeTags);
        setButtonClickListener(R.id.btnChangeBackground);
        setButtonClickListener(R.id.btnChangeColor);
        setButtonClickListener(R.id.btnChangeSize);
        setButtonClickListener(R.id.btnChangeDrawableLeft);
        setButtonClickListener(R.id.btnChangeDrawableRight);
        setButtonClickListener(R.id.btnChangeClosePadding);
        setButtonClickListener(R.id.btnSetAllCaps);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            mTagsEditText.showDropDown();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnChangeTags: {
                //mTagsEditText.setTags("1", "2", "3");
                mTagsEditText.setTags(new String[]{"1","2","3","4"});
                break;
            }
            case R.id.btnChangeBackground: {
                mTagsEditText.setTagsBackground(R.drawable.square);
                break;
            }
            case R.id.btnChangeColor: {
                mTagsEditText.setTagsTextColor(R.color.blackOlive);
                break;
            }
            case R.id.btnChangeSize: {
                mTagsEditText.setTagsTextSize(R.dimen.larger_text_size);
                break;
            }
            case R.id.btnChangeDrawableLeft: {
                mTagsEditText.setCloseDrawableLeft(R.drawable.dot);
                break;
            }
            case R.id.btnChangeDrawableRight: {
                mTagsEditText.setCloseDrawableRight(R.drawable.tag_close);
                break;
            }
            case R.id.btnChangeClosePadding: {
                mTagsEditText.setCloseDrawablePadding(R.dimen.larger_padding);
                break;
            }
            case R.id.btnSetAllCaps: {
                mTagsEditText.setAllCaps(true);
            }
        }
    }

    @Override
    public boolean onNewTag(Tag tag) {
        Log.d(TAG, "Tag added");
        if (!fruitList.contains(tag.getSource().toUpperCase()))  {
            tag.getTagProperties().setTextColor(Color.RED);
        }
        return true;
    }

    @Override
    public void onTagsChanged(Collection<String> tags) {
        Log.d(TAG, "Tags changed: ");
        Log.d(TAG, Arrays.toString(tags.toArray()));
    }

    @Override
    public void onEditingFinished() {
        Log.d(TAG,"OnEditing finished");
//        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.hideSoftInputFromWindow(mTagsEditText.getWindowToken(), 0);
//        //mTagsEditText.clearFocus();
    }

    @Override
    public void onTagRemoved(int tagIndex, Tag removedTag) {
        String str = String.format(Locale.US, "Tag '%s' at index=%d has been removed", removedTag.getSource(), tagIndex);
        Log.d(TAG, "Tag removed: " + str);
        Toast.makeText(MainActivity.this,
                str,
                Toast.LENGTH_SHORT).show();
    }

    private void setButtonClickListener(@IdRes int id) {
        findViewById(id).setOnClickListener(this);
    }
}
