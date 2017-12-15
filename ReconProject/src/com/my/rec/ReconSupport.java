package com.my.rec;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Thor.API.Exceptions.tcAPIException;
import Thor.API.Operations.tcProvisioningOperationsIntf;
import Thor.API.Operations.tcUserOperationsIntf;
import oracle.iam.platform.OIMClient;
import oracle.iam.reconciliation.api.EventAttributes;
import oracle.iam.reconciliation.api.ReconOperationsService;

public class ReconSupport {
	
	
	private tcUserOperationsIntf userOperation=null;
	private tcProvisioningOperationsIntf provisionOperatoin=null;
	private ReconOperationsService reconOperations;
	private OIMClient client=null;
	private ArrayList data= new ArrayList();
	public String fileName;
	public String ItResource;
	public String resourceObjName;
	
	
	public void execute(HashMap hashMap){
		this.fileName=hashMap.get("File Name").toString();
		this.ItResource=hashMap.get("ITResource Name").toString();
		this.resourceObjName=hashMap.get("Resource Object Name").toString();
		
		initialize(client){
			
		};
	
	}
	
	
	
	
	
	
	private void getReconData(){
		String file= this.fileName;
		
		BufferedReader reader=null;
		try{
		       reader = new BufferedReader(new FileReader(file));	
		       int headerFieldCount=0;
		       String line="";
		       
		       while ((line=reader.readLine())!= null){
		       this.data.add(line.split("\\,"));
		       }
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void initialize(OIMClient client){
		this.userOperation=client.getService(tcUserOperationsIntf.class);
		this.provisionOperatoin=client.getService(tcProvisioningOperationsIntf.class);
		this.reconOperations=client.getService(ReconOperationsService.class);
	}

private void triggerRecon() throws tcAPIException{
	EventAttributes ea = new EventAttributes();
	
	for(int i=0; i < data.size(); i++){
		String[] temp =(String[])data.get(i);
		Map reconMap= new HashMap();
		
		
		reconMap.put("Account ID",temp[0]);
		reconMap.put("Account Name", temp[1]);
		reconMap.put("ITResource", this.ItResource);
		ea.setEventFinished(true);
		long eventKey = reconOperations.createReconciliationEvent(this.resourceObjName,reconMap,ea);
		
		reconOperations.processReconciliationEvent(eventKey);
	}
}
	
	
	



}
