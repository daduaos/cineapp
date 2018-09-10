package net.itinajero.app.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Util {

	/**
	 * Get next days by count
	 * @param int count
	 * @return {@link List}
	 */
	public static List<String> getNextDays(int count){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date dateStart = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, count);
		Date dateEnd = cal.getTime();
		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTime(dateStart);
		List<String> nextDays = new ArrayList<>();
		while(!gcal.getTime().after(dateEnd)){
			Date d = gcal.getTime();
			gcal.add(Calendar.DATE, 1);
			nextDays.add(dateFormat.format(d));
		}
		return nextDays;
	}
}
