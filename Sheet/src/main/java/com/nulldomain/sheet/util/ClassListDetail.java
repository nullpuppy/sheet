package com.nulldomain.sheet.util;

/**
 * Created by Dustin on 3/2/14.
 */
public class ClassListDetail {
    String _class_name;
    boolean _is_favored_class;
    String _class_type;
    String _class_icon;
    String _class_resource;

    public ClassListDetail(String class_name, boolean is_favored_class,
                           String class_type, String class_resource, String class_icon) {
        this._class_name = class_name;
        this._is_favored_class = is_favored_class;
        this._class_type = class_type;
        this._class_resource = class_resource;
        this._class_icon = class_icon;
    }

    public String getClassName() {
        return _class_name;
    }

    public boolean isFavoredClass() {
        return _is_favored_class;
    }

    public String getClassType() {
        return _class_type;
    }

    public String getClassResource() {
        return _class_resource;
    }

    public String getClassIcon() {
        return _class_icon;
    }
}
