package com.example.statecompose.todo

import com.example.statecompose.util.generateRandomTodoItem
import com.google.common.truth.Truth.assertThat
import org.junit.Test

internal class TodoViewModelTest {

    @Test
    fun whenRemoving_updateList() {
        // before
        val viewModel = TodoViewModel()
        val item1 = generateRandomTodoItem()
        val item2 = generateRandomTodoItem()
        viewModel.addItem(item1)
        viewModel.addItem(item2)

        // during
        viewModel.removeItem(item1)

        // after
        assertThat(viewModel.todoItems).isEqualTo(listOf(item2))
    }
}