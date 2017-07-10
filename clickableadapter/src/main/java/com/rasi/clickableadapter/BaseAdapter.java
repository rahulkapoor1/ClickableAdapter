package com.rasi.clickableadapter;
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
import android.content.res.Resources;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Base adapter to get position of a clicked view in a RecyclerView and also helpful in binding views.
 * Created by rahulkapoor on 22/04/17.
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseAdapter.ClickableViewHolder> {

    private final List<T> mData;

    private final OnViewHolderClickListener mItemClickListener;

    abstract protected int getItemView();

    abstract protected int[] getResIdOfInflatedViews();

    public BaseAdapter(@NonNull final List<T> data) {
        this(data, null);
    }

    public BaseAdapter(@NonNull final List<T> data, @Nullable final OnViewHolderClickListener itemClickListener) {
        this.mData = data;
        this.mItemClickListener = itemClickListener;
    }

    protected final T getItem(int position) {
        return this.mData.get(position);
    }

    @Override
    public final int getItemCount() {
        return mData.size();
    }

    @Override
    public final ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(getItemView(), parent, false);
        return new ClickableViewHolder(view, mItemClickListener, getResIdOfInflatedViews());
    }

    public static class ClickableViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final OnViewHolderClickListener mItemClickListener;

        private SparseArray<View> mInflatedViewsMap;

        public ClickableViewHolder(@NonNull View itemView, @Nullable OnViewHolderClickListener itemClickListener,
                                   @Nullable final int[] resIdOfInflatedViews) {
            super(itemView);
            this.mItemClickListener = itemClickListener;
            if (itemClickListener != null) {
                itemView.setOnClickListener(this);
            }
            initViews(resIdOfInflatedViews);
        }

        private void initViews(@Nullable final int[] resIdOfInflatedViews) {
            if (resIdOfInflatedViews != null) {
                mInflatedViewsMap = new SparseArray<>(0);
                for (Integer viewId : resIdOfInflatedViews) {
                    mInflatedViewsMap.put(viewId, itemView.findViewById(viewId));
                }
            }
        }

        public View getViewById(@IdRes int viewId) {
            final View view = mInflatedViewsMap.get(viewId);
            if (view == null) {
                throw new Resources.NotFoundException("View is not associated with this layout");
            }
            return view;
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onClickAtItem(getAdapterPosition());
            }
        }

    }
}
