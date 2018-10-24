package com.example.estelle.activitydemo.roomdemo.database;


import java.util.Date;

import androidx.room.TypeConverter;

/**
 * Created by gonzalo on 7/21/17
 */

public class DateTypeConverter {

    @TypeConverter
    public static Date toDate(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long toLong(Date value) {
        return value == null ? null : value.getTime();
    }
}
