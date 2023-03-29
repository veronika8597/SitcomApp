package com.example.sitcomapplication

data class CharacterModel(
    val fullName: String,
    val image: Int,
    val showName: String)

    val charactersList = listOf(
        CharacterModel("Rachel Green", R.drawable.rachel, "Friends"),
        CharacterModel("Ross Geller", R.drawable.ross, "Friends"),
        CharacterModel("Monica Geller", R.drawable.monica, "Friends"),
        CharacterModel("Joey Tribbiani", R.drawable.joey, "Friends"),
        CharacterModel("Phoebe Buffay", R.drawable.phoebe, "Friends"),
        CharacterModel("Chandler Bing", R.drawable.chandler, "Friends"),
        CharacterModel("Gloria Delgado-Pritchett", R.drawable.gloria, "Modern Family"),
        CharacterModel("Manny Delgado", R.drawable.manny, "Modern Family"),
        CharacterModel("Jay Pritchett", R.drawable.jay, "Modern Family"),
        CharacterModel("Claire Dunphy", R.drawable.claire, "Modern Family"),
        CharacterModel("Phil Dunphy", R.drawable.phil, "Modern Family"),
        CharacterModel("Haley Dunphy", R.drawable.haley, "Modern Family"),
        CharacterModel("Ted Mosby", R.drawable.ted, "How I met your mother"),
        CharacterModel("Robin Scherbatsky", R.drawable.robin, "How I met your mother"),
        CharacterModel("Barney Stinson", R.drawable.barney, "How I met your mother"),
        CharacterModel("Lily Aldrin", R.drawable.lily, "How I met your mother"),
        CharacterModel("Marshall Ericsson", R.drawable.marshall, "How I met your mother")
    )

