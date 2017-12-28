package org.dddml.wms.domain.attributesetinstance;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;

public abstract class AbstractAttributeSetInstanceStateCommandConverter<TCreateAttributeSetInstance extends AttributeSetInstanceCommand.CreateAttributeSetInstance>
{
    public AttributeSetInstanceCommand toCreateOrMergePatchAttributeSetInstance(AttributeSetInstanceState state)
    {
        //where TCreateAttributeSetInstance : ICreateAttributeSetInstance, new()
        //where TMergePatchAttributeSetInstance : IMergePatchAttributeSetInstance, new()
        boolean bUnsaved = state.isStateUnsaved();
        if (bUnsaved)
        {
            return toCreateAttributeSetInstance(state);
        }
        else 
        {
            return null;
        }
    }

    public TCreateAttributeSetInstance toCreateAttributeSetInstance(AttributeSetInstanceState state) //where TCreateAttributeSetInstance : ICreateAttributeSetInstance, new()
    {
        TCreateAttributeSetInstance cmd = newCreateAttributeSetInstance();

        cmd.setVersion(state.getVersion());
        cmd.setAttributeSetInstanceId(state.getAttributeSetInstanceId());
        cmd.setAttributeSetId(state.getAttributeSetId());
        cmd.setOrganizationId(state.getOrganizationId());
        cmd.setReferenceId(state.getReferenceId());
        cmd.setSerialNumber(state.getSerialNumber());
        cmd.setLot(state.getLot());
        cmd.setDescription(state.getDescription());
        cmd.setHash(state.getHash());
        cmd.setWidthInch(state.getWidthInch());
        cmd.setDiameterInch(state.getDiameterInch());
        cmd.setWeightLbs(state.getWeightLbs());
        cmd.setWeightKg(state.getWeightKg());
        cmd.setAirDryWeightLbs(state.getAirDryWeightLbs());
        cmd.setAirDryWeightKg(state.getAirDryWeightKg());
        cmd.setAirDryMetricTon(state.getAirDryMetricTon());
        cmd.setPackageCount(state.getPackageCount());
        cmd.setAirDryPct(state.getAirDryPct());
        cmd.set_F_B_0_(state.get_F_B_0_());
        cmd.set_F_I_0_(state.get_F_I_0_());
        cmd.set_F_L_0_(state.get_F_L_0_());
        cmd.set_F_DT_0_(state.get_F_DT_0_());
        cmd.set_F_N_0_(state.get_F_N_0_());
        cmd.set_F_C5_0_(state.get_F_C5_0_());
        cmd.set_F_C10_0_(state.get_F_C10_0_());
        cmd.set_F_C20_0_(state.get_F_C20_0_());
        cmd.set_F_C50_0_(state.get_F_C50_0_());
        cmd.set_F_C100_0_(state.get_F_C100_0_());
        cmd.set_F_C200_0_(state.get_F_C200_0_());
        cmd.set_F_C500_0_(state.get_F_C500_0_());
        cmd.set_F_C1000_0_(state.get_F_C1000_0_());
        cmd.set_F_B_1_(state.get_F_B_1_());
        cmd.set_F_I_1_(state.get_F_I_1_());
        cmd.set_F_L_1_(state.get_F_L_1_());
        cmd.set_F_DT_1_(state.get_F_DT_1_());
        cmd.set_F_N_1_(state.get_F_N_1_());
        cmd.set_F_C5_1_(state.get_F_C5_1_());
        cmd.set_F_C10_1_(state.get_F_C10_1_());
        cmd.set_F_C20_1_(state.get_F_C20_1_());
        cmd.set_F_C50_1_(state.get_F_C50_1_());
        cmd.set_F_C100_1_(state.get_F_C100_1_());
        cmd.set_F_C200_1_(state.get_F_C200_1_());
        cmd.set_F_B_2_(state.get_F_B_2_());
        cmd.set_F_I_2_(state.get_F_I_2_());
        cmd.set_F_L_2_(state.get_F_L_2_());
        cmd.set_F_DT_2_(state.get_F_DT_2_());
        cmd.set_F_N_2_(state.get_F_N_2_());
        cmd.set_F_C5_2_(state.get_F_C5_2_());
        cmd.set_F_C10_2_(state.get_F_C10_2_());
        cmd.set_F_C20_2_(state.get_F_C20_2_());
        cmd.set_F_C50_2_(state.get_F_C50_2_());
        cmd.set_F_B_3_(state.get_F_B_3_());
        cmd.set_F_I_3_(state.get_F_I_3_());
        cmd.set_F_L_3_(state.get_F_L_3_());
        cmd.set_F_DT_3_(state.get_F_DT_3_());
        cmd.set_F_N_3_(state.get_F_N_3_());
        cmd.set_F_C5_3_(state.get_F_C5_3_());
        cmd.set_F_C10_3_(state.get_F_C10_3_());
        cmd.set_F_C20_3_(state.get_F_C20_3_());
        cmd.set_F_C50_3_(state.get_F_C50_3_());
        cmd.set_F_B_4_(state.get_F_B_4_());
        cmd.set_F_I_4_(state.get_F_I_4_());
        cmd.set_F_L_4_(state.get_F_L_4_());
        cmd.set_F_DT_4_(state.get_F_DT_4_());
        cmd.set_F_N_4_(state.get_F_N_4_());
        cmd.set_F_C5_4_(state.get_F_C5_4_());
        cmd.set_F_C10_4_(state.get_F_C10_4_());
        cmd.set_F_C20_4_(state.get_F_C20_4_());
        cmd.set_F_C50_4_(state.get_F_C50_4_());
        cmd.setActive(state.getActive());
        return cmd;
    }

    protected abstract TCreateAttributeSetInstance newCreateAttributeSetInstance();

    public static class SimpleAttributeSetInstanceStateCommandConverter extends AbstractAttributeSetInstanceStateCommandConverter<AbstractAttributeSetInstanceCommand.SimpleCreateAttributeSetInstance>
    {
        @Override
        protected AbstractAttributeSetInstanceCommand.SimpleCreateAttributeSetInstance newCreateAttributeSetInstance() {
            return new AbstractAttributeSetInstanceCommand.SimpleCreateAttributeSetInstance();
        }


    }

}

