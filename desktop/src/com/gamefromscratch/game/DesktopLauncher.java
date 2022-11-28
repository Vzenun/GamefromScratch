package com.gamefromscratch.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.gamefromscratch.game.HelloWorld;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		//this below function is used to set the windows size actually
		config.setWindowedMode(1280,960);
		config.setForegroundFPS(60);
		config.setTitle("HelloWorld");
		new Lwjgl3Application(new HelloWorld(), config);
	}
}
