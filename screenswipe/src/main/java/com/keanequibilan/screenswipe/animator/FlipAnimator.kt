package com.keanequibilan.screenswipe.animator

import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.DecelerateInterpolator
import androidx.core.animation.addListener

internal class FlipAnimator(
    target: View,
    duration: Long
) {
    private val rotateStart = ObjectAnimator
        .ofFloat(target, "rotationY", 0f, 90f)
        .also { animator ->
            animator.interpolator = DecelerateInterpolator()
            animator.duration = duration / 2
        }

    private val rotateEnd = ObjectAnimator
        .ofFloat(target, "rotationY", 270f, 360f)
        .also { animator ->
            animator.interpolator = AccelerateDecelerateInterpolator()
            animator.duration = duration / 2
        }

    init {
        val scale = target.context.resources.displayMetrics.density
        target.cameraDistance = 28400f * scale
    }

    fun flip(hide: View, show: View) {
        rotateStart.run {
            addListener(
                onEnd = {
                    hide.visibility = View.INVISIBLE
                    show.visibility = View.VISIBLE
                    removeAllListeners()
                    rotateEnd.start()
                }
            )
            start()
        }
    }
}
