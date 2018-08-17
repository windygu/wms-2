package org.dddml.wms.domain.party;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.domain.Command;
import org.dddml.wms.specialization.DomainError;

public interface PartyCommand extends Command
{
    String getPartyId();

    void setPartyId(String partyId);

    Long getVersion();

    void setVersion(Long version);

    static void throwOnInvalidStateTransition(PartyState state, Command c) {
        if (state.getVersion() == null)
        {
            if (isCommandCreate((PartyCommand)c))
            {
                return;
            }
            throw DomainError.named("premature", "Can't do anything to unexistent aggregate");
        }
        if (state.getDeleted() != null && state.getDeleted())
        {
            throw DomainError.named("zombie", "Can't do anything to deleted aggregate.");
        }
        if (isCommandCreate((PartyCommand)c))
            throw DomainError.named("rebirth", "Can't create aggregate that already exists");
    }

    static boolean isCommandCreate(PartyCommand c) {
        return ((c instanceof PartyCommand.CreateParty) 
            && (COMMAND_TYPE_CREATE.equals(c.getCommandType()) || c.getVersion().equals(PartyState.VERSION_NULL)));
    }

    interface CreateOrMergePatchParty extends PartyCommand
    {
        String getPartyTypeId();

        void setPartyTypeId(String partyTypeId);

        String getPrimaryRoleTypeId();

        void setPrimaryRoleTypeId(String primaryRoleTypeId);

        String getExternalId();

        void setExternalId(String externalId);

        String getPreferredCurrencyUomId();

        void setPreferredCurrencyUomId(String preferredCurrencyUomId);

        String getDescription();

        void setDescription(String description);

        String getOrganizationName();

        void setOrganizationName(String organizationName);

        Boolean getIsSummary();

        void setIsSummary(Boolean isSummary);

        String getSalutation();

        void setSalutation(String salutation);

        String getFirstName();

        void setFirstName(String firstName);

        String getMiddleName();

        void setMiddleName(String middleName);

        String getLastName();

        void setLastName(String lastName);

        String getPersonalTitle();

        void setPersonalTitle(String personalTitle);

        String getNickname();

        void setNickname(String nickname);

        String getCardId();

        void setCardId(String cardId);

        Boolean getActive();

        void setActive(Boolean active);

    }

    interface CreateParty extends CreateOrMergePatchParty
    {
    }

    interface MergePatchParty extends CreateOrMergePatchParty
    {
        Boolean getIsPropertyPartyTypeIdRemoved();

        void setIsPropertyPartyTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyPrimaryRoleTypeIdRemoved();

        void setIsPropertyPrimaryRoleTypeIdRemoved(Boolean removed);

        Boolean getIsPropertyExternalIdRemoved();

        void setIsPropertyExternalIdRemoved(Boolean removed);

        Boolean getIsPropertyPreferredCurrencyUomIdRemoved();

        void setIsPropertyPreferredCurrencyUomIdRemoved(Boolean removed);

        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyOrganizationNameRemoved();

        void setIsPropertyOrganizationNameRemoved(Boolean removed);

        Boolean getIsPropertyIsSummaryRemoved();

        void setIsPropertyIsSummaryRemoved(Boolean removed);

        Boolean getIsPropertySalutationRemoved();

        void setIsPropertySalutationRemoved(Boolean removed);

        Boolean getIsPropertyFirstNameRemoved();

        void setIsPropertyFirstNameRemoved(Boolean removed);

        Boolean getIsPropertyMiddleNameRemoved();

        void setIsPropertyMiddleNameRemoved(Boolean removed);

        Boolean getIsPropertyLastNameRemoved();

        void setIsPropertyLastNameRemoved(Boolean removed);

        Boolean getIsPropertyPersonalTitleRemoved();

        void setIsPropertyPersonalTitleRemoved(Boolean removed);

        Boolean getIsPropertyNicknameRemoved();

        void setIsPropertyNicknameRemoved(Boolean removed);

        Boolean getIsPropertyCardIdRemoved();

        void setIsPropertyCardIdRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

    }

	interface DeleteParty extends PartyCommand
	{

        String getPartyTypeId();

        void setPartyTypeId(String partyTypeId);
	}

}

