package com.gamefromscratch.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class HelloWorld extends ApplicationAdapter {
	//ApplicationAdapter can be thought of as an platforms independent way of creating an application
	//Each launcher is actually the platform specific.
	//But each launcher creates an applicationAdapter which is like the main programme or heart of your programme
	//Now applicationAdapter is written in such a way that does not care what platform it is running on.
	//Assets folder is where our assets actually goes.
	SpriteBatch batch;
	Texture img;
	Sprite sprite;
	Sprite sprite2;


	//this below method is called after the constructor but it is called just before everything else
	//It is called only once at start of application
	@Override
	public void create () {
		batch = new SpriteBatch();
		//Spritebatch can be considered as the pixels in grid form in the memory
		img = new Texture("badlogic.jpg");
		sprite=new Sprite(img);
		sprite.setPosition(Gdx.graphics.getWidth()/2-sprite.getWidth()/2,Gdx.graphics.getHeight()/2-sprite.getHeight()/2);
		sprite2=new Sprite(img);
		sprite2.setPosition(Gdx.graphics.getWidth()/2-sprite.getWidth()/2,Gdx.graphics.getHeight()/2-sprite.getHeight()/2);
		sprite2.setRotation(40f);
		sprite2.setScale(2.0f);
	}

	//the below method is called over and over again....
	//if fps is 60 i.e, render is called 60 times in 1 second
	//i.e, called for every single frame that our Application runs...
	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0,(float) 0.5);
//		Gdx.gl.glClearColor(1,1,1,1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//Either 1st command or 2nd ,3rd command in collective works in the same way
		batch.begin();
		batch.draw(img, Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		batch.draw(img, 320-img.getWidth()/2, 240-img.getHeight()/2);
		batch.draw(img, 0, 0);
		batch.draw(sprite,sprite.getX(),sprite.getY());
		batch.draw(sprite2,sprite2.getX(),sprite2.getY(),0,0,sprite2.getWidth(),sprite2.getHeight(),sprite2.getScaleX(),sprite2.getScaleY(),sprite2.getRotation());
		batch.draw(sprite2,sprite2.getX(),sprite2.getY(),sprite2.getWidth()/2,sprite2.getHeight()/2,sprite2.getWidth(),sprite2.getHeight(),sprite2.getScaleX(),sprite2.getScaleY(),sprite2.getRotation());
		//Default 0,0 is the bottom left corner of the screen
		//i.e,default cartesian quadrant they are using is the 1st quadrant
		batch.end();

		//at batch.end() only is that all the instruction that we have given to the batch will be thrown on the screen
		//therefore when batch begin what is happening after that is we are instructing it what to do and what to not do
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
