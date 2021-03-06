/*
 Copyright 2015 Satoru Fujiwara
 Modifications Copyright(C) 2016 Fred Grott(GrottWorkShop)

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

 */
package com.github.shareme.greenmaterialscrolling.library.behavior;

import android.view.View;

import com.github.shareme.greenmaterialscrolling.library.Behavior;


@SuppressWarnings("unused")
public class ScrollFadingBehavior extends Behavior {

    private int targetTop = 0;

    @Override
    protected void onScrolled(final View target, final int scrollY, final int dy) {
        computeTranslation(target, scrollY, dy);
    }

    @Override
    protected void onGlobalLayout(final View target) {
        targetTop = target.getTop();
    }


    protected void computeTranslation(final View target, final int scrollY, final int y) {
        target.setTranslationY(-Math.min(scrollY, getFlexibleHeight()));
        if (targetTop != 0) {
            target.setAlpha(Math.max(0.0f, Math.min(1.0f, 1.0f - (float) y / (float) targetTop)));
        }
    }
}
