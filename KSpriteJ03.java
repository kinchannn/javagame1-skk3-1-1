import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;

/**
 * 地面３ 基地用
 */
public class KSpriteJ03 extends KSpriteJ00 implements KConstant {

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageJ03 = null;

		imageJ03 = KImage.getImage("image/imageJ03.gif");

		KSpriteJ03.setImage(KSpriteJ03.class, imageJ03);

	} // end initImage

	/**
	 * コンストラクタ
	 */
	public KSpriteJ03(KPanel panel, int intX){

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
