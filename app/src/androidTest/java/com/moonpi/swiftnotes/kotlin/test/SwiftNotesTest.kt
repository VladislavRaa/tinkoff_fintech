package com.moonpi.swiftnotes.kotlin.test

import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import com.moonpi.swiftnotes.kotlin.application.SwiftNotes
import org.junit.Test
import org.junit.runner.RunWith
import ru.tinkoff.allure.android.deviceScreenshot
import ru.tinkoff.allure.annotations.DisplayName
import ru.tinkoff.allure.step

@RunWith(AndroidJUnit4::class)
@LargeTest
@DisplayName("SwiftNotes test")

class SwiftNotesTest : AbstractApplicationTest<SwiftNotes>(SwiftNotes()) {

    @Test
    @DisplayName("Start case 1")
    fun case1() {
        step("Проверить на главном экране\n" +
                "наличие основных элементов:\n" +
                "Заголовок ‘Swiftnotes’\n" +
                "Надпись ‘Press '+' to add new note’\n" +
                "Кнопка ‘+’") {
            app.open()
            app.checkMainMenu()
            deviceScreenshot("Стартовый экран")
        }
        step("Проверить:\n" +
                " Заголовок ‘Title’\n" +
                " Надпись ‘Note’") {
            app.clickButtonPlus()
            app.checkDefaultElements()
            deviceScreenshot("Экран создания заметки")
        }
        step("Проверить текст ‘Save changes?’\n" +
                "Проверить наличие двух кнопок ‘NO’, ‘YES’") {
            app.clickButtonBack()
            app.clickButtonBack()
            app.checkSaveYesOrNo()
            app.clickButtonNo()
            deviceScreenshot("Диалоговое окно")
        }
        step("Переход на стартовый экран") {
            app.checkMainMenu()
            deviceScreenshot("Стартовый экран")
        }

    }

    @Test
    @DisplayName("Start case 2")
    fun case2() {
        app.open()
        app.clickButtonPlus()
        app.inputTitle("Заметка1")
        app.inputNote("Тестовая запись 1")
        app.clickButtonBack()
        //app.checkSaveYesOrNo()
        //app.clickButtonYes()
    }


    @Test
    @DisplayName("Start case 3")
    fun case3() {
        step("Проверить отображение пунктов меню:\n" +
                "‘Backup notes’\n" +
                "‘Restore notes’\n" +
                "‘Rate app’") {
            app.open()
            app.clickMoreOptions()
            app.checkMainFunc()
            deviceScreenshot("Стартовый экран")
            app.clickButtonBack()
        }
        step("Нажать кнопку ‘+’") {
            app.clickButtonPlus()
            deviceScreenshot("Экран создания заметки")
        }
        step("На экране создания заметки нажать на кнопку меню") {
            app.clickMoreOptions()
            app.checkEditMenu()
            deviceScreenshot("Стартовый экран")
        }
    }
}