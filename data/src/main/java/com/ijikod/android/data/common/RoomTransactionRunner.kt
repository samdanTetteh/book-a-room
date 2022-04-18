package com.ijikod.android.data.common

import javax.inject.Inject

class RoomTransactionRunner @Inject constructor(
    private val db: BookARoomDatabase
) : DatabaseTransactionRunner {
    override operator fun invoke(func: () -> Unit) {
        db.runInTransaction {
            func()
        }
    }
}