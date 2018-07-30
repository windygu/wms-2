package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.shipmentpackage.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "ShipmentPackages", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class ShipmentPackageResource {


    @Autowired
    private ShipmentPackageApplicationService shipmentPackageApplicationService;


    @GetMapping
    public ShipmentPackageStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<ShipmentPackageState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = shipmentPackageApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (ShipmentPackageMetadata.aliasMap.containsKey(n) ? ShipmentPackageMetadata.aliasMap.get(n) : n)),
                        ShipmentPackageResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = shipmentPackageApplicationService.get(
                        ShipmentPackageResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        ShipmentPackageResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            ShipmentPackageStateDto.DtoConverter dtoConverter = new ShipmentPackageStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentPackageStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_page")
    public Page<ShipmentPackageStateDto> getPage( HttpServletRequest request,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "page", defaultValue = "0") Integer page,
                                   @RequestParam(value = "size", required = false) @NotNull Integer size) {
        try {
            List<String> sort = ShipmentPackageResourceUtils.getQuerySorts(request.getParameterMap());
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<ShipmentPackageState> states = null; 
            Iterable<Map.Entry<String, Object>> queryFilterMap = ShipmentPackageResourceUtils.getQueryFilterMap(request.getParameterMap());
            states = shipmentPackageApplicationService.get(
                        queryFilterMap,
                        ShipmentPackageResourceUtils.getQuerySorts(request.getParameterMap()),
                        firstResult, maxResults);
            long count = shipmentPackageApplicationService.getCount(queryFilterMap);

            ShipmentPackageStateDto.DtoConverter dtoConverter = new ShipmentPackageStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<ShipmentPackageStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toShipmentPackageStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public ShipmentPackageStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            ShipmentPackageId idObj = ShipmentPackageResourceUtils.parseIdString(id);
            ShipmentPackageState state = shipmentPackageApplicationService.get(idObj);
            if (state == null) { return null; }

            ShipmentPackageStateDto.DtoConverter dtoConverter = new ShipmentPackageStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentPackageStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = shipmentPackageApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (ShipmentPackageMetadata.aliasMap.containsKey(n) ? ShipmentPackageMetadata.aliasMap.get(n) : n)));
            } else {
                count = shipmentPackageApplicationService.getCount(ShipmentPackageResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public ShipmentPackageId post(@RequestBody CreateOrMergePatchShipmentPackageDto.CreateShipmentPackageDto value,  HttpServletResponse response) {
        try {
            ShipmentPackageCommand.CreateShipmentPackage cmd = value.toCreateShipmentPackage();
            if (cmd.getShipmentPackageId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "ShipmentPackage");
            }
            shipmentPackageApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getShipmentPackageId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchShipmentPackageDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                ShipmentPackageCommand.MergePatchShipmentPackage cmd = (ShipmentPackageCommand.MergePatchShipmentPackage) value.toCommand();
                ShipmentPackageResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                shipmentPackageApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            ShipmentPackageCommand.CreateShipmentPackage cmd = (ShipmentPackageCommand.CreateShipmentPackage) value.toCommand();
            ShipmentPackageResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            shipmentPackageApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchShipmentPackageDto.MergePatchShipmentPackageDto value) {
        try {

            ShipmentPackageCommand.MergePatchShipmentPackage cmd = value.toMergePatchShipmentPackage();
            ShipmentPackageResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            shipmentPackageApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            ShipmentPackageCommand.DeleteShipmentPackage deleteCmd = new AbstractShipmentPackageCommand.SimpleDeleteShipmentPackage();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            ShipmentPackageResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            shipmentPackageApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            ShipmentPackageMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_events/{version}")
    public ShipmentPackageEvent getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            ShipmentPackageId idObj = ShipmentPackageResourceUtils.parseIdString(id);
            //ShipmentPackageStateEventDtoConverter dtoConverter = getShipmentPackageStateEventDtoConverter();
            return shipmentPackageApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public ShipmentPackageStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            ShipmentPackageId idObj = ShipmentPackageResourceUtils.parseIdString(id);
            ShipmentPackageStateDto.DtoConverter dtoConverter = new ShipmentPackageStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toShipmentPackageStateDto(shipmentPackageApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{shipmentPackageId}/ShipmentPackageContents/{shipmentItemSeqId}")
    public ShipmentPackageContentStateDto getShipmentPackageContent(@PathVariable("shipmentPackageId") String shipmentPackageId, @PathVariable("shipmentItemSeqId") String shipmentItemSeqId) {
        try {

            ShipmentPackageContentState state = shipmentPackageApplicationService.getShipmentPackageContent((new AbstractValueObjectTextFormatter<ShipmentPackageId>(ShipmentPackageId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(shipmentPackageId)), shipmentItemSeqId);
            if (state == null) { return null; }
            ShipmentPackageContentStateDto.DtoConverter dtoConverter = new ShipmentPackageContentStateDto.DtoConverter();
            ShipmentPackageContentStateDto stateDto = dtoConverter.toShipmentPackageContentStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @PutMapping("{shipmentPackageId}/ShipmentPackageContents/{shipmentItemSeqId}")
    public void putShipmentPackageContent(@PathVariable("shipmentPackageId") String shipmentPackageId, @PathVariable("shipmentItemSeqId") String shipmentItemSeqId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchShipmentPackageContentDto.MergePatchShipmentPackageContentDto body) {
        try {
            ShipmentPackageCommand.MergePatchShipmentPackage mergePatchShipmentPackage = new AbstractShipmentPackageCommand.SimpleMergePatchShipmentPackage();
            mergePatchShipmentPackage.setShipmentPackageId((new AbstractValueObjectTextFormatter<ShipmentPackageId>(ShipmentPackageId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(shipmentPackageId)));
            mergePatchShipmentPackage.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchShipmentPackage.setVersion(version); }
            mergePatchShipmentPackage.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            ShipmentPackageContentCommand.MergePatchShipmentPackageContent mergePatchShipmentPackageContent = body.toMergePatchShipmentPackageContent();
            mergePatchShipmentPackageContent.setShipmentItemSeqId(shipmentItemSeqId);
            mergePatchShipmentPackage.getShipmentPackageContentCommands().add(mergePatchShipmentPackageContent);
            shipmentPackageApplicationService.when(mergePatchShipmentPackage);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{shipmentPackageId}/ShipmentPackageContents/{shipmentItemSeqId}")
    public void deleteShipmentPackageContent(@PathVariable("shipmentPackageId") String shipmentPackageId, @PathVariable("shipmentItemSeqId") String shipmentItemSeqId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            ShipmentPackageCommand.MergePatchShipmentPackage mergePatchShipmentPackage = new AbstractShipmentPackageCommand.SimpleMergePatchShipmentPackage();
            mergePatchShipmentPackage.setShipmentPackageId((new AbstractValueObjectTextFormatter<ShipmentPackageId>(ShipmentPackageId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(shipmentPackageId)));
            mergePatchShipmentPackage.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchShipmentPackage.setVersion(version); }
            mergePatchShipmentPackage.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            ShipmentPackageContentCommand.RemoveShipmentPackageContent removeShipmentPackageContent = new AbstractShipmentPackageContentCommand.SimpleRemoveShipmentPackageContent();
            removeShipmentPackageContent.setShipmentItemSeqId(shipmentItemSeqId);
            mergePatchShipmentPackage.getShipmentPackageContentCommands().add(removeShipmentPackageContent);
            shipmentPackageApplicationService.when(mergePatchShipmentPackage);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{shipmentPackageId}/ShipmentPackageContents/")
    public ShipmentPackageContentStateDto[] getShipmentPackageContents(@PathVariable("shipmentPackageId") String shipmentPackageId) {
        try {
            Iterable<ShipmentPackageContentState> states = shipmentPackageApplicationService.getShipmentPackageContents((new AbstractValueObjectTextFormatter<ShipmentPackageId>(ShipmentPackageId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(shipmentPackageId)));
            if (states == null) { return null; }
            ShipmentPackageContentStateDto.DtoConverter dtoConverter = new ShipmentPackageContentStateDto.DtoConverter();
            dtoConverter.setAllFieldsReturned(true);
            return dtoConverter.toShipmentPackageContentStateDtoArray(states);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @PostMapping("{shipmentPackageId}/ShipmentPackageContents/")
    public void postShipmentPackageContents(@PathVariable("shipmentPackageId") String shipmentPackageId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchShipmentPackageContentDto.CreateShipmentPackageContentDto body) {
        try {
            ShipmentPackageCommand.MergePatchShipmentPackage mergePatchShipmentPackage = new AbstractShipmentPackageCommand.SimpleMergePatchShipmentPackage();
            mergePatchShipmentPackage.setShipmentPackageId((new AbstractValueObjectTextFormatter<ShipmentPackageId>(ShipmentPackageId.class, ",") {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    }.parse(shipmentPackageId)));
            mergePatchShipmentPackage.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchShipmentPackage.setVersion(version); }
            mergePatchShipmentPackage.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            ShipmentPackageContentCommand.CreateShipmentPackageContent createShipmentPackageContent = body.toCreateShipmentPackageContent();
            mergePatchShipmentPackage.getShipmentPackageContentCommands().add(createShipmentPackageContent);
            shipmentPackageApplicationService.when(mergePatchShipmentPackage);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  ShipmentPackageStateEventDtoConverter getShipmentPackageStateEventDtoConverter() {
    //    return new ShipmentPackageStateEventDtoConverter();
    //}

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new ShipmentPackagePropertyTypeResolver();
    }

    // ////////////////////////////////

    private class ShipmentPackagePropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return ShipmentPackageResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class ShipmentPackageResourceUtils {

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

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            List<String> sorts = new ArrayList<>();
            if (values == null) {
                return null;
            }
            if (values.length == 1
                    && !values[0].toLowerCase().endsWith(",asc")
                    && !values[0].toLowerCase().endsWith(",desc")) {
                return getQueryOrders(values[0], ",");
            }
            Arrays.stream(values).forEach(s -> {
                if (s.toLowerCase().endsWith(",asc")) {
                    String f = s.substring(0, s.length() - 4).trim();
                    if (!f.isEmpty()) {
                        sorts.add(f);
                    }
                } else if (s.toLowerCase().endsWith(",desc")) {
                    String f = s.substring(0, s.length() - 5).trim();
                    if (!f.isEmpty()) {
                        sorts.add("-" + f);
                    }
                } else {
                    String f = s.trim();
                    if (!f.isEmpty()) {
                        sorts.add(f);
                    }
                }
            });
            return sorts;
        }

        public static void setNullIdOrThrowOnInconsistentIds(String id, ShipmentPackageCommand value) {
            ShipmentPackageId idObj = parseIdString(id);
            if (value.getShipmentPackageId() == null) {
                value.setShipmentPackageId(idObj);
            } else if (!value.getShipmentPackageId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getShipmentPackageId());
            }
        }
    

        public static ShipmentPackageId parseIdString(String idString) {
            TextFormatter<ShipmentPackageId> formatter =
                    new AbstractValueObjectTextFormatter<ShipmentPackageId>(ShipmentPackageId.class) {
                        @Override
                        protected Class<?> getClassByTypeName(String type) {
                            return BoundedContextMetadata.CLASS_MAP.get(type);
                        }
                    };
            return formatter.parse(idString);
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (ShipmentPackageMetadata.aliasMap.containsKey(fieldName)) {
                return ShipmentPackageMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (ShipmentPackageMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = ShipmentPackageMetadata.propertyTypeMap.get(propertyName);
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

        public static ShipmentPackageStateDto[] toShipmentPackageStateDtoArray(Iterable<ShipmentPackageId> ids) {
            List<ShipmentPackageStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                ShipmentPackageStateDto dto = new ShipmentPackageStateDto();
                dto.setShipmentPackageId(id);
                states.add(dto);
            });
            return states.toArray(new ShipmentPackageStateDto[0]);
        }

    }

}

