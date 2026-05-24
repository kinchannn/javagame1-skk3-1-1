import java.awt.image.*;
import java.io.*;

/**
 * 恒星
 */
public class KSpriteJ80 extends KSprite implements KConstant {

	private		int		time		= 0;

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageJ80 = null;

		imageJ80 = KImage.getImage("image/imageJ80.gif");

		KSpriteJ80.setImage(KSpriteJ80.class, imageJ80);

	} // end initImage

	/**
	 * コンストラクタ
	 */
	public KSpriteJ80(KPanel panel){

		super(panel);

		intX = -300;
		intY = -getHeight();

	}

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * </pre>
	 */
	public void run(){

		time++;

		if(time % 4 == 0){

			intX = intX + 1;

		}

		if(time % 2 == 0){

			intY = intY + 1;

			if(intY > HEIGHT){
				super.removeSprite();
			}

		}

	}

}
