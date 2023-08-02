package com.app.lobotustask.models;

import java.util.List;

public class AddressModel {
    public boolean success;
    public String message;
    public String errorMessage;
    public List<Integer> recordCount;
    public List<Result> result;

    public class City {
        public int cityId;
        public String cityName;
        public int stateId;
        public String stateName;
        public int countryID;
        public String countryName;
        public Object countryCode;
        public int zoneId;
        public String zoneName;
    }

    public class ClientLoc {
        public String latitude;
        public String longitude;
        public String location;
    }

    public class Result {
        public int clientID;
        public String clientName;
        public String mobile;
        public String addedByUserID;
        public String userFullName;
        public int enabledStatus;
        public ClientLoc clientLoc;
        public String clientDate;
        public String flag;
        public String email;
        public String contactPersonName;
        public String landline;
        public int countryID;
        public int zoneID;
        public int stateID;
        public int cityID;
        public String pincode;
        public int updateCount;
        public int retagCount;
        public int categoryID;
        public String clientCategoryName;
        public int stageID;
        public String clientStageName;
        public City city;
    }
}
