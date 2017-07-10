package com.rasi.clickablerecyclerviewadapter;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.rasi.clickableadapter.BaseAdapter;
import com.rasi.clickableadapter.OnViewHolderClickListener;

import java.util.List;

/**
 * Copyright (c) 2017 Rasi Mobile
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

/**
 * This Adapter class is used to init views and mapping with their assigned values.
 *
 * create by Rasi Mobile
 */
public class MyCustomAdapter extends BaseAdapter<CustomItem> {

    public MyCustomAdapter(@NonNull List<CustomItem> data, @Nullable OnViewHolderClickListener itemClickListener) {
        super(data, itemClickListener);
    }

    @Override
    protected int getItemView() {
        // view id which is going to inflate
        return R.layout.item_adapter;
    }

    @Override
    protected int[] getResIdOfInflatedViews() {
        // id of views which are going to display on UI with custom values
        return new int[]{R.id.tv_first_name, R.id.tv_last_name};
    }

    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position) {

        // Get current item which is going to display on UI
        final CustomItem item = getItem(position);

        // Views mapping
        final TextView tvFirstName = (TextView)holder.getViewById(R.id.tv_first_name);
        final TextView tvLastName = (TextView)holder.getViewById(R.id.tv_last_name);

        // Set values
        tvFirstName.setText(item.getFirstName());
        tvLastName.setText(item.getLastName());
    }
}
