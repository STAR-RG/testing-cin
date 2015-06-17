/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.notepad;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.notepad.NotePad.NoteColumns;

/**
 * A generic activity for editing a note in a database.  This can be used
 * either to simply view a note {@link android.content.Intent#ACTION_VIEW}, view and edit a note
 * {@link android.content.Intent#ACTION_EDIT}, or create a new note {@link android.content.Intent#ACTION_INSERT}.
 */
public class NoteEditor extends Activity {
    private static final String TAG = "NoteEditor";

    /**
     * Standard projection for the interesting columns of a normal note.
     */
    private static final String[] PROJECTION = new String[] {
        NoteColumns._ID, // 0
        NoteColumns.NOTE, // 1
        NoteColumns.TITLE, // 2
    };
    /** The index of the note column */
    private static final int COLUMN_INDEX_NOTE = 1;
    /** The index of the title column */
    private static final int COLUMN_INDEX_TITLE = 2;
    
    // This is our state data that is stored when freezing.
    private static final String ORIGINAL_CONTENT = "origContent";

    // The different distinct states the activity can be run in.
    private static final int STATE_EDIT = 0;
    private static final int STATE_INSERT = 1;

    private int mState;
    private Uri mUri;
    private Cursor mCursor;
    private EditText mText;
    private String mOriginalContent;

    /**
     * A custom EditText that draws lines between each line of text that is displayed.
     */
    public static class LinedEditText extends EditText {
        private Rect mRect;
        private Paint mPaint;

        // we need this constructor for LayoutInflater
        public LinedEditText(Context context, AttributeSet attrs) {
            super(context, attrs);
            
            mRect = new Rect();
            mPaint = new Paint();
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setColor(0x800000FF);
        }
        
        @Override
        protected void onDraw(Canvas canvas) {
            int count = getLineCount();
            Rect r = mRect;
            Paint paint = mPaint;

            for (int i = 0; i < count; i++) {
                int baseline = getLineBounds(i, r);

                canvas.drawLine(r.left, baseline + 1, r.right, baseline + 1, paint);
            }

            super.onDraw(canvas);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Intent intent = getIntent();

        // Do some setup based on the action being performed.
        final String action = intent.getAction();
        if (Intent.ACTION_EDIT.equals(action)) {
            // Requested to edit: set that state, and the data being edited.
            mState = STATE_EDIT;
            mUri = intent.getData();
        } else if (Intent.ACTION_INSERT.equals(action)) {
            // Requested to insert: set that state, and create a new entry
            // in the container.
            mState = STATE_INSERT;
            mUri = getContentResolver().insert(intent.getData(), null);

            // If we were unable to create a new note, then just finish
            // this activity.  A RESULT_CANCELED will be sent back to the
            // original activity if they requested a result.
            if (mUri == null) {
                Log.e(TAG, "Failed to insert new note into " + getIntent().getData());
                finish();
                return;
            }

            // The new entry was created, so assume all will end well and
            // set the result to be returned.
            setResult(RESULT_OK, (new Intent()).setAction(mUri.toString()));

        } else {
            // Whoops, unknown action!  Bail.
            Log.e(TAG, "Unknown action, exiting");
            finish();
            return;
        }

        // Set the layout for this activity.  You can find it in res/layout/note_editor.xml
        setContentView(R.layout.note_editor);
        
        // The text view for our note, identified by its ID in the XML file.
        mText = (EditText) findViewById(R.id.note);
        
//        mText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);


        // Get the note!
        mCursor = managedQuery(mUri, PROJECTION, null, null, null);

        // If an instance of this activity had previously stopped, we can
        // get the original text it started with.
        if (savedInstanceState != null) {
            mOriginalContent = savedInstanceState.getString(ORIGINAL_CONTENT);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // If we didn't have any trouble retrieving the data, it is now
        // time to get at the stuff.
        if (mCursor != null) {
            // Requery in case something changed while paused (such as the title)
            mCursor.requery();
            // Make sure we are at the one and only row in the cursor.
            mCursor.moveToFirst();

            // Modify our overall title depending on the mode we are running in.
            if (mState == STATE_EDIT) {
                // Set the title of the Activity to include the note title
                String title = mCursor.getString(COLUMN_INDEX_TITLE);
                Resources res = getResources();
                String text = String.format(res.getString(R.string.title_edit), title);
                setTitle(text);
            } else if (mState == STATE_INSERT) {
                setTitle(getText(R.string.title_create));
            }

            // This is a little tricky: we may be resumed after previously being
            // paused/stopped.  We want to put the new text in the text view,
            // but leave the user where they were (retain the cursor position
            // etc).  This version of setText does that for us.
            String note = mCursor.getString(COLUMN_INDEX_NOTE);
            mText.setTextKeepState(note);
            
            // If we hadn't previously retrieved the original text, do so
            // now.  This allows the user to revert their changes.
            if (mOriginalContent == null) {
                mOriginalContent = note;
            }

        } else {
            setTitle(getText(R.string.error_title));
            mText.setText(getText(R.string.error_message));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Save away the original text, so we still have it if the activity
        // needs to be killed while paused.
        outState.putString(ORIGINAL_CONTENT, mOriginalContent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // The user is going somewhere, so make sure changes are saved

        String text = mText.getText().toString();
        int length = text.length();

        // If this activity is finished, and there is no text, then we
        // simply delete the note entry.
        // Note that we do this both for editing and inserting...  it
        // would be reasonable to only do it when inserting.
        if (isFinishing() && (length == 0) && mCursor != null) {
            setResult(RESULT_CANCELED);
            deleteNote();
        } else {
            saveNote();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate menu from XML resource
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.editor_options_menu, menu);

        // Append to the
        // menu items for any other activities that can do stuff with it
        // as well.  This does a query on the system for any activities that
        // implement the ALTERNATIVE_ACTION for our data, adding a menu item
        // for each one that is found.
        Intent intent = new Intent(null, getIntent().getData());
        intent.addCategory(Intent.CATEGORY_ALTERNATIVE);
        menu.addIntentOptions(Menu.CATEGORY_ALTERNATIVE, 0, 0,
                new ComponentName(this, NoteEditor.class), null, intent, 0, null);

        return super.onCreateOptionsMenu(menu);
    }
    
    

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (mState == STATE_EDIT) {
            menu.setGroupVisible(R.id.menu_group_edit, true);
            menu.setGroupVisible(R.id.menu_group_insert, false);
            
            // Check if note has changed and enable/disable the revert option
            String savedNote = mCursor.getString(COLUMN_INDEX_NOTE);
            String currentNote = mText.getText().toString();
            if (savedNote.equals(currentNote)) {
                menu.findItem(R.id.menu_revert).setEnabled(false);
            } else {
                menu.findItem(R.id.menu_revert).setEnabled(true);
            }
        } else {
            menu.setGroupVisible(R.id.menu_group_edit, false);
            menu.setGroupVisible(R.id.menu_group_insert, true);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle all of the possible menu actions.
        switch (item.getItemId()) {
        case R.id.menu_save:
            saveNote();
            finish();
            break;
        case R.id.menu_delete:
            deleteNote();
            finish();
            break;
        case R.id.menu_revert:
        case R.id.menu_discard:
            cancelNote();
            break;
        }
        return super.onOptionsItemSelected(item);
        
    }
    
    private final void saveNote() {
        // Make sure their current
        // changes are safely saved away in the provider.  We don't need
        // to do this if only editing.
        if (mCursor != null) {
            // Get out updates into the provider.
            ContentValues values = new ContentValues();

            // Bump the modification time to now.
            values.put(NoteColumns.MODIFIED_DATE, System.currentTimeMillis());

            String text = mText.getText().toString();
            int length = text.length();
            // If we are creating a new note, then we want to also create
            // an initial title for it.
            if (mState == STATE_INSERT) {
                if (length == 0) {
                    Toast.makeText(this, R.string.nothing_to_save, Toast.LENGTH_SHORT).show();
                    return;
                }
                String title = text.substring(0, Math.min(30, length));
                if (length > 30) {
                    int lastSpace = title.lastIndexOf(' ');
                    if (lastSpace > 0) {
                        title = title.substring(0, lastSpace);
                    }
                }
                values.put(NoteColumns.TITLE, title);
            }

            // Write our text back into the provider.
            values.put(NoteColumns.NOTE, text);

            // Commit all of our changes to persistent storage. When the update completes
            // the content provider will notify the cursor of the change, which will
            // cause the UI to be updated.
            try {
                getContentResolver().update(mUri, values, null, null);
            } catch (NullPointerException e) {
                Log.e(TAG, e.getMessage());
            }
            
        }
    }

    /**
     * Take care of canceling work on a note.  Deletes the note if we
     * had created it, otherwise reverts to the original text.
     */
    private final void cancelNote() {
        if (mCursor != null) {
            if (mState == STATE_EDIT) {
                // Put the original note text back into the database
                mCursor.close();
                mCursor = null;
                ContentValues values = new ContentValues();
                values.put(NoteColumns.NOTE, mOriginalContent);
                getContentResolver().update(mUri, values, null, null);
            } else if (mState == STATE_INSERT) {
                // We inserted an empty note, make sure to delete it
                deleteNote();
            }
        }
        setResult(RESULT_CANCELED);
        finish();
    }

    /**
     * Take care of deleting a note.  Simply deletes the entry.
     */
    private final void deleteNote() {
        if (mCursor != null) {
            mCursor.close();
            mCursor = null;
            getContentResolver().delete(mUri, null, null);
            mText.setText("");
        }
    }
}
