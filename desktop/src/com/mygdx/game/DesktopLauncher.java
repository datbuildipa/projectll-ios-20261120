package com.mygdx.game;

import beatdz.AppListener;
import beatdz.Utlis;
import beatdz.DataCenter;
import beatdz.CheckVersionScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.tgame.model.Caption;

public class DesktopLauncher {
    public static void main(String[] args) {
        Caption.loadVN();
        Utlis.ipsv = "http://160.191.50.113/serverlist.txt";
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("Lang La - Desktop Test");
        config.setWindowedMode(960, 640);
        config.setResizable(false);
        config.useVsync(true);
        config.setForegroundFPS(60);
        new Lwjgl3Application(new AppListener() {
            private boolean ready;
            private long lastStatus;

            @Override
            public void create() {
                super.create();
                // Font creation is queued; render after those tasks have run.
                Gdx.app.postRunnable(() -> ready = true);
            }

            @Override
            public void render() {
                if (ready) super.render();
                if (Boolean.getBoolean("langla.debug") && System.currentTimeMillis() - lastStatus > 5000) {
                    lastStatus = System.currentTimeMillis();
                    Object screen = DataCenter.gI().currentScreen;
                    System.out.println("Desktop screen=" + (screen == null ? "null" : screen.getClass().getSimpleName())
                        + " server=" + DataCenter.gI().ipServer);
                    if (screen instanceof CheckVersionScreen) {
                        CheckVersionScreen loading = (CheckVersionScreen) screen;
                        if (loading.a != null) System.out.println("Loading=" + loading.a.a.a + "/" + loading.a.a.b
                            + " finished=" + loading.a.b + " disabled=" + CheckVersionScreen.d);
                    }
                }
            }
        }, config);
    }
}
