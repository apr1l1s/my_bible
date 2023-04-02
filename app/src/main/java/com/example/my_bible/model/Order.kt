package com.example.my_bible.model

data class Order (
    var customer:Customer,
    var book: Book,
    var date:String
        )