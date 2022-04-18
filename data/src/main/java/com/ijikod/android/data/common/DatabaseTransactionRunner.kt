package com.ijikod.android.data.common

interface DatabaseTransactionRunner {
    operator fun invoke(func: () -> Unit)
}