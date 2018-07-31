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
import org.dddml.wms.domain.facility.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "Facilities", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class FacilityResource {


    @Autowired
    private FacilityApplicationService facilityApplicationService;


    @GetMapping
    public FacilityStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<FacilityState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = facilityApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (FacilityMetadata.aliasMap.containsKey(n) ? FacilityMetadata.aliasMap.get(n) : n)),
                        FacilityResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = facilityApplicationService.get(
                        FacilityResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        FacilityResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            FacilityStateDto.DtoConverter dtoConverter = new FacilityStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toFacilityStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_page")
    public Page<FacilityStateDto> getPage( HttpServletRequest request,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "page", defaultValue = "0") Integer page,
                                   @RequestParam(value = "size", required = false) @NotNull Integer size) {
        try {
            List<String> sort = FacilityResourceUtils.getQuerySorts(request.getParameterMap());
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<FacilityState> states = null; 
            Criterion criterion = CriterionDto.toSubclass(
                    QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                            .filter(kv -> FacilityResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                            .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue()))),
                            getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (FacilityMetadata.aliasMap.containsKey(n) ? FacilityMetadata.aliasMap.get(n) : n));
            states = facilityApplicationService.get(
                        criterion,
                        FacilityResourceUtils.getQuerySorts(request.getParameterMap()),
                        firstResult, maxResults);
            long count = facilityApplicationService.getCount(criterion);

            FacilityStateDto.DtoConverter dtoConverter = new FacilityStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<FacilityStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toFacilityStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            statePage.setTotalElements(count);
            return statePage;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public FacilityStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = id;
            FacilityState state = facilityApplicationService.get(idObj);
            if (state == null) { return null; }

            FacilityStateDto.DtoConverter dtoConverter = new FacilityStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toFacilityStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = facilityApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (FacilityMetadata.aliasMap.containsKey(n) ? FacilityMetadata.aliasMap.get(n) : n)));
            } else {
                count = facilityApplicationService.getCount(FacilityResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public String post(@RequestBody CreateOrMergePatchFacilityDto.CreateFacilityDto value,  HttpServletResponse response) {
        try {
            FacilityCommand.CreateFacility cmd = value.toCreateFacility();
            if (cmd.getFacilityId() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "Facility");
            }
            facilityApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getFacilityId();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchFacilityDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                FacilityCommand.MergePatchFacility cmd = (FacilityCommand.MergePatchFacility) value.toCommand();
                FacilityResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                facilityApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            FacilityCommand.CreateFacility cmd = (FacilityCommand.CreateFacility) value.toCommand();
            FacilityResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            facilityApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchFacilityDto.MergePatchFacilityDto value) {
        try {

            FacilityCommand.MergePatchFacility cmd = value.toMergePatchFacility();
            FacilityResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            facilityApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id,
                       @NotNull @RequestParam(value = "commandId", required = false) String commandId,
                       @NotNull @RequestParam(value = "version", required = false) @Min(value = -1) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {

            FacilityCommand.DeleteFacility deleteCmd = new AbstractFacilityCommand.SimpleDeleteFacility();

            deleteCmd.setCommandId(commandId);
            deleteCmd.setRequesterId(requesterId);
            deleteCmd.setVersion(version);
            FacilityResourceUtils.setNullIdOrThrowOnInconsistentIds(id, deleteCmd);
            facilityApplicationService.when(deleteCmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            FacilityMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_events/{version}")
    public FacilityEvent getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            String idObj = id;
            //FacilityStateEventDtoConverter dtoConverter = getFacilityStateEventDtoConverter();
            return facilityApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public FacilityStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = id;
            FacilityStateDto.DtoConverter dtoConverter = new FacilityStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toFacilityStateDto(facilityApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  FacilityStateEventDtoConverter getFacilityStateEventDtoConverter() {
    //    return new FacilityStateEventDtoConverter();
    //}

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new FacilityPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class FacilityPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return FacilityResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class FacilityResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String id, FacilityCommand value) {
            String idObj = id;
            if (value.getFacilityId() == null) {
                value.setFacilityId(idObj);
            } else if (!value.getFacilityId().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getFacilityId());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, FacilityMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            return QueryParamUtils.getQuerySorts(queryNameValuePairs, FacilityMetadata.aliasMap);
        }


        public static String getFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (FacilityMetadata.aliasMap.containsKey(fieldName)) {
                return FacilityMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (FacilityMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = FacilityMetadata.propertyTypeMap.get(propertyName);
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

        public static FacilityStateDto[] toFacilityStateDtoArray(Iterable<String> ids) {
            List<FacilityStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                FacilityStateDto dto = new FacilityStateDto();
                dto.setFacilityId(id);
                states.add(dto);
            });
            return states.toArray(new FacilityStateDto[0]);
        }

    }

}

