package com.kp.org.rsa.token;

import java.util.HashMap;
import java.util.Map;

import Thor.API.Exceptions.tcAPIException;
import Thor.API.Exceptions.tcColumnNotFoundException;
import Thor.API.Exceptions.tcInvalidLookupException;
import Thor.API.Operations.tcFormDefinitionOperationsIntf;
import Thor.API.Operations.tcFormInstanceOperationsIntf;
import Thor.API.Operations.tcITResourceInstanceOperationsIntf;
import Thor.API.Operations.tcLookupOperationsIntf;
import Thor.API.Operations.tcUserOperationsIntf;

public class RSAUtility {
	
	private static tcFormDefinitionOperationsIntf formDefAPI;
	private static tcFormInstanceOperationsIntf formAPI;
	private tcUserOperationsIntf userOps= null;
	public static tcLookupOperationsIntf lookupOps;
	
	
	public long getITResourceName(tcITResourceInstanceOperationsIntf itResInstOp,String name) throws tcAPIException, tcColumnNotFoundException{
	    long result =0L;
	    Map searchFor = new HashMap();
	    searchFor.put("IT Resources.Name", name);
	    
	    Thor.API.tcResultSet results=itResInstOp.findITResourceInstances(searchFor);
	    
	    if(results.getRowCount() ==1){
	    	results.goToRow(0);
	    	result=results.getLongValue("IT Resource.Key");
	    	
	    }else{
	    	searchFor.clear();
	    	results=itResInstOp.findITResourceInstances(searchFor);
	    	int i=0;
	    	do {
	    		if(i > results.getRowCount())
	    			break;
	    		results.goToRow(i);
	    		if(results.getStringValue("IT Resource.Name").equalsIgnoreCase(name)){
	    			result=results.getLongValue("IT Resources.Key");
	    			break;
	    		}
	    		i++;
	    	 }while(true);
	    }
		return result;
}
	
	
	public HashMap getLookUpMap(tcLookupOperationsIntf lookupOps,String s) throws tcAPIException, tcInvalidLookupException, tcColumnNotFoundException{
		
		HashMap hashMap =new HashMap();
		
		 Thor.API.tcResultSet tcresultSet=lookupOps.getLookupValues(s);
		 
		 for(int i=0; i < tcresultSet.getRowCount();i++){
			 tcresultSet.goToRow(i);
			 String code = tcresultSet.getStringValue("Lookup Definition.Lookup Code Information.Code Key");
			 String decode = tcresultSet.getStringValue("Lookup Definition.Lookup Code Information.Decode");
			 hashMap.put(code, decode);
		 }
		 return hashMap;
			
	}
	
	
	
	
	
	
}
