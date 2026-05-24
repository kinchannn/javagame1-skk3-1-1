import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;

/**
 * 自機ミニ
 */
public class KSpriteShipMini extends KSprite implements KConstant {

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageShipMini = null;

		imageShipMini = KImage.getImage("image/imageShipMini.gif");

		KSpriteShipMini.setImage(KSpriteShipMini.class, imageShipMini);

	} // end initImage

	/**
	 * コンストラクタ
	 */
	public KSpriteShipMini(KPanel panel){

		super(panel);

	}

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * 継承先で定義をしてください。
	 * <pre>
	 */
	public void run(){

	} // end run

}
