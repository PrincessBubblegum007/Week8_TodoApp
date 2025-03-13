package com.example.todoapp.model

import retrofit2.http.GET

data class Todo(
    //@SerializedName("userId") var uID: Int,
    var userId: Int,
    var id: Int,
    var title: String,
    var completed: Boolean
)




