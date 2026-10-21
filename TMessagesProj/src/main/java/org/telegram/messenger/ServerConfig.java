package org.telegram.messenger;

import java.util.ArrayList;
import java.util.List;

public class ServerConfig {

    public static class Server {
        public String id = "kuark";
        public String name = LocaleController.isRTL ? "کوآرک" : "Kuark";
        public String description = "Kuark Official Cloud";
        public String host = "5.57.35.21";
        public int port = 2398;
        public boolean isOfficial = true;
        public boolean isTelegram = false;
        public boolean multiDc = false;
        public int mainDcId = 1;
        public String rsaPublicKey = "-----BEGIN RSA PUBLIC KEY-----\nMIIBCgKCAQEAoHKrCaVZJ+gSAXF/h+5zneyjxQoFxs54LM4gHi2lIF+lS+o2Bhkj\nGj3JMLvEQ4iGcwTnZLzdfQz5vfXDjCagMjP78bk6My06BXvv3HtY9WcEvbRQ7JCi\nQmsioubvh2hcTgpwOzcZR16PEAQP1FYTr87Fe9be8HV2zHIiko+MzqKHSCMb7OtP\ncKKnsSQwMwAv8SHNuANX8v31D2G7ym3+6kpv71iWvuW4w70XMGJmO9Dijbc4W4r0\nKzMqFduh1xfJs1Lt01K41t6hjTBiQlZ4we+Pdf2glhRDh4necA8JkpdfjL8nR43D\n32Kmur0bM3/ezYI6yzlBVPPtUkwoZyBJjQIDAQAB\n-----END RSA PUBLIC KEY-----";
        public long rsaKeyFingerprint = 0L;
    }

    public static Server getServer() {
        return new Server();
    }

    public static String getServerIdForAccount(int account) {
        return "kuark";
    }

    public static Server getServerForAccount(int account) {
        return getServer();
    }

    public static String serverNameForAccount(int account) {
        return LocaleController.isRTL ? "کوآرک" : "Kuark";
    }

    public static void applyServerToAccount(Server server, int account, boolean reconnect) {
        if (server == null) return;
        org.telegram.tgnet.ConnectionsManager.native_applyServerConfig(
            account,
            server.host,
            server.port,
            server.isTelegram,
            server.mainDcId,
            server.rsaPublicKey,
            server.rsaKeyFingerprint,
            reconnect
        );
    }

    public static void applyStoredServerToAccount(int account) {
        applyServerToAccount(getServer(), account, false);
    }

    public static boolean serverIsOfficialTelegram(int account) {
        return false;
    }

    public static boolean canAddTelegramAccount() {
        return true;
    }

    public static List<Server> listServers() {
        List<Server> list = new ArrayList<>();
        list.add(getServer());
        return list;
    }
}
