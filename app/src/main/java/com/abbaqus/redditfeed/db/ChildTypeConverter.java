package com.abbaqus.redditfeed.db;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.abbaqus.redditfeed.model.Child;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

/**
 * Abbaqus
 * Created by Administrator on 21-07-2018.
 */
public class ChildTypeConverter {

    private static Gson gson = new Gson();
    @TypeConverter
    public static List<Child> stringToList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Child>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String ListToString(List<Child> someObjects) {
        return gson.toJson(someObjects);
    }
}
