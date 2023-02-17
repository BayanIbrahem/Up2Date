package com.dev.bayan_ibrahim.news_app.utiles.annotations

import androidx.annotation.StringDef
import com.dev.bayan_ibrahim.news_app.utiles.Constants
import java.lang.annotation.RetentionPolicy


@Retention(AnnotationRetention.SOURCE)
@StringDef (
    Constants.Categories.BUSINESS,
    Constants.Categories.ENTERTAINMENT,
    Constants.Categories.GENERAL,
    Constants.Categories.HEALTH,
    Constants.Categories.SCIENCE,
    Constants.Categories.SPORTS,
    Constants.Categories.TECHNOLOGY,
        )
annotation class Categories()
