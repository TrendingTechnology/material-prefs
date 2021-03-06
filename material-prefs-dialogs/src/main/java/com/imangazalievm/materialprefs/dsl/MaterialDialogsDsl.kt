package com.imangazalievm.materialprefs.dsl

import com.imangazalievm.materialprefs.dsl.preferences.ListMultiChoicePreference
import com.imangazalievm.materialprefs.dsl.preferences.ListSinglePreference
import com.imangazalievm.materialprefs.dsl.preferences.PreferenceBuilder
import com.imangazalievm.materialprefs.dsl.preferences.TextInputPreference
import com.imangazalievm.materialprefs.util.checkIsTypeSupported
import kotlin.reflect.KClass

fun <T : Any> PreferenceCategory.listSingleChoice(
    key: String,
    valueType: KClass<T>,
    builder: PreferenceBuilder<ListSinglePreference<T>>
) {
    checkIsTypeSupported(valueType)
    ListSinglePreference(key, valueType, container, appearanceManager)
        .apply(builder)
        .also { addPreference(it) }
}

fun <T : Any> PreferenceCategory.listMultiChoice(
    key: String,
    valueType: KClass<T>,
    builder: PreferenceBuilder<ListMultiChoicePreference<T>>
) {
    checkIsTypeSupported(valueType)
    ListMultiChoicePreference<T>(key, container, appearanceManager)
        .apply(builder)
        .also { addPreference(it) }
}

fun PreferenceCategory.textInput(
    key: String,
    builder: PreferenceBuilder<TextInputPreference>
) {
    TextInputPreference(key, container, appearanceManager)
        .apply(builder)
        .also { addPreference(it) }
}