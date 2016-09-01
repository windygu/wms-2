<?php

namespace Dddml\Wms\HttpClient;


trait MonthPlanFilteringFieldsTrait
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
            'MonthPlanId.PersonalNameFirstName' => 'string',
            'MonthPlanId.PersonalNameLastName' => 'string',
            'MonthPlanId.Year' => 'integer',
            'MonthPlanId.Month' => 'integer',
            'PersonalName.FirstName' => 'string',
            'PersonalName.LastName' => 'string',
        ];
    }

}

