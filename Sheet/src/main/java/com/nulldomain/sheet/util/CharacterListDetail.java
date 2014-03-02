package com.nulldomain.sheet.util;

/**
 * Created by Dustin on 3/1/14.
 */
public class CharacterListDetail {
    String _character_name;
    String _game_master;
    String _portrait_thumbnail;
    String _last_modified_date;
    String _age;

    public CharacterListDetail(String name, String gm, String portrait,
                               String last_modified, String age) {
        this._character_name = name;
        this._game_master = gm;
        this._portrait_thumbnail = portrait;
        this._last_modified_date = last_modified;
        this._age = age;
    }

    public String getCharacterName() {
        return this._character_name;
    }

    public String getGameMaster() {
        return this._game_master;
    }

    public String getLastModified() {
        return this._last_modified_date;
    }

    public String getCharacterAge() {
        return this._age;
    }
}
