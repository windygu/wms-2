<?php

namespace Dddml\Wms\HttpClient;


trait PersonFilteringFieldsTrait
{
    public function getFilteringFields()
    {
        return [
            'BirthDate' => '\DateTime',
            'Email' => 'string',
            'CreatedBy' => 'string',
            'UpdatedBy' => 'string',
            'Version' => 'Long',
            'CreatedAt' => '\DateTime',
            'UpdatedAt' => '\DateTime',
            'Active' => 'boolean',
            'Deleted' => 'boolean',
            'PersonalName.FirstName' => 'string',
            'PersonalName.LastName' => 'string',
            'Loves.FirstName' => 'string',
            'Loves.LastName' => 'string',
            'EmergencyContact.PersonalNameFirstName' => 'string',
            'EmergencyContact.PersonalNameLastName' => 'string',
            'EmergencyContact.PhoneNumber' => 'string',
            'EmergencyContact.Address' => 'string',
        ];
    }

}

