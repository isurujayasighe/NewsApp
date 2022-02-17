package com.isuru.kotlinapp.repository.local

import androidx.room.TypeConverter
import com.isuru.kotlinapp.repository.model.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}