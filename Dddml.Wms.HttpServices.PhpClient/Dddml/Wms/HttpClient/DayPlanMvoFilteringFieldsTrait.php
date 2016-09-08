<?php

namespace Dddml\Wms\HttpClient;


trait DayPlanMvoFilteringFieldsTrait
{
    public function getFilteringFields()
    {
        return [
            'Description' => 'string',
            'CreatedBy' => 'string',
            'UpdatedBy' => 'string',
            'Version' => 'Long',
            'CreatedAt' => '\DateTime',
            'UpdatedAt' => '\DateTime',
            'Active' => 'boolean',
            'Deleted' => 'boolean',
            'MonthPlanDescription' => 'string',
            'MonthPlanCreatedBy' => 'string',
            'MonthPlanUpdatedBy' => 'string',
            'MonthPlanVersion' => 'Long',
            'MonthPlanCreatedAt' => '\DateTime',
            'MonthPlanUpdatedAt' => '\DateTime',
            'MonthPlanActive' => 'boolean',
            'MonthPlanDeleted' => 'boolean',
            'YearPlanDescription' => 'string',
            'YearPlanCreatedBy' => 'string',
            'YearPlanUpdatedBy' => 'string',
            'YearPlanVersion' => 'Long',
            'YearPlanCreatedAt' => '\DateTime',
            'YearPlanUpdatedAt' => '\DateTime',
            'YearPlanActive' => 'boolean',
            'YearPlanDeleted' => 'boolean',
            'PersonBirthDate' => '\DateTime',
            'PersonCreatedBy' => 'string',
            'PersonUpdatedBy' => 'string',
            'PersonVersion' => 'Long',
            'PersonCreatedAt' => '\DateTime',
            'PersonUpdatedAt' => '\DateTime',
            'PersonActive' => 'boolean',
            'PersonDeleted' => 'boolean',
            'DayPlanId.PersonalNameFirstName' => 'string',
            'DayPlanId.PersonalNameLastName' => 'string',
            'DayPlanId.Year' => 'integer',
            'DayPlanId.Month' => 'integer',
            'DayPlanId.Day' => 'integer',
            'PersonLoves.FirstName' => 'string',
            'PersonLoves.LastName' => 'string',
            'PersonEmergencyContact.PersonalNameFirstName' => 'string',
            'PersonEmergencyContact.PersonalNameLastName' => 'string',
            'PersonEmergencyContact.PhoneNumber' => 'string',
            'PersonEmergencyContact.Address' => 'string',
        ];
    }

}

