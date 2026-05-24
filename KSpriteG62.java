import java.awt.image.*;
import java.io.*;
import java.util.*;

/**
 * 64ドットCPU
 */
public class KSpriteG62 extends KSpriteG00 implements KConstant {

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageG62 = null;
		BufferedImage imageG63 = null;

		imageG62 = KImage.getImage("image/imageG62.gif");
		imageG63 = KImage.getImage("image/imageG63.gif");

		KSpriteG62.setImage(KSpriteG62.class, new BufferedImage[]{
			imageG62,
			imageG63
		});

	} // end initImage

	/**
	 * コンストラクタ
	 */
	public KSpriteG62(KPanel panel, int intX, int image){

		super(panel);

		int tekiImage = -1;

		tekiImage = (image == G62)? 0: tekiImage;
		tekiImage = (image == G63)? 1: tekiImage;

		setImage(tekiImage);

		this.intX = intX;
		intY = -128;

	} // end KSpriteG62

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
