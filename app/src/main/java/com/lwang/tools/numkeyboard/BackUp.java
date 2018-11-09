package com.lwang.tools.numkeyboard;

/**
 * @author lwang
 * @date 2018/11/09
 * @description 数字键盘的应用
 */
public class BackUp {

    /**

     <EditText
     android:id="@+id/et"
     android:layout_width="match_parent"
     android:layout_height="50dp" />

     <com.lwang.tools.numkeyboard.XNumberKeyboardView
     android:id="@+id/view_keyboard"
     android:layout_width="match_parent"
     android:layout_height="wrap_content"
     android:layout_marginTop="13dp"
     android:background="#ffededed"
     android:focusable="true"
     android:focusableInTouchMode="true"
     android:keyBackground="@drawable/selector_key_background"
     android:keyTextColor="#000000"
     android:shadowColor="@android:color/transparent"
     android:shadowRadius="0"
     app:xnkv_deleteBackgroundColor="#ffededed"
     app:xnkv_deleteDrawable="@mipmap/keyboard_backspace"
     app:xnkv_deleteWidth="22dp" />



     final EditText et = findViewById(R.id.et);
     XNumberKeyboardView mKeyboard = (XNumberKeyboardView)findViewById(R.id.view_keyboard);

     mKeyboard.setIOnKeyboardListener(new XNumberKeyboardView.IOnKeyboardListener() {
    @Override public void onInsertKeyEvent(String text) {
    et.append(text);
    }

    @Override public void onDeleteKeyEvent() {
    int start = et.length() - 1;
    if (start >= 0) {
    et.getText().delete(start, start + 1);
    }
    }
    });

     */
}
