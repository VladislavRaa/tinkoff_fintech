package com.moonpi.swiftnotes.kotlin.application

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.replaceText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import com.moonpi.swiftnotes.MainActivity
import com.moonpi.swiftnotes.R
import com.moonpi.swiftnotes.kotlin.util.byContentDesc
import com.moonpi.swiftnotes.kotlin.util.getDevice
import com.moonpi.swiftnotes.kotlin.util.waitFindObject
import java.util.EnumSet.allOf

open class SwiftNotes : AbstractApplication<MainActivity>(MainActivity::class.java) {

    fun checkMainMenu() {
        onView(withText(R.string.app_name)).check(matches(isDisplayed()))
        onView(withId(R.id.noNotes)).check(matches(withText(R.string.no_notes_text)))
        onView(withId(R.id.newNote)).check(matches(isDisplayed()))
    }

    fun clickButtonPlus() {
        onView(withId(R.id.newNote)).perform(click())
    }

    fun checkDefaultElements() {
        onView(withId(R.id.titleEdit)).check(matches(withHint(R.string.note_title)))
        onView(withId(R.id.bodyEdit)).check(matches(withHint(R.string.title_edit_notes_activity)))
    }

    fun clickButtonBack() {
        getDevice().pressBack()
    }

    fun checkSaveYesOrNo() {
        onView(withText(R.string.dialog_save_changes)).check(matches(isDisplayed()))
        onView(withText(R.string.yes_button)).check(matches(isDisplayed()))
        onView(withText(R.string.no_button)).check(matches(isDisplayed()))
    }

    fun clickButtonYes() {
        onView(withText(R.string.yes_button)).perform(click())
    }

    fun clickButtonNo() {
        onView(withText(R.string.no_button)).perform(click())

    }

    fun clickMoreOptions() {
        byContentDesc("More options").waitFindObject().click()
    }

    fun checkMainFunc() {
        onView(withText(R.string.action_backup)).check(matches(isDisplayed()))
        onView(withText(R.string.action_restore)).check(matches(isDisplayed()))
        onView(withText(R.string.action_rate_app)).check(matches(isDisplayed()))
    }

    fun checkEditMenu() {
        onView(withText(R.string.action_font_size)).check(matches(isDisplayed()))
        onView(withText(R.string.action_hide_body)).check(matches(isDisplayed()))
    }

    fun inputTitle(title: String) {
        onView(withId(R.id.titleEdit)).perform(replaceText(title))
    }

    fun inputNote(note: String) {
        onView(withId(R.id.bodyEdit)).perform(replaceText(note))
    }
}