<?php

namespace Dddml\Wms\HttpClient;


trait MonthPlanMvoFilteringFieldsTrait
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
            'YearPlanDescription' => 'string',
            'YearPlanCreatedBy' => 'string',
            'YearPlanUpdatedBy' => 'string',
            'YearPlanVersion' => 'Long',
            'YearPlanCreatedAt' => '\DateTime',
            'YearPlanUpdatedAt' => '\DateTime',
            'YearPlanActive' => 'boolean',
            'YearPlanDeleted' => 'boolean',
            'PersonBirthDate' => '\DateTime',
            'PersonEmail' => 'string',
            'PersonCreatedBy' => 'string',
            'PersonUpdatedBy' => 'string',
            'PersonVersion' => 'Long',
            'PersonCreatedAt' => '\DateTime',
            'PersonUpdatedAt' => '\DateTime',
            'PersonActive' => 'boolean',
            'PersonDeleted' => 'boolean',
            'MonthPlanId.PersonalNameFirstName' => 'string',
            'MonthPlanId.PersonalNameLastName' => 'string',
            'MonthPlanId.Year' => 'integer',
            'MonthPlanId.Month' => 'integer',
            'PersonLoves.FirstName' => 'string',
            'PersonLoves.LastName' => 'string',
            'PersonEmergencyContact.PersonalNameFirstName' => 'string',
            'PersonEmergencyContact.PersonalNameLastName' => 'string',
            'PersonEmergencyContact.PhoneNumber' => 'string',
            'PersonEmergencyContact.Address' => 'string',
        ];
    }

}

