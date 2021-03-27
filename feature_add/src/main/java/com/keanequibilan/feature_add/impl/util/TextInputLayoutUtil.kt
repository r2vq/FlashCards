package com.keanequibilan.feature_add.impl.util

import com.google.android.material.textfield.TextInputLayout

internal fun TextInputLayout.getTextOrNull(): String? = editText
    ?.text
    ?.toString()
    ?.trim()
    ?.takeIf { it.isNotEmpty() }
