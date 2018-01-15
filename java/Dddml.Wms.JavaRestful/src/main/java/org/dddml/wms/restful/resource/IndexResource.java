package org.dddml.wms.restful.resource;

import org.dddml.wms.restful.annotation.Logged;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

/**
 * Created by Li Yongchun on 2016/8/31.
 */
@Path("/")
public class IndexResource {

    @Context
    private UriInfo uriInfo;
    @Context
    private SecurityContext securityContext;

    @GET
    @Logged
    public PersonTemp get(@Context SecurityContext context) {
        System.out.println(context.getUserPrincipal().getName());
        PersonTemp person = new PersonTemp();
        person.setAge(11);
        person.setName("Li yongchun");
        return person;
    }

    @POST
    public PersonTemp post(PersonTemp in) {
        PersonTemp person = new PersonTemp();
        person.setAge(in.getAge());
        person.setName(in.getName());
        return person;
    }


    public static class PersonTemp {
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
}
