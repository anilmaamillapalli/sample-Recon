package identity.dbconnector;

import java.util.Set;

import org.identityconnectors.framework.api.operations.GetApiOp;
import org.identityconnectors.framework.api.operations.UpdateApiOp;
import org.identityconnectors.framework.common.objects.Attribute;
import org.identityconnectors.framework.common.objects.ConnectorObject;
import org.identityconnectors.framework.common.objects.ObjectClass;
import org.identityconnectors.framework.common.objects.OperationOptions;
import org.identityconnectors.framework.common.objects.ResultsHandler;
import org.identityconnectors.framework.common.objects.Schema;
import org.identityconnectors.framework.common.objects.Uid;
import org.identityconnectors.framework.common.objects.filter.FilterTranslator;
import org.identityconnectors.framework.spi.Configuration;
import org.identityconnectors.framework.spi.PoolableConnector;
import org.identityconnectors.framework.spi.operations.CreateOp;
import org.identityconnectors.framework.spi.operations.DeleteOp;
import org.identityconnectors.framework.spi.operations.SchemaOp;
import org.identityconnectors.framework.spi.operations.SearchOp;
import org.identityconnectors.framework.spi.operations.UpdateOp;

public class DataBaseConnector implements SchemaOp,CreateOp,DeleteOp,UpdateOp,SearchOp,GetApiOp,PoolableConnector{

	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	public Configuration getConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

	public void init(Configuration arg0) {
		// TODO Auto-generated method stub
		
	}

	public void checkAlive() {
		// TODO Auto-generated method stub
		
	}

	public ConnectorObject getObject(ObjectClass arg0, Uid arg1, OperationOptions arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	public FilterTranslator createFilterTranslator(ObjectClass arg0, OperationOptions arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public void executeQuery(ObjectClass arg0, Object arg1, ResultsHandler arg2, OperationOptions arg3) {
		// TODO Auto-generated method stub
		
	}

	public Uid update(ObjectClass arg0, Uid arg1, Set<Attribute> arg2, OperationOptions arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(ObjectClass arg0, Uid arg1, OperationOptions arg2) {
		// TODO Auto-generated method stub
		
	}

	public Uid create(ObjectClass arg0, Set<Attribute> arg1, OperationOptions arg2) {
		
		return null;
	}

	public Schema schema() {
		// TODO Auto-generated method stub
		return null;
	}

}
