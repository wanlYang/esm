package com.wanl.utils;

import java.util.UUID;

public class UUIDUtils {
	public static String getUid() {
		return UUID.randomUUID().toString();
	}
	public static String getOrderid() {
		return UUID.randomUUID().toString();
	}
	public static String getOrderItemid() {
		return UUID.randomUUID().toString();
	}
	public static String getPid() {
		return UUID.randomUUID().toString();
	}
	public static String getCateGoryId() {
		return UUID.randomUUID().toString();
	}
	public static String getCode() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString());
	}
}
