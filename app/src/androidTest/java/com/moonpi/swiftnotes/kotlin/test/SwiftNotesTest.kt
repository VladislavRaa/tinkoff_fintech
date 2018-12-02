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
            deviceScreenshot("Создание заметки")
        }
        step("Проверить текст ‘Save changes?’") {
            app.buttonBack()
            app.buttonBack()
            app.checkSaveYesOrNo()
            app.clickButtonNo()
            deviceScreenshot("Диалоговое окно")
        }
        step("Переход на стартовый экран") {
            app.checkMainMenu()
            deviceScreenshot("Стартовый экран")
        }

    }
}