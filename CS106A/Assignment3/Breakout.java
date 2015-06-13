/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

	/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

	/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

	/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

	/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

	/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

	/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

	/** Separation between bricks */
	private static final int BRICK_SEP = 4;

	/** Width of a brick */
	private static final int BRICK_WIDTH =
			(WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

	/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

	/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 5;

	/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

	/** Number of turns */
	private static final int NTURNS = 3;

	private AudioClip sound = MediaTools.loadAudioClip("bounce.au");
	private GLabel label = new GLabel("");
	private GRect paddle = new GRect((WIDTH - PADDLE_WIDTH) / 2, HEIGHT - PADDLE_Y_OFFSET, PADDLE_WIDTH, PADDLE_HEIGHT);
	private GOval ball = new GOval(BALL_RADIUS * 2, BALL_RADIUS * 2);
	private double vx, vy;
	private RandomGenerator rgen = RandomGenerator.getInstance();
	int turns = NTURNS;
	int numberOfBricks = NBRICK_ROWS * NBRICKS_PER_ROW;
	private Color color;

	/* Method: init() */
	/** Sets up the Breakout program. */
	public void init() {
		add(label);
		addBricks();
		addPaddle();
		addBall();
		addMouseListeners();
	}

	private void addBricks() {
		Color[] colors = {Color.RED,Color.ORANGE,Color.YELLOW,Color.GREEN,Color.CYAN};
		int rowOffset = BRICK_Y_OFFSET;
		for(int rowIndex = 0; rowIndex < NBRICK_ROWS; rowIndex++){
			int columnOffset = (WIDTH - ((BRICK_WIDTH * NBRICKS_PER_ROW) + (BRICK_SEP * (NBRICKS_PER_ROW - 1)))) / 2;
			for (int columnIndex = 0; columnIndex < NBRICKS_PER_ROW; columnIndex++)	{
				if (rowIndex % 2 == 0)
					color = colors[rowIndex / 2];
				GRect brick = new GRect(columnOffset, rowOffset, BRICK_WIDTH, BRICK_HEIGHT);
				brick.setColor(color);
				brick.setFilled(true);
				add(brick);
				columnOffset = columnOffset + BRICK_WIDTH + BRICK_SEP;
			}
			rowOffset = rowOffset + BRICK_HEIGHT + BRICK_SEP;
		}
	}

	private void addPaddle() {
		paddle.setFilled(true);
		add(paddle);		
	}

	public void mouseMoved(MouseEvent e){
		int mouseCurrentLocation = e.getX();
		if (mouseCurrentLocation > WIDTH - PADDLE_WIDTH){
			paddle.setLocation(WIDTH - PADDLE_WIDTH, HEIGHT - PADDLE_Y_OFFSET);	
		}
		else {
			paddle.setLocation(e.getX() - 3, HEIGHT - PADDLE_Y_OFFSET);	
		}
	}

	private void addBall() {
		ball.setLocation((WIDTH - BALL_RADIUS) / 2, (HEIGHT - BALL_RADIUS) / 2);
		ball.setFilled(true);
		add(ball);				
	}

	/* Method: run() */
	/** Runs the Breakout program. */
	public void run() {
		boolean continueGame = true;


		setBallVelocity();		
		while(continueGame) {
			ballHitSide();
			collidedWithObject();
			ball.move(vx, vy);

			updateLabel(String.valueOf(vx));

			pause(5);
			if (turns == 0)
				continueGame = false;
			if (numberOfBricks == 0)
				continueGame = false;
		}
		remove(ball);
		updateLabel(String.valueOf("Game Over"));
	}

	private void updateLabel(String str) {
		label.setVisible(false);
		label.setLabel(str);
		label.setLocation((WIDTH - label.getWidth()) / 2, (HEIGHT - label.getHeight()) / 2);
		label.setVisible(true);
	}

	private void collidedWithObject() {
		GObject[] gObjects = new GObject[4];
		gObjects[0] = getElementAt(ball.getX(), ball.getY());
		gObjects[1] = getElementAt(ball.getX() + (BALL_RADIUS * 2), ball.getY());
		gObjects[2] = getElementAt(ball.getX(), ball.getY() + (BALL_RADIUS * 2));
		gObjects[3] = getElementAt(ball.getX() + (BALL_RADIUS * 2), ball.getY() + (BALL_RADIUS * 2));

		for (GObject gObject: gObjects){
			if(gObject == null)
				;
			else if (gObject.equals(label)){
				;
			}
			else if (gObject.equals(paddle)){

				int xOfBall = (int) ball.getLocation().getX();
				int xOfPaddle = (int) paddle.getLocation().getX();
				playSound();
				if (vx >= 0){
					if (xOfBall <= xOfPaddle + (PADDLE_WIDTH * .33) - (BRICK_WIDTH / 2)) {
						reverseVx();
					} else if (xOfBall <= xOfPaddle + (PADDLE_WIDTH * .66) - (BRICK_WIDTH / 2)) {
						vx = vx - rgen.nextDouble(0.0, 2.0);
					} else {
						;
					}
				} else {
					if (xOfBall <= xOfPaddle + (PADDLE_WIDTH * .33) - (BRICK_WIDTH / 2)) {
						;
					} else if (xOfBall <= xOfPaddle + (PADDLE_WIDTH * .66) - (BRICK_WIDTH / 2)) {
						vx = vx + rgen.nextDouble(0.0, 2.0);
					} else {
						reverseVx();
					}
				}
				ball.setLocation(xOfBall, HEIGHT - PADDLE_Y_OFFSET - (BALL_RADIUS * 2));
				reverseVy();
				break;
			}
			else {
				remove(gObject);
				numberOfBricks--;
				reverseVy();
				playSound();
				break;
			}
		}
	}

	private void setBallVelocity() {
		vy = 2.0;
		vx = rgen.nextDouble(1.0, 2.0);
		if (rgen.nextBoolean(.5))
			reverseVx();
	}

	private void ballHitSide() {
		hitTopSide();
		hitBottomSide();
		hitLeftSide();
		hitRightSide();
	}

	private void hitTopSide() {
		int y = (int) ball.getLocation().getY();
		int topBound = 0;
		if(y <= topBound){
			reverseVy();
			playSound();			
		}

	}

	private void playSound() {
		sound.play();
	}

	private void hitBottomSide() {
		int y = (int) ball.getLocation().getY();
		int bottomBound = HEIGHT - (BALL_RADIUS *2);
		if(y >= bottomBound) {
			turns--;
			remove(ball);
			addBall();			
		}
	}

	private void reverseVy() {
		vy = -vy;
	}

	private void hitLeftSide() {
		int x = (int) ball.getLocation().getX();
		int leftBound = 0;
		if(x <= leftBound) {
			reverseVx();
			playSound();			
		}
	}

	private void hitRightSide() {
		int x = (int) ball.getLocation().getX();
		int rightBound = WIDTH - (BALL_RADIUS *2);
		if(x >= rightBound) {
			reverseVx();
			playSound();			
		}
	}

	private void reverseVx() {
		vx = -vx;
	}
}
