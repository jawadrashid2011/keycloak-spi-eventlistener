package com.keycloaktesting.sampleeventlistenerprovider.provider;

import org.keycloak.Config.Scope;
import org.keycloak.events.EventListenerProvider;
import org.keycloak.events.EventListenerProviderFactory;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;

public class SampleEventListenerProviderFactory implements EventListenerProviderFactory {

	@Override
	public EventListenerProvider create(KeycloakSession session) {
		return new SampleEventListenerProvider();
	}

	@Override
	public void init(Scope config) {

	}

	@Override
	public void postInit(KeycloakSessionFactory factory) {

	}

	@Override
	public void close() {
		
	}

	@Override
	public String getId() {
		return "sample_event_listener";
	}

}
