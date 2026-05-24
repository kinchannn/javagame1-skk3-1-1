import java.awt.image.*;
import java.io.*;
import java.util.*;

/**
 * 地上物 64ドット 破壊可能
 */
public class KSpriteG11 extends KSpriteG00 implements KConstant {

	/**
	 * イメージ初期化
	 * <pre>
	 * イメージの取り込みを行います。
	 * </pre>
	 */
	public static void initImage() throws IOException {

		BufferedImage imageG11 = null;
		BufferedImage imageG12 = null;

		imageG11 = KImage.getImage("image/imageG11.gif");
		imageG12 = KImage.getImage("image/imageG12.gif");

		KSpriteG11.setImage(KSpriteG11.class, new BufferedImage[]{
			imageG11,
			imageG12
		});

	} // end initImage

	/**
	 * コンストラクタ
	 */
	public KSpriteG11(KPanel panel, int intX, int image){

		super(panel);

		int tekiImage = -1;

		tekiImage = (image == G11)? 0: tekiImage;
		tekiImage = (image == G12)? 1: tekiImage;

		setImage(tekiImage);

		this.intX = intX;
		intY = -128;

	} // end KSpriteG11

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

	/**
	 * 爆発
	 */
	public void bomb(){

		((KCtrlSKK)panel.getKCtrl()).addScore(100);

		super.bomb();

	} // end bomb

}
