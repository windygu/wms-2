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


    /**
     * 查询.
     * 查询 DocumentTypes
     */
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
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> DocumentTypeResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (DocumentTypeMetadata.aliasMap.containsKey(n) ? DocumentTypeMetadata.aliasMap.get(n) : n));
            states = documentTypeApplicationService.get(
                c,
                DocumentTypeResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            DocumentTypeStateDto.DtoConverter dtoConverter = new DocumentTypeStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toDocumentTypeStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查询.
     * 分页查询 DocumentTypes
     */
    @GetMapping("_page")
    public Page<DocumentTypeStateDto> getPage( HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<DocumentTypeState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> DocumentTypeResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (DocumentTypeMetadata.aliasMap.containsKey(n) ? DocumentTypeMetadata.aliasMap.get(n) : n));
            states = documentTypeApplicationService.get(
                c,
                DocumentTypeResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = documentTypeApplicationService.getCount(c);

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

    /**
     * 查看.
     * 通过 Id 获取单个 DocumentType
     */
    @GetMapping("{documentTypeId}")
    public DocumentTypeStateDto get(@PathVariable("documentTypeId") String documentTypeId, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = documentTypeId;
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
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSONObject.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap());
            }
            count = documentTypeApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (DocumentTypeMetadata.aliasMap.containsKey(n) ? DocumentTypeMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 新建.
     * 新建 DocumentType
     */
    @PostMapping
    public String post(@RequestBody CreateOrMergePatchDocumentTypeDto.CreateDocumentTypeDto value,  HttpServletResponse response) {
        try {
            DocumentTypeCommand.CreateDocumentType cmd = value.toCreateDocumentType();
            if (cmd.getDocumentTypeId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "DocumentType");
            }
            String idObj = cmd.getDocumentTypeId();
            documentTypeApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return idObj;
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 DocumentType
     */
    @PutMapping("{documentTypeId}")
    public void put(@PathVariable("documentTypeId") String documentTypeId, @RequestBody CreateOrMergePatchDocumentTypeDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                DocumentTypeCommand.MergePatchDocumentType cmd = (DocumentTypeCommand.MergePatchDocumentType) value.toCommand();
                DocumentTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(documentTypeId, cmd);
                documentTypeApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            DocumentTypeCommand.CreateDocumentType cmd = (DocumentTypeCommand.CreateDocumentType) value.toCommand();
            DocumentTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(documentTypeId, cmd);
            documentTypeApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 修改.
     * 修改 DocumentType
     */
    @PatchMapping("{documentTypeId}")
    public void patch(@PathVariable("documentTypeId") String documentTypeId, @RequestBody CreateOrMergePatchDocumentTypeDto.MergePatchDocumentTypeDto value) {
        try {

            DocumentTypeCommand.MergePatchDocumentType cmd = value.toMergePatchDocumentType();
            DocumentTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(documentTypeId, cmd);
            documentTypeApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 删除.
     * 删除 DocumentType
     */
    @DeleteMapping("{documentTypeId}")
    public void delete(@PathVariable("documentTypeId") String documentTypeId,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            DocumentTypeCommand.DeleteDocumentType deleteCmd = new DeleteDocumentTypeDto().toDeleteDocumentType();;

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            DocumentTypeResourceUtils.setNullIdOrThrowOnInconsistentIds(documentTypeId, deleteCmd);
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

        public static void setNullIdOrThrowOnInconsistentIds(String documentTypeId, DocumentTypeCommand value) {
            String idObj = documentTypeId;
            if (value.getDocumentTypeId() == null) {
                value.setDocumentTypeId(idObj);
            } else if (!value.getDocumentTypeId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", documentTypeId, value.getDocumentTypeId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, DocumentTypeMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, DocumentTypeMetadata.aliasMap);
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
            ids.forEach(i -> {
                DocumentTypeStateDto dto = new DocumentTypeStateDto();
                dto.setDocumentTypeId(i);
                states.add(dto);
            });
            return states.toArray(new DocumentTypeStateDto[0]);
        }

    }

}

