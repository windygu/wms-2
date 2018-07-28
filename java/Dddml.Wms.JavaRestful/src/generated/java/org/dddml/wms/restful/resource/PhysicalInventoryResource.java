package org.dddml.wms.restful.resource;

import java.util.*;
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
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = physicalInventoryApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (PhysicalInventoryMetadata.aliasMap.containsKey(n) ? PhysicalInventoryMetadata.aliasMap.get(n) : n)),
                        PhysicalInventoryResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = physicalInventoryApplicationService.get(
                        PhysicalInventoryResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        PhysicalInventoryResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            PhysicalInventoryStateDto.DtoConverter dtoConverter = new PhysicalInventoryStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPhysicalInventoryStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public PhysicalInventoryStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = id;
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
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = physicalInventoryApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (PhysicalInventoryMetadata.aliasMap.containsKey(n) ? PhysicalInventoryMetadata.aliasMap.get(n) : n)));
            } else {
                count = physicalInventoryApplicationService.getCount(PhysicalInventoryResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


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


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchPhysicalInventoryDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                PhysicalInventoryCommand.MergePatchPhysicalInventory cmd = (PhysicalInventoryCommand.MergePatchPhysicalInventory) value.toCommand();
                PhysicalInventoryResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                physicalInventoryApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            PhysicalInventoryCommand.CreatePhysicalInventory cmd = (PhysicalInventoryCommand.CreatePhysicalInventory) value.toCommand();
            PhysicalInventoryResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            physicalInventoryApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchPhysicalInventoryDto.MergePatchPhysicalInventoryDto value) {
        try {

            PhysicalInventoryCommand.MergePatchPhysicalInventory cmd = value.toMergePatchPhysicalInventory();
            PhysicalInventoryResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            physicalInventoryApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}/_commands/CountItem")
    public void countItem(@PathVariable("id") String id, @RequestBody PhysicalInventoryCommands.CountItem content) {
        try {

            PhysicalInventoryCommands.CountItem cmd = content;//.toCountItem();
            String idObj = id;
            if (cmd.getDocumentNumber() == null) {
                cmd.setDocumentNumber(idObj);
            } else if (!cmd.getDocumentNumber().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, cmd.getDocumentNumber());
            }
            physicalInventoryApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}/_commands/DocumentAction")
    public void documentAction(@PathVariable("id") String id, @RequestBody PhysicalInventoryCommands.DocumentAction content) {
        try {

            PhysicalInventoryCommands.DocumentAction cmd = content;//.toDocumentAction();
            String idObj = id;
            if (cmd.getDocumentNumber() == null) {
                cmd.setDocumentNumber(idObj);
            } else if (!cmd.getDocumentNumber().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, cmd.getDocumentNumber());
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

    @GetMapping("{id}/_events/{version}")
    public PhysicalInventoryEvent getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            String idObj = id;
            //PhysicalInventoryStateEventDtoConverter dtoConverter = getPhysicalInventoryStateEventDtoConverter();
            return physicalInventoryApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public PhysicalInventoryStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = id;
            PhysicalInventoryStateDto.DtoConverter dtoConverter = new PhysicalInventoryStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toPhysicalInventoryStateDto(physicalInventoryApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{physicalInventoryDocumentNumber}/PhysicalInventoryLines/{inventoryItemId}")
    public PhysicalInventoryLineStateDto getPhysicalInventoryLine(@PathVariable("physicalInventoryDocumentNumber") String physicalInventoryDocumentNumber, @PathVariable("inventoryItemId") String inventoryItemId) {
        try {

            PhysicalInventoryLineState state = physicalInventoryApplicationService.getPhysicalInventoryLine(physicalInventoryDocumentNumber, (new AbstractValueObjectTextFormatter<InventoryItemId>(InventoryItemId.class, ",") {
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

    @GetMapping("{physicalInventoryDocumentNumber}/PhysicalInventoryLines/")
    public PhysicalInventoryLineStateDto[] getPhysicalInventoryLines(@PathVariable("physicalInventoryDocumentNumber") String physicalInventoryDocumentNumber) {
        try {
            Iterable<PhysicalInventoryLineState> states = physicalInventoryApplicationService.getPhysicalInventoryLines(physicalInventoryDocumentNumber);
            if (states == null) { return null; }
            PhysicalInventoryLineStateDto.DtoConverter dtoConverter = new PhysicalInventoryLineStateDto.DtoConverter();
            dtoConverter.setAllFieldsReturned(true);
            return dtoConverter.toPhysicalInventoryLineStateDtoArray(states);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  PhysicalInventoryStateEventDtoConverter getPhysicalInventoryStateEventDtoConverter() {
    //    return new PhysicalInventoryStateEventDtoConverter();
    //}

    protected String getQueryOrderSeparator() {
        return ",";
    }

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

        public static List<String> getQueryOrders(String str, String separator) {
            List<String> orders = new ArrayList<>();
            if (StringHelper.isNullOrEmpty(str)) {
                return orders;
            }
            String[] splits = str.split(separator);
            for (String item : splits) {
                if (!StringHelper.isNullOrEmpty(item)) {
                    orders.add(item);
                }
            }
            return orders;
        }

        public static void setNullIdOrThrowOnInconsistentIds(String id, PhysicalInventoryCommand value) {
            String idObj = id;
            if (value.getDocumentNumber() == null) {
                value.setDocumentNumber(idObj);
            } else if (!value.getDocumentNumber().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getDocumentNumber());
            }
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
            ids.forEach(id -> {
                PhysicalInventoryStateDto dto = new PhysicalInventoryStateDto();
                dto.setDocumentNumber(id);
                states.add(dto);
            });
            return states.toArray(new PhysicalInventoryStateDto[0]);
        }

    }

}

