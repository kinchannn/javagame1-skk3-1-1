import java.awt.image.*;
import java.io.*;
import java.util.*;

/**
 * M680
 */
public class KSpriteG51 extends KSpriteG00 implements KConstant {

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageG51 = null;
		BufferedImage imageG52 = null;

		imageG51 = KImage.getImage("image/imageG51.gif");
		imageG52 = KImage.getImage("image/imageG52.gif");

		KSpriteG51.setImage(KSpriteG51.class, new BufferedImage[]{
			imageG51,
			imageG52
		});

	} // end initImage

	/**
	 * コンストラクタ
	 */
	public KSpriteG51(KPanel panel, int intX, int image){

		super(panel);

		int tekiImage = -1;

		tekiImage = (image == G51)? 0: tekiImage;
		tekiImage = (image == G52)? 1: tekiImage;

		setImage(tekiImage);

		this.intX = intX;
		intY = -128;

	} // end KSpriteG51

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

	/**
	 * 爆発
	 */
	public void bomb(){

		((KCtrlSKK)panel.getKCtrl()).addScore(100);

		super.bomb();

	} // end bomb

}
