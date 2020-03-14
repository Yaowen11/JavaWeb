package web.flux.utls;

/**
 * @author z
 */
public class Ip2Long {

    private static final int IPV4_SPLIT_LENGTH = 4;

    private static final String IP_SPLIT = "\\.";

    public static Long ipv42Int(String ip) {
        String[] split = ip.split("\\.");
        return ((Long.parseLong(split[0]) << 24) + (Long.parseLong(split[1]) << 16)
                + (Long.parseLong(split[2]) << 8) + (Long.parseLong(split[3])));
    }

    public static String int2Ipv4(Long ipInt) {
        return (ipInt >>> 24) +
                "." +
                ((ipInt & 0x00FFFFFF) >>> 16) +
                "." +
                ((ipInt & 0x0000FFFF) >>> 8) +
                "." +
                (ipInt & 0x000000FF);
    }
}
