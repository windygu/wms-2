package org.dddml.wms.restful.resource;

import java.util.*;
import java.util.stream.*;
import javax.servlet.http.*;
import javax.validation.constraints.*;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.dddml.support.criterion.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;
import org.dddml.wms.specialization.annotation.*;
import org.dddml.wms.domain.inout.*;
import org.dddml.wms.domain.meta.*;

import com.alibaba.fastjson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.dddml.support.criterion.TypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping(path = "InOuts", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class InOutResource {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private InOutApplicationService inOutApplicationService;


    /**
     * 查询.
     * 查询 InOuts
     */
    @GetMapping
    public InOutStateDto[] getAll(@Specification(value = InOutStateDto.class) HttpServletRequest request,
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
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> InOutResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (InOutMetadata.aliasMap.containsKey(n) ? InOutMetadata.aliasMap.get(n) : n));
            states = inOutApplicationService.get(
                c,
                InOutResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);

            InOutStateDto.DtoConverter dtoConverter = new InOutStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInOutStateDtoArray(states);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查询.
     * 分页查询 InOuts
     */
    @GetMapping("_page")
    public Page<InOutStateDto> getPage(@Specification(value = InOutStateDto.class) HttpServletRequest request,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "page", defaultValue = "0") Integer page,
                    @RequestParam(value = "size", defaultValue = "20") Integer size,
                    @RequestParam(value = "filter", required = false) String filter) {
        try {
            Integer firstResult = (page == null ? 0 : page) * size;
            Integer maxResults = (size ==null ? 0 : size);
            Iterable<InOutState> states = null; 
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> InOutResourceUtils.getFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (InOutMetadata.aliasMap.containsKey(n) ? InOutMetadata.aliasMap.get(n) : n));
            states = inOutApplicationService.get(
                c,
                InOutResourceUtils.getQuerySorts(request.getParameterMap()),
                firstResult, maxResults);
            long count = inOutApplicationService.getCount(c);

            InOutStateDto.DtoConverter dtoConverter = new InOutStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            Page.PageImpl<InOutStateDto> statePage =  new Page.PageImpl<>(dtoConverter.toInOutStateDtoList(states), count);
            statePage.setSize(size);
            statePage.setNumber(page);
            return statePage;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查看.
     * 通过 Id 获取单个 InOut
     */
    @GetMapping("{documentNumber}")
    public InOutStateDto get(@PathVariable("documentNumber") String documentNumber, @RequestParam(value = "fields", required = false) String fields) {
        try {
            String idObj = documentNumber;
            InOutState state = inOutApplicationService.get(idObj);
            if (state == null) { return null; }

            InOutStateDto.DtoConverter dtoConverter = new InOutStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInOutStateDto(state);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_count")
    public long getCount(@Specification(value = InOutStateDto.class) HttpServletRequest request,
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

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 新建.
     * 新建 InOut
     */
    @PostMapping(produces = MediaType.TEXT_PLAIN_VALUE) @ResponseStatus(HttpStatus.CREATED)
    public String post(@RequestBody CreateOrMergePatchInOutDto.CreateInOutDto value,  HttpServletResponse response) {
        try {
            InOutCommand.CreateInOut cmd = value.toCreateInOut();
            if (cmd.getDocumentNumber() == null) {
                throw DomainError.named("nullId", "Aggregate Id in cmd is null, aggregate name: %1$s.", "InOut");
            }
            String idObj = cmd.getDocumentNumber();
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            inOutApplicationService.when(cmd);

            return idObj;
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 创建 or 修改.
     * 创建 or 修改 InOut
     */
    @PutMapping("{documentNumber}")
    public void put(@PathVariable("documentNumber") String documentNumber, @RequestBody CreateOrMergePatchInOutDto value) {
        try {
            if (value.getVersion() != null) {
                value.setCommandType(Command.COMMAND_TYPE_MERGE_PATCH);
                InOutCommand.MergePatchInOut cmd = (InOutCommand.MergePatchInOut) value.toCommand();
                InOutResourceUtils.setNullIdOrThrowOnInconsistentIds(documentNumber, cmd);
                cmd.setRequesterId(SecurityContextUtil.getRequesterId());
                inOutApplicationService.when(cmd);
                return;
            }

            value.setCommandType(Command.COMMAND_TYPE_CREATE);
            InOutCommand.CreateInOut cmd = (InOutCommand.CreateInOut) value.toCommand();
            InOutResourceUtils.setNullIdOrThrowOnInconsistentIds(documentNumber, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            inOutApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    /**
     * 修改.
     * 修改 InOut
     */
    @PatchMapping("{documentNumber}")
    public void patch(@PathVariable("documentNumber") String documentNumber, @RequestBody CreateOrMergePatchInOutDto.MergePatchInOutDto value) {
        try {

            InOutCommand.MergePatchInOut cmd = value.toMergePatchInOut();
            InOutResourceUtils.setNullIdOrThrowOnInconsistentIds(documentNumber, cmd);
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            inOutApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    @PutMapping("{documentNumber}/_commands/Complete")
    public void complete(@PathVariable("documentNumber") String documentNumber, @RequestBody InOutCommands.Complete content) {
        try {

            InOutCommands.Complete cmd = content;//.toComplete();
            String idObj = documentNumber;
            if (cmd.getDocumentNumber() == null) {
                cmd.setDocumentNumber(idObj);
            } else if (!cmd.getDocumentNumber().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", documentNumber, cmd.getDocumentNumber());
            }
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            inOutApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    @PutMapping("{documentNumber}/_commands/Close")
    public void close(@PathVariable("documentNumber") String documentNumber, @RequestBody InOutCommands.Close content) {
        try {

            InOutCommands.Close cmd = content;//.toClose();
            String idObj = documentNumber;
            if (cmd.getDocumentNumber() == null) {
                cmd.setDocumentNumber(idObj);
            } else if (!cmd.getDocumentNumber().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", documentNumber, cmd.getDocumentNumber());
            }
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            inOutApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    @PutMapping("{documentNumber}/_commands/Void")
    public void _void(@PathVariable("documentNumber") String documentNumber, @RequestBody InOutCommands.Void content) {
        try {

            InOutCommands.Void cmd = content;//.toVoid();
            String idObj = documentNumber;
            if (cmd.getDocumentNumber() == null) {
                cmd.setDocumentNumber(idObj);
            } else if (!cmd.getDocumentNumber().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", documentNumber, cmd.getDocumentNumber());
            }
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            inOutApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    @PutMapping("{documentNumber}/_commands/Reverse")
    public void reverse(@PathVariable("documentNumber") String documentNumber, @RequestBody InOutCommands.Reverse content) {
        try {

            InOutCommands.Reverse cmd = content;//.toReverse();
            String idObj = documentNumber;
            if (cmd.getDocumentNumber() == null) {
                cmd.setDocumentNumber(idObj);
            } else if (!cmd.getDocumentNumber().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", documentNumber, cmd.getDocumentNumber());
            }
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            inOutApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    @PutMapping("{documentNumber}/_commands/AddLine")
    public void addLine(@PathVariable("documentNumber") String documentNumber, @RequestBody InOutCommands.AddLine content) {
        try {

            InOutCommands.AddLine cmd = content;//.toAddLine();
            String idObj = documentNumber;
            if (cmd.getDocumentNumber() == null) {
                cmd.setDocumentNumber(idObj);
            } else if (!cmd.getDocumentNumber().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", documentNumber, cmd.getDocumentNumber());
            }
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            inOutApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    @PutMapping("{documentNumber}/_commands/Import")
    public void _import(@PathVariable("documentNumber") String documentNumber, @RequestBody InOutCommands.Import content) {
        try {

            InOutCommands.Import cmd = content;//.toImport();
            String idObj = documentNumber;
            if (cmd.getDocumentNumber() == null) {
                cmd.setDocumentNumber(idObj);
            } else if (!cmd.getDocumentNumber().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", documentNumber, cmd.getDocumentNumber());
            }
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            inOutApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    @PutMapping("{documentNumber}/_commands/DocumentAction")
    public void documentAction(@PathVariable("documentNumber") String documentNumber, @RequestBody InOutCommands.DocumentAction content) {
        try {

            InOutCommands.DocumentAction cmd = content;//.toDocumentAction();
            String idObj = documentNumber;
            if (cmd.getDocumentNumber() == null) {
                cmd.setDocumentNumber(idObj);
            } else if (!cmd.getDocumentNumber().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", documentNumber, cmd.getDocumentNumber());
            }
            cmd.setRequesterId(SecurityContextUtil.getRequesterId());
            inOutApplicationService.when(cmd);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("_metadata/filteringFields")
    public List<PropertyMetadataDto> getMetadataFilteringFields() {
        try {

            List<PropertyMetadataDto> filtering = new ArrayList<>();
            InOutMetadata.propertyTypeMap.forEach((key, value) -> {
                filtering.add(new PropertyMetadataDto(key, value, true));
            });
            return filtering;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{documentNumber}/_events/{version}")
    public InOutEvent getStateEvent(@PathVariable("documentNumber") String documentNumber, @PathVariable("version") long version) {
        try {

            String idObj = documentNumber;
            //InOutStateEventDtoConverter dtoConverter = getInOutStateEventDtoConverter();
            return inOutApplicationService.getEvent(idObj, version);

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    @GetMapping("{documentNumber}/_historyStates/{version}")
    public InOutStateDto getHistoryState(@PathVariable("documentNumber") String documentNumber, @PathVariable("version") long version, @RequestParam(value = "fields", required = false) String fields) {
        try {

            String idObj = documentNumber;
            InOutStateDto.DtoConverter dtoConverter = new InOutStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInOutStateDto(inOutApplicationService.getHistoryState(idObj, version));

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查看.
     * 获取指定 SequenceId 的 InOutImage
     */
    @GetMapping("{documentNumber}/InOutImages/{sequenceId}")
    public InOutImageStateDto getInOutImage(@PathVariable("documentNumber") String documentNumber, @PathVariable("sequenceId") String sequenceId) {
        try {

            InOutImageState state = inOutApplicationService.getInOutImage(documentNumber, sequenceId);
            if (state == null) { return null; }
            InOutImageStateDto.DtoConverter dtoConverter = new InOutImageStateDto.DtoConverter();
            InOutImageStateDto stateDto = dtoConverter.toInOutImageStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 创建 or 修改.
     * 创建 or 修改 InOutImage
     */
    @PutMapping(path = "{documentNumber}/InOutImages/{sequenceId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putInOutImage(@PathVariable("documentNumber") String documentNumber, @PathVariable("sequenceId") String sequenceId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchInOutImageDto.MergePatchInOutImageDto body) {
        try {
            InOutCommand.MergePatchInOut mergePatchInOut = new AbstractInOutCommand.SimpleMergePatchInOut();
            mergePatchInOut.setDocumentNumber(documentNumber);
            mergePatchInOut.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchInOut.setVersion(version); }
            mergePatchInOut.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            InOutImageCommand.MergePatchInOutImage mergePatchInOutImage = body.toMergePatchInOutImage();
            mergePatchInOutImage.setSequenceId(sequenceId);
            mergePatchInOut.getInOutImageCommands().add(mergePatchInOutImage);
            mergePatchInOut.setRequesterId(SecurityContextUtil.getRequesterId());
            inOutApplicationService.when(mergePatchInOut);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 移除.
     * 移除 InOutImage
     */
    @DeleteMapping("{documentNumber}/InOutImages/{sequenceId}")
    public void deleteInOutImage(@PathVariable("documentNumber") String documentNumber, @PathVariable("sequenceId") String sequenceId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            InOutCommand.MergePatchInOut mergePatchInOut = new AbstractInOutCommand.SimpleMergePatchInOut();
            mergePatchInOut.setDocumentNumber(documentNumber);
            mergePatchInOut.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { 
                mergePatchInOut.setVersion(version); 
            } else {
                mergePatchInOut.setVersion(inOutApplicationService.get(documentNumber).getVersion());
            }
            mergePatchInOut.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            InOutImageCommand.RemoveInOutImage removeInOutImage = new AbstractInOutImageCommand.SimpleRemoveInOutImage();
            removeInOutImage.setSequenceId(sequenceId);
            mergePatchInOut.getInOutImageCommands().add(removeInOutImage);
            mergePatchInOut.setRequesterId(SecurityContextUtil.getRequesterId());
            inOutApplicationService.when(mergePatchInOut);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * InOutImage List
     */
    @GetMapping("{documentNumber}/InOutImages")
    public InOutImageStateDto[] getInOutImages(@PathVariable("documentNumber") String documentNumber,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "filter", required = false) String filter,
                    @Specification(value = InOutImageStateDto.class) HttpServletRequest request) {
        try {
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> InOutResourceUtils.getInOutImageFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (InOutImageMetadata.aliasMap.containsKey(n) ? InOutImageMetadata.aliasMap.get(n) : n));
            Iterable<InOutImageState> states = inOutApplicationService.getInOutImages(documentNumber, c,
                    InOutResourceUtils.getInOutImageQuerySorts(request.getParameterMap()));
            if (states == null) { return null; }
            InOutImageStateDto.DtoConverter dtoConverter = new InOutImageStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInOutImageStateDtoArray(states);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 新建.
     * 新建 InOutImage
     */
    @PostMapping(path = "{documentNumber}/InOutImages", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postInOutImages(@PathVariable("documentNumber") String documentNumber,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchInOutImageDto.CreateInOutImageDto body) {
        try {
            InOutCommand.MergePatchInOut mergePatchInOut = new AbstractInOutCommand.SimpleMergePatchInOut();
            mergePatchInOut.setDocumentNumber(documentNumber);
            mergePatchInOut.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchInOut.setVersion(version); }
            mergePatchInOut.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            InOutImageCommand.CreateInOutImage createInOutImage = body.toCreateInOutImage();
            mergePatchInOut.getInOutImageCommands().add(createInOutImage);
            mergePatchInOut.setRequesterId(SecurityContextUtil.getRequesterId());
            inOutApplicationService.when(mergePatchInOut);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查看.
     * 获取指定 LineNumber 的 InOutLine
     */
    @GetMapping("{documentNumber}/InOutLines/{lineNumber}")
    public InOutLineStateDto getInOutLine(@PathVariable("documentNumber") String documentNumber, @PathVariable("lineNumber") String lineNumber) {
        try {

            InOutLineState state = inOutApplicationService.getInOutLine(documentNumber, lineNumber);
            if (state == null) { return null; }
            InOutLineStateDto.DtoConverter dtoConverter = new InOutLineStateDto.DtoConverter();
            InOutLineStateDto stateDto = dtoConverter.toInOutLineStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 创建 or 修改.
     * 创建 or 修改 InOutLine
     */
    @PutMapping(path = "{documentNumber}/InOutLines/{lineNumber}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putInOutLine(@PathVariable("documentNumber") String documentNumber, @PathVariable("lineNumber") String lineNumber,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchInOutLineDto.MergePatchInOutLineDto body) {
        try {
            InOutCommand.MergePatchInOut mergePatchInOut = new AbstractInOutCommand.SimpleMergePatchInOut();
            mergePatchInOut.setDocumentNumber(documentNumber);
            mergePatchInOut.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchInOut.setVersion(version); }
            mergePatchInOut.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            InOutLineCommand.MergePatchInOutLine mergePatchInOutLine = body.toMergePatchInOutLine();
            mergePatchInOutLine.setLineNumber(lineNumber);
            mergePatchInOut.getInOutLineCommands().add(mergePatchInOutLine);
            mergePatchInOut.setRequesterId(SecurityContextUtil.getRequesterId());
            inOutApplicationService.when(mergePatchInOut);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 移除.
     * 移除 InOutLine
     */
    @DeleteMapping("{documentNumber}/InOutLines/{lineNumber}")
    public void deleteInOutLine(@PathVariable("documentNumber") String documentNumber, @PathVariable("lineNumber") String lineNumber,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            InOutCommand.MergePatchInOut mergePatchInOut = new AbstractInOutCommand.SimpleMergePatchInOut();
            mergePatchInOut.setDocumentNumber(documentNumber);
            mergePatchInOut.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { 
                mergePatchInOut.setVersion(version); 
            } else {
                mergePatchInOut.setVersion(inOutApplicationService.get(documentNumber).getVersion());
            }
            mergePatchInOut.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            InOutLineCommand.RemoveInOutLine removeInOutLine = new AbstractInOutLineCommand.SimpleRemoveInOutLine();
            removeInOutLine.setLineNumber(lineNumber);
            mergePatchInOut.getInOutLineCommands().add(removeInOutLine);
            mergePatchInOut.setRequesterId(SecurityContextUtil.getRequesterId());
            inOutApplicationService.when(mergePatchInOut);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * InOutLine List
     */
    @GetMapping("{documentNumber}/InOutLines")
    public InOutLineStateDto[] getInOutLines(@PathVariable("documentNumber") String documentNumber,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "filter", required = false) String filter,
                    @Specification(value = InOutLineStateDto.class) HttpServletRequest request) {
        try {
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> InOutResourceUtils.getInOutLineFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (InOutLineMetadata.aliasMap.containsKey(n) ? InOutLineMetadata.aliasMap.get(n) : n));
            Iterable<InOutLineState> states = inOutApplicationService.getInOutLines(documentNumber, c,
                    InOutResourceUtils.getInOutLineQuerySorts(request.getParameterMap()));
            if (states == null) { return null; }
            InOutLineStateDto.DtoConverter dtoConverter = new InOutLineStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInOutLineStateDtoArray(states);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 新建.
     * 新建 InOutLine
     */
    @PostMapping(path = "{documentNumber}/InOutLines", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postInOutLines(@PathVariable("documentNumber") String documentNumber,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchInOutLineDto.CreateInOutLineDto body) {
        try {
            InOutCommand.MergePatchInOut mergePatchInOut = new AbstractInOutCommand.SimpleMergePatchInOut();
            mergePatchInOut.setDocumentNumber(documentNumber);
            mergePatchInOut.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchInOut.setVersion(version); }
            mergePatchInOut.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            InOutLineCommand.CreateInOutLine createInOutLine = body.toCreateInOutLine();
            mergePatchInOut.getInOutLineCommands().add(createInOutLine);
            mergePatchInOut.setRequesterId(SecurityContextUtil.getRequesterId());
            inOutApplicationService.when(mergePatchInOut);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 查看.
     * 获取指定 SequenceId 的 InOutLineImage
     */
    @GetMapping("{documentNumber}/InOutLines/{inOutLineLineNumber}/InOutLineImages/{sequenceId}")
    public InOutLineImageStateDto getInOutLineImage(@PathVariable("documentNumber") String documentNumber, @PathVariable("inOutLineLineNumber") String inOutLineLineNumber, @PathVariable("sequenceId") String sequenceId) {
        try {

            InOutLineImageState state = inOutApplicationService.getInOutLineImage(documentNumber, inOutLineLineNumber, sequenceId);
            if (state == null) { return null; }
            InOutLineImageStateDto.DtoConverter dtoConverter = new InOutLineImageStateDto.DtoConverter();
            InOutLineImageStateDto stateDto = dtoConverter.toInOutLineImageStateDto(state);
            dtoConverter.setAllFieldsReturned(true);
            return stateDto;

        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 创建 or 修改.
     * 创建 or 修改 InOutLineImage
     */
    @PutMapping(path = "{documentNumber}/InOutLines/{inOutLineLineNumber}/InOutLineImages/{sequenceId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void putInOutLineImage(@PathVariable("documentNumber") String documentNumber, @PathVariable("inOutLineLineNumber") String inOutLineLineNumber, @PathVariable("sequenceId") String sequenceId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchInOutLineImageDto.MergePatchInOutLineImageDto body) {
        try {
            InOutCommand.MergePatchInOut mergePatchInOut = new AbstractInOutCommand.SimpleMergePatchInOut();
            mergePatchInOut.setDocumentNumber(documentNumber);
            mergePatchInOut.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchInOut.setVersion(version); }
            mergePatchInOut.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            InOutLineCommand.MergePatchInOutLine mergePatchInOutLine = new AbstractInOutLineCommand.SimpleMergePatchInOutLine();
            mergePatchInOutLine.setLineNumber(inOutLineLineNumber);
            mergePatchInOut.getInOutLineCommands().add(mergePatchInOutLine);
            InOutLineImageCommand.MergePatchInOutLineImage mergePatchInOutLineImage = body.toMergePatchInOutLineImage();
            mergePatchInOutLineImage.setSequenceId(sequenceId);
            mergePatchInOutLine.getInOutLineImageCommands().add(mergePatchInOutLineImage);
            mergePatchInOut.setRequesterId(SecurityContextUtil.getRequesterId());
            inOutApplicationService.when(mergePatchInOut);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 移除.
     * 移除 InOutLineImage
     */
    @DeleteMapping("{documentNumber}/InOutLines/{inOutLineLineNumber}/InOutLineImages/{sequenceId}")
    public void deleteInOutLineImage(@PathVariable("documentNumber") String documentNumber, @PathVariable("inOutLineLineNumber") String inOutLineLineNumber, @PathVariable("sequenceId") String sequenceId,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId) {
        try {
            InOutCommand.MergePatchInOut mergePatchInOut = new AbstractInOutCommand.SimpleMergePatchInOut();
            mergePatchInOut.setDocumentNumber(documentNumber);
            mergePatchInOut.setCommandId(commandId);// != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { 
                mergePatchInOut.setVersion(version); 
            } else {
                mergePatchInOut.setVersion(inOutApplicationService.get(documentNumber).getVersion());
            }
            mergePatchInOut.setRequesterId(requesterId);// != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            InOutLineCommand.MergePatchInOutLine mergePatchInOutLine = new AbstractInOutLineCommand.SimpleMergePatchInOutLine();
            mergePatchInOutLine.setLineNumber(inOutLineLineNumber);
            mergePatchInOut.getInOutLineCommands().add(mergePatchInOutLine);
            InOutLineImageCommand.RemoveInOutLineImage removeInOutLineImage = new AbstractInOutLineImageCommand.SimpleRemoveInOutLineImage();
            removeInOutLineImage.setSequenceId(sequenceId);
            mergePatchInOutLine.getInOutLineImageCommands().add(removeInOutLineImage);
            mergePatchInOut.setRequesterId(SecurityContextUtil.getRequesterId());
            inOutApplicationService.when(mergePatchInOut);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * InOutLineImage List
     */
    @GetMapping("{documentNumber}/InOutLines/{inOutLineLineNumber}/InOutLineImages")
    public InOutLineImageStateDto[] getInOutLineImages(@PathVariable("documentNumber") String documentNumber, @PathVariable("inOutLineLineNumber") String inOutLineLineNumber,
                    @RequestParam(value = "sort", required = false) String sort,
                    @RequestParam(value = "fields", required = false) String fields,
                    @RequestParam(value = "filter", required = false) String filter,
                    @Specification(value = InOutLineImageStateDto.class) HttpServletRequest request) {
        try {
            CriterionDto criterion = null;
            if (!StringHelper.isNullOrEmpty(filter)) {
                criterion = JSON.parseObject(filter, CriterionDto.class);
            } else {
                criterion = QueryParamUtils.getQueryCriterionDto(request.getParameterMap().entrySet().stream()
                    .filter(kv -> InOutResourceUtils.getInOutLineImageFilterPropertyName(kv.getKey()) != null)
                    .collect(Collectors.toMap(kv -> kv.getKey(), kv -> kv.getValue())));
            }
            Criterion c = CriterionDto.toSubclass(criterion, getCriterionTypeConverter(), getPropertyTypeResolver(), 
                n -> (InOutLineImageMetadata.aliasMap.containsKey(n) ? InOutLineImageMetadata.aliasMap.get(n) : n));
            Iterable<InOutLineImageState> states = inOutApplicationService.getInOutLineImages(documentNumber, inOutLineLineNumber, c,
                    InOutResourceUtils.getInOutLineImageQuerySorts(request.getParameterMap()));
            if (states == null) { return null; }
            InOutLineImageStateDto.DtoConverter dtoConverter = new InOutLineImageStateDto.DtoConverter();
            if (StringHelper.isNullOrEmpty(fields)) {
                dtoConverter.setAllFieldsReturned(true);
            } else {
                dtoConverter.setReturnedFieldsString(fields);
            }
            return dtoConverter.toInOutLineImageStateDtoArray(states);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }

    /**
     * 新建.
     * 新建 InOutLineImage
     */
    @PostMapping(path = "{documentNumber}/InOutLines/{inOutLineLineNumber}/InOutLineImages", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postInOutLineImages(@PathVariable("documentNumber") String documentNumber, @PathVariable("inOutLineLineNumber") String inOutLineLineNumber,
                       @RequestParam(value = "commandId", required = false) String commandId,
                       @RequestParam(value = "version", required = false) Long version,
                       @RequestParam(value = "requesterId", required = false) String requesterId,
                       @RequestBody CreateOrMergePatchInOutLineImageDto.CreateInOutLineImageDto body) {
        try {
            InOutCommand.MergePatchInOut mergePatchInOut = new AbstractInOutCommand.SimpleMergePatchInOut();
            mergePatchInOut.setDocumentNumber(documentNumber);
            mergePatchInOut.setCommandId(commandId != null && !commandId.isEmpty() ? commandId : body.getCommandId());
            if (version != null) { mergePatchInOut.setVersion(version); }
            mergePatchInOut.setRequesterId(requesterId != null && !requesterId.isEmpty() ? requesterId : body.getRequesterId());
            InOutLineCommand.MergePatchInOutLine mergePatchInOutLine = new AbstractInOutLineCommand.SimpleMergePatchInOutLine();
            mergePatchInOutLine.setLineNumber(inOutLineLineNumber);
            mergePatchInOut.getInOutLineCommands().add(mergePatchInOutLine);
            InOutLineImageCommand.CreateInOutLineImage createInOutLineImage = body.toCreateInOutLineImage();
            mergePatchInOutLine.getInOutLineImageCommands().add(createInOutLineImage);
            mergePatchInOut.setRequesterId(SecurityContextUtil.getRequesterId());
            inOutApplicationService.when(mergePatchInOut);
        } catch (DomainError error) { logger.info(error.getMessage(), error); throw error; } catch (Exception ex) { String exMsg = "[" + UUID.randomUUID().toString() + "] Exception caught."; logger.error(exMsg, ex); throw new RuntimeException(exMsg, ex); }
    }


    //protected  InOutStateEventDtoConverter getInOutStateEventDtoConverter() {
    //    return new InOutStateEventDtoConverter();
    //}

    protected TypeConverter getCriterionTypeConverter() {
        return new DefaultTypeConverter();
    }

    protected PropertyTypeResolver getPropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return InOutResourceUtils.getFilterPropertyType(propertyName);
            }
        };
    }

    protected PropertyTypeResolver getInOutImagePropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return InOutResourceUtils.getInOutImageFilterPropertyType(propertyName);
            }
        };
    }

    protected PropertyTypeResolver getInOutLinePropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return InOutResourceUtils.getInOutLineFilterPropertyType(propertyName);
            }
        };
    }

    protected PropertyTypeResolver getInOutLineImagePropertyTypeResolver() {
        return new PropertyTypeResolver() {
            @Override
            public Class resolveTypeByPropertyName(String propertyName) {
                return InOutResourceUtils.getInOutLineImageFilterPropertyType(propertyName);
            }
        };
    }

    // ////////////////////////////////
 
    public static class InOutResourceUtils {

        public static void setNullIdOrThrowOnInconsistentIds(String documentNumber, InOutCommand value) {
            String idObj = documentNumber;
            if (value.getDocumentNumber() == null) {
                value.setDocumentNumber(idObj);
            } else if (!value.getDocumentNumber().equals(idObj)) {
                throw DomainError.named("inconsistentId", "Argument Id %1$s NOT equals body Id %2$s", documentNumber, value.getDocumentNumber());
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

        public static List<String> getInOutImageQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, InOutImageMetadata.aliasMap);
        }

        public static List<String> getInOutImageQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, InOutImageMetadata.aliasMap);
        }

        public static String getInOutImageFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (InOutImageMetadata.aliasMap.containsKey(fieldName)) {
                return InOutImageMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getInOutImageFilterPropertyType(String propertyName) {
            if (InOutImageMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = InOutImageMetadata.propertyTypeMap.get(propertyName);
                if (!StringHelper.isNullOrEmpty(propertyType)) {
                    if (org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.containsKey(propertyType)) {
                        return org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.get(propertyType);
                    }
                }
            }
            return String.class;
        }

        public static Iterable<Map.Entry<String, Object>> getInOutImageQueryFilterMap(Map<String, String[]> queryNameValuePairs) {
            Map<String, Object> filter = new HashMap<>();
            queryNameValuePairs.forEach((key, values) -> {
                if (values.length > 0) {
                    String pName = getInOutImageFilterPropertyName(key);
                    if (!StringHelper.isNullOrEmpty(pName)) {
                        Class pClass = getInOutImageFilterPropertyType(pName);
                        filter.put(pName, ApplicationContext.current.getTypeConverter().convertFromString(pClass, values[0]));
                    }
                }
            });
            return filter.entrySet();
        }

        public static List<String> getInOutLineQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, InOutLineMetadata.aliasMap);
        }

        public static List<String> getInOutLineQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, InOutLineMetadata.aliasMap);
        }

        public static String getInOutLineFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (InOutLineMetadata.aliasMap.containsKey(fieldName)) {
                return InOutLineMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getInOutLineFilterPropertyType(String propertyName) {
            if (InOutLineMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = InOutLineMetadata.propertyTypeMap.get(propertyName);
                if (!StringHelper.isNullOrEmpty(propertyType)) {
                    if (org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.containsKey(propertyType)) {
                        return org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.get(propertyType);
                    }
                }
            }
            return String.class;
        }

        public static Iterable<Map.Entry<String, Object>> getInOutLineQueryFilterMap(Map<String, String[]> queryNameValuePairs) {
            Map<String, Object> filter = new HashMap<>();
            queryNameValuePairs.forEach((key, values) -> {
                if (values.length > 0) {
                    String pName = getInOutLineFilterPropertyName(key);
                    if (!StringHelper.isNullOrEmpty(pName)) {
                        Class pClass = getInOutLineFilterPropertyType(pName);
                        filter.put(pName, ApplicationContext.current.getTypeConverter().convertFromString(pClass, values[0]));
                    }
                }
            });
            return filter.entrySet();
        }

        public static List<String> getInOutLineImageQueryOrders(String str, String separator) {
            return QueryParamUtils.getQueryOrders(str, separator, InOutLineImageMetadata.aliasMap);
        }

        public static List<String> getInOutLineImageQuerySorts(Map<String, String[]> queryNameValuePairs) {
            String[] values = queryNameValuePairs.get("sort");
            return QueryParamUtils.getQuerySorts(values, InOutLineImageMetadata.aliasMap);
        }

        public static String getInOutLineImageFilterPropertyName(String fieldName) {
            if ("sort".equalsIgnoreCase(fieldName)
                    || "firstResult".equalsIgnoreCase(fieldName)
                    || "maxResults".equalsIgnoreCase(fieldName)
                    || "fields".equalsIgnoreCase(fieldName)) {
                return null;
            }
            if (InOutLineImageMetadata.aliasMap.containsKey(fieldName)) {
                return InOutLineImageMetadata.aliasMap.get(fieldName);
            }
            return null;
        }

        public static Class getInOutLineImageFilterPropertyType(String propertyName) {
            if (InOutLineImageMetadata.propertyTypeMap.containsKey(propertyName)) {
                String propertyType = InOutLineImageMetadata.propertyTypeMap.get(propertyName);
                if (!StringHelper.isNullOrEmpty(propertyType)) {
                    if (org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.containsKey(propertyType)) {
                        return org.dddml.wms.domain.meta.BoundedContextMetadata.CLASS_MAP.get(propertyType);
                    }
                }
            }
            return String.class;
        }

        public static Iterable<Map.Entry<String, Object>> getInOutLineImageQueryFilterMap(Map<String, String[]> queryNameValuePairs) {
            Map<String, Object> filter = new HashMap<>();
            queryNameValuePairs.forEach((key, values) -> {
                if (values.length > 0) {
                    String pName = getInOutLineImageFilterPropertyName(key);
                    if (!StringHelper.isNullOrEmpty(pName)) {
                        Class pClass = getInOutLineImageFilterPropertyType(pName);
                        filter.put(pName, ApplicationContext.current.getTypeConverter().convertFromString(pClass, values[0]));
                    }
                }
            });
            return filter.entrySet();
        }

        public static InOutStateDto[] toInOutStateDtoArray(Iterable<String> ids) {
            List<InOutStateDto> states = new ArrayList<>();
            ids.forEach(i -> {
                InOutStateDto dto = new InOutStateDto();
                dto.setDocumentNumber(i);
                states.add(dto);
            });
            return states.toArray(new InOutStateDto[0]);
        }

    }

}

