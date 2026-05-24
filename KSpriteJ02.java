import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;

/**
 * 地面２
 */
public class KSpriteJ02 extends KSpriteJ00 implements KConstant {

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageJ02 = null;

		imageJ02 = KImage.getImage("image/imageJ02.gif");

		KSpriteJ02.setImage(KSpriteJ02.class, imageJ02);

	} // end initImage

	/**
	 * コンストラクタ
	 */
	public KSpriteJ02(KPanel panel, int intX){

		super(panel);

		this.intX = intX;
		intY = -128;

	}

	/**
	 * 実行
	 * <pre>
	 * 当オブジェクトのふるまいを決定します。
	 * 継承先で定義をしてください。
	 * <pre>
	 */
	public void run(){

		// スーパークラスを呼び出す
		// 移動はスーパークラスで制御
		super.run();

	} // end run

}
