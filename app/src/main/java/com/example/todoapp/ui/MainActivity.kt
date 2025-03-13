package com.example.todoapp.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todo.viewmodel.TodoViewModel
import com.example.todoapp.ui.theme.TodoAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TodoScreen(modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun TodoList(modifier: Modifier = Modifier, todos: List<String>) {
    LazyColumn (
        modifier = modifier
    )
    {
        items(todos) { todo ->
            Text(
                text = todo,
                modifier = Modifier.padding(top=4.dp,bottom=4.dp)
            )
            HorizontalDivider(color = Color.LightGray, thickness = 2.dp)
        }
    }
}


@Composable
fun TodoScreen(modifier: Modifier = Modifier,
               todoViewModel: TodoViewModel = viewModel()) {
    TodoList(modifier,todoViewModel.todos)}

@Composable
fun TodoList(todos: List<String>) {
    LazyColumn (
        modifier = Modifier.padding(8.dp)
    )
    {
        items(todos) { todo ->
            Text(
                text = todo,
                modifier = Modifier.padding(top=4.dp,bottom=4.dp)
            )
            HorizontalDivider(color = Color.LightGray, thickness = 2.dp)
        }
    }
}

