package its.tsid.coders.dataAccess;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public abstract class Checker {

	public abstract BasicDBObject validator(DBObject input);
}
