package com.example.advancedrecyclerviewtest.model

class DataSource {

    companion object {
        fun createDataSet(): ArrayList<Card> {
            val list = ArrayList<Card>()
            list.add(
                Card("Exemplo 1", "blablabla", "1")
            )
            list.add(
                Card("Exemplo 2", "blablabla", "2")
            )
            list.add(
                Card("Exemplo 3", "blablabla", "3")
            )

            list.add(
                Card("Exemplo 4", "blablabla", "4")
            )

            return list
        }
    }
}