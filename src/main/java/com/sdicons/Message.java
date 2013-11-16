package com.sdicons;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// Data definition that can be rendered to JSON or XML.
// Don't forget to register this object in the AppConfig::providers method.

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Message {

    @XmlElement(name="contents")
    private String contents;

    public Message() {
    }

    public Message(String contetns) {
        this.contents = contetns;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
