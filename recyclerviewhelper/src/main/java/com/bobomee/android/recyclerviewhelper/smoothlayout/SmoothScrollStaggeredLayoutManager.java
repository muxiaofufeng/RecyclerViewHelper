/*
 * Copyright (C) 2016.  BoBoMEe(wbwjx115@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.bobomee.android.recyclerviewhelper.smoothlayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

/**
 * Optimized implementation of StaggeredGridLayoutManager to SmoothScroll to a Top position.
 *
 * @since 5.0.0-b8
 */
public class SmoothScrollStaggeredLayoutManager extends StaggeredGridLayoutManager {

	private final RecyclerView.SmoothScroller mSmoothScroller;

	public SmoothScrollStaggeredLayoutManager(Context context, int spanCount) {
		this(context, spanCount, VERTICAL);
	}

	public SmoothScrollStaggeredLayoutManager(Context context, int spanCount, int orientation) {
		super(spanCount, orientation);
		mSmoothScroller = new TopSnappedSmoothScroller(context, this);
	}

	@Override
	public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
		mSmoothScroller.setTargetPosition(position);
		startSmoothScroll(mSmoothScroller);
	}

}