package com.dev.bayan_ibrahim.news_app.utiles.annotations

import androidx.annotation.StringDef
import com.dev.bayan_ibrahim.news_app.utiles.Constants

@Retention(AnnotationRetention.SOURCE)
@StringDef(
    Constants.Countries.UNITED_ARAB_EMIRATES,
    Constants.Countries.ARGENTINA,
    Constants.Countries.AUSTRIA,
    Constants.Countries.AUSTRALIA,
    Constants.Countries.BELGIUM,
    Constants.Countries.BULGARIA,
    Constants.Countries.BRAZIL,
    Constants.Countries.CANADA,
    Constants.Countries.SWITZERLAND,
    Constants.Countries.CHINA,
    Constants.Countries.COLOMBIA,
    Constants.Countries.CUBA,
    Constants.Countries.CZECHIA,
    Constants.Countries.GERMANY,
    Constants.Countries.EGYPT,
    Constants.Countries.FRANCE,
    Constants.Countries.UNITED_KINDOM,
    Constants.Countries.GREECE,
    Constants.Countries.HONG_KONG,
    Constants.Countries.HUNGARY,
    Constants.Countries.INDONESIA,
    Constants.Countries.IRELAND,
    Constants.Countries.ISAEL,
    Constants.Countries.INDIA,
    Constants.Countries.ITALY,
    Constants.Countries.JAPAN,
    Constants.Countries.KOREA,
    Constants.Countries.LITHUANIA,
    Constants.Countries.LATVIA,
    Constants.Countries.MOROCCO,
    Constants.Countries.MEXICO,
    Constants.Countries.MALAYSIA,
    Constants.Countries.NIGEIA,
    Constants.Countries.NETHERLAND,
    Constants.Countries.NORWAY,
    Constants.Countries.NEW_ZEALAND,
    Constants.Countries.PHILIPPINES,
    Constants.Countries.POLAND,
    Constants.Countries.PORTUGAL,
    Constants.Countries.ROMANIA,
    Constants.Countries.SERBIA,
    Constants.Countries.RUSSIA,
    Constants.Countries.SAUDI_ARABIA,
    Constants.Countries.SWEDEN,
    Constants.Countries.SOMGAPORE,
    Constants.Countries.SLOVENIA,
    Constants.Countries.SLOVAKIA,
    Constants.Countries.THAILAND,
    Constants.Countries.TURKEY,
    Constants.Countries.TAIWAN,
    Constants.Countries.UKARINE,
    Constants.Countries.USA,
    Constants.Countries.VENEZUELA,
    Constants.Countries.SOUTH_AFRICA,
)
annotation class Countries()

/*
enum class Countries (const val code: String) {
    UNITED_ARAB_EMIRATES("ae")
    ARGENTINA ("ar")
    AUSTRIA ("at")
    AUSTRALIA ("au")
    BELGIUM ("be")
    BULGARIA ("bg")
    BRAZIL ("br")
    CANADA ("ca")
    SWITZERLAND ("ch")
    CHINA ("cn")
    COLOMBIA ("co")
    CUBA ("cu")
    CZECHIA ("cz")
    GERMANY ("de")
    EGYPT ("eg")
    FRANCE ("fr")
    UNITED_KINDOM ("gb")
    GREECE ("gr")
    HONG_KONG ("hk")
    HUNGARY ("hu")
    INDONESIA ("id")
    IRELAND ("ie")
    ISAEL ("il")
    INDIA ("in")
    ITALY ("it")
    JAPAN ("jp")
    KOREA ("kr")
    LITHUANIA ("lt")
    LATVIA ("lv")
    MOROCCO ("ma")
    MEXICO ("mx")
    MALAYSIA ("my")
    NIGEIA ("ng")
    NETHERLAND ("nl")
    NORWAY ("no")
    NEW_ZEALAND ("nz")
    PHILIPPINES ("ph")
    POLAND ("pl")
    PORTUGAL ("pt")
    ROMANIA ("ro")
    SERBIA ("rs")
    RUSSIA("ru")
    SAUDI_ARABIA ("sa")
    SWEDEN ("se")
    SOMGAPORE ("sg")
    SLOVENIA ("si")
    SLOVAKIA ("sk")
    THAILAND ("th")
    TURKEY ("tr")
    TAIWAN ("tw")
    UKARINE ("ua")
    USA ("us")
    VENEZUELA ("ve")
    SOUTH_AFRICA ("za")
}

 */