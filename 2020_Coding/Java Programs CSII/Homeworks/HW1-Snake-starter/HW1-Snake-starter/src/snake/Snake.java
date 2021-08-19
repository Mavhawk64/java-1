package snake;
public class Snake {
	private static final int SNAKE_MAX = 5000;
	private static final int SNAKE_2D = 2;
	private Direction currentDirection;
	private int length;
	private int[][] theSnake;
	private final int initialPos = 20;
	public Snake() {
		theSnake= new int[SNAKE_MAX][SNAKE_2D];
		theSnake[0][0] = initialPos;
		theSnake[0][1] = initialPos;
		getHeadX();
		getHeadY();
		length = 4;
		boolean growingDown = false;
		for(int i = 1; i< length; i++) {
			if(theSnake[i - 1][1] > 0 && !growingDown) {
				theSnake[i][0] = theSnake[i-1][0];
				theSnake[i][1] = theSnake[i-1][1]-1;
			} else if(theSnake[i-1][0] > 0 && !growingDown) {
				theSnake[i][0] = theSnake[i-1][0]-1;
				theSnake[i][1] = theSnake[i-1][1];
			} else {
				growingDown = true;
				theSnake[i][0] = theSnake[i-1][0];
				theSnake[i][1] = theSnake[i-1][1]-1;
			}
		}
		currentDirection = Direction.DOWN;
	}
	public void changeDir(Direction dirIn) {
		Direction oppositeDirection = null;
		switch(currentDirection) {
			case UP: oppositeDirection = Direction.DOWN;
			break;
			case DOWN: oppositeDirection = Direction.UP;
			break;
			case LEFT: oppositeDirection = Direction.RIGHT;
			break;
			case RIGHT: oppositeDirection = Direction.LEFT;
			break;
			default:
		}
		if(oppositeDirection != dirIn) {
			currentDirection = dirIn;
		}
	}
	public Direction getDirection() {
		return currentDirection;
	}
	public int getHeadX() {
		return theSnake[0][0];
	}
	public int getHeadY() {
		return theSnake[0][1];
	}
	public int getLength() {
		return length;
	}
	public int[][] getSnake() {
		return theSnake;
	}
	public boolean hitSelf() {
		for(int i = 1; i < length; i++) {
			return getHeadX() == theSnake[i][0] && getHeadY() == theSnake[i][1];
		}
		return false;
	}
	public void increaseLength() {
		theSnake[length[0] = theSnake[length-1][0];
		theSnake[length][1] = theSnake[length-1][1];
		length++;
	}
	public void move() {
		int[][] memoryTrail = new int[SNAKE_MAX][SNAKE_2D];
		for(int i = 0; i < length; i++) {
			memoryTrail[i][0] = theSnake[i][0];
			memoryTrail[i][1] = theSnake[i][1];
		}
		switch(currentDirection) {
			case UP:
				theSnake[0][1] = getHeadY() - 1;
			break;
			case DOWN:
				theSnake[0][1] = getHeadY() + 1;
			break;
			case LEFT:
				theSnake[0][1] = getHeadX() - 1;
			break;
			case RIGHT:
				theSnake[0][1] = getHeadX() + 1;
			break;
			default:
		}
		for(int i = 1; i < length; i++) {
			theSnake[i][1] = memoryTrail[i-1][1];
			theSnake[i][0] = memoryTrail[i-1][0];
		}		
	}
}
