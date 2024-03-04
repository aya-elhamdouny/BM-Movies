package com.example.bmmovies.domain.entities.mapper


import android.os.Build
import androidx.annotation.RequiresApi
import java.util.Locale
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.Year
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.*

interface ModelMapper<From,To> {
    fun convert(from:From?):To
    @RequiresApi(Build.VERSION_CODES.O)
    fun changeDateFormat(
        dateFromApi: String,
        inputDateTemplate: String,
        outputDateTemplate: String
    ): String {
        return try {
            val inputFormatter = DateTimeFormatter.ofPattern(inputDateTemplate, Locale.US)

            val outputFormatter = DateTimeFormatter.ofPattern(outputDateTemplate, Locale.US)

            val localDate = LocalDate.parse(dateFromApi, inputFormatter)
            localDate.format(outputFormatter)

        } catch (e: DateTimeParseException) {

            ""
        }
    }}