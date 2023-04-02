package com.example.my_bible

import android.app.Application
import com.example.my_bible.model.Book
import com.example.my_bible.model.Customer
import com.example.my_bible.model.Order

class App: Application() {

    var currentCustomer:Customer? = null
    var currentBook:Book? = null
    var currentDate:String? = null

    fun checkOrder():Boolean{
        return !(currentCustomer==null||currentDate==null||currentBook==null)
    }

    val customers = mutableListOf(
        Customer(1,"Алексей Тупикин"),
        Customer(2,"Александр Сафронов"),
        Customer(3,"Сергей Янев")
    )
    val books = mutableListOf(
        Book(1,"Горе от ума","Александр Грибоедов","1980",234),
        Book(2,"10 негритят","Агата Кристи","1992",123),
        Book(3,"Винни-Пух","Алан Александр","1992",211),
        Book(4,"Волшебник Изумрудного города","Александр Волков","1991",361),
        Book(5,"Алые паруса","Александр Грин","1993",251),
        Book(6,"Три мушкетера","Александр Дюма","1994",121),
        Book(7,"Евгений Онегин","Александр Пушкин","1996",741),
        Book(8,"Чума","Альбер Камю","1999",211),
        Book(9,"Сага о ведьмаке","Анджей Сапковский","1966",221),
        Book(10,"Котлован","Андрей Платонов","1955",121),
        Book(11,"Палата №6","Антон Чехов","1976",541),
        Book(12,"Трудно быть Богом","Аркадий и Борис Стругацкие","1965",341),
        Book(13,"Мемуары гейши","Артур Голден","1988",701),
        Book(14,"Шерлок Холмс","Артёр Конан Дойл","1955",411),
        Book(15,"Чтец","Бернхард Шлинк","1923",131),
        Book(16,"А зори здесь тихие","Борис Васильев","1953",531),
        Book(17,"Доктор Живаго","Борис Пастернак","1999",331),
        Book(18,"Дракула","Брем Стокер","1921",901),
        Book(19,"Айвенго","Вальтер Скотт","1978",801),
        Book(20,"Собор Парижской Богоматери","Виктор Гюго","1945",501)
    )
    val orders = mutableListOf(
        Order(customers[2],books[1],"07.04.2023"),
        Order(customers[1],books[19],"07.04.2023")

    )
}