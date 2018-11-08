package com.server.dto;

/**
 * @author CYX
 * @date 2018/11/7 18:44
 */
public class PersonDTO {

    private String name;
    private String id;
    private String age;

    /**
     * 是否开启slave路由
     * <p>
     * 0-关闭，1-开启
     */
    private String slaveFlag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSlaveFlag() {
        return slaveFlag;
    }

    public void setSlaveFlag(String slaveFlag) {
        this.slaveFlag = slaveFlag;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", age='" + age + '\'' +
                ", slaveFlag='" + slaveFlag + '\'' +
                '}';
    }
}
