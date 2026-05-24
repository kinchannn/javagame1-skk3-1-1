import java.awt.image.*;
import java.io.*;
import java.util.*;

/**
 * 1
 */
public class KSpriteS04 extends KSprite implements KConstant {

	private final int SPRITE_WIDTH = 32;

	private final int MARGIN = 48;

	private final int RANGE = (WIDTH - MARGIN * 2) / 2;

	private final int CENTER = WIDTH / 2 - SPRITE_WIDTH;

	private double doubleY = 0d;

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageS04 = null;

		imageS04 = KImage.getImage("image/imageS04.gif");

		KSpriteS04.setImage(KSpriteS04.class, imageS04);

	} // end initImage

	/**
	 * コンストラクタ.
	 */
	public KSpriteS04(KPanel panel){

		super(panel);

		intY = -getHeight();

	}

	/**
	 * 実行.
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * 継承先で定義をしてください。
	 * <pre>
	 */
	public void run(){

		doubleY = doubleY + 1.0;
		intY = (int)doubleY;

		if(intY > HEIGHT){
			super.removeSprite();
		}

		intX = CENTER + (int)(Math.sin(Math.toRadians((double)(doubleY % 360))) * RANGE);

	} // end run

}
