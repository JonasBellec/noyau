package com.deckard.noyau.core.util;

import java.util.UUID;

public class Util {
	private Util() {

	}

	public static String generateUuid() {
		return UUID.randomUUID().toString();
	}
}
