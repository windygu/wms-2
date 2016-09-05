package org.dddml.wms.restful.resource;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * Created by Li Yongchun on 2016/8/31.
 */
@Path("/")
public class IndexResource {
    @GET
    public Object get() {
        Person person = new Person();
        person.setAge(11);
        person.setName("Li yongchun");
        return person;
    }

    @POST
    public Object post(Person in) {
        Person person = new Person();
        person.setAge(in.getAge());
        person.setName(in.getName());
        return person;
    }
}

class Person {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
