package org.dddml.wms.domain;


public class WarehouseStateEventIdDtoWrapper extends WarehouseStateEventIdDto
{
	
    private WarehouseStateEventId value;

    public WarehouseStateEventIdDtoWrapper()
    {
        this(new WarehouseStateEventId());
    }

    public WarehouseStateEventIdDtoWrapper(WarehouseStateEventId value)
    {
        this.value = value;
    }

    public WarehouseStateEventId toWarehouseStateEventId()
    {
        return this.value;
    }

    @Override
    public String getWarehouseId()
    {
        return this.value.getWarehouseId();
    }

    @Override
    public void setWarehouseId(String warehouseId)
    {
        this.value.setWarehouseId(warehouseId);
    }

    @Override
    public Long getVersion()
    {
        return this.value.getVersion();
    }

    @Override
    public void setVersion(Long version)
    {
        this.value.setVersion(version);
    }


    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == WarehouseStateEventIdDto.class) {
            return super.equals(obj);
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        WarehouseStateEventIdDtoWrapper other = (WarehouseStateEventIdDtoWrapper)obj;
        return value.equals(other.value);
    }

    //@Override
    //public int hashCode()
    //{
    //    return value.hashCode();
    //}

}

