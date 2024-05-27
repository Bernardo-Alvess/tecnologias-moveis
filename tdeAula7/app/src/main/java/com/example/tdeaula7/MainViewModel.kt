package com.example.tdeaula7

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    fun getProdutos() = mutableListOf(
        Product(
            urlImage = "https://shared.akamai.steamstatic.com/store_item_assets/steam/apps/367520/header.jpg?t=1695270428",
            name = "Hollow Knight",
            price = "46,99"
        ),
        Product(
            urlImage = "https://shared.akamai.steamstatic.com/store_item_assets/steam/apps/1174180/header.jpg?t=1714055653",
            name = "Red Dead Redemption 2",
            price = "299,90"
        ),
        Product(
            urlImage = "https://shared.akamai.steamstatic.com/store_item_assets/steam/apps/1449690/header.jpg?t=1698776763",
            name = "The Walking Dead: The Telltale Definitive Series",
            price = "134,99"
        )
    )
}