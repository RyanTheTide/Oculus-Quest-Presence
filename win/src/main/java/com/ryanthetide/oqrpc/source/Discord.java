package com.ryanthetide.oqrpc.source;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;

public class Discord {

    private static DiscordRPC rpc;
    private static DiscordRichPresence presence;

    public static void init() {
        rpc = DiscordRPC.INSTANCE;
        rpc.Discord_Initialize("699644046045347923", new DiscordEventHandlers(), true, "");
        presence = new DiscordRichPresence();
        presence.details = "Just started playing";
        presence.largeImageText = "Oculus Quest";
        presence.largeImageKey = "quest";
        presence.smallImageText = "Oculus Quest RPC";
        presence.smallImageKey = "quest";
        rpc.Discord_UpdatePresence(presence);
    }

    public static void changeGame(String details, String state, String largeImageKey, String largeImageText) {
        presence.details = details;
        presence.state = state;
        presence.largeImageKey = largeImageKey;
        presence.largeImageText = largeImageText;
        rpc.Discord_UpdatePresence(presence);
    }

    public static void terminate() {
        try {
            rpc.Discord_ClearPresence();
        } catch (Exception ignored) {}
    }
}
