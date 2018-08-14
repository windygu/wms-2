package org.dddml.wms.restful.resource;

import java.util.*;
import java.util.stream.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.inventoryitem.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.physicalinventory.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "PhysicalInventories", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class PhysicalInventoryResource {


    @Autowired
    private PhysicalInventoryApplicationService physicalInventoryApplicationService;


    /**
     * 查询.
     * 查询 PhysicalInventories
     */
    @GetMapping
    public PhysicalInventoryStateDto[] getAll( HttpServletRequest request,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                    @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                    @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<PhysicalInventoryState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> PhysicalInventoryResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (PhysicalInventoryMetadata.aliasMap.containsKey(n) ? PhysicalInventoryMetadata.aliasMap.get(n) : n));
            states = physicalInventoryApplicationService.get(
                c,
                PhysicalInventoryResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            PhysicalInventoryStateDto.DtoConverter dtoConverter = new PhysicalInventoryStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPhysicalInventoryStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查询.
     * 分页查询 PhysicalInventories
     */
    @GetMapping("_page")
    public Page<PhysicalInventoryStateDto> getPage( HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<PhysicalInventoryState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> PhysicalInventoryResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (PhysicalInventoryMetadata.aliasMap.containsKey(n) ? PhysicalInventoryMetadata.aliasMap.get(n) : n));
            states = physicalInventoryApplicationService.get(
                c,
                PhysicalInventoryResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = physicalInventoryApplicationService.getCount(c);

            PhysicalInventoryStateDto.DtoConverter dtoConverter = new PhysicalInventoryStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<PhysicalInventoryStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toPhysicalInventoryStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            statePage.setTotalElements(count);
            return statePage;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 PhysicalInventory
     */
    @GetMapping("{documentNumber}")
    public PhysicalInventoryStateDto get(@PathVariable("documentNumber") String documentNumber, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = documentNumber;
            PhysicalInventoryState state = physicalInventoryApplicationService.get(idObj);
            if (state == null) { return null; }

            PhysicalInventoryStateDto.DtoConverter dtoConverter = new PhysicalInventoryStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPhysicalInventoryStateDto(state);

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
            count = physicalInventoryApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (PhysicalInventoryMetadata.aliasMap.containsKey(n) ? PhysicalInventoryMetadata.aliasMap.get(n) : n)));
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 新建.
     * 新建 PhysicalInventory
     */
    @PostMapping
    public String post(@RequestBody CreateOrMergePatchPhysicalInventoryDto.CreatePhysicalInventoryDto value,  HttpServletResponse response) {
        try {
            PhysicalInventoryCommand.CreatePhysicalInventory cmd = value.toCreatePhysicalInventory();
            if (cmd.getDocumentNumber() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "PhysicalInventory");
            }
            physicalInventoryApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getDocumentNumber();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 PhysicalInventory
     */
    @PutMapping("{documentNumber}")
    public void put(@PathVariable("documentNumber") String documentNumber, @RequestBody CreateOrMergePatchPhysicalInventoryDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                PhysicalInventoryCommand.MergePatchPhysicalInventory cmd = (PhysicalInventoryCommand.MergePatchPhysicalInventory) value.toCommand();
                PhysicalInventoryResourceUtils.setNullIdOrThrowOnInconsistentIds(documentNumber, cmd);
                physicalInventoryApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            PhysicalInventoryCommand.CreatePhysicalInventory cmd = (PhysicalInventoryCommand.CreatePhysicalInventory) value.toCommand();
            PhysicalInventoryResourceUtils.setNullIdOrThrowOnInconsistentIds(documentNumber, cmd);
            physicalInventoryApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    /**
     * 修改.
     * 修改 PhysicalInventory
     */
    @PatchMapping("{documentNumber}")
    public void patch(@PathVariable("documentNumber") String documentNumber, @RequestBody CreateOrMergePatchPhysicalInventoryDto.MergePatchPhysicalInventoryDto value) {
        try {

            PhysicalInventoryCommand.MergePatchPhysicalInventory cmd = value.toMergePatchPhysicalInventory();
            PhysicalInventoryResourceUtils.setNullIdOrThrowOnInconsistentIds(documentNumber, cmd);
            physicalInventoryApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{documentNumber}/_commands/CountItem")
    public void countItem(@PathVariable("documentNumber") String documentNumber, @RequestBody PhysicalInventoryCommands.CountItem content) {
        try {

            PhysicalInventoryCommands.CountItem cmd = content;//.toCountItem();
            String idObj = documentNumber;
            if (cmd.getDocumentNumber() == null) {
                cmd.setDocumentNumber(idObj);
            } else if (!cmd.getDocumentNumber().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", documentNumber, cmd.getDocumentNumber());
            }
            physicalInventoryApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{documentNumber}/_commands/DocumentAction")
    public void documentAction(@PathVariable("documentNumber") String documentNumber, @RequestBody PhysicalInventoryCommands.DocumentAction content) {
        try {

            PhysicalInventoryCommands.DocumentAction cmd = content;//.toDocumentAction();
            String idObj = documentNumber;
            if (cmd.getDocumentNumber() == null) {
                cmd.setDocumentNumber(idObj);
            } else if (!cmd.getDocumentNumber().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", documentNumber, cmd.getDocumentNumber());
            }
            physicalInventoryApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            PhysicalInventoryMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{documentNumber}/_events/{version}")
    public PhysicalInventoryEvent getStateEvent(@PathVariable("documentNumber") String documentNumber, @PathVariable("version") long version) {
        try {

            String idObj = documentNumber;
            //PhysicalInventoryStateEventDtoConverter dtoConverter = getPhysicalInventoryStateEventDtoConverter();
            return physicalInventoryApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{documentNumber}/_historyStates/{version}")
    public PhysicalInventoryStateDto getHistoryState(@PathVariable("documentNumber") String documentNumber, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = documentNumber;
            PhysicalInventoryStateDto.DtoConverter dtoConverter = new PhysicalInventoryStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPhysicalInventoryStateDto(physicalInventoryApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 查看.
     * 获取指定 InventoryItemId 的 PhysicalInventoryLine
     */
    @GetMapping("{documentNumber}/PhysicalInventoryLines/{inventoryItemId}")
    public PhysicalInventoryLineStateDto getPhysicalInventoryLine(@PathVariable("documentNumber") String documentNumber, @PathVariable("inventoryItemId") String inventoryItemId) {
        try {

            PhysicalInventoryLineState state = physicalInventoryApplicationService.getPhysicalInventoryLine(documentNumber, (new AbstractValueObjectTextFormatter<InventoryItemId>(InventoryItemId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(inventoryItemId)));
            if (state == null) { return null; }
            PhysicalInventoryLineStateDto.DtoConverter dtoConverter = new PhysicalInventoryLineStateDto.DtoConverter();
            PhysicalInventoryLineStateDto stateDto = dtoConverter.toPhysicalInventoryLineStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 创建 or 修改.
     * 创建 or 修改 PhysicalInventoryLine
     */
    @PutMapping(path = "{documentNumber}/PhysicalInventoryLines/{inventoryItemId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putPhysicalInventoryLine(@PathVariable("documentNumber") String documentNumber, @PathVariable("inventoryItemId") String inventoryItemId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchPhysicalInventoryLineDto.MergePatchPhysicalInventoryLineDto body) {
        try {
            PhysicalInventoryCommand.MergePatchPhysicalInventory mergePatchPhysicalInventory = new AbstractPhysicalInventoryCommand.SimpleMergePatchPhysicalInventory();
            mergePatchPhysicalInventory.setDocumentNumber(documentNumber);
            mergePatchPhysicalInventory.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchPhysicalInventory.setVersion(version); }
            mergePatchPhysicalInventory.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            PhysicalInventoryLineCommand.MergePatchPhysicalInventoryLine mergePatchPhysicalInventoryLine = body.toMergePatchPhysicalInventoryLine();
            mergePatchPhysicalInventoryLine.setInventoryItemId((new AbstractValueObjectTextFormatter<InventoryItemId>(InventoryItemId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(inventoryItemId)));
            mergePatchPhysicalInventory.getPhysicalInventoryLineCommands().add(mergePatchPhysicalInventoryLine);
            physicalInventoryApplicationService.when(mergePatchPhysicalInventory);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 移除.
     * 移除 PhysicalInventoryLine
     */
    @DeleteMapping("{documentNumber}/PhysicalInventoryLines/{inventoryItemId}")
    public void deletePhysicalInventoryLine(@PathVariable("documentNumber") String documentNumber, @PathVariable("inventoryItemId") String inventoryItemId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            PhysicalInventoryCommand.MergePatchPhysicalInventory mergePatchPhysicalInventory = new AbstractPhysicalInventoryCommand.SimpleMergePatchPhysicalInventory();
            mergePatchPhysicalInventory.setDocumentNumber(documentNumber);
            mergePatchPhysicalInventory.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchPhysicalInventory.setVersion(version); }
            mergePatchPhysicalInventory.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            PhysicalInventoryLineCommand.RemovePhysicalInventoryLine removePhysicalInventoryLine = new AbstractPhysicalInventoryLineCommand.SimpleRemovePhysicalInventoryLine();
            removePhysicalInventoryLine.setInventoryItemId((new AbstractValueObjectTextFormatter<InventoryItemId>(InventoryItemId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(inventoryItemId)));
            mergePatchPhysicalInventory.getPhysicalInventoryLineCommands().add(removePhysicalInventoryLine);
            physicalInventoryApplicationService.when(mergePatchPhysicalInventory);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * PhysicalInventoryLine List
     */
    @GetMapping("{documentNumber}/PhysicalInventoryLines")
    public PhysicalInventoryLineStateDto[] getPhysicalInventoryLines(@PathVariable("documentNumber") String documentNumber) {
        try {
            Iterable<PhysicalInventoryLineState> states = physicalInventoryApplicationService.getPhysicalInventoryLines(documentNumber);
            if (states == null) { return null; }
            PhysicalInventoryLineStateDto.DtoConverter dtoConverter = new PhysicalInventoryLineStateDto.DtoConverter();
            dtoConverter.setAllFieldsReturned(true);
            return dtoConverter.toPhysicalInventoryLineStateDtoArray(states);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    /**
     * 新建.
     * 新建 PhysicalInventoryLine
     */
    @PostMapping(path = "{documentNumber}/PhysicalInventoryLines", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postPhysicalInventoryLines(@PathVariable("documentNumber") String documentNumber,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchPhysicalInventoryLineDto.CreatePhysicalInventoryLineDto body) {
        try {
            PhysicalInventoryCommand.MergePatchPhysicalInventory mergePatchPhysicalInventory = new AbstractPhysicalInventoryCommand.SimpleMergePatchPhysicalInventory();
            mergePatchPhysicalInventory.setDocumentNumber(documentNumber);
            mergePatchPhysicalInventory.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchPhysicalInventory.setVersion(version); }
            mergePatchPhysicalInventory.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            PhysicalInventoryLineCommand.CreatePhysicalInventoryLine createPhysicalInventoryLine = body.toCreatePhysicalInventoryLine();
            mergePatchPhysicalInventory.getPhysicalInventoryLineCommands().add(createPhysicalInventoryLine);
            physicalInventoryApplicationService.when(mergePatchPhysicalInventory);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  PhysicalInventoryStateEventDtoConverter getPhysicalInventoryStateEventDtoConverter() {
    //    return new PhysicalInventoryStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PhysicalInventoryPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class PhysicalInventoryPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return PhysicalInventoryResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class PhysicalInventoryResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String documentNumber, PhysicalInventoryCommand value) {
            String idObj = documentNumber;
            if (value.getDocumentNumber() == null) {
                value.setDocumentNumber(idObj);
            } else if (!value.getDocumentNumber().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", documentNumber, value.getDocumentNumber());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, PhysicalInventoryMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, PhysicalInventoryMetadata.aliasMap);
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (PhysicalInventoryMetadata.aliasMap.containsKey(fieldName)) {
                return PhysicalInventoryMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (PhysicalInventoryMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = PhysicalInventoryMetadata.propertyTypeMap.get(propertyName);
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

        public static PhysicalInventoryStateDto[] toPhysicalInventoryStateDtoArray(Iterable<String> ids) {
            List<PhysicalInventoryStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                PhysicalInventoryStateDto dto = new PhysicalInventoryStateDto();
                dto.setDocumentNumber(i);
                states.add(dto);
            });
            return states.toArray(new PhysicalInventoryStateDto[0]);
        }

    }

}

