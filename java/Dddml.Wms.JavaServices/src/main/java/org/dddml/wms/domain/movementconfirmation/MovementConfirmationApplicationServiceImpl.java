package org.dddml.wms.domain.movementconfirmation;

import org.dddml.wms.domain.DocumentAction;
import org.dddml.wms.domain.DocumentStatusIds;
import org.dddml.wms.domain.inventoryitem.InventoryItemApplicationService;
import org.dddml.wms.domain.inventoryitem.InventoryItemEntryCommand;
import org.dddml.wms.domain.inventoryitem.InventoryItemUtils;
import org.dddml.wms.domain.movement.*;
import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.EventStore;
import org.dddml.wms.specialization.IdGenerator;
import org.dddml.wms.specialization.hibernate.TableIdGenerator;
import org.dddml.wms.specialization.spring.SpringUtils;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by yangjiefeng on 2018/1/15.
 */
public class MovementConfirmationApplicationServiceImpl extends AbstractMovementConfirmationApplicationService.SimpleMovementConfirmationApplicationService {

    InventoryItemApplicationService getInventoryItemApplicationService() {
        return (InventoryItemApplicationService) ApplicationContext.current.get("inventoryItemApplicationService");
    }

    MovementApplicationServiceImpl getMovementApplicationService() {
        MovementApplicationService movService = (MovementApplicationService) ApplicationContext.current.get("movementApplicationService");
        if (movService instanceof MovementApplicationServiceImpl) {
            return (MovementApplicationServiceImpl) movService;
        }
        Object aopTarget = SpringUtils.getAopTarget(movService);
        return (MovementApplicationServiceImpl) aopTarget;
    }

    private IdGenerator<Long, Object, Object> seqIdGenerator = new TableIdGenerator();

    public final IdGenerator<Long, Object, Object> getSeqIdGenerator() {
        return seqIdGenerator;
    }

    public final void setSeqIdGenerator(IdGenerator<Long, Object, Object> value) {
        seqIdGenerator = value;
    }

    public MovementConfirmationApplicationServiceImpl(EventStore eventStore, MovementConfirmationStateRepository stateRepository, MovementConfirmationStateQueryRepository stateQueryRepository) {
        super(eventStore, stateRepository, stateQueryRepository);
    }

    @Override
    @Transactional
    public void when(MovementConfirmationCommands.DocumentAction c) {
        if (Objects.equals(c.getValue(), DocumentAction.CONFIRM)) {
            MovementConfirmationState movConfirm = assertDocumentStatus(c.getDocumentNumber(), DocumentStatusIds.IN_PROGRESS);
            String movDocNumber = movConfirm.getMovementDocumentNumber();
            MovementState mov = assertMovementDocumentStatusInProgress(movDocNumber);

            Map<String, BigDecimal> cqDict = getConfirmedQuantityMap(movConfirm);
            assertAllLinesConfirmed(mov, cqDict);

            List<InventoryItemEntryCommand.CreateInventoryItemEntry> inventoryItemEntries = confirmMovementCreateInventoryItemEntries(mov, cqDict);
            InventoryItemUtils.createOrUpdateInventoryItems(getInventoryItemApplicationService(), inventoryItemEntries);

            confirmUpdateMovement(c, mov);

            super.when(c);
        } else {
            super.when(c);
        }
    }

    private void confirmUpdateMovement(MovementConfirmationCommands.DocumentAction c, MovementState mov) {
        MovementCommands.DocumentAction documentAction = new MovementCommands.DocumentAction();
        documentAction.setDocumentNumber(mov.getDocumentNumber());
        documentAction.setVersion(mov.getVersion());
        documentAction.setCommandId(c.getCommandId());
        documentAction.setRequesterId(c.getRequesterId());
        getMovementApplicationService().confirmUpdateMovement(documentAction);
    }

    private MovementState assertMovementDocumentStatusInProgress(String movDocNumber) {
        MovementState mov = getMovementApplicationService().get(movDocNumber);
        if (mov == null) {
            throw new IllegalArgumentException(String.format("Movement document number: %1$s", movDocNumber));
        }
        if (!Objects.equals(DocumentStatusIds.IN_PROGRESS.toLowerCase(), mov.getDocumentStatusId().toLowerCase())) {
            throw new IllegalArgumentException(String.format("Error document status: %1$s", mov.getDocumentStatusId()));
        }
        return mov;
    }

    private List<InventoryItemEntryCommand.CreateInventoryItemEntry> confirmMovementCreateInventoryItemEntries(
            MovementState mov, Map<String, BigDecimal> quantitiesDict) {

        List<InventoryItemEntryCommand.CreateInventoryItemEntry> inventoryItemEntries = MovementApplicationServiceImpl
                .confirmMovementCreateInventoryItemEntries(
                        mov, line -> quantitiesDict.get(line.getLineNumber()), () -> getSeqIdGenerator().getNextId()
                ); // confirmedQuantity
        return inventoryItemEntries;
    }

    private static Map<String, BigDecimal> getConfirmedQuantityMap(MovementConfirmationState movConfirm) {
        Map<String, BigDecimal> cqDict = new HashMap<>();
        //StreamSupport.stream(movConfirm.getMovementConfirmationLines().spliterator(), false)
        //.collect(Collectors.toMap(d -> d.getMovementLineNumber(), d -> d.getConfirmedQuantity()));

        for (MovementConfirmationLineState d : movConfirm.getMovementConfirmationLines()) {
            BigDecimal tq = d.getTargetQuantity() != null ? d.getTargetQuantity() : BigDecimal.ZERO;
            BigDecimal cq = d.getConfirmedQuantity() != null ? d.getConfirmedQuantity() : BigDecimal.ZERO;
            BigDecimal sq = d.getScrappedQuantity() != null ? d.getScrappedQuantity() : BigDecimal.ZERO;
            boolean b = tq.equals(cq.add(sq));
            if (!b) {
                throw new RuntimeException(
                        String.format("Error movement confirmation line quantities. Movement line No.: %1$s",
                                d.getMovementLineNumber()));
            }
            cqDict.put(d.getMovementLineNumber(), cq);
        }
        return cqDict;
    }

    private static void assertAllLinesConfirmed(MovementState mov, Map<String, BigDecimal> confirmedQtyMap) {
        Optional<MovementLineState> movLineNotConfirmed = StreamSupport.stream(
                mov.getMovementLines().spliterator(), false
        ).filter(line -> !confirmedQtyMap.containsKey(line.getLineNumber())).findFirst();
        if (movLineNotConfirmed.isPresent()) {
            throw new RuntimeException(String.format("Movement line NOT found confirmation. Line No.: %1$s",
                    movLineNotConfirmed.get().getLineNumber()));
        }
    }

    private MovementConfirmationState assertDocumentStatus(String docNumber, String docStatus) {
        MovementConfirmationState mov = getStateRepository().get(docNumber, true);
        if (mov == null) {
            throw new IllegalArgumentException(String.format("Error document number: %1$s", docNumber));
        } else {
            if (!Objects.equals(docStatus.toLowerCase(), mov.getDocumentStatusId().toLowerCase())) {
                throw new IllegalArgumentException(String.format("Error document status: %1$s", mov.getDocumentStatusId()));
            }
        }
        return mov;
    }
}
