package com.ijikod.android.book_a_room.meetingRooms.common

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class AutoCompositeDisposable(private val lifecycle: Lifecycle,
                              private val doOnPause: Boolean = false) :
    DefaultLifecycleObserver {

    private val compositeDisposable: CompositeDisposable

    init {
        lifecycle.addObserver(this)
        compositeDisposable = CompositeDisposable()
    }

    fun add(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        if (doOnPause) {
            compositeDisposable.clear()
        }
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        if (!doOnPause) {
            compositeDisposable.clear()
        }
        lifecycle.removeObserver(this)
    }
}

fun Disposable.addTo(d: AutoCompositeDisposable) {
    d.add(this)
}