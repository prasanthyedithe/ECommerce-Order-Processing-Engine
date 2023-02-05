package com.company.ecommerce.orderservice.utils;

import java.util.Arrays;
import java.util.Optional;

public enum LookupData {
	
	ORDER_STATUS_PLACED("PLACED", 0),
	ORDER_STATUS_PROCESSING("PROCESSING", 1),
	ORDER_STATUS_SHIPPED("SHIPPED", 2),
	ORDER_STATUS_DELIVERED("DELIVERED", 3),
	ORDER_STATUS_READYFORPICK("READY_FOR_PICK", 4),
	ORDER_STATUS_CANCELLED("CANCELLED", 5),
	PAYMENT_METHOD_TYPE_CC("CREDIT_CARD",0),
	PAYMENT_METHOD_TYPE_DC("DEBIT_CARD",1),
	PAYMENT_METHOD_TYPE_PAYPAL("PAYPAL",2),
	ORDER_ADDRESS_TYPE_SHIPPING("SHIPPING",0),
	ORDER_ADDRESS_TYPE_BILLING("BILLING",2),
	ORDER_SHIPPING_TYPE_SHIPTOADDRESS("SHIP_TO_ADDRESS",0),
	ORDER_SHIPPING_TYPE_INSTOREPICKUP("INSTORE_PICKUP",1),
	ORDER_SHIPPING_TYPE_CURBSIDEDELIVERY("CURBSIDE_DELIVERY",2),
	ORDER_SHIPPING_TYPE_THIRDPARTYDELIVERY("THIRDPARTY_DELIVERY",3);
	
	
	private final String status;
    private final Integer value;
    
	private LookupData(String status, Integer value) {
		this.status = status;
		this.value = value;
	}
	public String getStatus() {
		return status;
	}
	public Integer getValue() {
		return value;
	}
	
	// Reverse lookup methods
    public static Optional<LookupData> getLookupDataByValue(String value) {
        return Arrays.stream(LookupData.values())
            .filter(status -> status.status.equals(value))
            .findFirst();
    }
    
    public static Optional<LookupData> getLookupDataByValue(int value) {
        return Arrays.stream(LookupData.values())
            .filter(status -> status.value == value)
            .findFirst();
    }

}
