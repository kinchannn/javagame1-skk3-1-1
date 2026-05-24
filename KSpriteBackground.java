import java.awt.image.*;
import java.io.*;

/**
 * 背景
 */
public class KSpriteBackground extends KSprite {

	private		int		time		= 0;

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageBackground0 = null;
		BufferedImage imageBackground1 = null;

		imageBackground0 = KImage.getImage("image/imageBackground0.gif");
		imageBackground1 = KImage.getImage("image/imageBackground1.gif");

		KSpriteBackground.setImage(KSpriteBackground.class, new BufferedImage[]{
			imageBackground0,
			imageBackground1
		});

	} // end initImage

	/**
	 * コンストラクタ
	 */
	public KSpriteBackground(KPanel panel){

		super(panel);

	}

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * </pre>
	 */
	public void run(){

		time++;

		if(time >= 2){

			time = 0;

			intY = intY + 1;

			if(intY > 600){
				intY = intY - 1200;
			}

		}

	}

}
