package com.javarush.task.task33.task3309;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
class Ex{
    public int count;
    public String str;
    public String[] second;

    public Ex() {
        this.count = 5;
        str = "hello";
        second = new String[]{"1", "2"};
    }
}
