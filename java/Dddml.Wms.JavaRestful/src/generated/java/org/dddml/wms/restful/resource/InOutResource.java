package org.dddml.wms.restful.resource;

import java.util.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.domain.inout.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;

@RequestMapping(path = "InOuts", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class InOutResource {


    @Autowired
    private InOutApplicationService inOutApplicationService;


    @GetMapping
    public InOutStateDto[] getAll( HttpServletRequest request,
                                   @RequestParam(value = "sort", required = false) String sort,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "firstResult", defaultValue = "0") Integer firstResult,
                                   @RequestParam(value = "maxResults", defaultValue = "2147483647") Integer maxResults,
                                   @RequestParam(value = "filter", required = false) String filter) {
        if (firstResult < 0) { firstResult = 0; }
        if (maxResults == null || maxResults < 1) { maxResults = Integer.MAX_VALUE; }
        try {

            Iterable<InOutState> states = null; 
            if (!StringHelper.isNullOrEmpty(filter)) {
                states = inOutApplicationService.get(
                        CriterionDto.toSubclass(
                                JSON.parseObject(filter, CriterionDto.class),
                                getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (InOutMetadata.aliasMap.containsKey(n) ? InOutMetadata.aliasMap.get(n) : n)),
                        InOutResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            } else {
                states = inOutApplicationService.get(
                        InOutResourceUtils.getQueryFilterMap(request.getParameterMap()),
                        InOutResourceUtils.getQueryOrders(sort, getQueryOrderSeparator()),
                        firstResult, maxResults);
            }

            InOutStateDto.DtoConverter dtoConverter = new InOutStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInOutStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}")
    public InOutStateDto get(@PathVariable("id") String id, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = id;
            InOutState state = inOutApplicationService.get(idObj);
            if (state == null) { return null; }

            InOutStateDto.DtoConverter dtoConverter = new InOutStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInOutStateDto(state);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_count")
    public long getCount( HttpServletRequest request,
                         @RequestParam(value = "filter", required = false) String filter) {
        try {
            long count = 0;
            if (!StringHelper.isNullOrEmpty(filter)) {
                count = inOutApplicationService.getCount(CriterionDto.toSubclass(JSONObject.parseObject(filter, CriterionDto.class),
                        getCriterionTypeConverter(), getPropertyTypeResolver(), n -> (InOutMetadata.aliasMap.containsKey(n) ? InOutMetadata.aliasMap.get(n) : n)));
            } else {
                count = inOutApplicationService.getCount(InOutResourceUtils.getQueryFilterMap(request.getParameterMap()));
            }
            return count;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PostMapping
    public String post(@RequestBody CreateOrMergePatchInOutDto.CreateInOutDto value,  HttpServletResponse response) {
        try {
            InOutCommand.CreateInOut cmd = value.toCreateInOut();
            if (cmd.getDocumentNumber() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "InOut");
            }
            inOutApplicationService.when(cmd);

            response.setStatus(HttpServletResponse.SC_CREATED);
            return cmd.getDocumentNumber();
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}")
    public void put(@PathVariable("id") String id, @RequestBody CreateOrMergePatchInOutDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                InOutCommand.MergePatchInOut cmd = (InOutCommand.MergePatchInOut) value.toCommand();
                InOutResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
                inOutApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            InOutCommand.CreateInOut cmd = (InOutCommand.CreateInOut) value.toCommand();
            InOutResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            inOutApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PatchMapping("{id}")
    public void patch(@PathVariable("id") String id, @RequestBody CreateOrMergePatchInOutDto.MergePatchInOutDto value) {
        try {

            InOutCommand.MergePatchInOut cmd = value.toMergePatchInOut();
            InOutResourceUtils.setNullIdOrThrowOnInconsistentIds(id, cmd);
            inOutApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}/_commands/Complete")
    public void complete(@PathVariable("id") String id, @RequestBody InOutCommandDtos.CompleteRequestContent content) {
        try {

            InOutCommands.Complete cmd = content.toComplete();
            String idObj = id;
            if (cmd.getDocumentNumber() == null) {
                cmd.setDocumentNumber(idObj);
            } else if (!cmd.getDocumentNumber().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, cmd.getDocumentNumber());
            }
            inOutApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}/_commands/Close")
    public void close(@PathVariable("id") String id, @RequestBody InOutCommandDtos.CloseRequestContent content) {
        try {

            InOutCommands.Close cmd = content.toClose();
            String idObj = id;
            if (cmd.getDocumentNumber() == null) {
                cmd.setDocumentNumber(idObj);
            } else if (!cmd.getDocumentNumber().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, cmd.getDocumentNumber());
            }
            inOutApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}/_commands/Void")
    public void _void(@PathVariable("id") String id, @RequestBody InOutCommandDtos.VoidRequestContent content) {
        try {

            InOutCommands.Void cmd = content.toVoid();
            String idObj = id;
            if (cmd.getDocumentNumber() == null) {
                cmd.setDocumentNumber(idObj);
            } else if (!cmd.getDocumentNumber().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, cmd.getDocumentNumber());
            }
            inOutApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}/_commands/Reverse")
    public void reverse(@PathVariable("id") String id, @RequestBody InOutCommandDtos.ReverseRequestContent content) {
        try {

            InOutCommands.Reverse cmd = content.toReverse();
            String idObj = id;
            if (cmd.getDocumentNumber() == null) {
                cmd.setDocumentNumber(idObj);
            } else if (!cmd.getDocumentNumber().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, cmd.getDocumentNumber());
            }
            inOutApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}/_commands/AddLine")
    public void addLine(@PathVariable("id") String id, @RequestBody InOutCommandDtos.AddLineRequestContent content) {
        try {

            InOutCommands.AddLine cmd = content.toAddLine();
            String idObj = id;
            if (cmd.getDocumentNumber() == null) {
                cmd.setDocumentNumber(idObj);
            } else if (!cmd.getDocumentNumber().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, cmd.getDocumentNumber());
            }
            inOutApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    @PutMapping("{id}/_commands/DocumentAction")
    public void documentAction(@PathVariable("id") String id, @RequestBody InOutCommandDtos.DocumentActionRequestContent content) {
        try {

            InOutCommands.DocumentAction cmd = content.toDocumentAction();
            String idObj = id;
            if (cmd.getDocumentNumber() == null) {
                cmd.setDocumentNumber(idObj);
            } else if (!cmd.getDocumentNumber().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, cmd.getDocumentNumber());
            }
            inOutApplicationService.when(cmd);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            InOutMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_stateEvents/{version}")
    public InOutStateEventDto getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            String idObj = id;
            InOutStateEventDtoConverter dtoConverter = getInOutStateEventDtoConverter();
            return dtoConverter.toInOutStateEventDto((AbstractInOutEvent) inOutApplicationService.getEvent(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{id}/_historyStates/{version}")
    public InOutStateDto getHistoryState(@PathVariable("id") String id, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = id;
            InOutStateDto.DtoConverter dtoConverter = new InOutStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInOutStateDto(inOutApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{inOutDocumentNumber}/InOutImages/{sequenceId}")
    public InOutImageStateDto getInOutImage(@PathVariable("inOutDocumentNumber") String inOutDocumentNumber, @PathVariable("sequenceId") String sequenceId) {
        try {

            InOutImageState state = inOutApplicationService.getInOutImage(inOutDocumentNumber, sequenceId);
            if (state == null) { return null; }
            InOutImageStateDto.DtoConverter dtoConverter = new InOutImageStateDto.DtoConverter();
            InOutImageStateDto stateDto = dtoConverter.toInOutImageStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{inOutDocumentNumber}/InOutImages/")
    public InOutImageStateDto[] getInOutImages(@PathVariable("inOutDocumentNumber") String inOutDocumentNumber) {
        try {
            Iterable<InOutImageState> states = inOutApplicationService.getInOutImages(inOutDocumentNumber);
            if (states == null) { return null; }
            InOutImageStateDto.DtoConverter dtoConverter = new InOutImageStateDto.DtoConverter();
            dtoConverter.setAllFieldsReturned(true);
            return dtoConverter.toInOutImageStateDtoArray(states);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{inOutDocumentNumber}/InOutLines/{lineNumber}")
    public InOutLineStateDto getInOutLine(@PathVariable("inOutDocumentNumber") String inOutDocumentNumber, @PathVariable("lineNumber") String lineNumber) {
        try {

            InOutLineState state = inOutApplicationService.getInOutLine(inOutDocumentNumber, lineNumber);
            if (state == null) { return null; }
            InOutLineStateDto.DtoConverter dtoConverter = new InOutLineStateDto.DtoConverter();
            InOutLineStateDto stateDto = dtoConverter.toInOutLineStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{inOutDocumentNumber}/InOutLines/")
    public InOutLineStateDto[] getInOutLines(@PathVariable("inOutDocumentNumber") String inOutDocumentNumber) {
        try {
            Iterable<InOutLineState> states = inOutApplicationService.getInOutLines(inOutDocumentNumber);
            if (states == null) { return null; }
            InOutLineStateDto.DtoConverter dtoConverter = new InOutLineStateDto.DtoConverter();
            dtoConverter.setAllFieldsReturned(true);
            return dtoConverter.toInOutLineStateDtoArray(states);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{inOutDocumentNumber}/InOutLines/{inOutLineLineNumber}/InOutLineImages/{sequenceId}")
    public InOutLineImageStateDto getInOutLineImage(@PathVariable("inOutDocumentNumber") String inOutDocumentNumber, @PathVariable("inOutLineLineNumber") String inOutLineLineNumber, @PathVariable("sequenceId") String sequenceId) {
        try {

            InOutLineImageState state = inOutApplicationService.getInOutLineImage(inOutDocumentNumber, inOutLineLineNumber, sequenceId);
            if (state == null) { return null; }
            InOutLineImageStateDto.DtoConverter dtoConverter = new InOutLineImageStateDto.DtoConverter();
            InOutLineImageStateDto stateDto = dtoConverter.toInOutLineImageStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("{inOutDocumentNumber}/InOutLines/{inOutLineLineNumber}/InOutLineImages/")
    public InOutLineImageStateDto[] getInOutLineImages(@PathVariable("inOutDocumentNumber") String inOutDocumentNumber, @PathVariable("inOutLineLineNumber") String inOutLineLineNumber) {
        try {
            Iterable<InOutLineImageState> states = inOutApplicationService.getInOutLineImages(inOutDocumentNumber, inOutLineLineNumber);
            if (states == null) { return null; }
            InOutLineImageStateDto.DtoConverter dtoConverter = new InOutLineImageStateDto.DtoConverter();
            dtoConverter.setAllFieldsReturned(true);
            return dtoConverter.toInOutLineImageStateDtoArray(states);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    protected  InOutStateEventDtoConverter getInOutStateEventDtoConverter() {
        return new InOutStateEventDtoConverter();
    }

    protected String getQueryOrderSeparator() {
        return ",";
    }

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new InOutPropertyTypeResolver();
    }

    // ////////////////////////////////

    private class InOutPropertyTypeResolver implements PropertyTypeResolver {
        @Override
        public Class resolveTypeByPropertyName(String propertyName) {
            return InOutResourceUtils.getFilterPropertyType(propertyName);
        }
    }

 
    public static class InOutResourceUtils {

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, InOutCommand value) {
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
            if (InOutMetadata.aliasMap.containsKey(fieldName)) {
                return InOutMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getFilterPropertyType(String propertyName) {
            if (InOutMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = InOutMetadata.propertyTypeMap.get(propertyName);
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

        public static InOutStateDto[] toInOutStateDtoArray(Iterable<String> ids) {
            List<InOutStateDto> states = new ArrayList<>();
            ids.forEach(id -> {
                InOutStateDto dto = new InOutStateDto();
                dto.setDocumentNumber(id);
                states.add(dto);
            });
            return states.toArray(new InOutStateDto[0]);
        }

    }

}

