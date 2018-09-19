alter table test.inoutnoticeevents add column isScheduleNeeded bit;
alter table test.inoutnoticeevents add column IsPropertyIsScheduleNeededRemoved bit;
alter table test.inoutnotices add column isScheduleNeeded bit;
alter table test.shipmentevents add column isScheduleNeeded bit;
alter table test.shipmentevents add column IsPropertyIsScheduleNeededRemoved bit;
alter table test.shipments add column isScheduleNeeded bit;
