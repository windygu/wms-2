package org.dddml.wms.restful.resource;

import java.util.*;
import java.util.stream.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.documenttype.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "DocumentTypes", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class DocumentTypeResource {


    @Autowired
    private DocumentTypeApplicationService documentTypeApplicationService;


    @GetMapping
    public DocumentTypeStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<DocumentTypeState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = documentTypeApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (DocumentTypeMetadata.aliasMap.containsKey(n) ? DocumentTypeMetadata.aliasMap.get(n) : n)),
                        DocumentTypeResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = documentTypeApplicationService.get(
                        DocumentTypeResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        DocumentTypeResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            DocumentTypeStateDto.DtoConverter dtoConverter = new DocumentTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toDocumentTypeStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_page")
    public Page<DocumentTypeStateDto> getPage( HttpServletRequest request,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "page", defaultValue = "0") Integer page,
                                   @RequestParam(value = "size", required = false) @NotNull Integer size) {
        try {
            List<String> sort = DocumentTypeResourceUtils.getQuerySorts(request.getParameterMap());
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<DocumentTypeState> states = null; 
            Iterable<Map.Entry<String, Object>> queryFilterMap = DocumentTypeResourceUtils.getQueryFilterMap(request.getParameterMap());
            states = documentTypeApplicationService.get(
                        CriterionDto.toSubclass(
                                QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                                        .filter(kv -> DocumentTypeResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                                        .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue()))),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (DocumentTypeMetadata.aliasMap.containsKey(n) ? DocumentTypeMetadata.aliasMap.get(n) : n)),
                        DocumentTypeResourceUtils.getQuerySorts(request.getParameterMap()),
                        firstResult, maxResults);
            long count = documentTypeApplicationService.getCount(queryFilterMap);

            DocumentTypeStateDto.DtoConverter dtoConverter = new DocumentTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<DocumentTypeStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toDocumentTypeStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            statePage.setTotalElements(count);
            return statePage;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public DocumentTypeStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = id;
            DocumentTypeState state = documentTypeApplicationService.get(idObj);
            if (state == null) { return null; }

            DocumentTypeStateDto.DtoConverter dtoConverter = new DocumentTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toDocumentTypeStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = documentTypeApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (DocumentTypeMetadata.aliasMap.containsKey(n) ? DocumentTypeMetadata.aliasMap.get(n) : n)));
            } else {
                count = documentTypeApplicationService.getCount(DocumentTypeResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public String post(@RequestBody CreateOrMergePatchDocumentTypeDto.CreateDocumentTypeDto value,  HttpServletResponse response) {
        try {
            DocumentTypeCommand.CreateDocumentType cmd = value.toCreateDocumentType();
            if (cmd.getDocumentTypeId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "DocumentType");
            }
            documentTypeApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getDocumentTypeId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchDocumentTypeDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                DocumentTypeCommand.MergePatchDocumentType cmd = (DocumentTypeCommand.MergePatchDocumentType) value.toCommand();
                DocumentTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                documentTypeApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            DocumentTypeCommand.CreateDocumentType cmd = (DocumentTypeCommand.CreateDocumentType) value.toCommand();
            DocumentTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            documentTypeApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchDocumentTypeDto.MergePatchDocumentTypeDto value) {
        try {

            DocumentTypeCommand.MergePatchDocumentType cmd = value.toMergePatchDocumentType();
            DocumentTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            documentTypeApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            DocumentTypeCommand.DeleteDocumentType deleteCmd = new DeleteDocumentTypeDto().toDeleteDocumentType();;

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            DocumentTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            documentTypeApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            DocumentTypeMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new DocumentTypePropertyTypeResolver();
    }

    // ////////////////////////////////

    private class DocumentTypePropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return DocumentTypeResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class DocumentTypeResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String id, DocumentTypeCommand value) {
            String idObj = id;
            if (value.getDocumentTypeId() == null) {
                value.setDocumentTypeId(idObj);
            } else if (!value.getDocumentTypeId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getDocumentTypeId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, DocumentTypeMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            return QueryParamUtils.getQuerySorts(queryNameValuePairs, DocumentTypeMetadata.aliasMap);
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (DocumentTypeMetadata.aliasMap.containsKey(fieldName)) {
                return DocumentTypeMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (DocumentTypeMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = DocumentTypeMetadata.propertyTypeMap.get(propertyName);
                if (!StringHelper.isNullOrEmpty(propertyType)) {
                    if (org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.containsKey(propertyType)) {
                        return org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.get(propertyType);
                    }
                }
            }
            return String.class;
        }

        public static Iterable<Map.Entry<String, Object>> getQueryFilterMap(Map<String, String[]> queryNameValuePairs) {
            Map<String, Object> filter = new HashMap<>();
            queryNameValuePairs.forEach((key, values) -> {
                if (values.length > 0) {
                    String pName = getFilterPropertyName(key);
                    if (!StringHelper.isNullOrEmpty(pName)) {
                        Class pClass = getFilterPropertyType(pName);
                        filter.put(pName, ApplicationContext.current.getTypeConverter().convertFromString(pClass, values[0]));
                    }
                }
            });
            return filter.entrySet();
        }

        public static DocumentTypeStateDto[] toDocumentTypeStateDtoArray(Iterable<String> ids) {
            List<DocumentTypeStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                DocumentTypeStateDto dto = new DocumentTypeStateDto();
                dto.setDocumentTypeId(id);
                states.add(dto);
            });
            return states.toArray(new DocumentTypeStateDto[0]);
        }

    }

}

