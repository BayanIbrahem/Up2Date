package com.dev.bayan_ibrahim.news_app.utiles.annotations

import androidx.annotation.StringDef
import com.dev.bayan_ibrahim.news_app.utiles.Constants

@Retention(AnnotationRetention.SOURCE)
@StringDef (
    Constants.SearchIn.TITLE,
    Constants.SearchIn.DESCRIPTION,
    Constants.SearchIn.CONTENT,
)
annotation class SearchIn()
