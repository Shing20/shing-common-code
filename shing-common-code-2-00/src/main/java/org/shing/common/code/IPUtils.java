package org.shing.common.code;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: IPUtils
 * @Description:获取IP工具类
 * @author: Shing 公众号 ：香蜜湖的蜜。 慢慢来，成长最快。相信奋斗，看见未来！天堂向左，深圳向右，记录与分享深圳故事。
 * @date: 2020-7-3 17:44:25
 */
public class IPUtils {

	private static final Logger logger = LoggerFactory.getLogger(IPUtils.class);
	public final static String HTTP_HEADER_REAL_IP = "X-Real-IP";
	public final static String HTTP_HEADER_FORWARDED = "X-Forwarded-For";
	public final static String HTTP_HEADER_PROXY = "Proxy-Client-IP";
	public final static String HTTP_RESPONSE_UNKNOWN = "unknown";
	// 在使用正则表达式时，利用好其预编译功能，可以有效加快正则匹配速度。
	private final static Pattern CHECK_IP_PATTERN = Pattern.compile(
			"\\\\b((?!\\\\d\\\\d\\\\d)\\\\d+|1\\\\d\\\\d|2[0-4]\\\\d|25[0-5])\\\\.((?!\\\\d\\\\d\\\\d)\\\\d+|1\\\\d\\\\d|2[0-4]\\\\d|25[0-5])\\\\.((?!\\\\d\\\\d\\\\d)\\\\d+|1\\\\d\\\\d|2[0-4]\\\\d|25[0-5])\\\\.((?!\\\\d\\\\d\\\\d)\\\\d+|1\\\\d\\\\d|2[0-4]\\\\d|25[0-5])\\\\b");

	/**
	 * 根据客户端http请求获取客户端地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getClientIP(HttpServletRequest request) {

		String ip = request.getHeader(HTTP_HEADER_REAL_IP);
		if (StringUtils.isEmpty(ip) || StringUtils.equalsIgnoreCase(HTTP_RESPONSE_UNKNOWN, ip)) {
			ip = request.getHeader(HTTP_HEADER_FORWARDED);
		}
		if (StringUtils.isEmpty(ip) || StringUtils.equalsIgnoreCase(HTTP_RESPONSE_UNKNOWN, ip)) {
			ip = request.getHeader(HTTP_HEADER_PROXY);
		}
		if (StringUtils.isEmpty(ip) || StringUtils.equalsIgnoreCase(HTTP_RESPONSE_UNKNOWN, ip)) {
			ip = request.getRemoteAddr();
		} else {
			String[] strArray = StringUtils.split(ip, ",");
			String strIp = StringUtils.trim(strArray[0]);
			if (checkIP(strIp)) {
				ip = strIp;
			} else {
				ip = request.getRemoteAddr();
			}
		}
		return ip;
	}

	private static boolean checkIP(String str) {

		Matcher m = CHECK_IP_PATTERN.matcher(str);
		return m.matches();
	}

	/**
	 * 从ip的字符串形式得到字节数组形式
	 * 
	 * @param ip 字符串形式的ip
	 * @return 字节数组形式的ip
	 */
	public static byte[] getIpByteArrayFromString(String ip) {

		byte[] ret = new byte[4];
		java.util.StringTokenizer st = new java.util.StringTokenizer(ip, ".");
		try {
			ret[0] = (byte) (Integer.parseInt(st.nextToken()) & 0xFF);
			ret[1] = (byte) (Integer.parseInt(st.nextToken()) & 0xFF);
			ret[2] = (byte) (Integer.parseInt(st.nextToken()) & 0xFF);
			ret[3] = (byte) (Integer.parseInt(st.nextToken()) & 0xFF);
		} catch (Exception e) {
			logger.error("failed e={}", e.getMessage());
		}
		return ret;
	}

	/**
	 * 对原始字符串进行编码转换，如果失败，返回原始的字符串
	 * 
	 * @param s            原始字符串
	 * @param srcEncoding  源编码方式
	 * @param destEncoding 目标编码方式
	 * @return 转换编码后的字符串，失败返回原始字符串
	 */
	public static String getString(String s, String srcEncoding, String destEncoding) {

		try {
			return new String(s.getBytes(srcEncoding), destEncoding);
		} catch (UnsupportedEncodingException e) {
			return s;
		}
	}

	/**
	 * 根据某种编码方式将字节数组转换成字符串
	 * 
	 * @param b        字节数组
	 * @param encoding 编码方式
	 * @return 如果encoding不支持，返回一个缺省编码的字符串
	 */
	public static String getString(byte[] b, String encoding) {

		try {
			return new String(b, encoding);
		} catch (UnsupportedEncodingException e) {
			return new String(b);
		}
	}

	/**
	 * 根据某种编码方式将字节数组转换成字符串
	 * 
	 * @param b        字节数组
	 * @param offset   要转换的起始位置
	 * @param len      要转换的长度
	 * @param encoding 编码方式
	 * @return 如果encoding不支持，返回一个缺省编码的字符串
	 */
	public static String getString(byte[] b, int offset, int len, String encoding) {

		try {
			return new String(b, offset, len, encoding);
		} catch (UnsupportedEncodingException e) {
			return new String(b, offset, len);
		}
	}

	/**
	 * @param ip ip的字节数组形式
	 * @return 字符串形式的ip
	 */
	public static String getIpStringFromBytes(byte[] ip) {

		StringBuffer sb = new StringBuffer();
		sb.append(ip[0] & 0xFF);
		sb.append('.');
		sb.append(ip[1] & 0xFF);
		sb.append('.');
		sb.append(ip[2] & 0xFF);
		sb.append('.');
		sb.append(ip[3] & 0xFF);
		return sb.toString();
	}

	/**
	 * 将127.0.0.1形式的IP地址转换成十进制整数
	 */
	public static long ipToLong(String strIp) {

		long[] ip = new long[4];
		// 先找到IP地址字符串中.的位置
		int position1 = strIp.indexOf(".");
		int position2 = strIp.indexOf(".", position1 + 1);
		int position3 = strIp.indexOf(".", position2 + 1);
		// 将每个.之间的字符串转换成整型
		ip[0] = Long.parseLong(strIp.substring(0, position1));
		ip[1] = Long.parseLong(strIp.substring(position1 + 1, position2));
		ip[2] = Long.parseLong(strIp.substring(position2 + 1, position3));
		ip[3] = Long.parseLong(strIp.substring(position3 + 1));
		return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
	}

	/**
	 * 将十进制整数形式转换成127.0.0.1形式的ip地址
	 * 
	 * @param longIp
	 * @return
	 */
	public static String longToIP(long longIp) {

		StringBuffer sb = new StringBuffer("");
		// 直接右移24位
		sb.append(String.valueOf((longIp >>> 24)));
		sb.append(".");
		// 将高8位置0，然后右移16位
		sb.append(String.valueOf((longIp & 0x00FFFFFF) >>> 16));
		sb.append(".");
		// 将高16位置0，然后右移8位
		sb.append(String.valueOf((longIp & 0x0000FFFF) >>> 8));
		sb.append(".");
		// 将高24位置0
		sb.append(String.valueOf((longIp & 0x000000FF)));
		return sb.toString();
	}
}
