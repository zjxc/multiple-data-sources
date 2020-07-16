package com.zjx.multiple.data.sources.annotation.config;

/**
 * @author zjx
 * @version 1.0
 * @date 2020/6/1 15:05
 */
public class DataSourceType {

    public enum DataBaseType {
        /** 数据源1*/
        DB1,
        /** 数据源2*/
        DB2
    }

    private static final ThreadLocal<DataBaseType> TYPE = new ThreadLocal<>();

    public static void setDataBaseType(DataBaseType dataBaseType) {
        if (dataBaseType == null) {
            throw new NullPointerException();
        }
        TYPE.set(dataBaseType);
    }

    public static DataBaseType getDataBaseType() {
        return TYPE.get() == null ? DataBaseType.DB1 : TYPE.get();
    }

    public static void clearDataBaseType() {
        TYPE.remove();
    }
}
