package com.gamefromscratch.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.particles.ParticleShader;
import com.badlogic.gdx.utils.ScreenUtils;

import java.io.Serializable;


public class HelloWorld extends ApplicationAdapter implements InputProcessor, Serializable {
	//ApplicationAdapter can be thought of as an platforms independent way of creating an application
	//Each launcher is actually the platform specific.
	//But each launcher creates an applicationAdapter which is like the main programme or heart of your programme
	//Now applicationAdapter is written in such a way that does not care what platform it is running on.
	//Assets folder is where our assets actually goes.
	SpriteBatch batch;
	boolean movingright=false;
	boolean movingleft=false;
	boolean movingup=false;
	boolean movingdown=false;

	@Override
	public boolean keyDown(int keycode) {
		if(keycode==Input.Keys.LEFT) {
			movingleft=true;
		}
		if(keycode==Input.Keys.RIGHT){
			movingright=true;
		}
		if(keycode==Input.Keys.UP){
			movingup=true;
		}
		if(keycode==Input.Keys.DOWN){
			movingdown=true;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if(keycode==Input.Keys.LEFT) {
			movingleft=false;
		}
		if(keycode==Input.Keys.RIGHT){
			movingright=false;
		}
		if(keycode==Input.Keys.UP){
			movingup=false;
		}
		if(keycode==Input.Keys.DOWN){
			movingdown=false;
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		//sprite.setPosition(screenX,Gdx.graphics.getHeight()-screenY);
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		//sprite.setPosition(screenX,Gdx.graphics.getHeight()-screenY);
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		//sprite.setPosition(screenX,Gdx.graphics.getHeight()-screenY);
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		//sprite.setPosition(screenX,Gdx.graphics.getHeight()-screenY);
		return false;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		//sprite.setPosition(sprite.getX()-amountX,sprite.getY()+amountY);
		//OR
//		if(amountX>0){
//			sprite.translateX(2f);
//		}
//		else if(amountX<0){
//			sprite.translateX(-2f);
//		}
		if(amountY>0){
			sprite.translateY(2f);
		}
		else if(amountY<0){
			sprite.translateY(-2f);
		}
		return false;
	}

	Texture img;
	Sprite sprite;
	//Sprite sprite2;
	public static final int WindowWIDTH=1280;
	public static final int WindowHEIGHT=960;
	//Now we are gonna see how to load as well as display the text on the screen
	//In the world of games there are basically 2 types of fonts:
	//Bit Map font which is basically the pictures of text basically drawling the letters
	//it is the most performant way but with the downside
	//Another is true type font which our operating systems use.
	//It basically draws letter mathematically i.e, this approach is more of towards the vector graphics
	//We can scale it up and scale it down infinitesimally but only downfall is that it is slow.
	//WE are not going to cover this in our course right now but here Freestyle is basically the library to render the true type font in the libgdx
	//Now in order to get hte bitmap font what we are going to do is that we are going to create one ands the easiest way to do
	//that is to actually load one of our system ttf files and then create the bit map graphic from it
	//There is a tool named as the Hero included in the Tools extension in the libgdx

	//this below method is called after the constructor but it is called just before everything else
	//It is called only once at start of application
	@Override
	public void create () {
		batch = new SpriteBatch();
		//Spritebatch can be considered as the pixels in grid form in the memory
		img = new Texture("badlogic.jpg");
		sprite=new Sprite(img);
		sprite.setPosition(Gdx.graphics.getWidth()/2-sprite.getWidth()/2,Gdx.graphics.getHeight()/2-sprite.getHeight()/2);
//		sprite2=new Sprite(img);
//		sprite2.setPosition(Gdx.graphics.getWidth()/2-sprite.getWidth()/2,Gdx.graphics.getHeight()/2-sprite.getHeight()/2);
//		sprite2.setRotation(40f);
//		sprite2.setScale(2.0f);
//		sprite2.setScale(2.0f,3.0f);
		Gdx.input.setInputProcessor(this); //It is not enough to just implement the input processor in the game main class we also need to
		//register Input processor to work in this class
	}

	//the below method is called over and over again....
	//if fps is 60 i.e, render is called 60 times in 1 second
	//i.e, called for every single frame that our Application runs...
	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0,(float) 0.5);
		//How to move a sprite;
//		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){ //these are for the keys
//			sprite.translateX(-6f);
//		}
//		if(Gdx.input.isKeyPressed(Input.Keys.UP)){
//			sprite.translateY(6f);
//		}
//		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
//			sprite.translateY(-10f);
//		}
//		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
//			sprite.translateX(6f);
//		}
//		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
//			sprite.setPosition(Gdx.input.getX(), Gdx.graphics.getHeight()-Gdx.input.getY());
//		}
		if(movingleft){
			sprite.translateX(-2f);
		}
		if(movingright){
			sprite.translateX(2f);
		}
		if(movingup){
			sprite.translateY(2f);
		}
		if(movingdown){
			sprite.translateY(-2f);
		}
//		Gdx.gl.glClearColor(1,1,1,1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//Either 1st command or 2nd ,3rd command in collective works in the same way
		batch.begin();
//		batch.draw(img, Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
//		batch.draw(img, 320-img.getWidth()/2, 240-img.getHeight()/2);
//		batch.draw(img, 0, 0);
		batch.draw(sprite,sprite.getX(),sprite.getY());
//		batch.draw(sprite2,sprite2.getX(),sprite2.getY(),0,0,sprite2.getWidth(),sprite2.getHeight(),sprite2.getScaleX(),sprite2.getScaleY(),sprite2.getRotation());
//		batch.draw(sprite2,sprite2.getX(),sprite2.getY(),sprite2.getWidth()/2,sprite2.getHeight()/2,sprite2.getWidth(),sprite2.getHeight(),sprite2.getScaleX(),sprite2.getScaleY(),sprite2.getRotation());
		//Default 0,0 is the bottom left corner of the screen
		//i.e,default cartesian quadrant they are using is the 1st quadrant
		batch.end();

		//at batch.end() only is that all the instruction that we have given to the batch will be thrown on the screen
		//therefore when batch begin what is happening after that is we are instructing it what to do and what to not do
	}
	
	@Override
	public void dispose () { //used to dispose the used instances.
		//Usually people working int he java thinks that there is no direct connection of the code with the memory.
		batch.dispose();
		//It is always a good habit to dispose the instance of the texture class.
		// actually the thing is that there are som classes which implements the dispose interface and some which does not
		// sprite does not implement the dispose interface but texture does
		img.dispose();
	}
}
