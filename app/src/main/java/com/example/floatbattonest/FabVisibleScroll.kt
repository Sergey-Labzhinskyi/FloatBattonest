package com.example.floatbattonest

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener

class FabVisibleScroll(context: Context?, attrs: AttributeSet?):
    FloatingActionButton.Behavior(context, attrs){



    val TAG: String = FabVisibleScroll::class.java.getName()

    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: FloatingActionButton,
                                target: View, dxConsumed: Int,
                                dyConsumed: Int, dxUnconsumed: Int,
                                dyUnconsumed: Int, type: Int) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed,
            dyUnconsumed, type)
        Log.d(TAG, "onNestedScroll() $dyConsumed")


        if (child.getVisibility() == View.VISIBLE && dyConsumed > 0) {
           // child.hide()
            Log.d(TAG, "hide()")

            child.hide(object : OnVisibilityChangedListener() {
                @SuppressLint("RestrictedApi")
                override fun onHidden(fab: FloatingActionButton) {
                    super.onHidden(fab)
                    fab.visibility = View.INVISIBLE
                }
            })
        } else if (child.getVisibility() == View.INVISIBLE && dyConsumed < 0) {
            //child.show()
            Log.d(TAG, "show()")
            Log.d(TAG, "show()")
            Log.d(TAG, "show()")
            Log.d(TAG, "show()")
            Log.d(TAG, "show()")
            Log.d(TAG, "qqqqqqshow()")
            Log.d(TAG, "show()")
            Log.d(TAG, "show()")




            child.show(object : OnVisibilityChangedListener() {
                @SuppressLint("RestrictedApi")
                override fun onShown(fab: FloatingActionButton) {
                    super.onShown(fab)
                    fab.visibility = View.VISIBLE
                }
            })
        }
       /*
        if (dyConsumed > 0) {
            val layoutParams =  child.getLayoutParams() as CoordinatorLayout.LayoutParams
            val fab_bottomMargin = layoutParams.bottomMargin
            child.animate().translationY(child.getHeight().toFloat() + fab_bottomMargin).setInterpolator(
                LinearInterpolator()
            ).start()
        } else if (dyConsumed < 0) {
            child.animate().translationY(0f).setInterpolator(LinearInterpolator()).start();
        }*/
    }



    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: FloatingActionButton,
                                     directTargetChild: View, target: View, axes: Int, type: Int): Boolean {
        Log.d(TAG, "onStartNestedScroll() ${axes  == ViewCompat.SCROLL_AXIS_VERTICAL}")
        return axes  == ViewCompat.SCROLL_AXIS_VERTICAL //||
               // super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target,
               //     axes, type)
    }

}