package org.dddml.wms.domain.attributesetinstance;

import java.util.*;
import java.math.BigDecimal;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.*;

public class AttributeSetInstanceStateEventDtoConverter {

    public AttributeSetInstanceStateEventDto toAttributeSetInstanceStateEventDto(AbstractAttributeSetInstanceStateEvent stateEvent) {
        if (stateEvent instanceof AbstractAttributeSetInstanceStateEvent.AbstractAttributeSetInstanceStateCreated) {
            AttributeSetInstanceStateEvent.AttributeSetInstanceStateCreated e = (AttributeSetInstanceStateEvent.AttributeSetInstanceStateCreated) stateEvent;
            return toAttributeSetInstanceStateCreatedDto(e);
        }

        throw DomainError.named("invalidStateEventType", String.format("Invalid state event type: %1$s", stateEvent.getStateEventType()));
    }

    public AttributeSetInstanceStateEventDto.AttributeSetInstanceStateCreatedDto toAttributeSetInstanceStateCreatedDto(AttributeSetInstanceStateEvent.AttributeSetInstanceStateCreated e) {
        AttributeSetInstanceStateEventDto.AttributeSetInstanceStateCreatedDto dto = new AttributeSetInstanceStateEventDto.AttributeSetInstanceStateCreatedDto();
        dto.setAttributeSetInstanceEventId(e.getAttributeSetInstanceEventId());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setCreatedBy(e.getCreatedBy());
        dto.setCommandId(e.getCommandId());
        dto.setAttributeSetId(e.getAttributeSetId());
        dto.setOrganizationId(e.getOrganizationId());
        dto.setReferenceId(e.getReferenceId());
        dto.setSerialNumber(e.getSerialNumber());
        dto.setLotId(e.getLotId());
        dto.setDescription(e.getDescription());
        dto.setHash(e.getHash());
        dto.setWidthInch(e.getWidthInch());
        dto.setDiameterInch(e.getDiameterInch());
        dto.setWeightLbs(e.getWeightLbs());
        dto.setWeightKg(e.getWeightKg());
        dto.setAirDryWeightLbs(e.getAirDryWeightLbs());
        dto.setAirDryWeightKg(e.getAirDryWeightKg());
        dto.setAirDryMetricTon(e.getAirDryMetricTon());
        dto.setPackageCount(e.getPackageCount());
        dto.setAirDryPct(e.getAirDryPct());
        dto.set_F_B_0_(e.get_F_B_0_());
        dto.set_F_I_0_(e.get_F_I_0_());
        dto.set_F_L_0_(e.get_F_L_0_());
        dto.set_F_DT_0_(e.get_F_DT_0_());
        dto.set_F_N_0_(e.get_F_N_0_());
        dto.set_F_C5_0_(e.get_F_C5_0_());
        dto.set_F_C10_0_(e.get_F_C10_0_());
        dto.set_F_C20_0_(e.get_F_C20_0_());
        dto.set_F_C50_0_(e.get_F_C50_0_());
        dto.set_F_C100_0_(e.get_F_C100_0_());
        dto.set_F_C200_0_(e.get_F_C200_0_());
        dto.set_F_C500_0_(e.get_F_C500_0_());
        dto.set_F_C1000_0_(e.get_F_C1000_0_());
        dto.set_F_B_1_(e.get_F_B_1_());
        dto.set_F_I_1_(e.get_F_I_1_());
        dto.set_F_L_1_(e.get_F_L_1_());
        dto.set_F_DT_1_(e.get_F_DT_1_());
        dto.set_F_N_1_(e.get_F_N_1_());
        dto.set_F_C5_1_(e.get_F_C5_1_());
        dto.set_F_C10_1_(e.get_F_C10_1_());
        dto.set_F_C20_1_(e.get_F_C20_1_());
        dto.set_F_C50_1_(e.get_F_C50_1_());
        dto.set_F_C100_1_(e.get_F_C100_1_());
        dto.set_F_C200_1_(e.get_F_C200_1_());
        dto.set_F_B_2_(e.get_F_B_2_());
        dto.set_F_I_2_(e.get_F_I_2_());
        dto.set_F_L_2_(e.get_F_L_2_());
        dto.set_F_DT_2_(e.get_F_DT_2_());
        dto.set_F_N_2_(e.get_F_N_2_());
        dto.set_F_C5_2_(e.get_F_C5_2_());
        dto.set_F_C10_2_(e.get_F_C10_2_());
        dto.set_F_C20_2_(e.get_F_C20_2_());
        dto.set_F_C50_2_(e.get_F_C50_2_());
        dto.set_F_B_3_(e.get_F_B_3_());
        dto.set_F_I_3_(e.get_F_I_3_());
        dto.set_F_L_3_(e.get_F_L_3_());
        dto.set_F_DT_3_(e.get_F_DT_3_());
        dto.set_F_N_3_(e.get_F_N_3_());
        dto.set_F_C5_3_(e.get_F_C5_3_());
        dto.set_F_C10_3_(e.get_F_C10_3_());
        dto.set_F_C20_3_(e.get_F_C20_3_());
        dto.set_F_C50_3_(e.get_F_C50_3_());
        dto.set_F_B_4_(e.get_F_B_4_());
        dto.set_F_I_4_(e.get_F_I_4_());
        dto.set_F_L_4_(e.get_F_L_4_());
        dto.set_F_DT_4_(e.get_F_DT_4_());
        dto.set_F_N_4_(e.get_F_N_4_());
        dto.set_F_C5_4_(e.get_F_C5_4_());
        dto.set_F_C10_4_(e.get_F_C10_4_());
        dto.set_F_C20_4_(e.get_F_C20_4_());
        dto.set_F_C50_4_(e.get_F_C50_4_());
        dto.setActive(e.getActive());
        return dto;
    }

}

