package org.dddml.wms.raml;

import com.syj.raml.model.datamodel.*;
import com.syj.raml.model.resources.RamlMethod;
import com.syj.raml.parser.javadoc.MethodDoc;
import com.syj.raml.parser.parameter.ResourceParameterProcessor;
import org.dddml.wms.specialization.annotation.Specification;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;


/**
 * Created by yangjiefeng on 2018/8/24.
 */
public class SpecificationResourceParameterProcessor implements ResourceParameterProcessor {

    @Override
    public boolean canResolve(final Method method, final RamlMethod me, final Parameter parameter) {
        Specification a = parameter.getAnnotation(Specification.class);
        //if(HttpServletRequest.class.isAssignableFrom(parameter.getType())) {
        //    System.out.println(parameter);
        //}
        return a != null;
    }

    @Override
    public void resolve(RamlMethod ramlMethod, Method method, MethodDoc methodDoc, Parameter parameter, String s) {
        Specification a = parameter.getAnnotation(Specification.class);
        Class type = a.value();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(type);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                if (propertyDescriptor.getName().startsWith("_")) {
                    continue;
                }
                Class propertyType = propertyDescriptor.getPropertyType();
                TypeDeclaration typeDeclaration = null;
                if (propertyType.equals(String.class)) {
                    typeDeclaration = new StringTypeDeclaration();
                } else if (propertyType.equals(java.util.Date.class) || propertyType.equals(java.sql.Timestamp.class)) {
                    typeDeclaration = new DateTimeTypeDeclaration(propertyType.getName());
                } else if (propertyType.equals(java.sql.Date.class)) {
                    typeDeclaration = new DateTimeTypeDeclaration(propertyType.getName());
                } else if (Number.class.isAssignableFrom(propertyType)) {
                    typeDeclaration = new NumberTypeDeclaration();
                } else if (Boolean.class.isAssignableFrom(propertyType)) {
                    typeDeclaration = new BooleanTypeDeclaration();
                }
                if(typeDeclaration == null) {
                    continue;
                }
                typeDeclaration.setRequired(false);
                typeDeclaration.setName(propertyDescriptor.getName());
                ramlMethod.addQueryParameter(typeDeclaration);
            }
        } catch (IntrospectionException e) {
            throw new RuntimeException(e);
        }


    }

}
