package com.jokeher.Update.Service;

import com.jokeher.MySQL.SQLBase;
import com.jokeher.Update.Model.Version;

import java.util.List;
import java.util.Map;

/**
 * Created by 10397 on 2016/6/14.
 */
public class VersionService {
    private static final String QUERY_VERSION_HIGHER_OR_EQUAL_EXIST_SQL = "SELECT * FROM version WHERE version>=%d";
    private static final String QUERY_VERSION_HIGHER_EXIST_SQL = "SELECT * FROM version WHERE version>%d";
    private static final String UPDATE_VERSION_SQL = "UPDATE version SET forceUpdate=%b,updateInfo=\'%s\',updateTime=%d,url=\'%s\' where version=%d";
    private static final String INSERT_VERSION_SQL = "INSERT INTO version(version,forceUpdate,updateInfo,updateTime,url) VALUES(%d,%b,\'%s\',%d,'%s')";

    public static boolean insertVersion(Version version) {
        Boolean result = false;

        SQLBase sqlBase = new SQLBase();
        List<Map<String, Object>> list;
        list = sqlBase.queryDateWithReturn(String.format(QUERY_VERSION_HIGHER_OR_EQUAL_EXIST_SQL, new Object[]{Float.floatToIntBits(version.getVersion())}));
        System.out.print(list.size());
        if (list != null && list.size() > 0) {

            if (Float.floatToIntBits(version.getVersion()) == (int) list.get(0).get("version")) {
                result = sqlBase.executeSQL(String.format(UPDATE_VERSION_SQL, new Object[]{version.isForceUpdate(), version.getUpdateInfo(), version.getUpdateTime(), version.getUrl(), Float.floatToIntBits(version.getVersion())}));
            }
        } else {
            result = sqlBase.executeSQL(String.format(INSERT_VERSION_SQL, new Object[]{Float.floatToIntBits(version.getVersion()), version.isForceUpdate(), version.getUpdateInfo(), version.getUpdateTime(), version.getUrl()}));
        }
        return result;
    }

    public static List<Map<String, Object>> getAllUpdateVersion(Float version) {
        List<Map<String, Object>> list=new SQLBase().queryDateWithReturn(String.format(QUERY_VERSION_HIGHER_EXIST_SQL, new Object[]{Float.floatToIntBits(version)}));
        int len=list.size();
        for (int i=0;i<len;i++){
            list.get(i).put("version",Float.intBitsToFloat((int)list.get(i).get("version")));
        }
        return list;
    }

}
