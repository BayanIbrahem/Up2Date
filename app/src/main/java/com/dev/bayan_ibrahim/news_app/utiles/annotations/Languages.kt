package com.dev.bayan_ibrahim.news_app.utiles.annotations

import androidx.annotation.StringDef
import com.dev.bayan_ibrahim.news_app.utiles.Constants

@Retention(AnnotationRetention.SOURCE)
@StringDef (
    Constants.Languages.ARABIC,
    Constants.Languages.GERMAN,
    Constants.Languages.ENGLISH,
    Constants.Languages.FRANCE,
    Constants.Languages.ITALIAN,
    Constants.Languages.DUTCH,
    Constants.Languages.NORWEGIAN,
    Constants.Languages.PORTUGUESE,
    Constants.Languages.RUSSIAN,
    Constants.Languages.SWEDISH,
    Constants.Languages.SHINESE,
)
annotation class Languages()
