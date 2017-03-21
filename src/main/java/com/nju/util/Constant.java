package com.nju.util;

import com.nju.entity.Order;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by OptimusPrime on 2017.3.12.
 */
public class Constant {
	/**
	 * back ratio
	 */
	public final static double BACKRATIO = 0.7;

	/**
	 * manager userno
	 */
	public final static String MANAGENO = "1730001";
	/**
	 * date format pattern
	 */
	public final static String sdfPattern = "yyyyMMddHHmms";

	/**
	 * website fee ratio
	 */
	public final static double feeRatio = 0.01;

	/**
	 * score exchange to balance ratio=0.1
	 */
	public final static double exchangeRatio = 0.1;


	/**
	 * get yyyyMMddHHmms format time string
	 *
	 * @return
	 */
	public static String getTimeFormatString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmms");
		String str = sdf.format((new java.util.Date()).getTime());
		return str;
	}

	public static Map<java.sql.Date, Integer> getOrderMap(List<Order> orderList) {
		Map<java.sql.Date, Integer> map = new HashMap<Date, Integer>();
		for (Order o : orderList) {
			Date d = o.getStartTime();
			if (map.containsKey(d)) {
				map.put(d, map.get(d) + 1);
			} else {
				map.put(d, 1);
			}
		}
		return map;
	}

	/**
	 * get the distance between d1 and d2
	 *
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int getDateDistance(Date d1, Date d2) {
		int dateDistance = (int) (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24);
		return dateDistance;
	}

	/**
	 * get date String line,delimitor is |,and d1<d2;
	 *
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static String getDateString(String d1, String d2) {
		Date date1 = Date.valueOf(d1);
		Date date2 = Date.valueOf(d2);
		Date t = date1;
		StringBuffer sb = new StringBuffer();
		for (; t.before(date2); ) {
			sb.append(t.toString() + "|");
			t = new Date(t.getTime() + 24 * 3600 * 1000);
		}
		return sb.toString();
	}

	public static String getUserType(int userType) {
		String result = "";
		switch (userType) {
			case 1:
				result = "会员";
				break;
			case 2:
				result = "酒店";
				break;
			case 3:
				result = "经理";
				break;
			default:
				result = "会员";
				System.out.println("UserType error!");
				break;
		}
		return result;
	}
}