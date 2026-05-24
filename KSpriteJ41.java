import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;

/**
 * 地面 プリセット配線
 */
public class KSpriteJ41 extends KSpriteJ00 implements KConstant {

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageJ41_0 = null;
		BufferedImage imageJ41_1 = null;

		imageJ41_0 = KImage.getImage("image/imageJ41_0.gif");
		imageJ41_1 = KImage.getImage("image/imageJ41_1.gif");

		KSpriteJ41.setImage(KSpriteJ41.class, new BufferedImage[]{
			imageJ41_0,
			imageJ41_1
		});

	} // end initImage

	/**
	 * コンストラクタ
	 */
	public KSpriteJ41(KPanel panel, int intX, int image){

		super(panel);

		int tekiImage = -1;

		tekiImage = (image == J41_0)? 0: tekiImage;
		tekiImage = (image == J41_1)? 1: tekiImage;

		setImage(tekiImage);

		this.intX = intX;
		intY = -128;

	} // end KSpriteJ41

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

	}

}
