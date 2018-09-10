alter table test.ordershipgroupevents add column DestinationFacilityId VARCHAR(20);
alter table test.ordershipgroupevents add column IsPropertyDestinationFacilityIdRemoved bit;
alter table test.ordershipgroups add column DestinationFacilityId VARCHAR(20);
