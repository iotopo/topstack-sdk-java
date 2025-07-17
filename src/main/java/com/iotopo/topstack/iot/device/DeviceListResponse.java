package com.iotopo.topstack.iot.device;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceListResponse {
    public static class Device {
        private String id;
        private String code;
        private String name;
        private String description;
        private String gatewayID;
        private String gatewayName;
        private String typeID;
        private String typeName;
        private String groupID;
        private String groupName;
        private Boolean template;
        private String address;
        private Integer idleTimeout;
        private String connectMode;
        private String userGroupID;
        private String userGroupName;
        private String dataChannelID;
        private String dataChannelName;
        private String customChannelID;
        private String customChannelName;
        private Integer state;
        private Date stateChangeTime;
        private Date createdAt;
        private Date updatedAt;
        private Boolean hasProps;
        private Boolean manualGI;
        private Double longitude;
        private Double latitude;
        private String longitudePointID;
        private String latitudePointID;

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        
        public String getCode() { return code; }
        public void setCode(String code) { this.code = code; }
        
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
        
        public String getGatewayID() { return gatewayID; }
        public void setGatewayID(String gatewayID) { this.gatewayID = gatewayID; }
        
        public String getGatewayName() { return gatewayName; }
        public void setGatewayName(String gatewayName) { this.gatewayName = gatewayName; }
        
        public String getTypeID() { return typeID; }
        public void setTypeID(String typeID) { this.typeID = typeID; }
        
        public String getTypeName() { return typeName; }
        public void setTypeName(String typeName) { this.typeName = typeName; }
        
        public String getGroupID() { return groupID; }
        public void setGroupID(String groupID) { this.groupID = groupID; }
        
        public String getGroupName() { return groupName; }
        public void setGroupName(String groupName) { this.groupName = groupName; }
        
        public Boolean getTemplate() { return template; }
        public void setTemplate(Boolean template) { this.template = template; }
        
        public String getAddress() { return address; }
        public void setAddress(String address) { this.address = address; }
        
        public Integer getIdleTimeout() { return idleTimeout; }
        public void setIdleTimeout(Integer idleTimeout) { this.idleTimeout = idleTimeout; }
        
        public String getConnectMode() { return connectMode; }
        public void setConnectMode(String connectMode) { this.connectMode = connectMode; }
        
        public String getUserGroupID() { return userGroupID; }
        public void setUserGroupID(String userGroupID) { this.userGroupID = userGroupID; }
        
        public String getUserGroupName() { return userGroupName; }
        public void setUserGroupName(String userGroupName) { this.userGroupName = userGroupName; }
        
        public String getDataChannelID() { return dataChannelID; }
        public void setDataChannelID(String dataChannelID) { this.dataChannelID = dataChannelID; }
        
        public String getDataChannelName() { return dataChannelName; }
        public void setDataChannelName(String dataChannelName) { this.dataChannelName = dataChannelName; }
        
        public String getCustomChannelID() { return customChannelID; }
        public void setCustomChannelID(String customChannelID) { this.customChannelID = customChannelID; }
        
        public String getCustomChannelName() { return customChannelName; }
        public void setCustomChannelName(String customChannelName) { this.customChannelName = customChannelName; }
        
        public Integer getState() { return state; }
        public void setState(Integer state) { this.state = state; }
        
        public Date getStateChangeTime() { return stateChangeTime; }
        public void setStateChangeTime(Date stateChangeTime) { this.stateChangeTime = stateChangeTime; }
        
        public Date getCreatedAt() { return createdAt; }
        public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
        
        public Date getUpdatedAt() { return updatedAt; }
        public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }
        
        public Boolean getHasProps() { return hasProps; }
        public void setHasProps(Boolean hasProps) { this.hasProps = hasProps; }
        
        public Boolean getManualGI() { return manualGI; }
        public void setManualGI(Boolean manualGI) { this.manualGI = manualGI; }
        
        public Double getLongitude() { return longitude; }
        public void setLongitude(Double longitude) { this.longitude = longitude; }
        
        public Double getLatitude() { return latitude; }
        public void setLatitude(Double latitude) { this.latitude = latitude; }
        
        public String getLongitudePointID() { return longitudePointID; }
        public void setLongitudePointID(String longitudePointID) { this.longitudePointID = longitudePointID; }
        
        public String getLatitudePointID() { return latitudePointID; }
        public void setLatitudePointID(String latitudePointID) { this.latitudePointID = latitudePointID; }
    }

    private Long total;
    private List<Device> items;

    public Long getTotal() { return total; }
    public void setTotal(Long total) { this.total = total; }
    
    public List<Device> getItems() { return items; }
    public void setItems(List<Device> items) { this.items = items; }
} 