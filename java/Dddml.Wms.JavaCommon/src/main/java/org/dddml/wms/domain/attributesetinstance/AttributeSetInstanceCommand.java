package org.dddml.wms.domain.attributesetinstance;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface AttributeSetInstanceCommand extends Command
{
    String getAttributeSetInstanceId();

    void setAttributeSetInstanceId(String attributeSetInstanceId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(AttributeSetInstanceState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((AttributeSetInstanceCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (isCommandCreate((AttributeSetInstanceCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(AttributeSetInstanceCommand c) {
        return ((c instanceof AttributeSetInstanceCommand.CreateAttributeSetInstance) 
            && c.getVersion().equals(AttributeSetInstanceState.VERSION_NULL));
    }

    interface CreateOrMergePatchAttributeSetInstance extends AttributeSetInstanceCommand
    {
        String getAttributeSetId();

        void setAttributeSetId(String attributeSetId);

        String getOrganizationId();

        void setOrganizationId(String organizationId);

        String getReferenceId();

        void setReferenceId(String referenceId);

        String getSerialNumber();

        void setSerialNumber(String serialNumber);

        String getLotId();

        void setLotId(String lotId);

        String getDescription();

        void setDescription(String description);

        String getHash();

        void setHash(String hash);

        BigDecimal getWidthInch();

        void setWidthInch(BigDecimal widthInch);

        BigDecimal getDiameterInch();

        void setDiameterInch(BigDecimal diameterInch);

        BigDecimal getWeightLbs();

        void setWeightLbs(BigDecimal weightLbs);

        BigDecimal getWeightKg();

        void setWeightKg(BigDecimal weightKg);

        BigDecimal getAirDryWeightLbs();

        void setAirDryWeightLbs(BigDecimal airDryWeightLbs);

        BigDecimal getAirDryWeightKg();

        void setAirDryWeightKg(BigDecimal airDryWeightKg);

        BigDecimal getAirDryMetricTon();

        void setAirDryMetricTon(BigDecimal airDryMetricTon);

        Integer getPackageCount();

        void setPackageCount(Integer packageCount);

        BigDecimal getAirDryPct();

        void setAirDryPct(BigDecimal airDryPct);

        Boolean get_F_B_0_();

        void set_F_B_0_(Boolean _F_B_0_);

        Integer get_F_I_0_();

        void set_F_I_0_(Integer _F_I_0_);

        Long get_F_L_0_();

        void set_F_L_0_(Long _F_L_0_);

        Date get_F_DT_0_();

        void set_F_DT_0_(Date _F_DT_0_);

        BigDecimal get_F_N_0_();

        void set_F_N_0_(BigDecimal _F_N_0_);

        String get_F_C5_0_();

        void set_F_C5_0_(String _F_C5_0_);

        String get_F_C10_0_();

        void set_F_C10_0_(String _F_C10_0_);

        String get_F_C20_0_();

        void set_F_C20_0_(String _F_C20_0_);

        String get_F_C50_0_();

        void set_F_C50_0_(String _F_C50_0_);

        String get_F_C100_0_();

        void set_F_C100_0_(String _F_C100_0_);

        String get_F_C200_0_();

        void set_F_C200_0_(String _F_C200_0_);

        String get_F_C500_0_();

        void set_F_C500_0_(String _F_C500_0_);

        String get_F_C1000_0_();

        void set_F_C1000_0_(String _F_C1000_0_);

        Boolean get_F_B_1_();

        void set_F_B_1_(Boolean _F_B_1_);

        Integer get_F_I_1_();

        void set_F_I_1_(Integer _F_I_1_);

        Long get_F_L_1_();

        void set_F_L_1_(Long _F_L_1_);

        Date get_F_DT_1_();

        void set_F_DT_1_(Date _F_DT_1_);

        BigDecimal get_F_N_1_();

        void set_F_N_1_(BigDecimal _F_N_1_);

        String get_F_C5_1_();

        void set_F_C5_1_(String _F_C5_1_);

        String get_F_C10_1_();

        void set_F_C10_1_(String _F_C10_1_);

        String get_F_C20_1_();

        void set_F_C20_1_(String _F_C20_1_);

        String get_F_C50_1_();

        void set_F_C50_1_(String _F_C50_1_);

        String get_F_C100_1_();

        void set_F_C100_1_(String _F_C100_1_);

        String get_F_C200_1_();

        void set_F_C200_1_(String _F_C200_1_);

        Boolean get_F_B_2_();

        void set_F_B_2_(Boolean _F_B_2_);

        Integer get_F_I_2_();

        void set_F_I_2_(Integer _F_I_2_);

        Long get_F_L_2_();

        void set_F_L_2_(Long _F_L_2_);

        Date get_F_DT_2_();

        void set_F_DT_2_(Date _F_DT_2_);

        BigDecimal get_F_N_2_();

        void set_F_N_2_(BigDecimal _F_N_2_);

        String get_F_C5_2_();

        void set_F_C5_2_(String _F_C5_2_);

        String get_F_C10_2_();

        void set_F_C10_2_(String _F_C10_2_);

        String get_F_C20_2_();

        void set_F_C20_2_(String _F_C20_2_);

        String get_F_C50_2_();

        void set_F_C50_2_(String _F_C50_2_);

        Boolean get_F_B_3_();

        void set_F_B_3_(Boolean _F_B_3_);

        Integer get_F_I_3_();

        void set_F_I_3_(Integer _F_I_3_);

        Long get_F_L_3_();

        void set_F_L_3_(Long _F_L_3_);

        Date get_F_DT_3_();

        void set_F_DT_3_(Date _F_DT_3_);

        BigDecimal get_F_N_3_();

        void set_F_N_3_(BigDecimal _F_N_3_);

        String get_F_C5_3_();

        void set_F_C5_3_(String _F_C5_3_);

        String get_F_C10_3_();

        void set_F_C10_3_(String _F_C10_3_);

        String get_F_C20_3_();

        void set_F_C20_3_(String _F_C20_3_);

        String get_F_C50_3_();

        void set_F_C50_3_(String _F_C50_3_);

        Boolean get_F_B_4_();

        void set_F_B_4_(Boolean _F_B_4_);

        Integer get_F_I_4_();

        void set_F_I_4_(Integer _F_I_4_);

        Long get_F_L_4_();

        void set_F_L_4_(Long _F_L_4_);

        Date get_F_DT_4_();

        void set_F_DT_4_(Date _F_DT_4_);

        BigDecimal get_F_N_4_();

        void set_F_N_4_(BigDecimal _F_N_4_);

        String get_F_C5_4_();

        void set_F_C5_4_(String _F_C5_4_);

        String get_F_C10_4_();

        void set_F_C10_4_(String _F_C10_4_);

        String get_F_C20_4_();

        void set_F_C20_4_(String _F_C20_4_);

        String get_F_C50_4_();

        void set_F_C50_4_(String _F_C50_4_);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateAttributeSetInstance extends CreateOrMergePatchAttributeSetInstance
    {
    }

}

