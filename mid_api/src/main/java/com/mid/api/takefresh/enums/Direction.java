package com.mid.api.takefresh.enums;

public enum Direction {
    WEBQD("WEBQD", "Web前端"),

    WEBHD("WEBHD", "Web后端"),

    APP("APP", "APP"),

    WXXCX("WXXCX", "微信小程序"),

    CPSJ("CPSJ", "产品设计");


    Direction(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private String code;
    private String desc;

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public Direction getDirectionEnumByCode(String code){
        for (Direction direction : Direction.values()){
            if (direction.getCode().equals(code)){
                return direction;
            }
        }
        return null;
    }
}
