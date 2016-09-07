<?php

namespace Dddml\Wms\HttpClient;


trait DayPlanFilteringFieldsTrait
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
            'Year' => 'integer',
            'Month' => 'integer',
            'DayPlanId.PersonalNameFirstName' => 'string',
            'DayPlanId.PersonalNameLastName' => 'string',
            'DayPlanId.Year' => 'integer',
            'DayPlanId.Month' => 'integer',
            'DayPlanId.Day' => 'integer',
            'PersonalName.FirstName' => 'string',
            'PersonalName.LastName' => 'string',
        ];
    }

}

