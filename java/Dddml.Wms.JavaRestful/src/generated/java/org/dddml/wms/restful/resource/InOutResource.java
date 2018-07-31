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
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap());
            }
            states = inOutApplicationService.get(
                CriterionDto.toSubclass(
                        criterion,
                        getCriterionTypeConverter(), 
                        getPropertyTypeResolver(), 
                        n -> (InOutMetadata.aliasMap.containsKey(n) ? InOutMetadata.aliasMap.get(n) : n)),
                InOutResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            InOutStateDto.DtoConverter dtoConverter = new InOutStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInOutStateDtoArray(states);

        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @GetMapping("_page")
    public Page<InOutStateDto> getPage( HttpServletRequest request,
                                   @RequestParam(value = "fields", required = false) String fields,
                                   @RequestParam(value = "page", defaultValue = "0") Integer page,
                                   @RequestParam(value = "size", required = false) @NotNull Integer size) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<InOutState> states = null; 
            Criterion criterion = CriterionDto.toSubclass(
                QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> InOutResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue()))),
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (InOutMetadata.aliasMap.containsKey(n) ? InOutMetadata.aliasMap.get(n) : n));
            states = inOutApplicationService.get(
                criterion,
                InOutResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = inOutApplicationService.getCount(criterion);

            InOutStateDto.DtoConverter dtoConverter = new InOutStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<InOutStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toInOutStateDtoList(states), 0);//todo
            statePage.setSize(size);
            statePage.setNumber(page);
            statePage.setTotalElements(count);
            return statePage;

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
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSONObject.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap());
            }
            count = inOutApplicationService.getCount(CriterionDto.toSubclass(criterion,
                getCriterionTypeConverter(), 
                getPropertyTypeResolver(), 
                n -> (InOutMetadata.aliasMap.containsKey(n) ? InOutMetadata.aliasMap.get(n) : n)));
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
    public void complete(@PathVariable("id") String id, @RequestBody InOutCommands.Complete content) {
        try {

            InOutCommands.Complete cmd = content;//.toComplete();
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
    public void close(@PathVariable("id") String id, @RequestBody InOutCommands.Close content) {
        try {

            InOutCommands.Close cmd = content;//.toClose();
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
    public void _void(@PathVariable("id") String id, @RequestBody InOutCommands.Void content) {
        try {

            InOutCommands.Void cmd = content;//.toVoid();
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
    public void reverse(@PathVariable("id") String id, @RequestBody InOutCommands.Reverse content) {
        try {

            InOutCommands.Reverse cmd = content;//.toReverse();
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
    public void addLine(@PathVariable("id") String id, @RequestBody InOutCommands.AddLine content) {
        try {

            InOutCommands.AddLine cmd = content;//.toAddLine();
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
    public void documentAction(@PathVariable("id") String id, @RequestBody InOutCommands.DocumentAction content) {
        try {

            InOutCommands.DocumentAction cmd = content;//.toDocumentAction();
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

    @GetMapping("{id}/_events/{version}")
    public InOutEvent getStateEvent(@PathVariable("id") String id, @PathVariable("version") long version) {
        try {

            String idObj = id;
            //InOutStateEventDtoConverter dtoConverter = getInOutStateEventDtoConverter();
            return inOutApplicationService.getEvent(idObj, version);

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

    @PutMapping("{inOutDocumentNumber}/InOutImages/{sequenceId}")
    public void putInOutImage(@PathVariable("inOutDocumentNumber") String inOutDocumentNumber, @PathVariable("sequenceId") String sequenceId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchInOutImageDto.MergePatchInOutImageDto body) {
        try {
            InOutCommand.MergePatchInOut mergePatchInOut = new AbstractInOutCommand.SimpleMergePatchInOut();
            mergePatchInOut.setDocumentNumber(inOutDocumentNumber);
            mergePatchInOut.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchInOut.setVersion(version); }
            mergePatchInOut.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            InOutImageCommand.MergePatchInOutImage mergePatchInOutImage = body.toMergePatchInOutImage();
            mergePatchInOutImage.setSequenceId(sequenceId);
            mergePatchInOut.getInOutImageCommands().add(mergePatchInOutImage);
            inOutApplicationService.when(mergePatchInOut);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{inOutDocumentNumber}/InOutImages/{sequenceId}")
    public void deleteInOutImage(@PathVariable("inOutDocumentNumber") String inOutDocumentNumber, @PathVariable("sequenceId") String sequenceId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            InOutCommand.MergePatchInOut mergePatchInOut = new AbstractInOutCommand.SimpleMergePatchInOut();
            mergePatchInOut.setDocumentNumber(inOutDocumentNumber);
            mergePatchInOut.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchInOut.setVersion(version); }
            mergePatchInOut.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            InOutImageCommand.RemoveInOutImage removeInOutImage = new AbstractInOutImageCommand.SimpleRemoveInOutImage();
            removeInOutImage.setSequenceId(sequenceId);
            mergePatchInOut.getInOutImageCommands().add(removeInOutImage);
            inOutApplicationService.when(mergePatchInOut);
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

    @PostMapping("{inOutDocumentNumber}/InOutImages/")
    public void postInOutImages(@PathVariable("inOutDocumentNumber") String inOutDocumentNumber,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchInOutImageDto.CreateInOutImageDto body) {
        try {
            InOutCommand.MergePatchInOut mergePatchInOut = new AbstractInOutCommand.SimpleMergePatchInOut();
            mergePatchInOut.setDocumentNumber(inOutDocumentNumber);
            mergePatchInOut.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchInOut.setVersion(version); }
            mergePatchInOut.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            InOutImageCommand.CreateInOutImage createInOutImage = body.toCreateInOutImage();
            mergePatchInOut.getInOutImageCommands().add(createInOutImage);
            inOutApplicationService.when(mergePatchInOut);
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

    @PutMapping("{inOutDocumentNumber}/InOutLines/{lineNumber}")
    public void putInOutLine(@PathVariable("inOutDocumentNumber") String inOutDocumentNumber, @PathVariable("lineNumber") String lineNumber,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchInOutLineDto.MergePatchInOutLineDto body) {
        try {
            InOutCommand.MergePatchInOut mergePatchInOut = new AbstractInOutCommand.SimpleMergePatchInOut();
            mergePatchInOut.setDocumentNumber(inOutDocumentNumber);
            mergePatchInOut.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchInOut.setVersion(version); }
            mergePatchInOut.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            InOutLineCommand.MergePatchInOutLine mergePatchInOutLine = body.toMergePatchInOutLine();
            mergePatchInOutLine.setLineNumber(lineNumber);
            mergePatchInOut.getInOutLineCommands().add(mergePatchInOutLine);
            inOutApplicationService.when(mergePatchInOut);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{inOutDocumentNumber}/InOutLines/{lineNumber}")
    public void deleteInOutLine(@PathVariable("inOutDocumentNumber") String inOutDocumentNumber, @PathVariable("lineNumber") String lineNumber,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            InOutCommand.MergePatchInOut mergePatchInOut = new AbstractInOutCommand.SimpleMergePatchInOut();
            mergePatchInOut.setDocumentNumber(inOutDocumentNumber);
            mergePatchInOut.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchInOut.setVersion(version); }
            mergePatchInOut.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            InOutLineCommand.RemoveInOutLine removeInOutLine = new AbstractInOutLineCommand.SimpleRemoveInOutLine();
            removeInOutLine.setLineNumber(lineNumber);
            mergePatchInOut.getInOutLineCommands().add(removeInOutLine);
            inOutApplicationService.when(mergePatchInOut);
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

    @PostMapping("{inOutDocumentNumber}/InOutLines/")
    public void postInOutLines(@PathVariable("inOutDocumentNumber") String inOutDocumentNumber,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchInOutLineDto.CreateInOutLineDto body) {
        try {
            InOutCommand.MergePatchInOut mergePatchInOut = new AbstractInOutCommand.SimpleMergePatchInOut();
            mergePatchInOut.setDocumentNumber(inOutDocumentNumber);
            mergePatchInOut.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchInOut.setVersion(version); }
            mergePatchInOut.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            InOutLineCommand.CreateInOutLine createInOutLine = body.toCreateInOutLine();
            mergePatchInOut.getInOutLineCommands().add(createInOutLine);
            inOutApplicationService.when(mergePatchInOut);
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

    @PutMapping("{inOutDocumentNumber}/InOutLines/{inOutLineLineNumber}/InOutLineImages/{sequenceId}")
    public void putInOutLineImage(@PathVariable("inOutDocumentNumber") String inOutDocumentNumber, @PathVariable("inOutLineLineNumber") String inOutLineLineNumber, @PathVariable("sequenceId") String sequenceId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchInOutLineImageDto.MergePatchInOutLineImageDto body) {
        try {
            InOutCommand.MergePatchInOut mergePatchInOut = new AbstractInOutCommand.SimpleMergePatchInOut();
            mergePatchInOut.setDocumentNumber(inOutDocumentNumber);
            mergePatchInOut.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchInOut.setVersion(version); }
            mergePatchInOut.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            InOutLineCommand.MergePatchInOutLine mergePatchInOutLine = new AbstractInOutLineCommand.SimpleMergePatchInOutLine();
            mergePatchInOutLine.setLineNumber(inOutLineLineNumber);
            mergePatchInOut.getInOutLineCommands().add(mergePatchInOutLine);
            InOutLineImageCommand.MergePatchInOutLineImage mergePatchInOutLineImage = body.toMergePatchInOutLineImage();
            mergePatchInOutLineImage.setSequenceId(sequenceId);
            mergePatchInOutLine.getInOutLineImageCommands().add(mergePatchInOutLineImage);
            inOutApplicationService.when(mergePatchInOut);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }

    @DeleteMapping("{inOutDocumentNumber}/InOutLines/{inOutLineLineNumber}/InOutLineImages/{sequenceId}")
    public void deleteInOutLineImage(@PathVariable("inOutDocumentNumber") String inOutDocumentNumber, @PathVariable("inOutLineLineNumber") String inOutLineLineNumber, @PathVariable("sequenceId") String sequenceId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            InOutCommand.MergePatchInOut mergePatchInOut = new AbstractInOutCommand.SimpleMergePatchInOut();
            mergePatchInOut.setDocumentNumber(inOutDocumentNumber);
            mergePatchInOut.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchInOut.setVersion(version); }
            mergePatchInOut.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            InOutLineCommand.MergePatchInOutLine mergePatchInOutLine = new AbstractInOutLineCommand.SimpleMergePatchInOutLine();
            mergePatchInOutLine.setLineNumber(inOutLineLineNumber);
            mergePatchInOut.getInOutLineCommands().add(mergePatchInOutLine);
            InOutLineImageCommand.RemoveInOutLineImage removeInOutLineImage = new AbstractInOutLineImageCommand.SimpleRemoveInOutLineImage();
            removeInOutLineImage.setSequenceId(sequenceId);
            mergePatchInOutLine.getInOutLineImageCommands().add(removeInOutLineImage);
            inOutApplicationService.when(mergePatchInOut);
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

    @PostMapping("{inOutDocumentNumber}/InOutLines/{inOutLineLineNumber}/InOutLineImages/")
    public void postInOutLineImages(@PathVariable("inOutDocumentNumber") String inOutDocumentNumber, @PathVariable("inOutLineLineNumber") String inOutLineLineNumber,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchInOutLineImageDto.CreateInOutLineImageDto body) {
        try {
            InOutCommand.MergePatchInOut mergePatchInOut = new AbstractInOutCommand.SimpleMergePatchInOut();
            mergePatchInOut.setDocumentNumber(inOutDocumentNumber);
            mergePatchInOut.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchInOut.setVersion(version); }
            mergePatchInOut.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            InOutLineCommand.MergePatchInOutLine mergePatchInOutLine = new AbstractInOutLineCommand.SimpleMergePatchInOutLine();
            mergePatchInOutLine.setLineNumber(inOutLineLineNumber);
            mergePatchInOut.getInOutLineCommands().add(mergePatchInOutLine);
            InOutLineImageCommand.CreateInOutLineImage createInOutLineImage = body.toCreateInOutLineImage();
            mergePatchInOutLine.getInOutLineImageCommands().add(createInOutLineImage);
            inOutApplicationService.when(mergePatchInOut);
        } catch (DomainError error) { throw error; } catch (Exception ex) { throw new DomainError("ExceptionCaught", ex); }
    }


    //protected  InOutStateEventDtoConverter getInOutStateEventDtoConverter() {
    //    return new InOutStateEventDtoConverter();
    //}

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

        public static void setNullIdOrThrowOnInconsistentIds(String id, InOutCommand value) {
            String idObj = id;
            if (value.getDocumentNumber() == null) {
                value.setDocumentNumber(idObj);
            } else if (!value.getDocumentNumber().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", id, value.getDocumentNumber());
            }
        }
    
        public static List<String> getQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, InOutMetadata.aliasMap);
        }

        public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, InOutMetadata.aliasMap);
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

