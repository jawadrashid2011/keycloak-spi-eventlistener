package com.keycloaktesting.sampleeventlistenerprovider.provider;

import java.util.Map;
import java.util.Map.Entry;

import org.keycloak.events.Event;
import org.keycloak.events.EventListenerProvider;
import org.keycloak.events.admin.AdminEvent;

public class SampleEventListenerProvider implements EventListenerProvider {
	
	public SampleEventListenerProvider() {
		
	}

	@Override
    public void onEvent(Event event) {
		if(event.getType().toString() == "LOGIN") {
			System.out.println("Event Occurred:" + toString(event));
		}
    }

    @Override
    public void onEvent(AdminEvent adminEvent, boolean b) {

//        System.out.println("Admin Event Occurred:" + toString(adminEvent));
    }

    @Override
    public void close() {

    }
	
	private String toString(Event event) {

        StringBuilder sb = new StringBuilder();

        sb.append("Event FOUND");

        sb.append(", type=");

        sb.append(event.getType());

        sb.append(", realmId=");

        sb.append(event.getRealmId());

        sb.append(", clientId=");

        sb.append(event.getClientId());

        sb.append(", userId=");

        sb.append(event.getUserId());

        sb.append(", ipAddress=");

        sb.append(event.getIpAddress());
        
        sb.append(", time=");

        sb.append(event.getTime());
        
        sb.append(", sessionId=");

        sb.append(event.getSessionId());
        
        sb.append(", details=");
        
        for(Map.Entry<String, String> entry : event.getDetails().entrySet()) {
        	sb.append(entry.getKey() + ":" + entry.getValue().toString() + ",");
        }        


//        if (event.getError() != null) {
//
//            sb.append(", error=");
//
//            sb.append(event.getError());
//
//        }


        if (event.getDetails() != null) {

            for (Entry<String, String> e : event.getDetails().entrySet()) {

                sb.append(", ");

                sb.append(e.getKey());

                if (e.getValue() == null || e.getValue().indexOf(' ') == -1) {

                    sb.append("=");

                    sb.append(e.getValue());

                } else {

                    sb.append("='");

                    sb.append(e.getValue());

                    sb.append("'");

                }

            }

        }


        return sb.toString();

    }

	
	private String toString(AdminEvent adminEvent) {

        StringBuilder sb = new StringBuilder();


        sb.append("operationType=");

        sb.append(adminEvent.getOperationType());

        sb.append(", realmId=");

        sb.append(adminEvent.getAuthDetails().getRealmId());

        sb.append(", clientId=");

        sb.append(adminEvent.getAuthDetails().getClientId());

        sb.append(", userId=");

        sb.append(adminEvent.getAuthDetails().getUserId());

        sb.append(", ipAddress=");

        sb.append(adminEvent.getAuthDetails().getIpAddress());

        sb.append(", resourcePath=");

        sb.append(adminEvent.getResourcePath());


        if (adminEvent.getError() != null) {

            sb.append(", error=");

            sb.append(adminEvent.getError());

        }


        return sb.toString();

    }

}
