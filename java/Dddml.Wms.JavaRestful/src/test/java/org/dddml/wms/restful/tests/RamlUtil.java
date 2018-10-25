package org.dddml.wms.restful.tests;

import com.syj.raml.model.api.Raml;
import com.syj.raml.model.datamodel.TypeDeclaration;
import com.syj.raml.model.resources.Resource;
import com.syj.raml.parser.RamlEmitter;
import com.syj.raml.parser.RamlParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangjiefeng on 2018/8/20.
 */
public class RamlUtil {

    public static void main(String[] args) {
        String baseUri = "/api";
        // combine
        PartialRaml[] ramls = new PartialRaml[] {
                new PartialRaml(getRaml0(), null),
                new PartialRaml(getRaml1(), "queries")//,
                //new PartialRaml(getRaml2(), "iam")
        };
        Raml fullRaml = combine(ramls, baseUri);

        // dump
        String fullFilePath = "C:\\Users\\yangjiefeng\\Documents\\GitHub\\wms\\java\\Dddml.Wms.JavaRestful\\"
                        + "src\\main\\resources\\dddml-wms-restful-full.raml";
        File fullFile = new File(fullFilePath);
        RamlEmitter ramlEmitter = new RamlEmitter();
        ramlEmitter.dump(fullRaml, fullFile);

        System.out.println("Dump full raml file Ok.");
    }

    private static Raml getRaml0() {
        String name = "dddml-wms-restful.raml";
        return getRamlFromResource(name);
    }

    private static Raml getRaml1() {
        String queryRamlPath = "C:\\Users\\yangjiefeng\\Documents\\coding.net\\wms\\wms-query\\src\\main\\resources\\dddml-wms-query.raml";
        return getRamlFromFile(queryRamlPath);
    }

    //    private static Raml getRaml2() {
    //        String iamRamlPath = "C:\\Users\\yangjiefeng\\Documents\\coding.net\\wms\\iam\\src\\main\\resources\\malls-sso.raml";
    //        return getRamlFromFile(iamRamlPath);
    //    }

    // //////////////////////////////////////////////////////////////

    private static Raml getRamlFromFile(String filePath) {
        File f = new File(filePath);
        InputStream in = null;
        try {
            in = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Read file error. " + filePath);
        }
        return RamlParser.parse(in);
    }

    private static Raml getRamlFromResource(String name) {
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(name);
        return RamlParser.parse(in);
    }

    public static Raml combine(PartialRaml[] ramls, String baseUri) {
        Raml fullRaml = new Raml();
        fullRaml.setBaseUri(baseUri);
        fullRaml.setTitle(ramls[0].getRaml().getTitle());
        fullRaml.setDescription(ramls[0].getRaml().getDescription());
        fullRaml.setVersion(ramls[0].getRaml().getVersion());
        fullRaml.setProtocols(ramls[0].getRaml().getProtocols());//todo?
        fullRaml.setMediaType(ramls[0].getRaml().getMediaType());//todo?

        List<TypeDeclaration> types = new ArrayList<>();
        List<Resource> resources = new ArrayList<>();
        for (PartialRaml partialRaml : ramls) {
            List<TypeDeclaration> partTS = partialRaml.getRaml().getTypes();
            if(partTS != null) {
                types.addAll(partTS);
            }
            String relUri = null;
            if (partialRaml.getParentResourceName() != null) {
                relUri = partialRaml.getParentResourceName();
                if (!relUri.startsWith("/")) {
                    relUri = "/" + relUri;
                }
            }
            if (relUri != null) {
                Resource parentResource = new Resource();
                parentResource.setRelativeUri(relUri);
                for (Resource r : partialRaml.getRaml().getResources()) {
                    parentResource.addResource(r);
                }
                resources.add(parentResource);
            } else {
                for (Resource r : partialRaml.getRaml().getResources()){
                    resources.add(r);
                }
            }
        }
        fullRaml.setTypes(types);
        fullRaml.setResources(resources);
        return fullRaml;
    }

    static class PartialRaml {
        private Raml raml;
        private String parentResourceName;

        public Raml getRaml() {
            return raml;
        }

        public void setRaml(Raml raml) {
            this.raml = raml;
        }

        public String getParentResourceName() {
            return parentResourceName;
        }

        public void setParentResourceName(String parentResourceName) {
            this.parentResourceName = parentResourceName;
        }


        public PartialRaml(Raml raml, String parentResourceName) {
            this.raml = raml;
            this.parentResourceName = parentResourceName;
        }
    }


}
