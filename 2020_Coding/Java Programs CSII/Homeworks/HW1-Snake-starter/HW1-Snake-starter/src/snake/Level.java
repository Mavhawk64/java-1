package snake;
import java.util.Random;
public class Level {
	private int[][] grid;
	private GameState g;
	private Item apple;
	private Snake python;
	private Random r;
	private int height, width;
	public Level(int widthIn, int heightIn, Random randIn) {
		r = randIn;
		height = heightIn;
		width = widthIn;
		grid = new int[heightIn][widthIn];
		g = GameState.PLAYING;
		apple = new Item();
		python = new Snake();
		generateMap();
	}
	public int[][] generateMap() {
		for(int row = 0; row < height; row++) {
			for(int col = 0; col < width; col++) {
				grid[row][col] = 0;
			}
		}
		grid[apple.getY()][apple.getX()] = -1;
		for(int i = 0; i < python.getLength(); i++) {
			grid[python.getSnake()[i][1]][python.getSnake()[i][0]] = 1;
		}
		return grid;
	}
	public GameState getGameState() {
		return g;
	}
	public Item getItem() {
		return apple;
	}
	public int[][] getMap() {
		return grid;
	}
	public Snake getSnake() {
		return python;
	}
	public void updateOneStep() {
		python.move();
		if(python.getHeadX() < 0 || python.getHeadX() >= width || python.getHeadY() < 0 || python.getHeadY() >= height || python.hitSelf()) {
		g = GameState.LOST;
		}
		if(g != GameState.LOST) {
			generateMap();
		}
		if(apple.getX() == python.getHeadX() && apple.getY() == python.getHeadY()) {
			int randCol = r.nextInt(width);
			int randRow = r.nextInt(height);
			while(grid[randRow][randCol] == 1) {
				randCol = r.nextInt(width);
				randRow = r.nextInt(height);
				generateMap();
			}
			apple.setNewLocation(randCol, randRow);
			python.increaseLength();
		}
		getGameState();
	}
}
