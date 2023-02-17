package com.dev.bayan_ibrahim.news_app.data.utiles

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.dev.bayan_ibrahim.news_app.domain.module.Source
import com.dev.bayan_ibrahim.news_app.utiles.Constants

@TypeConverters
class DatabaseConverters {
    @TypeConverter
    fun sourceToString (source: Source): String {
        /* e.g:
           id = 101, name = bbc, delimiter #
           string is: 101#bbc
        */
        return "${source.id}${Constants.Converters.SOURCE_DELIMITER}${source.name}"
    }

    @TypeConverter
    fun stringToSource (string: String): Source {
        val id = string.substringBefore (Constants.Converters.SOURCE_DELIMITER)
        val name = string.substringAfter (Constants.Converters.SOURCE_DELIMITER)
        return Source (id = id, name = name)
    }
}