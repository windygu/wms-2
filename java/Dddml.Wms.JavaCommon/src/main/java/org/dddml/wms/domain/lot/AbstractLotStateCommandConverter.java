package org.dddml.wms.domain.lot;

public abstract class AbstractLotStateCommandConverter<TCreateLot extends LotCommand.CreateLot, TMergePatchLot extends LotCommand.MergePatchLot, TDeleteLot extends LotCommand.DeleteLot> {
    public LotCommand toCreateOrMergePatchLot(LotState state) {
        //where TCreateLot : ICreateLot, new()
        //where TMergePatchLot : IMergePatchLot, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved) {
            return toCreateLot(state);
        } else {
            return toMergePatchLot(state);
        }
    }

    public TDeleteLot toDeleteLot(LotState state) //where TDeleteLot : IDeleteLot, new()
    {
        TDeleteLot cmd = newDeleteLot();
        cmd.setLotId(state.getLotId());
        cmd.setVersion(state.getVersion());

        return cmd;
    }

    public TMergePatchLot toMergePatchLot(LotState state) //where TMergePatchLot : IMergePatchLot, new()
    {
        TMergePatchLot cmd = newMergePatchLot();

        cmd.setVersion(state.getVersion());

        cmd.setLotId(state.getLotId());
        cmd.setCreationDate(state.getCreationDate());
        cmd.setQuantity(state.getQuantity());
        cmd.setExpirationDate(state.getExpirationDate());
        cmd.setActive(state.getActive());

        if (state.getCreationDate() == null) {
            cmd.setIsPropertyCreationDateRemoved(true);
        }
        if (state.getQuantity() == null) {
            cmd.setIsPropertyQuantityRemoved(true);
        }
        if (state.getExpirationDate() == null) {
            cmd.setIsPropertyExpirationDateRemoved(true);
        }
        if (state.getActive() == null) {
            cmd.setIsPropertyActiveRemoved(true);
        }
        return cmd;
    }

    public TCreateLot toCreateLot(LotState state) //where TCreateLot : ICreateLot, new()
    {
        TCreateLot cmd = newCreateLot();

        cmd.setVersion(state.getVersion());
        cmd.setLotId(state.getLotId());
        cmd.setCreationDate(state.getCreationDate());
        cmd.setQuantity(state.getQuantity());
        cmd.setExpirationDate(state.getExpirationDate());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreateLot newCreateLot();

    protected abstract TMergePatchLot newMergePatchLot();

    protected abstract TDeleteLot newDeleteLot();

    public static class SimpleLotStateCommandConverter extends AbstractLotStateCommandConverter<AbstractLotCommand.SimpleCreateLot, AbstractLotCommand.SimpleMergePatchLot, AbstractLotCommand.SimpleDeleteLot> {
        @Override
        protected AbstractLotCommand.SimpleCreateLot newCreateLot() {
            return new AbstractLotCommand.SimpleCreateLot();
        }

        @Override
        protected AbstractLotCommand.SimpleMergePatchLot newMergePatchLot() {
            return new AbstractLotCommand.SimpleMergePatchLot();
        }

        @Override
        protected AbstractLotCommand.SimpleDeleteLot newDeleteLot() {
            return new AbstractLotCommand.SimpleDeleteLot();
        }


    }

}

