package org.dddml.wms.domain;

import java.util.*;
import java.util.Date;
import org.dddml.wms.domain.Command;

public interface MonthPlanMvoCommand extends Command
{
    MonthPlanId getMonthPlanId();

    void setMonthPlanId(MonthPlanId monthPlanId);

    Long getPersonVersion();

    void setPersonVersion(Long personVersion);


    interface CreateOrMergePatchMonthPlanMvo extends MonthPlanMvoCommand
    {
        String getDescription();

        void setDescription(String description);

        Long getVersion();

        void setVersion(Long version);

        Boolean getActive();

        void setActive(Boolean active);

        String getYearPlanDescription();

        void setYearPlanDescription(String yearPlanDescription);

        String getYearPlanCreatedBy();

        void setYearPlanCreatedBy(String yearPlanCreatedBy);

        String getYearPlanUpdatedBy();

        void setYearPlanUpdatedBy(String yearPlanUpdatedBy);

        Long getYearPlanVersion();

        void setYearPlanVersion(Long yearPlanVersion);

        Date getYearPlanCreatedAt();

        void setYearPlanCreatedAt(Date yearPlanCreatedAt);

        Date getYearPlanUpdatedAt();

        void setYearPlanUpdatedAt(Date yearPlanUpdatedAt);

        Boolean getYearPlanActive();

        void setYearPlanActive(Boolean yearPlanActive);

        Boolean getYearPlanDeleted();

        void setYearPlanDeleted(Boolean yearPlanDeleted);

        Date getPersonBirthDate();

        void setPersonBirthDate(Date personBirthDate);

        PersonalName getPersonLoves();

        void setPersonLoves(PersonalName personLoves);

        Contact getPersonEmergencyContact();

        void setPersonEmergencyContact(Contact personEmergencyContact);

        String getPersonCreatedBy();

        void setPersonCreatedBy(String personCreatedBy);

        String getPersonUpdatedBy();

        void setPersonUpdatedBy(String personUpdatedBy);

        Date getPersonCreatedAt();

        void setPersonCreatedAt(Date personCreatedAt);

        Date getPersonUpdatedAt();

        void setPersonUpdatedAt(Date personUpdatedAt);

        Boolean getPersonActive();

        void setPersonActive(Boolean personActive);

        Boolean getPersonDeleted();

        void setPersonDeleted(Boolean personDeleted);

    }

    interface CreateMonthPlanMvo extends CreateOrMergePatchMonthPlanMvo
    {
    }

    interface MergePatchMonthPlanMvo extends CreateOrMergePatchMonthPlanMvo
    {
        Boolean getIsPropertyDescriptionRemoved();

        void setIsPropertyDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyVersionRemoved();

        void setIsPropertyVersionRemoved(Boolean removed);

        Boolean getIsPropertyActiveRemoved();

        void setIsPropertyActiveRemoved(Boolean removed);

        Boolean getIsPropertyYearPlanDescriptionRemoved();

        void setIsPropertyYearPlanDescriptionRemoved(Boolean removed);

        Boolean getIsPropertyYearPlanCreatedByRemoved();

        void setIsPropertyYearPlanCreatedByRemoved(Boolean removed);

        Boolean getIsPropertyYearPlanUpdatedByRemoved();

        void setIsPropertyYearPlanUpdatedByRemoved(Boolean removed);

        Boolean getIsPropertyYearPlanVersionRemoved();

        void setIsPropertyYearPlanVersionRemoved(Boolean removed);

        Boolean getIsPropertyYearPlanCreatedAtRemoved();

        void setIsPropertyYearPlanCreatedAtRemoved(Boolean removed);

        Boolean getIsPropertyYearPlanUpdatedAtRemoved();

        void setIsPropertyYearPlanUpdatedAtRemoved(Boolean removed);

        Boolean getIsPropertyYearPlanActiveRemoved();

        void setIsPropertyYearPlanActiveRemoved(Boolean removed);

        Boolean getIsPropertyYearPlanDeletedRemoved();

        void setIsPropertyYearPlanDeletedRemoved(Boolean removed);

        Boolean getIsPropertyPersonBirthDateRemoved();

        void setIsPropertyPersonBirthDateRemoved(Boolean removed);

        Boolean getIsPropertyPersonLovesRemoved();

        void setIsPropertyPersonLovesRemoved(Boolean removed);

        Boolean getIsPropertyPersonEmergencyContactRemoved();

        void setIsPropertyPersonEmergencyContactRemoved(Boolean removed);

        Boolean getIsPropertyPersonCreatedByRemoved();

        void setIsPropertyPersonCreatedByRemoved(Boolean removed);

        Boolean getIsPropertyPersonUpdatedByRemoved();

        void setIsPropertyPersonUpdatedByRemoved(Boolean removed);

        Boolean getIsPropertyPersonCreatedAtRemoved();

        void setIsPropertyPersonCreatedAtRemoved(Boolean removed);

        Boolean getIsPropertyPersonUpdatedAtRemoved();

        void setIsPropertyPersonUpdatedAtRemoved(Boolean removed);

        Boolean getIsPropertyPersonActiveRemoved();

        void setIsPropertyPersonActiveRemoved(Boolean removed);

        Boolean getIsPropertyPersonDeletedRemoved();

        void setIsPropertyPersonDeletedRemoved(Boolean removed);

    }

	interface DeleteMonthPlanMvo extends MonthPlanMvoCommand
	{
	}

}

