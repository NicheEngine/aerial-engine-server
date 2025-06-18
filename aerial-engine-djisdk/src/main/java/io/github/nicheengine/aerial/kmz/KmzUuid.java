package io.github.nicheengine.aerial.kmz;

import java.util.Random;

public class KmzUuid {

    public static final String UUID_CONSTANT = "xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx";

    public static String uuid_v4() {
        StringBuilder uuid = new StringBuilder(UUID_CONSTANT);
        Random random = new Random();
        for (int i = 0; i < uuid.length(); i++) {
            char c = uuid.charAt(i);
            if (c == 'x') {
                int r = random.nextInt(16);
                uuid.setCharAt(i, Integer.toHexString(r).charAt(0));
            } else if (c == 'y') {
                int r = random.nextInt(16);
                int v = (r & 0x3) | 0x8;
                uuid.setCharAt(i, Integer.toHexString(v).charAt(0));
            }
        }
        return uuid.toString();
    }
}
