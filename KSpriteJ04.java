import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;

/**
 * 地面４ 64ドット
 */
public class KSpriteJ04 extends KSpriteJ00 implements KConstant {

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageJ04_00 = null;
		BufferedImage imageJ04_01 = null;

		imageJ04_00 = KImage.getImage("image/imageJ04_00.gif");
		imageJ04_01 = KImage.getImage("image/imageJ04_01.gif");

		KSpriteJ04.setImage(KSpriteJ04.class, new BufferedImage[]{
			imageJ04_00,
			imageJ04_01
		});

	} // end initImage

	/**
	 * コンストラクタ
	 */
	public KSpriteJ04(KPanel panel, int intX){

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

		// だが、スピードが足りないため、ここで加速
		intY = intY + 6;

	} // end run

}
