<?php

namespace Dddml\Wms\HttpClient;


trait YearPlanMvoFilteringFieldsTrait
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
            'PersonBirthDate' => '\DateTime',
            'PersonEmail' => 'string',
            'PersonCreatedBy' => 'string',
            'PersonUpdatedBy' => 'string',
            'PersonVersion' => 'Long',
            'PersonCreatedAt' => '\DateTime',
            'PersonUpdatedAt' => '\DateTime',
            'PersonActive' => 'boolean',
            'PersonDeleted' => 'boolean',
            'YearPlanId.PersonalNameFirstName' => 'string',
            'YearPlanId.PersonalNameLastName' => 'string',
            'YearPlanId.Year' => 'integer',
            'PersonLoves.FirstName' => 'string',
            'PersonLoves.LastName' => 'string',
            'PersonEmergencyContact.PersonalNameFirstName' => 'string',
            'PersonEmergencyContact.PersonalNameLastName' => 'string',
            'PersonEmergencyContact.PhoneNumber' => 'string',
            'PersonEmergencyContact.Address' => 'string',
        ];
    }

}

