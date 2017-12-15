package com.kp.org.rsa.token;

import java.util.Date;
import java.util.HashMap;

import Thor.API.Exceptions.tcAPIException;
import oracle.iam.platform.OIMClient;
import oracle.iam.reconciliation.api.ChangeType;
import oracle.iam.reconciliation.api.EventAttributes;
import oracle.iam.reconciliation.api.ReconOperationsService;

public class ReconciliationEvents {
	
	public final ReconOperationsService reconOps;
	
	public ReconciliationEvents(OIMClient client){
		
		this.reconOps=client.getService(ReconOperationsService.class);
    }
	
	public void makeReconciliationEvent(String resObjectName, HashMap<String,Object> reconFieldData) throws tcAPIException{
		
		//setup Event Attributes
		EventAttributes evtAttrs = new EventAttributes();
		evtAttrs.setEventFinished(true);
		evtAttrs.setActionDate(new Date());
		evtAttrs.setActionDate(null);
		evtAttrs.setChangeType(ChangeType.REGULAR);
		
		//Call OIM API to create reconciliation event
		long reconEventKey = this.reconOps.createReconciliationEvent(resObjectName, reconFieldData, evtAttrs);
		
		
		//Call OIM API to Process reconciliation event(apply action and matching rules, and link to appropriate user, org or processs instance)
		
		this.reconOps.processReconciliationEvent(reconEventKey);
	}

}
