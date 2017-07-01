package br.com.appdivulga.interfaces;

import android.view.View;

/**
 * Created by jardel on 25/06/2017.
 */

public interface CustomClickListener {
    void clickItem(int position, View v);
    void clickLongItem(int position, View v);
}
