import java.lang.reflect.Type;
import java.util.GregorianCalendar;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import java.util.Map.Entry;

public class CustomGregorianCalendarDeserializer implements JsonDeserializer<GregorianCalendar>
{
   
   @Override
	public GregorianCalendar deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext ctx)
	{      
		Long epoch = json.getAsLong();
		GregorianCalendar gc = new GregorianCalendar();
      gc.setTimeInMillis(epoch);
      
      return gc;
	}


}